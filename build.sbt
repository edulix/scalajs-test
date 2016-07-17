enablePlugins(SbtWeb)
enablePlugins(ScalaJSPlugin)
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

scalaVersion := "2.11.8"

resolvers += "releases" at "http://nexus.delivery.realestate.com.au/nexus/content/repositories/releases"

libraryDependencies += "com.thoughtworks.binding" %%% "dom" % "7.0.0"

lazy val js = (project in file("js"))
  .settings(
    name := "nvotes-results",
    version := "0.1"
  )

// web task generates all the files needed for scala.js in assets to be run as
// a single page app. Use it as "sbt web"
val web = taskKey[Seq[File]]("JavaScript files generated by Scala.js")

web := {
  val jsFile = (fastOptJS in js in Compile).value.data
  val destinationFile = (sourceManaged in Assets).value / jsFile.getName
  IO.copyFile(jsFile, destinationFile)
  Seq(jsFile)
}

// TODO: check http://www.scala-sbt.org/1.0/docs/Howto-Dynamic-Input-Task.html
//
resourceGenerators in Assets <+= web

resourceGenerators in Assets <+= Def.task[Seq[File]] {
  val jsFile = (fastOptJS in js in Compile).value.data
  val mapFile = jsFile.getParentFile / s"${jsFile.getName}.map"
  val destinationFile = (sourceManaged in Assets).value / mapFile.getName
  IO.copyFile(mapFile, destinationFile)
  Seq(destinationFile)
}

resourceGenerators in Assets <+= Def.task[Seq[File]] {
  val base = (sourceManaged in Assets).value
  val indexHtml = base / "index.html"
  IO.writeLines(
    indexHtml,
    Seq(
      "<!DOCTYPE html>",
      xml.Xhtml.toXhtml(<html>
        <head>
          {for {
          jsFile <- web.value
        } yield {
          <script type="text/javascript" src={jsFile.getName}></script>
        }}
        </head>
        <body>
          <script type="text/javascript">
            org.nvotes.results.Main().main()
          </script>
        </body>
      </html>)))
  Seq(indexHtml)
}


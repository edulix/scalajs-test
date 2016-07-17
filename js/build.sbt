// This file is part of nvotes-results.
// Copyright (C) 2016  Agora Voting SL <legal@agoravoting.com>
//
// nvotes-results is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as published by
// the Free Software Foundation, either version 3 of the License.
//
// nvotes-results is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with nvotes-results.  If not, see <http://www.gnu.org/licenses/>.

enablePlugins(SbtWeb)
enablePlugins(ScalaJSPlugin)
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

scalaVersion := "2.11.8"

resolvers += "releases" at "http://nexus.delivery.realestate.com.au/nexus/content/repositories/releases"

libraryDependencies += "com.thoughtworks.binding" %%% "dom" % "7.0.0"

libraryDependencies += "com.lihaoyi" %%% "utest" % "0.4.3" % "test"
testFrameworks += new TestFramework("utest.runner.Framework")

lazy val js = (project in file("."))
  .settings(
    name := "nvotes-results",
    version := "0.1"
  )
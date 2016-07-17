# nvotes-results

This is a test project using:
* [Binding.scala](https://github.com/ThoughtWorksInc/Binding.scala)
* [Scala.js](http://www.scala-js.org/)

## Building

Let's build and run the project in the web browser.

### Step 0: Prerequisites

You will need to [download & install sbt](http://www.scala-sbt.org/0.13/tutorial/Setup.html) (>= 0.13.0). Note that no prior sbt knowledge (only a working installation) is required to follow the tutorial.

### Step 1: Compile

Execute in the main directory the following command:

    cd path/to/nvotes-results/
    sbt web

### Step 2: Open it in a web browser

Open in a browser the path to `nvotes-results/target/web/assets-managed/main/index.html`. It's a single page application self-contained in the `main` directory, so you can copy and move it.

## Unit testing

Let's build and run the unit tests.

### Step 0: 
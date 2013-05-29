package myproject

import sbt._
import sbt.Keys._

object MyProjectBuild extends Build {

  lazy val buildSettings = Seq(
    organization := "com.myco.myproject",
    version      := "0.1.0-SNAPSHOT",
    scalaVersion := "2.10.1"
  )

  lazy val myproject = Project(
    id = "myproject",
    base = file("myproject"),
    settings = defaultSettings ++ Seq(
      libraryDependencies ++= Dependencies.baseDependencies
    )
  )

  override lazy val settings =
    super.settings ++
    buildSettings ++
    Seq(
      shellPrompt := { s => Project.extract(s).currentProject.id + " > " }
    )

  lazy val baseSettings = Defaults.defaultSettings

  lazy val defaultSettings = baseSettings ++ Seq(

    parallelExecution in Test := false,
    
    // show full stack traces and test case durations
    testOptions in Test += Tests.Argument("-oDF"),
    testOptions in Test += Tests.Filter(s => !s.endsWith("IntegrationTest") && s.endsWith("Test"))
  )
}


object Dependencies {

  object Compile {
  	val slf4jApi       = "org.slf4j"                   % "slf4j-api"                    % "1.7.5"
      
    object Test {
      val logback      = "ch.qos.logback"              % "logback-classic"              % "1.0.13"            % "test"
      val scalatest	   = "org.scalatest" 			   % "scalatest_2.10"				% "1.9.1"			  % "test"
      val testng       = "org.testng"                  % "testng"                       % "6.8.5"             % "test"
      val mockito      = "org.mockito"                 % "mockito-all"                  % "1.9.5"             % "test"
      val guice		   = "com.google.inject"           % "guice"                        % "3.0"               % "test"  // Needed by TestNG
    }
  }

  import Compile._

  val logging = Seq(slf4jApi)

  val testing = Seq(Test.logback, Test.scalatest, Test.testng, Test.mockito, Test.guice)

  val baseDependencies = logging ++ testing

}
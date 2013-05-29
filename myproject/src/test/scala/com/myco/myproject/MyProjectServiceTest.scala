package com.myco.myproject

import org.scalatest.testng.TestNGSuite
import org.scalatest.Assertions
import org.testng.Assert._
import org.testng.annotations.Test
import org.testng.annotations.Configuration

class MyProjectServiceTest extends TestNGSuite {

  @Test
  def verifyReturnStatus() {
  	val service = new MyProjectService()
  	val retValue = service.returnStatus()

 	assertTrue(retValue) 	
  }

}
package com.myco.myproject

import org.slf4j.LoggerFactory

class MyProjectService {
  private def logger = LoggerFactory.getLogger(classOf[MyProjectService])

  def returnStatus(): Boolean = {
  	logger.info("Status is true")
    return true
  }

}
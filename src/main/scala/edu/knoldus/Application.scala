package edu.knoldus

import org.apache.log4j.Logger

object Application extends App {

  val logger = Logger.getLogger(this.getClass)
  val operation = new Operation
  val one = 1
  val two = 2
  val three = 3
  val four = 4
  val five = 5
  val function = (a: Int) => a % 2 == 0

  logger.info(operation.getListLength(List(one, two, three, four)) + "\n")
  logger.info(operation.hasSubsequence(List(one, two, three), List(one, two)) + "\n")
  logger.info(operation.concateList(List(one, two, three), List(four, five)) + "\n")
  logger.info(operation.splitList(List(one, two, three, four, five), function, List.empty, List.empty))
}

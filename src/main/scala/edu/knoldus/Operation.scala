package edu.knoldus

class Operation {

  def getListLength(list: List[Int]): Int = {

    list.foldRight(0)((_, length) => length + 1)

  }

  def availableCheck[A](list: List[A], value: A): Boolean = {

    list match {
      case Nil => false
      case first :: second if first == value => true
      case first :: second => availableCheck(second, value)
    }
  }

  def concateList[A](list1: List[A], list2: List[A]): List[A] = {

    list2 match {
      case Nil => list1
      case first :: tail => concateList(list1 :+ first, tail)
    }

  }

  def hasSubsequence[A](list: List[A], sub: List[A]): Boolean = {

    sub match {
      case Nil => true
      case first :: Nil if availableCheck(list, first) == false => false
      case first :: tail if availableCheck(list, first) == true => hasSubsequence(list, tail)

    }
  }

  def splitList[A](list: List[A], f: A => Boolean, list1: List[A], list2: List[A]): (List[A], List[A]) = {

    list match {

      case Nil => (list1, list2)
      case head :: tail if f(head) => splitList(tail, f, list1 :+ head, list2)
      case head :: tail => splitList(tail, f, list1, list2 :+ head)

    }

  }
}

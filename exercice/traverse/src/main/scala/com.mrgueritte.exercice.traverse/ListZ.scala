package com.mrgueritte.exercice.traverse

import cats.{Applicative, Eval, Traverse}


sealed trait ListZ[+A] {

  import ListZ._

  def drop(n: Int): ListZ[A] = ???

  def headOption(): Option[A] = ???

  def ::[B >: A](value: B): ListZ[B] = ???

  def foldLeft[B](acc: B)(f: (B, A) => B): B = ???

  def traverse[G[_], B](f: A => G[B])(implicit applicative: Applicative[G]): G[ListZ[B]] = ???

}

case object Empty extends ListZ[Nothing]
case class Cons[+A](hd: A, tail: ListZ[A]) extends ListZ[A]

object ListZ {

  def apply[A](as: A*): ListZ[A] = ???

  implicit def traverseInstance: Traverse[ListZ] = new Traverse[ListZ] {
    override def traverse[G[_], A, B](fa: ListZ[A])(f: A => G[B])(implicit applicative: Applicative[G]): G[ListZ[B]] = ???

    override def foldLeft[A, B](fa: ListZ[A], acc: B)(f: (B, A) => B): B = ???

    override def foldRight[A, B](fa: ListZ[A], acc: Eval[B])(f: (A, Eval[B]) => Eval[B]): Eval[B] = ???
  }

}

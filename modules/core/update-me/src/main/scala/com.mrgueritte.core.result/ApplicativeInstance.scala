package com.mrgueritte.core.result

import cats.Applicative

object applicativeInstance extends ResultApplicative

trait ResultApplicative {

  implicit def resultApplicative[A, ?]: Applicative[Result[A, ?]] = new Applicative[Result[A, ?]] {
    override def pure[B](x: B): Result[A, B] = ???

    override def ap[B, Z](ff: Result[A, B => Z])(fa: Result[A, B]): Result[A, Z] = ???
  }

}
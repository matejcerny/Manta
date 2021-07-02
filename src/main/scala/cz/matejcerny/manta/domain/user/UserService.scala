package cz.matejcerny.manta.domain.user

import cats.data.EitherT
import cats.Monad
import cz.matejcerny.manta.domain.MantaError

class UserService[F[_]](userAlgebra: UserAlgebra[F]) {

  def listAllUsers: EitherT[F, MantaError, Seq[User]] = ???

  def createUser(user: User)(implicit M: Monad[F]): EitherT[F, MantaError, User] =
    EitherT.liftF(userAlgebra.create(user))

}

object UserService {

  def apply[F[_]](userAlgebra: UserAlgebra[F]): UserService[F] = new UserService(userAlgebra)

}

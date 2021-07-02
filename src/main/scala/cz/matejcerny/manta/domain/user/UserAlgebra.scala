package cz.matejcerny.manta.domain.user

trait UserAlgebra[F[_]] {

  def create(user: User): F[User]

}

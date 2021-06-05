package cz.matejcerny.manta.controller

import org.http4s.HttpRoutes

object Controller {

  def router[F[_]]: HttpRoutes[F] = ???

}

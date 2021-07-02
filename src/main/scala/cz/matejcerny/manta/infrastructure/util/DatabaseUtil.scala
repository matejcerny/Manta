package cz.matejcerny.manta.infrastructure.util

import cats.effect.{Async, Blocker, ContextShift, Resource}
import cz.matejcerny.manta.config.{AppConfig, DbConfig}
import doobie.hikari.HikariTransactor

import scala.concurrent.ExecutionContext

object DatabaseUtil {

  def createTransactor[F[_]: Async: ContextShift](
    dbConfig: DbConfig,
    ec: ExecutionContext,
    blocker: Blocker
  ): Resource[F, HikariTransactor[F]] =
    HikariTransactor.newHikariTransactor[F](
      dbConfig.driver,
      dbConfig.url,
      dbConfig.user,
      dbConfig.password,
      ec,
      blocker
    )

}

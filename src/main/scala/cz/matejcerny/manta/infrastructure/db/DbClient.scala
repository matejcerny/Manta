package cz.matejcerny.manta.infrastructure.db

import cats.effect.kernel.Sync
import cats.effect.{IO, Resource}
import cz.matejcerny.manta.config.DbConfig
import doobie.hikari.HikariTransactor
import doobie.util.ExecutionContexts
import org.flywaydb.core.Flyway

class DbClient(xa: HikariTransactor[IO])

object DbClient:

  def createResource(dbConfig: DbConfig): Resource[IO, DbClient] =
    for
      executionContext <- ExecutionContexts.fixedThreadPool[IO](dbConfig.threadPoolSize)
      xa <- HikariTransactor.newHikariTransactor[IO](
        dbConfig.driver,
        dbConfig.url,
        dbConfig.user,
        dbConfig.password.value,
        executionContext
      )
    yield DbClient(xa)

  def prepareDatabase(dbConfig: DbConfig): Resource[IO, Int] =
    Resource.eval(
      Sync[IO]
        .delay:
          Flyway
            .configure()
            .baselineOnMigrate(true)
            .dataSource(dbConfig.url, dbConfig.user, dbConfig.password.value)
            .load
            .migrate()
            .migrationsExecuted
    )

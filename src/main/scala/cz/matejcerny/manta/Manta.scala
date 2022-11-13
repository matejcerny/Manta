package cz.matejcerny.manta

import cats.effect.*
import cats.implicits.*
import cz.matejcerny.manta.config.AppConfig

object Manta extends IOApp {

  def build: Resource[IO, Unit] =
    for {
      appConfig <- AppConfig.resource
      _ <- Resource.eval(IO(println(appConfig)))
    } yield ()
  
  override def run(args: List[String]): IO[ExitCode] =
    build.use(_ => IO.unit).as(ExitCode.Success)

}

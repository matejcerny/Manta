package cz.matejcerny.manta.config

import cz.matejcerny.manta.domain.MantaError.CannotParseConfig
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.util.{Failure, Success, Try}

class AppConfigTest extends AnyFlatSpec with Matchers {

  it should "fail when config file does not exist" in {
    AppConfig[Try]("/config/not-exist") shouldBe Failure(CannotParseConfig("Cannot open file /config/not-exist"))
  }

  it should "fail parsing of config on invalid file" in {
    AppConfig[Try]("/config/invalid-application.conf") shouldBe Failure(
      CannotParseConfig(
        "[manta.http.port] Reader: 2: port has type STRING value 'WRONG' rather than int (32-bit integer)"
      )
    )
  }

  it should "parse valid config file" in {
    AppConfig[Try]("/config/valid-application.conf") shouldBe Success(
      AppConfig(
        Http("test-host", 8080),
        Database("test-user", "test-password", "test-url", "org.postgresql.Driver", "test-schema")
      )
    )
  }

}

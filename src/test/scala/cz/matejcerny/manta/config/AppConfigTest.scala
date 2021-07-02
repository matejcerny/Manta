package cz.matejcerny.manta.config

import cz.matejcerny.manta.domain.MantaError.CannotParseConfig
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.util.{Failure, Success, Try}

class AppConfigTest extends AnyFlatSpec with Matchers {

  it should "fail when config file does not exist" in {
    AppConfig[Try]("/config/not-exist") shouldBe Failure(CannotParseConfig("Cannot open file /config/not-exist"))
  }

  it should "fail parsing invalid config" in {
    AppConfig[Try]("/config/invalid.conf") shouldBe Failure(
      CannotParseConfig(
        "[http.port] Reader: 1: port has type STRING value 'WRONG' rather than int (32-bit integer)"
      )
    )
  }

  it should "fail parsing config with not set env variable" in {
    AppConfig[Try]("/config/valid-with-env-variable.conf") shouldBe Failure(
      CannotParseConfig(
        "Reader: 6: Could not resolve substitution to a value: ${PG_USER}"
      )
    )
  }

  it should "parse valid config file" in {
    AppConfig[Try]("/config/valid.conf") shouldBe Success(
      AppConfig(
        HttpConfig(8080, "test-host"),
        DbConfig("test-user", "test-password", "test-url", "org.postgresql.Driver", 4, "test-schema")
      )
    )
  }

}

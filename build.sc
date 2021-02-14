import mill._
import scalalib._

object database extends ScalaModule {

  def scalaVersion = "2.13.4"

  override def ivyDeps = Agg(
    ivy"dev.zio::zio:1.0.4"
  )
}

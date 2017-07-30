package com.phasmid.darwin.plugin

import java.time.{Duration, LocalDateTime}

import scala.collection.mutable

/**
  * Created by scalaprof on 7/28/17.
  */
case class TestPlugin() extends AbstractPlugin("Test plugin", "1.0") with EvolvablePlugin {
  protected def doInit: Unit = println(s"$name initialized")

  protected def doStart: Unit = println(s"$name started")

  protected def doStop: Unit = println(s"$name stopped")

  protected def doDestroy: Unit = println(s"$name destroyed")

  def addListener(x: Listener): Unit = listeners += x

  val listeners: mutable.MutableList[Listener] = mutable.MutableList[Listener]()

  def actionDuration: Duration = Duration.ofSeconds(1L)

  def act(generation: Long): Unit = {
    println(s"$name received tick #$generation")
    for (l <- listeners) l.receive(this, s"generation $generation at ${LocalDateTime.now()}")
  }

  override def toString: String = s"'$name' version $version"
}

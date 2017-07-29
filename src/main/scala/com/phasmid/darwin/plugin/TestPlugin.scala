package com.phasmid.darwin.plugin

import java.time.LocalDateTime

import scala.collection.mutable

/**
  * Created by scalaprof on 7/28/17.
  */
class TestPlugin extends AbstractPlugin("Test plugin", "1.0") with EvolvablePlugin {
  protected def doInit: Unit = println(s"$name initialized")

  protected def doStart: Unit = println(s"$name started")

  protected def doStop: Unit = println(s"$name stopped")

  protected def doDestroy: Unit = println(s"$name destroyed")

  def onTick(time: LocalDateTime): Unit = {
    println(s"$name received tick at $time")
    for (l <- listeners) l.receive(this)
  }

  def addListener(x: Listener): Unit = listeners += x

  val listeners: mutable.MutableList[Listener] = mutable.MutableList[Listener]()
}

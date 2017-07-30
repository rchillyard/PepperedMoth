package com.phasmid.darwin.plugin

import java.time.LocalDateTime

import org.scalatest.{FlatSpec, Matchers}

class TestPluginSpec extends FlatSpec with Matchers {

  behavior of "TestPlugin"
  it should "get constructed properly" in {
    val x = new TestPlugin()
    x.listeners.size shouldBe 0
    x.addListener(new Listener(){
      def receive(sender: AnyRef, msg: Any): Unit = println(s"received $msg from $sender")
    })
    x.onTick(LocalDateTime.now)
  }
}

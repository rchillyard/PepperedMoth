package com.phasmid.darwin.plugin

import java.time.Duration

import org.scalatest.{FlatSpec, Matchers}

class TestPluginSpec extends FlatSpec with Matchers {

  behavior of "TestPlugin"
  it should "get constructed properly" in {
    val x = TestPlugin()
    x.listeners.size shouldBe 0
    x.addListener(new Listener(){
      def receive(sender: AnyRef, msg: Any): Unit = println(s"received $msg from $sender")
    })
    x.onTick(1L, Duration.ofSeconds(1L))
  }
}

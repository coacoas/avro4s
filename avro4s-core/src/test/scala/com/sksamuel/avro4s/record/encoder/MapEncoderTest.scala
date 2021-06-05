//package com.sksamuel.avro4s.record.encoder
//
//import com.sksamuel.avro4s._
//import org.apache.avro.util.Utf8
//import org.scalatest.matchers.should.Matchers
//import org.scalatest.wordspec.AnyWordSpec
//
//import scala.collection.JavaConverters._
//
//class MapEncoderTest extends AnyWordSpec with Matchers {
//  "Encoder" should {
//    "support top level Map[String, Double]" in {
//      val data = Map("a" -> 1.2, "ç" -> 34.5, "阿夫罗" -> 54.3)
//      Encoder[Map[String, Double]].encode(data) shouldBe data.asJava
//    }
//    "support top level Map[String, Int]" in {
//      val data = Map("a" -> 111, "ç" -> 222, "阿夫罗" -> 333)
//      Encoder[Map[String, Int]].encode(data) shouldBe data.asJava
//    }
//    "support top level Map[String, String]" in {
//      val data = Map("a" -> "b", "ç" -> "đ", "阿夫罗" -> "아브로")
//      val enc = data.map{ case (k, v) => (k, new Utf8(v)) }.asJava
//      val res = Encoder[Map[String, String]].encode(data)
//      res shouldBe enc
//    }
//
//    "support top level Map[String, Test]" in {
//      case class Test(set: Set[String])
//      val sc = AvroSchema[Test]
//      val data = Map("a" -> Test(Set("a", "b")), "ç" -> Test(Set("c", "d")), "阿夫罗" -> Test(Set("아브로", "f")))
//      val enc = data.map{ case (k, Test(v)) =>
//        (k, ImmutableRecord(sc, Seq(v.map(new Utf8(_)).toSeq.asJava)))
//        }.asJava
//      val res = Encoder[Map[String, Test]].encode(data)
//      res shouldBe enc
//    }
//  }
//}
//

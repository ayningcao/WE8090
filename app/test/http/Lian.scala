package test.http

import java.io.{BufferedReader, InputStreamReader}
import java.net.URL

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import org.apache.http.NameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.HttpClients
import org.apache.http.message.BasicNameValuePair
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer

/**
 * Created by caowenjun763 on 2016/9/1.
 */
object Lian {

  val url: String = "http://lianhanghao.com/index.php"

  val cityUrl: String = "http://lianhanghao.com/area.php"

  /**
   * 获取全部银行列表
   * @param doc
   * @return
   */
  def getBanks(doc: Document): List[(Int, String)] = {
    val bankList = doc.body().getElementById("bank")
    val iterator = bankList.children().listIterator
    val v = new ListBuffer[(Int, String)]
    while (iterator.hasNext) {
      val e = iterator.next
      val idStr: String = e.`val`()
      if (!idStr.equals("")) {
        val text = e.text()
        v.+=((idStr.toInt, text))
      }

    }

    v.result()
  }

  /**
   * 获取全部省份列表
   * @param doc
   * @return
   */
  def getProvinces(doc: Document): List[(Int, String)] = {
    val elements = doc.body().getElementById("province").children()
    val listBuffer = new ListBuffer[(Int, String)]
    for (l <- elements) {
      val id = l.`val`()
      val text = l.text()
      if (!id.equals("")) {
        listBuffer.+=((id.toInt, text))
      }
    }

    listBuffer.toList
  }

  /**
   * 根据provinceId查询city list
   * @param provinceId
   * @return
   */
  def queryCities(provinceId: Int): List[(Int, String)] = {
    val url = new URL(cityUrl + "?act=ajax&id=" + provinceId)
    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    val map = mapper.readValue[Map[String, List[Map[String, String]]]](url)
    val listBuffer = new ListBuffer[(Int, String)]
    map.get("city") match {
      case Some(l) =>
        for (m <- l) {
          val text = m.get("name")
          val id = m.get("id") match {
            case Some(id) =>
              if (!id.equals("")) {
                listBuffer.+=((id.toInt, text.getOrElse("")))
              }
            case None =>
              println("error")
          }
        }
      case None =>
        println("error")
    }
    listBuffer.toList
  }

  /**
   * 执行查询
   * @param bankId
   * @param provinceId
   * @param cityId
   * @return
   */
  def search(bankId: String, provinceId: String, cityId: String): String = {
    val param1 = new BasicNameValuePair("bank", bankId)
    val param2 = new BasicNameValuePair("province", provinceId)
    val param3 = new BasicNameValuePair("city", cityId)
    val param4 = new BasicNameValuePair("act", "/boss")
    val param5 = new BasicNameValuePair("action", "find")
    val param7 = new BasicNameValuePair("key", "")

    val params: List[NameValuePair] = List(param1, param2, param3, param4, param5, param7)
    val entity = new UrlEncodedFormEntity(seqAsJavaList(params), "UTF-8")
    val httpclient = HttpClients.createDefault()
    val httpPost = new HttpPost(url)
    httpPost.setEntity(entity)
    val response = httpclient.execute(httpPost)
    val sb: StringBuilder = new StringBuilder
    try {
      val r = response.getStatusLine.getStatusCode
      val s = new BufferedReader(new InputStreamReader(response.getEntity.getContent))
      var flag: Boolean = true
      while (flag) {
        Option(s.readLine()) match {
          case Some(s) =>
            sb.append(s)
          case None =>
            flag = false
        }
      }
      s.close()
    } finally {
      response.close()
    }

    sb.toString()
  }

  def parseHtml(html: String): List[Banks] = {
    val trs = Jsoup.parse(html).body().select("center .tbdata table tbody").first().children()
    val banks = new ListBuffer[Banks]
    for (tr <- trs) {
      val tds = tr.children()
      val bank = new Banks(tds.get(1).text(), tds.get(2).text(), tds.get(3).text(), tds.get(4).text())
      banks += bank
    }
    banks.toList
  }

  def main(args: Array[String]): Unit = {
    val basicHtml = search("", "", "")
    val doc = Jsoup.parse(basicHtml)
    val banks = getBanks(doc)
    val provinces = getProvinces(doc)
    for (bank <- banks) {
      val bankId = bank._1
      for (province <- provinces) {
        val provinceId = province._1
        val cities = queryCities(provinceId)
        for (city <- cities) {
          val result = parseHtml(search(bankId.toString, provinceId.toString, city._1.toString))
          println("*****" + bank._2 + "***" + province._2 + "*****" + city._2 + "******")
          for (b <- result) {
            println(b)
          }
        }
      }
    }
  }
}

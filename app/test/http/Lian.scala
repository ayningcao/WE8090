package test.http

import java.io.{BufferedReader, InputStreamReader}

import scala.collection.JavaConversions._

/**
 * Created by caowenjun763 on 2016/9/1.
 */
object Lian {

  val url: String = "http://lianhanghao.com/index.php";

  def query(): Unit = {

    val param1 = new BasicNameValuePair("bank", "69")
    val param2 = new BasicNameValuePair("province", "9")
    val param3 = new BasicNameValuePair("city", "107")
    val param4 = new BasicNameValuePair("act", "/boss")
    val param5 = new BasicNameValuePair("action", "find")
    val param6 = new BasicNameValuePair("cityTmp", "9")
    val param7 = new BasicNameValuePair("key", "")

    val params: List[NameValuePair] = List(param1, param2, param3, param4, param5, param6, param7)
    val entity = new UrlEncodedFormEntity(seqAsJavaList(params), "UTF-8")
    val httpclient = HttpClients.createDefault()
    val httpPost = new HttpPost(url)
    httpPost.setEntity(entity)
    val response = httpclient.execute(httpPost)
    try {
      val r = response.getStatusLine.getStatusCode
      val s = new BufferedReader(new InputStreamReader(response.getEntity.getContent))
      var flag: Boolean = true
      while (flag) {
        Option(s.readLine()) match {
          case Some(s) =>
            println(s)
          case None =>
            flag = false
        }
      }
      s.close()
    } finally {
      response.close()
    }
  }

  def main(args: Array[String]) {
    query()
  }
}

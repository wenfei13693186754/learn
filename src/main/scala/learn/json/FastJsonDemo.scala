package learn.json

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject


/**
 * 阿里巴巴的fastJson案例
 */
object FastJsonDemo {
  def main(args: Array[String]): Unit = {
    //val json = "{ \"a\": 1, \"b\": { \"c\": 2, \"d\": [3,4] } }"
    val json = "{ \"a\": 1, \"c\": { \"a\": 1, \"b\": { \"c\": 2, \"d\": [3,4] } },\"b\": { \"c\": 2, \"d\": [3,4] } }"
    val a = jsonHandle(JSON.parseObject(json))
    println(a)
  }

  /*
   * 拼接json串
   * JSONObject拼接出来的json串是{}结构
	 * JSONArray拼接出来的json串是[]结构
   */
  def dataToJson() {
    val json = new JSONObject
    json.put("et", "kanqiu_client_join")
    json.put("vtm", "1435898329434")
    val jsonBody = new JSONObject
    jsonBody.put("client", "866963024862254")
    jsonBody.put("client_type", "android")
    jsonBody.put("room", "NBA_HOME")
    jsonBody.put("gid", "")
    jsonBody.put("type", "")
    jsonBody.put("roomid", "")
    json.put("body", jsonBody.toString())
    json.put("time", "1435898329")
    println("json串是：" + json.toString())
    //json串是：{"body":"{\"roomid\":\"\",\"client\":\"866963024862254\",\"client_type\":\"android\",\"gid\":\"\",\"type\":\"\",\"room\":\"NBA_HOME\"}","time":"1435898329","vtm":"1435898329434","et":"kanqiu_client_join"}

  }

  //字符串的解析
  def parseStr() {
    val str = "{\"et\":\"kanqiu_client_join\",\"vtm\":1435898329434,\"body\":{\"client\":\"866963024862254\",\"client_type\":\"android\",\"room\":\"NBA_HOME\",\"gid\":\"\",\"type\":\"\",\"roomid\":\"\"},\"time\":1435898329}"
    //标准格式字符串转化为json串
    val json = JSON.parseObject(str)
    //获取成员
    val m1 = json.get("et")
    //返回字符串成员
    val m2 = json.getString("et")
    //返回整形成员
    val m3 = json.getInteger("vtm")
    //返回多级成员
    val m4 = json.getJSONObject("body").get("client")
    println(m1 + "\n" + m2 + "\n" + m3 + "\n" + m4)
    /*
     * kanqiu_client_join
       kanqiu_client_join
       1379252570
       866963024862254
     */
  }

  /**
   * JSON串格式转化
   * 思路，因为json串的嵌套是多层的，所以考虑使用递归操作
   */
  var nj = new JSONObject()//预定义一个空的json串，用来放解析后的json串
  def jsonHandle(json: JSONObject): JSONObject = {
    //将待解析json串转化为迭代器进行迭代
    val iter1 = json.entrySet().iterator()
    while(iter1.hasNext()){
      val entry = iter1.next()
      val key = entry.getKey
      
      //如果迭代出的value值不是JSONObject，那么将对应的key和value放到nj中
      if(!entry.getValue.isInstanceOf[JSONObject]){
        nj.put(key, entry.getValue)
      }else{//如果迭代出的value值是JSONObject，那么继续迭代出该JSONObject的所有键值，然后将当前JSONObject的所有key(k2)拼接上上一级的key(k1)值后(得到k1.k2),按照"k1.k2":value的格式放到新定义的临时JSONObject中(也就是nj2)，
        val nj2 = new JSONObject()
        val jobj = entry.getValue.asInstanceOf[JSONObject]
        val iter2 = jobj.entrySet().iterator()
        while(iter2.hasNext()){
          val kv = iter2.next()
          nj2.put(key++"."+kv.getKey, kv.getValue)
        }
        
        //递归调用该方法
        jsonHandle(nj2)
      }
    }
    nj
  }
}


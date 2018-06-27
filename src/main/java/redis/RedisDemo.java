package redis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
ients.jedis.JedisPoolConfig;

public class RedisDemo {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("");
		Transaction multi = jedis.multi();
		
		multi.set("", "");
		multi.set("", "");
		
		List<Object> exec = multi.exec();
	}
	
}

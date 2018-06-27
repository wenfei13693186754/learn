package redis;

import java.util.Arrays;
import java.util.List;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPipeline;
import redis.clients.jedis.ShardedJedisPool;

public class ConnRedis {
	public void test8shardPipelinedPool() {
	    List<JedisShardInfo> shards = Arrays.asList(
	            new JedisShardInfo("localhost",6379),
	            new JedisShardInfo("localhost",6380));

	    ShardedJedisPool pool = new ShardedJedisPool(new JedisPoolConfig(), shards);

	    ShardedJedis one = pool.getResource();

	    ShardedJedisPipeline pipeline = one.pipelined();

	    long start = System.currentTimeMillis();
	    for (int i = 0; i < 100000; i++) {
	        pipeline.set("sppn" + i, "n" + i);
	    }
	    pipeline.sync();
	    long end = System.currentTimeMillis();
	    pool.returnResource(one);
	    System.out.println("Pipelined@Pool SET: " + ((end - start)/1000.0) + " seconds");
	    pool.destroy();
	}
}

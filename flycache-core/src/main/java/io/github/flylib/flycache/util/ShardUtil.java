package io.github.flylib.flycache.util;

import io.github.flylib.flycache.hash.ConsistentHash;
import io.github.flylib.flycache.hash.Node;
import io.github.flylib.flycache.redis.JedisPoolShardFactory;
import io.github.flylib.flycache.redis.RedisClient;
import io.github.flylib.flycache.spring.AppContextHolder;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liushaoming
 * @Package io.github.flylib.flycache.util
 * @Description:
 * @date 2018-1-22 18:09
 */
public class ShardUtil {
    public static void initNodes() {
        Set<Node> nodeSet = new HashSet<Node>();
        nodeSet.add(new Node("127.0.0.1", "", "6379"));
        nodeSet.add(new Node("127.0.0.1", "", "6380"));

        ConsistentHash consistentHash= ConsistentHash.getInstance();
        consistentHash.setNodeSet(nodeSet);
        consistentHash.buildHashCircle();

        String namePrefix = "lsm-";
        for (int index = 0; index < 30; index++) {
            String key = namePrefix + index;
            Node node = consistentHash.findNodeByKey(key);

            JedisPoolShardFactory jedisPoolShardFactory= AppContextHolder.getBean(JedisPoolShardFactory.class);
            JedisPool jedisPool= jedisPoolShardFactory.getJedisPool(node);
            RedisClient redisClient = new RedisClient();
            redisClient.setJedisPool(jedisPool);
            redisClient.set(key,   "ValueOf---" + key);
        }
    }

    public static void main(String[] args){
        initNodes();
    }
}

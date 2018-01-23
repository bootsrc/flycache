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
        JedisPoolShardFactory jedisPoolShardFactory = AppContextHolder.getBean(JedisPoolShardFactory.class);

        Set<Node> nodeSet = new HashSet<Node>();
        nodeSet.add(new Node("127.0.0.1", "6379", ""));
        nodeSet.add(new Node("127.0.0.1", "6380", ""));
        nodeSet.add(new Node("127.0.0.1", "6381", ""));
        resetAllRedis(nodeSet, jedisPoolShardFactory);
        ConsistentHash consistentHash = ConsistentHash.getInstance();
        consistentHash.setVirtualCount(4);
        consistentHash.setNodeSet(nodeSet);
        consistentHash.buildHashCircle();
        String namePrefix = "lsm-";

        for (int index = 0; index < 300; index++) {
            String key = namePrefix + index;
            Node node = consistentHash.findNodeByKey(key);
            JedisPool jedisPool = jedisPoolShardFactory.getJedisPool(node);
            RedisClient redisClient = new RedisClient();
            redisClient.setJedisPool(jedisPool);
            redisClient.set(key, "ValueOf---" + key);
        }
    }

    /**
     * Execute 'flushDB' on all Redis node in nodeSet
     * 在所有的Redis的当前db上执行"flushDB"操作
     * @param nodeSet
     * @param jedisPoolShardFactory
     */
    private static void resetAllRedis(Set<Node> nodeSet, JedisPoolShardFactory jedisPoolShardFactory) {
        if (nodeSet != null && nodeSet.size() > 0) {
            for (Node node : nodeSet) {
                JedisPool jedisPool = jedisPoolShardFactory.getJedisPool(node);
                RedisClient redisClient = new RedisClient(jedisPool);
                redisClient.flushDB();
            }
        }
    }

//    public static void main(String[] args) {
//        initNodes();
//    }
}

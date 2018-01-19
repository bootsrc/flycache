package io.github.flylib.flycache.redis;

import io.github.flylib.flycache.hash.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author liushaoming
 * @Package io.github.flylib.flycache.redis
 * @Description:
 * @date 2018-1-19 11:12
 */
@Component
public class JedisPoolShardFactory {
    @Autowired
    private JedisPoolConfig poolConfig;
    @Autowired
    private JedisSettings jedisSettings;

    public JedisPool getJedisPool(Node node) {

        int timeout = jedisSettings.getTimeout();
        int database = jedisSettings.getDb();
        JedisPool jedisPool = new JedisPool(poolConfig, node.getIp(), new Integer(node.getPort()), timeout, (String)null, database, (String)null);

        return jedisPool;
    }
}

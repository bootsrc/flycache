package io.github.flylib.flycache.controller;

import io.github.flylib.flycache.redis.JedisPoolShardFactory;
import io.github.flylib.flycache.redis.RedisClient;
import io.github.flylib.flycache.spring.AppContextHolder;
import io.github.flylib.flycache.hash.Node;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisPool;

/**
 * @author liushaoming
 * @Package io.github.flylib.flycache.controller
 * @Description:
 * @date 2018-1-19 9:55
 */
@Controller
public class IndexController {
    @ResponseBody
    @RequestMapping("")
    public String demo() {
        return "demo response from flycache-core.-------";
    }

    @ResponseBody
    @RequestMapping("testRedis")
    public String testRedis() {
        JedisPoolShardFactory jedisPoolShardFactory= AppContextHolder.getBean(JedisPoolShardFactory.class);
        Node node = new Node();
        node.setIp("127.0.0.1");
        node.setName("");
        node.setPort("6379");
        JedisPool jedisPool= jedisPoolShardFactory.getJedisPool(node);
        RedisClient redisClient= new RedisClient();
        redisClient.setJedisPool(jedisPool);
        String key ="testCache";
        redisClient.set(key, "mmmmmmm");
        String value = redisClient.get(key);
        System.out.println(value);
        return value;
    }
}

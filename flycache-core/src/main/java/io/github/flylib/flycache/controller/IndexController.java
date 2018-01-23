package io.github.flylib.flycache.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import io.github.flylib.flycache.entity.NodeGroupEntity;
import io.github.flylib.flycache.redis.JedisPoolShardFactory;
import io.github.flylib.flycache.redis.RedisClient;
import io.github.flylib.flycache.service.NodeGroupService;
import io.github.flylib.flycache.spring.AppContextHolder;
import io.github.flylib.flycache.hash.Node;
import io.github.flylib.flycache.util.ShardUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @author liushaoming
 * @Package io.github.flylib.flycache.controller
 * @Description:
 * @date 2018-1-19 9:55
 */
@Controller
public class IndexController {
    private final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private NodeGroupService nodeGroupService;

    @ResponseBody
    @RequestMapping("")
    public String demo() {
        return "demo response from flycache-core.-------";
    }

    @ResponseBody
    @RequestMapping("testRedis")
    public String testRedis() {
        JedisPoolShardFactory jedisPoolShardFactory = AppContextHolder.getBean(JedisPoolShardFactory.class);
        Node node = new Node();
        node.setHost("127.0.0.1");
        node.setPort("6379");
        node.setRemark("");
        JedisPool jedisPool = jedisPoolShardFactory.getJedisPool(node);
        RedisClient redisClient = new RedisClient();
        redisClient.setJedisPool(jedisPool);
        String key = "testCache";
        redisClient.set(key, "mmmmmmm");
        String value = redisClient.get(key);
        System.out.println(value);
        return value;
    }

    @ResponseBody
    @RequestMapping("test1")
    public String test1() {
        ShardUtil.initNodes();
        return "test1 done";
    }

    @ResponseBody
    @RequestMapping("nodeGroup")
    public String nodeGroup() {
        List<NodeGroupEntity> entityList = nodeGroupService.all();


        if (entityList != null && entityList.size() > 0) {
            for (NodeGroupEntity entity : entityList) {
                String jsonStr = entity.getNode();
                List<Node> nodeList = JSON.parseArray(jsonStr, Node.class);
                log.info("nodeList={}", nodeList);
            }
        }

        String listStr = JSONArray.toJSONString(entityList);
        return listStr;
    }
}

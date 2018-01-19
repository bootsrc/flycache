package io.github.flylib.flycache.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author liushaoming
 * @Package io.github.flylib.flycache.redis
 * @Description:
 * @date 2018-1-19 11:33
 */
@Configuration
public class RedisConfig {
    @Value("${redisPool.maxIdle}")
    private int maxIdle;

    @Value("${redisPool.maxTotal}")
    private int maxTotal;

    @Value("${redisPool.testOnBorrow}")
    private boolean testOnBorrow;

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        return jedisPoolConfig;
    }
}

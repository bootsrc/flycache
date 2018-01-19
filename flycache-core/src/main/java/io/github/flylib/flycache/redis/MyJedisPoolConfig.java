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
public class MyJedisPoolConfig {
    @Value("${redisPool.maxIdle}")
    private int maxIdle;

    @Value("${redisPool.maxTotal}")
    private int maxTotal;

    @Value("${redisPool.testOnBorrow}")
    private boolean testOnBorrow;

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    @Bean
    public JedisPoolConfig newJedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        return jedisPoolConfig;
    }
}

package io.github.flylib.flycache.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liushaoming
 * @Package io.github.flylib.flycache.redis
 * @Description:
 * @date 2018-1-19 11:43
 */
@Configuration
public class JedisSettings {
    @Value("@{redis.timeout}")
    private int timeout;

    @Value("@{redis.password}")
    private int password;

    @Value("@{redis.db}")
    private int db;

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getDb() {
        return db;
    }

    public void setDb(int db) {
        this.db = db;
    }

    @Bean
    public JedisSettings jedisSettings(){
        JedisSettings jedisSettings=new JedisSettings();
        jedisSettings.setTimeout(timeout);
        jedisSettings.setPassword(password);
        jedisSettings.setDb(db);
        return jedisSettings;
    }
}

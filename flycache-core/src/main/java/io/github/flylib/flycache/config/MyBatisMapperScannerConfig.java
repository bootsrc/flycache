package io.github.flylib.flycache.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liushaoming
 * @Package io.github.flylib.flycache.config
 * @Description:
 * @date 2018-1-23 16:51
 *
 * 扫描mybatis的接口
 */
@Configuration
// 因为这个对象的扫描，需要在MyBatisConfig的后面注入，所以加上下面的注解
@AutoConfigureAfter(MyBatisConfig.class)
public class MyBatisMapperScannerConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //获取之前注入的beanName为sqlSessionFactory的对象
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //指定xml配置文件的路径
//        mapperScannerConfigurer.setBasePackage("com.framework.msg.mapper");
        mapperScannerConfigurer.setBasePackage("io.github.flylib.flycache.repository");
        return mapperScannerConfigurer;
    }
}

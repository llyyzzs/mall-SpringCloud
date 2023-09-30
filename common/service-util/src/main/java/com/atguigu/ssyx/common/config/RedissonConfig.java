package com.atguigu.ssyx.common.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedissonConfig {

    private String host;

    private String addresses;

    private String password;

    private String port;

    private int timeout = 3000;
    private int connectionPoolSize = 64;
    private int connectionMinimumIdleSize=10;
    private int pingConnectionInterval = 60000;
    private static String ADDRESS_PREFIX = "redis://";

    /**
     * 自动装配
     *
     */
    @Bean
    public RedissonClient redissonSingle() {
        Config config = new Config();
        //  判断redis 的host是否为空
        if(StringUtils.isEmpty(host)){
            throw new RuntimeException("host is  empty");
        }
        //  配置host，port等参数
        SingleServerConfig serverConfig = config.useSingleServer()
                //redis://127.0.0.1:7181
                .setAddress(ADDRESS_PREFIX + this.host + ":" + port)
                .setTimeout(this.timeout) //设置Redis客户端与服务器建立连接的超时时间。
                .setPingConnectionInterval(pingConnectionInterval)//设置连接的持续活动监测间隔时间
                .setConnectionPoolSize(this.connectionPoolSize)//设置连接池的大小
                .setConnectionMinimumIdleSize(this.connectionMinimumIdleSize);//设置连接池的最小空闲连接数
        //  判断进入redis 是否密码
        if(!StringUtils.isEmpty(this.password)) {
            serverConfig.setPassword(this.password);
        }
        // RedissonClient redisson = Redisson.create(WebMvcConfiguration);
        return Redisson.create(config);
    }
}

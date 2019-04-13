package com.pgleon.user.bootconfig;

import com.google.common.collect.ImmutableMap;
import com.pgleon.mallspringboot.config.RedisCacheConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@EnableCaching
public class MyRedisCacheConfiguration extends RedisCacheConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(MyRedisCacheConfiguration.class);

    @Override
    public Map<String, Long> getExpires() {
        return ImmutableMap.<String, Long>builder()
                .put("demos", 1 * 60L)
                .build();
    }
}

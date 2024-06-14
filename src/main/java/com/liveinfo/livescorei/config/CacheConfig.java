package com.liveinfo.livescorei.config;


import java.time.Duration;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig  {

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cacheManager -> {
            cacheManager.createCache("methodCache", Eh107Configuration.fromEhcacheCacheConfiguration(
                    CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                            ResourcePoolsBuilder.heap(100))
                            .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(25)))
                            .build()));
        };
    }
}


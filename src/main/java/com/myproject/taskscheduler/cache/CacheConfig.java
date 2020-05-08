package com.myproject.taskscheduler.cache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * This class enable the Spring Caching strategy.
 * In this configuration we can call annotation base <br>
 * caching. This will ease the stress of the database <br>
 * instead of calling directly to the database, call the <br>
 * cache instead.
 *
 * @author Christian Pelayo
 * @since 2020-05-08
 */
@Configuration
@EnableCaching
public class CacheConfig {

}

package org.jzen.invoicing.config;



import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;


import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;

import org.springframework.stereotype.Component;
import static java.util.concurrent.TimeUnit.MINUTES;

@Component
public class EhcacheConfig implements JCacheManagerCustomizer  {

	@Override
	public void customize(javax.cache.CacheManager cacheManager) {
		 cacheManager.createCache("users", new MutableConfiguration<>()  
			        .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(MINUTES, 10))) 
			        .setStoreByValue(false)
			        .setStatisticsEnabled(false));
		 
	}



}

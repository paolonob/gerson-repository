package com.pnm.logicLayer;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.pnm.dataLayer.repositories", "com.pnm.logicLayer.components"})
public class SpringConfiguration {
	
	

}

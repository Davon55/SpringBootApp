package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.gcu.business.UsersBusinessService;
import com.gcu.business.UsersBusinessServiceInterface;

@Configuration

public class SpringConfig {
	
	@Bean(name="userBusinessService", initMethod="init", destroyMethod="destroy")

	public UsersBusinessServiceInterface getUsersBusiness()
	{
		return new UsersBusinessService();
	}

}

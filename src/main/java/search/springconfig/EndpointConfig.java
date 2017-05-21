package search.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import search.controller.SearchApplicationController;

/**
 * Here defined controller
 * 
 * @author Raman Skaskevich
 * */
@Configuration
public class EndpointConfig
{
	@Bean
	public SearchApplicationController searchApplicationController()
	{
		return new SearchApplicationController();
	}
}

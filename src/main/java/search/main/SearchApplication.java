package search.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import search.springconfig.EndpointConfig;

/**
 * 
 * @author Raman Skaskevich
 * */
@Import({
	EndpointConfig.class
})
@SpringBootApplication
public class SearchApplication
{
	public static void main(final String[] args) throws Exception
	{
		SpringApplication.run(SearchApplication.class, args);
	}
}

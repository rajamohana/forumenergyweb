package com.cyientinsights.forumenergyweb;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
@SpringBootApplication
public class ForumenergywebApplication  extends SpringBootServletInitializer implements CommandLineRunner{
	
	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ForumenergywebApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ForumenergywebApplication.class, args);
    }        */
	
	
	 public static void main(String[] args) {
		 
	        SpringApplication.run(ForumenergywebApplication.class, args);
	   
	 }

	 
	  @Bean
	    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	        return new PropertySourcesPlaceholderConfigurer();
	    }

	 
	 
	    /**
	     * Used when run as WAR
	     */
	  @Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
			return builder.sources(ForumenergywebApplication.class);
			
		}
		
		@Override
		public void run(String... args) throws Exception {
			
			
		}
	
	
}

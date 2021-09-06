package com.sefrinaldi.finaljavabe;

import com.sefrinaldi.finaljavabe.database.security.JWTAuthorizationFilter;
import com.sefrinaldi.finaljavabe.database.service.RestService;
import com.sefrinaldi.finaljavabe.restapi.rabbitmq.RestApiReceive;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication(scanBasePackages={"com.sefrinaldi.finaljavabe"})
public class FinaljavabeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinaljavabeApplication.class, args);
		RestApiReceive restApiReceive = new RestApiReceive();

		try {
			restApiReceive.receiveFromDatabase();
			restApiReceive.returnFromDatabase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@EnableWebSecurity
//	@Configuration
//	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//		@Override
//		protected void configure(HttpSecurity http) throws Exception {
//			http.csrf().disable()
//					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
//					.authorizeRequests()
//					.antMatchers(HttpMethod.POST, "/user/register").permitAll()
//					.antMatchers(HttpMethod.POST, "/user/login").permitAll()
//					.anyRequest().authenticated();
//		}
//	}

}

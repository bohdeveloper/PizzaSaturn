package com.bohdeveloper.pizzasaturn.configuraciones;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/tienda/**").authenticated()// <-- Acceso a usuarios registrados / .hasRole("ADMIN") <-- Acceso al rol administrador
			.anyRequest().permitAll()
			.and()
		.formLogin()
			.loginPage("/login")
		.permitAll()
			.and()
			.logout()
		.permitAll();
	}

 	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	  throws Exception {
	    auth.jdbcAuthentication()
	      .dataSource(dataSource)
		  
	//Iniciar sesión con email
	.usersByUsernameQuery("SELECT email, password, 1 "
	        + "FROM usuarios "
	        + "WHERE email = ?")
	      .authoritiesByUsernameQuery("SELECT u.email, CONCAT('ROLE_', r.nombre) "
		    + "FROM usuarios u JOIN roles r ON u.rol_id = r.id "
	        + "WHERE email = ?");
	}

	//Iniciar sesión con nombre de usuario
/* 	.usersByUsernameQuery("SELECT nombre, password, 1 "
	        + "FROM usuarios "
	        + "WHERE nombre = ?")
	      .authoritiesByUsernameQuery("SELECT u.nombre, CONCAT('ROLE_', r.nombre) "
		    + "FROM usuarios u JOIN roles r ON u.rol_id = r.id "
	        + "WHERE u.nombre = ?");
	} */

	

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder(); // NoOpPasswordEncoder.getInstance(); 
	} 
}

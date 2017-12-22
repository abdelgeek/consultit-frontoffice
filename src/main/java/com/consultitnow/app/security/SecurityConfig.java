package com.consultitnow.app.security;

import javax.annotation.security.PermitAll;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
/*
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Order(1)
*/
public class SecurityConfig  {//extends WebSecurityConfigurerAdapter

	/*
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
	
		
		// return username, password, and role using username
		auth.jdbcAuthentication()
			.dataSource(dataSource)
				.usersByUsernameQuery(
					"select username as principal, password as credentials,true from users where username=? AND actived=true")
				.authoritiesByUsernameQuery(""
						+ "SELECT users.username as principal, role.role_wording as role"
						+ " FROM users_role,users,role "
						+ " WHERE users_role.users_user_id =users.user_Id and users_role.role_role_id =role.role_Id"
						+ " and role.activated=true and users_role.authorized=true and username=?")
				.rolePrefix("Role_");
		
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/assets/**").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll()
		.and().logout().invalidateHttpSession(true).logoutUrl("/logout").permitAll();
	}
*/
}
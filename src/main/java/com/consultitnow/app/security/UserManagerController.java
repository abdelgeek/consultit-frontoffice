package com.consultitnow.app.security;


import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagerController {

	/*
	@RequestMapping(value="/getLogedUser")
	public Map<String, Object> getLoggedUser(HttpSession httpSession ){
		
		
		SecurityContext securityContext = (SecurityContext)httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		
		String userName = securityContext.getAuthentication().getName();
		List<String> roles = new ArrayList<>();
		for(GrantedAuthority ga : securityContext.getAuthentication().getAuthorities()){
			roles.add(ga.getAuthority());
		}
		Map<String,Object> params = new HashMap<>();
		
		params.put("username",userName);
		params.put("roles",roles);
		
		return params;
	}
	*/
}

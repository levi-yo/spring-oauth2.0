package org.client.controller;

import org.client.entity.domain.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
	
	@Autowired private OAuth2RestTemplate restTemplate;
	
	@GetMapping("/dashboard")
	public ModelAndView dashboard(ModelAndView mav) {
		callProtectedResource(mav);
		mav.setViewName("dashboard");
		return mav;
	}
	
	@GetMapping("/callback")
	public ModelAndView callback() {
		return new ModelAndView("forward:/dashboard");
	}
	
	private void callProtectedResource(ModelAndView mav) {
		String endpoint = "http://localhost:8090/api/profile";
		mav.addObject("profile", restTemplate.getForObject(endpoint, UserProfile.class));
	}
}

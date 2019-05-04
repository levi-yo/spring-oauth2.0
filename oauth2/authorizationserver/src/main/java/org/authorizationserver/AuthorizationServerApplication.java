package org.authorizationserver;

import org.authorizationserver.constrant.UserRole;
import org.authorizationserver.entity.ResourceOwner;
import org.authorizationserver.repository.ResourceOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthorizationServerApplication implements CommandLineRunner
{
	
	@Autowired private ResourceOwnerRepository repository;
	@Autowired private PasswordEncoder passwordEncoder;
	
    public static void main( String[] args )
    {
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		
		ResourceOwner user = new ResourceOwner();
		user.setId(1l);
		user.setUsername("1223yys@naver.com");
		user.setPassword(passwordEncoder.encode("password"));
		user.setRole(UserRole.ROLE_USER);
		
		repository.save(user);
		
	}
    
}

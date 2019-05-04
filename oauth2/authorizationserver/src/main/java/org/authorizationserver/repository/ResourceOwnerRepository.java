package org.authorizationserver.repository;

import org.authorizationserver.entity.ResourceOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceOwnerRepository extends JpaRepository<ResourceOwner, Long>{

	public ResourceOwner findByUsername(String username);

}

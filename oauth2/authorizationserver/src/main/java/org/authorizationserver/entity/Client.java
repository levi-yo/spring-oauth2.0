package org.authorizationserver.entity;

import org.authorizationserver.constrant.ClientType;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import lombok.Getter;

/**
 * 
 * @author yun-yeoseong
 *
 */
public class Client extends BaseClientDetails{

	private static final long serialVersionUID = 5840531070411146325L;
	
	@Getter
	private ClientType clientType;


	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
		this.addAdditionalInformation("client_type", clientType.name());
	}

}

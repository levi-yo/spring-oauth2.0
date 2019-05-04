package org.authorizationserver.entity;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

/**
 * Client Dto, 클라이언트 등록에 사용되는 컨트롤러 요청 Dto이다.
 * @author yun-yeoseong
 *
 */
@Getter
@Setter
@ToString
public class ClientDto {
	
	private String name;
	private String redirectUri;
	private String clientType;
}

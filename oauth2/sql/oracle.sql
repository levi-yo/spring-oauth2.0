CREATE USER oauth2 IDENTIFIED BY oauth2;
GRANT CONNECT,resource TO oauth_user;

-- 클라이언트 등록과 관련된 데이터 테이블
create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(2000),
  autoapprove VARCHAR(256)
);

-- AUTHORIZATION SERVER ClientDetailsServiceConfigurer IN Memory 형식에 정의했던 데이터 삽입
INSERT INTO oauth_client_details
    (client_id, resource_ids, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity,
    additional_information, autoapprove)
VALUES
    ('clientapp', null, '123456',
    'read_profile,read_posts', 'authorization_code,refresh_token',
    'http://localhost:9000/callback',
    null, 3000, -1, null, 'false');
    
INSERT INTO oauth_client_details
    (client_id, resource_ids, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity,
    additional_information, autoapprove)
VALUES
    ('clientapp', null, '311ffdc998038e85ac0b5bd1fb20097a67281b7c0bc0ef905771daec9eb52b66',
    'read_profile,read_posts', 'authorization_code,refresh_token',
    'http://localhost:9000/callback',
    null, 3000, -1, null, 'false');

-- 발급된 액세스 토큰을 저장하기 위한 테이블
create table oauth_access_token (
  token_id VARCHAR(256),
  token clob,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication clob,
  refresh_token VARCHAR(256)
);

-- 리프레시 토큰 발급을 위한 테이블
create table oauth_refresh_token (
  token_id VARCHAR(256),
  token varchar(1000),
  authentication varchar(1000)
);

SELECT * from OAUTH_REFRESH_TOKEN;

-- 사용자의 승인을 저장하기 위한 테이블
create table oauth_approvals (
    userId VARCHAR(256),
    clientId VARCHAR(256),
    scope VARCHAR(256),
    status VARCHAR(10),
    expiresAt TIMESTAMP,
    lastModifiedAt TIMESTAMP
);

create table oauth_code (
  code VARCHAR(256), authentication blob
);

-- 클라이언트 유저테이블
create table client_user(
    id integer primary key,
    username varchar(100),
    password varchar(50),
    access_token varchar(2000),
    access_token_validity TIMESTAMP,
    refresh_token varchar(2000)
);

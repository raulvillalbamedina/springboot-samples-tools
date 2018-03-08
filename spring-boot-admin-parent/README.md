# SPRING-AUTHENTICATION-PARENT

We use spring-cloud-starter-oauth2 to secure our apis.

## Modules

We have 2 modules:

* spring-authentication-server. An unique server to all verticals. 

* spring-authenticacion-client. Dependency to configure spring resource client.

# spring-authentication-server

## Server configuration

We have this properties to configure in this server:

	security.user.name=springTest
	security.user.password=springtestsecret
	security.oauth2.client.clientId=spring
	security.oauth2.client.clientSecret=springsecret

This values is needed to use at http client.

## Manual call to get a token

To get a token do you need call to this endpoint:

	(sample with 33 server) http://10.12.0.33:9091/oauth/token 
	
With method:

	POST
	
With header:

	Content-Type application/x-www-form-urlencoded
	
With basic auth (values in applicationXX.properties in tests):

	spring / springsecret
	
With parameters

	grant_type / password
	username / springTest
	password / springtestsecret
	

When yo call to this endpoint yo receive a json same that

	{
	  "access_token": "58e4e347-aea1-4e85-83e0-08e70554c28a",
	  "token_type": "bearer",
	  "refresh_token": "e9e7e352-318d-4312-bc6c-d7f61111ccf3",
	  "expires_in": 43199,
	  "scope": "openid"
	}
	
### Test your token in spring-authorization-server

Now yo could use the access_token to call to secured endpoints. To test this token yo could call to this endpoint in spring-authorization-server

	(sample with 33 server)  http://10.12.0.33:9091/authentication/user

With method

	GET
	
With header

	Authorization / Bearer 58e4e347-aea1-4e85-83e0-08e70554c28a
	
When yo call to this endpoint yo receive a json same that

	{
	  "authorities": [
	    {
	      "authority": "ROLE_ACTUATOR"
	    },
	    {
	      "authority": "ROLE_USER"
	    }
	  ],
	  "details": {
	    "remoteAddress": "10.50.254.18",
	    "sessionId": null,
	    "tokenValue": "58e4e347-aea1-4e85-83e0-08e70554c28a",
	    "tokenType": "Bearer",
	    "decodedDetails": null
	  },
	  "authenticated": true,
	  "userAuthentication": {
	    "authorities": [
	      {
	        "authority": "ROLE_ACTUATOR"
	      },
	      {
	        "authority": "ROLE_USER"
	      }
	    ],
	    "details": {
	      "grant_type": "password",
	      "username": "springTest"
	    },
	    "authenticated": true,
	    "principal": {
	      "password": null,
	      "username": "springTest",
	      "authorities": [
	        {
	          "authority": "ROLE_ACTUATOR"
	        },
	        {
	          "authority": "ROLE_USER"
	        }
	      ],
	      "accountNonExpired": true,
	      "accountNonLocked": true,
	      "credentialsNonExpired": true,
	      "enabled": true
	    },
	    "credentials": null,
	    "name": "springTest"
	  },
	  "credentials": "",
	  "principal": {
	    "password": null,
	    "username": "springTest",
	    "authorities": [
	      {
	        "authority": "ROLE_ACTUATOR"
	      },
	      {
	        "authority": "ROLE_USER"
	      }
	    ],
	    "accountNonExpired": true,
	    "accountNonLocked": true,
	    "credentialsNonExpired": true,
	    "enabled": true
	  },
	  "oauth2Request": {
	    "clientId": "spring",
	    "scope": [
	      "openid"
	    ],
	    "requestParameters": {
	      "grant_type": "password",
	      "username": "springTest"
	    },
	    "resourceIds": [],
	    "authorities": [
	      {
	        "authority": "ROLE_USER"
	      }
	    ],
	    "approved": true,
	    "refresh": false,
	    "redirectUri": null,
	    "responseTypes": [],
	    "extensions": {},
	    "refreshTokenRequest": null,
	    "grantType": "password"
	  },
	  "clientOnly": false,
	  "name": "springTest"
	}
	
# spring-authentication-client

We add this dependency to all verticals that we want to secure. By default are disabled.

## Configuration client

If you want to enable the authentication in verticals you need to add 2 properties at vertical application.properties.

sample with 33 server:

	security.oauth2.resource.userInfoUri: http://10.12.0.33:9091/authentication/user
	access.token.uri.test=http://10.12.0.33:9091/oauth/token
	
Now the verticals block all calls without a good token. 


In RestServerXXIT.java have samples to use OAuth2RestTemplate (calls oauth2 with spring) and samples to use our java7 springClients with oauth2 (using our class Oauth2Configuration)
package com.zeus.LoginGF.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class Oauth2Config extends AuthorizationServerConfigurerAdapter {
	
	private String clientId = "zeus";
	private String clientSecret = "my-secret";
	private String privateKey = "-----BEGIN RSA PRIVATE KEY-----\n" + 
			"MIIEpAIBAAKCAQEAxZLrU8szCpln2QbcC2ehCtniG57+mq3QZF2Y/X/hW+uQ25yM\n" + 
			"3IEH4wUHAVZBoeGHoUR3VY9yHO1esVVyz2F9adDJQAeO6RKTqxgxa8iNcSutnvi/\n" + 
			"08/C3yz+ahLlG7o3dLzrDW9HFVcnmuZM/Vxp3d+APp9h6u9pdw1SG07vaNL7Lbzs\n" + 
			"TqNnoBq5RRZv/sHuCK8OcXp/dBwKSDOnH5NSU9ULL7d6KbucUCuiyzosIE8afGXS\n" + 
			"wrv4+7+djxnPP0jvC2+MwnvViGy4Hvg3igZoGy4t+Zd/wmD+vsALipTh3m0jplfZ\n" + 
			"Jz9yrdnso4Y5VwSnror63epDI30bvhzedN958wIDAQABAoIBABmfMvt755OhT1Fa\n" + 
			"zWCBQOY6WVNBrDz8+4B4juWZFu2nv/Jq++2Aojgzp7PprrtClyc3zM4Au0i7E8Ol\n" + 
			"lC0GtI/rbp3qHQNm0FWo3ofey1D43Bw4oA/k6p2spRW2e5W78YMnGMh2PN6sncs9\n" + 
			"wJA+0s/eMzBr1PP1tlSlGpfGBdAvCeH89TqvtaQ0sGaV+OG0O3CupY3Vbajs8/v/\n" + 
			"I5910xYkji4JbmFk5KZ7UmBaC2tqahHXO6WtTXSEeghjTvXjIynFuopm74Xy3jju\n" + 
			"6dYNB08SRiRdk7wbtpcCF3n+sp/MvkPx0IdcdxYMkcgCbDj9oMTF+blh03KD/aJi\n" + 
			"0WeddbkCgYEA5X9l3gOHord6E77VnCXwtDF0KNp2plIYR4p227+y3FvjAb409odS\n" + 
			"GLiecQFEtyxVRN0vge9sW3NSpUg87fkA02llXbHDoC8ysFdPO7xWCZW/Un9NMscq\n" + 
			"FyAyVouYQRAahMkKK9iACnqGJ+T2Augb166aguqywdd+MpfaB7DNqM0CgYEA3GPD\n" + 
			"yWq80TsW4lSxUOt9Lvg1zJre/r5a9toywq56yQs0JKe1pbyjtPMHysEPdVSrgTb0\n" + 
			"H/EDEszVO5oMGXmLhISGNqbjtKTo0Ymi76przXRd7DxmT3Xx4Ec2MLs1enJaB0Yf\n" + 
			"bTwK6EpZpbO+YaUKrQwORgdKhETA4v5OiEHMrb8CgYEAuo4XJqRD67euGsL0LZyB\n" + 
			"0FirDlKYRJdTeURLXlK0eICRRedycjyKNeJNmZroWuZE4lfSuJMByE00j3rrXJ8f\n" + 
			"VrvEVKeeWGZFlCdFF0//uIbsIYmuHWrdAjN/9+499BW9GNe71uyFGP+EcoWinbZE\n" + 
			"e81JeMaETSJ5SXM7HylP5LkCgYEAzZVKt4KX691g9XPnjAJ/3eav2NLHHX7YP9k+\n" + 
			"7Jfx9cQ7uc2wBpC3bT4fkKUTFHINIhXvGDSsl0b3ygdjLghReyZcRHLdik8i1wO7\n" + 
			"ODITKa5ZRtr43Tq6jGohRMf9lOFC1fI1sqIF0rY4dff7qf5YvR+32N9IRaYVACoV\n" + 
			"e8lVcuUCgYBN82F4e3a0YfA5p1E1UDpea5cOTNlj1CWyVsUl3HYlpqzS6WDld8Mk\n" + 
			"6+Ngs9surCYlafPORFmuXZhDMsVxrbdbDkNQ9QJmZD/hoSWc9eKyCokkv4RXvjJY\n" + 
			"AEN63n10kKAGP3kxJKBev1dxxThftHRS/CP6TQR58NtMjbUPMheh1w==\n" + 
			"-----END RSA PRIVATE KEY-----";
	private String publicKey = "-----BEGIN PUBLIC KEY-----\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxZLrU8szCpln2QbcC2eh\n" + 
			"CtniG57+mq3QZF2Y/X/hW+uQ25yM3IEH4wUHAVZBoeGHoUR3VY9yHO1esVVyz2F9\n" + 
			"adDJQAeO6RKTqxgxa8iNcSutnvi/08/C3yz+ahLlG7o3dLzrDW9HFVcnmuZM/Vxp\n" + 
			"3d+APp9h6u9pdw1SG07vaNL7LbzsTqNnoBq5RRZv/sHuCK8OcXp/dBwKSDOnH5NS\n" + 
			"U9ULL7d6KbucUCuiyzosIE8afGXSwrv4+7+djxnPP0jvC2+MwnvViGy4Hvg3igZo\n" + 
			"Gy4t+Zd/wmD+vsALipTh3m0jplfZJz9yrdnso4Y5VwSnror63epDI30bvhzedN95\n" + 
			"8wIDAQAB\n" + 
			"-----END PUBLIC KEY-----";
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	@Bean 
	public JwtAccessTokenConverter tokenEnhancer() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(privateKey);
		converter.setVerifierKey(publicKey);
		return converter;
	}
	
	@Bean 
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(tokenEnhancer());
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception{
			endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				.accessTokenConverter(tokenEnhancer());
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll").checkTokenAccess("isAuthnticaticated()");
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		clients.inMemory().withClient(clientId).secret(clientSecret).scopes("read", "write")
			.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(20000)
			.refreshTokenValiditySeconds(20000);
		
	}
	
	
	

}

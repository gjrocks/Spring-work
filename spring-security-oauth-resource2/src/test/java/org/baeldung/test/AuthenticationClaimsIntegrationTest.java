package org.baeldung.test;

import static org.junit.Assert.assertTrue;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
//import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import sun.misc.BASE64Decoder;

import org.apache.commons.io.IOUtils;
import org.baeldung.ResourceServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ResourceServerApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class AuthenticationClaimsIntegrationTest {

    @Autowired
    private JwtTokenStore tokenStore;

    //@Test
    public void whenTokenDontContainIssuer_thenSuccess() {
        final String tokenValue = obtainAccessToken("fooClientIdPassword", "john", "123");
        final OAuth2Authentication auth = tokenStore.readAuthentication(tokenValue);
        System.out.println(tokenValue);
        System.out.println(auth);
        assertTrue(auth.isAuthenticated());
        System.out.println(auth.getDetails());
        //auth.
        Map<String, Object> details = (Map<String, Object>) auth.getDetails();
        assertTrue(details.containsKey("organization"));
        System.out.println(details.get("organization"));
    }
  
    @Test
    public void testForExpiration() throws Exception{
    	String token="eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJqb2huIiwic2NvcGUiOlsiZm9vIiwicmVhZCIsIndyaXRlIl0sIm9yZ2FuaXphdGlvbiI6ImpvaG53WHl2IiwiZXhwIjoxNTQwOTYxMzcyLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiMzc1M2M4MmUtY2M5ZC00MzBmLWFiMGItOTg0MjYyMDJkZDA2IiwiY2xpZW50X2lkIjoiZm9vQ2xpZW50SWRQYXNzd29yZCJ9.A3gcEIf2CO7PQshrQMNwzdCzHdS8tfp2G-CppJtWPUoL_2CglzkIApQGpvUa8Lp15jEK-B04K-PykX_ZAhLFcxzyC-3dDH1NMlmrbVTpasqmg-qYvHYMrOa6GbJf7cZxJVNuKxNA7R8sReocvyOCY2lktJ_y51Jo0QEFsJXRZoNuj4sFmRFtPMXMS8n-ldvVI_2G3-5lqPggWM9DKE8d3hOAHxx02xjgsphGxSmfUNVhgymCt_VYydE2IK1Eo8SHGktV78sL7AGVoP2mM6NvVNwTTxlpW521Y-2MNkRBANyGMLAjo_g8zR47er3IMwuPN-ZijlmKre0dGV5hiEaKLA";
    	final OAuth2Authentication auth = tokenStore.readAuthentication(token);
    	//tokenStore.
    	final Resource resource = new ClassPathResource("public.txt");
        String publicKey = null;
        try {
            publicKey = IOUtils.toString(resource.getInputStream());
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }
        
        PublicKey pk=getPemPublicKey("c:\\temp\\public.txt","RSA");
       // publicKey=publicKey.replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", "");
       // PublicKey pk=getKey(publicKey);
        //PublicKey pk=getPublicKey(publicKey.getBytes());
       // converter.setVerifierKey(publicKey);
    	final Claims claims = Jwts.parser().setSigningKey(pk)
                .parseClaimsJws(token).getBody();
    	  System.out.println(claims);
    }
    private String obtainAccessToken(String clientId, String username, String password) {
        final Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "password");
        params.put("client_id", clientId);
        params.put("username", username);
        params.put("password", password);
        final Response response = RestAssured.given()
            .auth()
            .preemptive()
            .basic(clientId, "secret")
            .and()
            .with()
            .params(params)
            .when()
            .post("http://localhost:8981/spring-security-oauth-server/oauth/token");
        return response.jsonPath()
            .getString("access_token");
    }

    public static PublicKey getKey(String key){
        try{
        	
        	byte[] byteKey = Base64.getDecoder().decode(key.getBytes());
            X509EncodedKeySpec X509publicKey = new X509EncodedKeySpec(byteKey);
            KeyFactory kf = KeyFactory.getInstance("RSA");

            return kf.generatePublic(X509publicKey);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }
    
    PublicKey getPublicKey(byte[] encodedKey) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        KeyFactory factory = KeyFactory.getInstance("RSA");
        X509EncodedKeySpec encodedKeySpec = new X509EncodedKeySpec(encodedKey);
        return factory.generatePublic(encodedKeySpec);
    }
    
    public  PublicKey getPemPublicKey(String filename, String algorithm) throws Exception {
        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int) f.length()];
        dis.readFully(keyBytes);
        dis.close();

        String temp = new String(keyBytes);
        String publicKeyPEM = temp.replace("-----BEGIN PUBLIC KEY-----\n", "");
        publicKeyPEM = publicKeyPEM.replace("-----END PUBLIC KEY-----", "");


        BASE64Decoder b64=new BASE64Decoder();
        byte[] decoded = b64.decodeBuffer(publicKeyPEM);

        X509EncodedKeySpec spec =
              new X509EncodedKeySpec(decoded);
        KeyFactory kf = KeyFactory.getInstance(algorithm);
        return kf.generatePublic(spec);
        }
}

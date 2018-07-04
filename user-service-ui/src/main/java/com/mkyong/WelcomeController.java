package com.mkyong;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
@RestController

public class WelcomeController {

	@Value("${gateway.url}")
	@NotNull
	private String gatewayUrl;
	
	@Value("${server.contextPath:/}")
	@NotNull
	private String contextPathUrl;
	
	
	@Autowired
	private RestTemplate client;
	
	private String whereAbouts=getWhereAbouts();
	// inject via application.properties
	/*@Value("${welcome.message:test}")
	private String message = "Hello World";

	@Value("${randomFlag:true}")
    private String randomFlag;
	@Value("${system.config.dir:true}")
	private String location;
	*/
	
	public static Map<String,String> userValues=new HashMap<String,String>();
	
	@RequestMapping("/")
	public ModelAndView welcome(ModelAndView mav) {
	/*	System.out.println("Ganesh  :" +randomFlag);
    	System.out.println("ffff :" +location);
		model.put("message", this.message);*/
		mav.setViewName("index");
		mav.addObject("context-path", contextPathUrl);
		//ModelAndView mav = new ModelAndView("index");
		mav.addObject("data", "''");
		
		return mav;
	}

	
	@RequestMapping(value="/ping", method=RequestMethod.GET)
	public ResponseEntity<String> ping(){
    	System.out.println("Returning from the ping from container :" +System.getenv("HOSTNAME") + "::" +System.getProperty("HOSTNAME"));
		return new ResponseEntity<String>("<H1>Service is running at <br>"+getWhereAbouts()+"</H1>", HttpStatus.OK);
	}
	 @PostMapping("/getuser") // //new annotation since 4.3
	public @ResponseBody String getUserDetails(HttpServletRequest request, Model model) {
		 String data=null;
		try {
			ResponseEntity<String> resp=client.getForEntity(gatewayUrl+"/user", String.class);
			data=resp.getBody();
			//String data="[{\"id\":1,\"fname\":\"fname\",\"lname\":\"lname\",\"address\":\"address\",\"userid\":\"userid\",\"mobileNumber\":\"mobileNumber\",\"email\":\"email@email.com\"},{\"id\":2,\"fname\":\"ganesh\",\"lname\":\"jadhav\",\"address\":\"ganesh address\",\"userid\":\"ganesh-1\",\"mobileNumber\":\"999\",\"email\":\"ganesh@ganesh.com\"},{\"id\":3,\"fname\":\"sidh\",\"lname\":\"nirwane\",\"address\":\"sidh address\",\"userid\":\"sidh-1\",\"mobileNumber\":\"998\",\"email\":\"sidh@sidh.com\"},{\"id\":4,\"fname\":\"aarvi\",\"lname\":\"jadhav\",\"address\":\"aarvi address\",\"userid\":\"aarvi-1\",\"mobileNumber\":\"997\",\"email\":\"aarvi@aarvi.com\"}]";
			model.addAttribute("data", data);
		System.out.println("All Values :" + data);

		} catch (Exception e) {
			model.addAttribute("data", "''");
			e.printStackTrace();
		}
		
		return data;
	}

	 private static String getWhereAbouts() {
		    StringBuilder whereAbouts=new StringBuilder();
		    	if(System.getenv("HOSTNAME") !=null) {
		    		whereAbouts.append("Docker Container id : ");
		    		whereAbouts.append(System.getenv("HOSTNAME"));
		    	}
		    	whereAbouts.append("-------------------------------------<br> ");
		    		whereAbouts.append("Instance ip  : ");
		    		try {
		    		 Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
		            while (n.hasMoreElements())
		             {
		                     NetworkInterface e = n.nextElement();
		                   //  System.out.println("Interface: " + e.getName());
		                     Enumeration<InetAddress> a = e.getInetAddresses();
		                     for (; a.hasMoreElements();)
		                     {
		                             InetAddress addr = a.nextElement();
		                             whereAbouts.append( addr.getHostAddress());
		                             whereAbouts.append("<br>");
		                     }
		             }
		    		}catch(Exception e) {
		    			e.printStackTrace();
		    		}
		    		
		    		
		    		
		    	
		    		
		    	return whereAbouts.toString();
		    }
}


/*@Controller
@PropertySource(value="${system.config.dir}/basicws.properties",ignoreResourceNotFound = false)
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@Value("${randomFlag:true}")
    private String randomFlag;
	@Value("${system.config.dir:true}")
	private String location;
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		System.out.println("Ganesh  :" +randomFlag);
    	System.out.println("ffff :" +location);
		model.put("message", this.message);
		return "welcome";
	}

}*/
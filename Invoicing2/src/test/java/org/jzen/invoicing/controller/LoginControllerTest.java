package org.jzen.invoicing.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jzen.invoicing.service.MessageByLocaleService;
import org.jzen.invoicing.service.SendMailService;
import org.jzen.invoicing.service.UserService;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(controllers = LoginController.class)
public class LoginControllerTest {

	

	@MockBean
	private UserService userServiceMock;


	@MockBean
	private SendMailService sendMailServiceMock;

	@MockBean
	private MessageByLocaleService messageByLocaleServiceMock;

	@InjectMocks
	private LoginController loginController;

	private MockMvc mockMvc;

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);

		this.mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();

	}

	@Test
	public void testshowLogin() {
	

		try {
			String error=null;
			String logout=null;
			String sessionExpired=null;
			String passSentSuccess=null;
			mockMvc.perform(MockMvcRequestBuilders.get("/login").param("error",error).param("logout", logout).param("sessionExpired",sessionExpired).param("passSentSuccess",passSentSuccess))
			
			.andExpect(status().isOk())

			.andExpect(view().name("loginPage"))
					// .andExpect(MockMvcResultMatchers.view().name("products"))
					.andExpect(model().attribute("showMessage", false))

					.andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void testshowLoginError() {
		

		try {
			String error="";
			String logout=null;
			String sessionExpired=null;
			String passSentSuccess=null;
			mockMvc.perform(MockMvcRequestBuilders.get("/login").param("error",error).param("logout", logout).param("sessionExpired",sessionExpired).param("passSentSuccess",passSentSuccess)
					 .sessionAttr("SPRING_SECURITY_LAST_EXCEPTION", "exception message"))
			
			.andExpect(status().isOk())

			.andExpect(view().name("loginPage"))
					// .andExpect(MockMvcResultMatchers.view().name("products"))
					.andExpect(model().attribute("showMessage", true))

					.andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void testshowLogout() {
		

		try {
			String error=null;
			String logout="";
			String sessionExpired=null;
			String passSentSuccess=null;
			mockMvc.perform(MockMvcRequestBuilders.get("/login").param("error",error).param("logout", logout).param("sessionExpired",sessionExpired)
					.param("passSentSuccess",passSentSuccess)
					)
			
			.andExpect(status().isOk())

					.andExpect(view().name("loginPage"))
					// .andExpect(MockMvcResultMatchers.view().name("products"))
					.andExpect(model().attribute("showMessage", true)).andExpect(model().attribute("message", "You have been successfully logged out"))

					.andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void testshowSessionExpired() {
		
		try {
			String error=null;
			String logout=null;
			String sessionExpired="";
			String passSentSuccess=null;
			mockMvc.perform(MockMvcRequestBuilders.get("/login").param("error",error).param("logout", logout).param("sessionExpired",sessionExpired)
					.param("passSentSuccess",passSentSuccess))
			
			.andExpect(status().isOk())

					.andExpect(view().name("loginPage"))
					// .andExpect(MockMvcResultMatchers.view().name("products"))
					.andExpect(model().attribute("showMessage", true)).andExpect(model().attribute("message", "Your session is expired , Please relogin."))

					.andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	public void testshowPasswordRestSuccess() {
		
		try {
			String error=null;
			String logout=null;
			String sessionExpired=null;
			String passSentSuccess="";
			mockMvc.perform(MockMvcRequestBuilders.get("/login").param("error",error).param("logout", logout).param("sessionExpired",sessionExpired)
					.param("passSentSuccess",passSentSuccess))
			
			.andExpect(status().isOk())

					.andExpect(view().name("loginPage"))
					// .andExpect(MockMvcResultMatchers.view().name("products"))
					.andExpect(model().attribute("showMessage", true)).andExpect(model().attribute("message", "Your session is expired , Please relogin."))

					.andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
//	when(userRepositoryMock.findByUsername("sonali")).thenReturn(null);
//	@RequestMapping(value = "forgotPassword", method = RequestMethod.POST)
//	public String sendPasswordEmail(ModelMap model, @Valid @ModelAttribute("email") String email,
//			BindingResult bindingResult) {
//		logger.debug("generatePasswordToken page");
//		String message = "";
//		UserDetail user = userService.getUserByEmail(email);
//		if (user == null || !user.isEnabled()) {
//			message = messageByLocaleService.getMessage("user.validateEmail.message");
//		} else {
//			String token = UUID.randomUUID().toString();
//			boolean mailSent = sendMailService.sendPasswordInEmail(user, token);
//			if (mailSent) {
//				userService.updatePasswordToken(user, token);
//				return "redirect:login?passSentSuccess";
//			} else {
//				message = messageByLocaleService.getMessage("user.passwordreset.error.message");
//			}
//		}
//		model.addAttribute(MESSAGE, message);
//		model.addAttribute(SHOW_MESSAGE, true);
//		return "forgotPassword";
//	}
//	
//	@Test
//	public void testSendPasswordEmailTest() {
//		
//	}
	
	


}

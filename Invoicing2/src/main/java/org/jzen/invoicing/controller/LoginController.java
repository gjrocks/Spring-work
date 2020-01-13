package org.jzen.invoicing.controller;

import java.security.Principal;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.RandomStringUtils;
import org.jzen.invoicing.entity.UserDetail;
import org.jzen.invoicing.service.MessageByLocaleService;
import org.jzen.invoicing.service.SendMailService;
import org.jzen.invoicing.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private static final String MESSAGE = "message";
	private static final String SHOW_MESSAGE = "showMessage";
	private static final String SHOW_SUCCESS_MESSAGE = "showSuccessMessage";
	private static final int UID_LENGTH = 12;
	@Autowired
	private UserService userService;

	@Autowired
	private SendMailService sendMailService;

	@Autowired
	private MessageByLocaleService messageByLocaleService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String showLogin(Model model, HttpServletRequest request, HttpServletResponse response, String error,
			String logout, String sessionExpired, String passSentSuccess) {

		logger.debug("inside login page");
		
		String message;
		if (error != null) {
			logger.debug("error condition");
			message = request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION").toString();
			model.addAttribute(MESSAGE, message);
			model.addAttribute(SHOW_MESSAGE, true);
		} else if (logout != null) {
			logger.debug("logout condition");
			message = messageByLocaleService.getMessage("user.logout.message");
			model.addAttribute(MESSAGE, message);
			model.addAttribute(SHOW_SUCCESS_MESSAGE, true);
			model.addAttribute(SHOW_MESSAGE, false);
		} else if (sessionExpired != null) {
			logger.debug("sessionExpired condition");
			message = messageByLocaleService.getMessage("user.sessionExpired.message");
			model.addAttribute(MESSAGE, message);
			model.addAttribute(SHOW_MESSAGE, true);

		} else if (passSentSuccess != null) {
			logger.debug("passwordSent condition");
			message = messageByLocaleService.getMessage("user.passwordsent.message");
			model.addAttribute(MESSAGE, message);
			model.addAttribute(SHOW_SUCCESS_MESSAGE, true);
			model.addAttribute(SHOW_MESSAGE, false);
		} else {
			model.addAttribute(SHOW_MESSAGE, false);
		}
		return "login";

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		logger.debug("dashboad page");
		return new ModelAndView("currentInvoices2");
	}
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logoutPage() {
		logger.debug("logout page");
		return "logout";
	}

	@RequestMapping(value = "dashboard")
	public String showDashboard(Model model, Principal principal) {
		logger.debug("dashboard page");
		return "dashboard";
	}

	@RequestMapping(value = "forgotPassword", method = RequestMethod.GET)
	public String forgotPassword() {
		logger.debug("forgotPassword page");
		return "forgotPassword";
	}

	@RequestMapping(value = "forgotPassword", method = RequestMethod.POST)
	public String sendPasswordEmail(ModelMap model, @Valid @ModelAttribute("email") String email,
			BindingResult bindingResult) {
		logger.debug("generatePasswordToken page");
		String message = "";
		UserDetail user = userService.getUserByEmail(email);
		if (user == null || !user.isEnabled()) {
			message = messageByLocaleService.getMessage("user.validateEmail.message");
			return "redirect:login?passSentSuccess";
		} else {
		
			
			String token = RandomStringUtils.randomAlphanumeric(UID_LENGTH);
			
			boolean mailSent = sendMailService.sendPasswordInEmail(user, token);
			if (mailSent) {
				userService.updatePasswordToken(user, token);
				return "redirect:login?passSentSuccess";
			} else {
				message = messageByLocaleService.getMessage("user.passwordreset.error.message");
			}
		}
		model.addAttribute(MESSAGE, message);
		model.addAttribute(SHOW_MESSAGE, true);
		return "forgotPassword";
	}
}

package org.jzen.invoicing.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.RandomStringUtils;
import org.jzen.invoicing.bean.UserBean;
import org.jzen.invoicing.entity.CustomUserDecorator;
import org.jzen.invoicing.entity.UserDetail;
import org.jzen.invoicing.entity.enums.UserStatusType;
import org.jzen.invoicing.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String MESSAGE = "message";
	private static final String SHOW_ERROR = "showError";
	@Autowired
	private UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@RequestMapping(value = "saveUser", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("userDetails") @Valid UserBean userDetails, BindingResult result,
			ModelMap model) {
		UserDetail usr = null;
		CustomUserDecorator customUserdecorator = null;
		Map<String, String> errorMsg = null;
		usr = userService.getUser(userDetails.getUname());
		if (usr != null) {
			model.addAttribute(MESSAGE, "User alreay Exists.");
			model.addAttribute(SHOW_ERROR, true);
			model.addAttribute("userDetails", userDetails);
			return "addUsersDetails";
		}
		if (userService.checkIfEmailExists(userDetails.getEmail())) {
			model.addAttribute(SHOW_ERROR, true);
			model.addAttribute(MESSAGE, "Email Address already exists.");
			model.addAttribute("userDetails", userDetails);
			return "addUsersDetails";
		}
		customUserdecorator = new CustomUserDecorator(userDetails, passwordEncoder, usr);
		if (result.hasErrors()) {
			model.addAttribute(SHOW_ERROR, true);
			model.addAttribute(MESSAGE, result.getAllErrors().get(0).getDefaultMessage());
			model.addAttribute("userDetails", userDetails);
			return "addUsersDetails";
		}

		userService.persistUser(customUserdecorator.getCustomUser());

		return "redirect:allUsers";

	}

	@RequestMapping(value = "updateUser", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("userDetails") @Valid UserBean userDetails, BindingResult result,
			ModelMap model,Principal principal) {
		UserDetail usr = null;
		CustomUserDecorator customUserdecorator = null;
		Map<String, String> errorMsg = null;
		usr = userService.getUser(userDetails.getUname());
		customUserdecorator = new CustomUserDecorator(userDetails, passwordEncoder, usr);
		
		if(principal.getName().equals(userDetails.getUname())){
			if(!userDetails.getEnabled().equals("enabled")) {
				model.addAttribute(SHOW_ERROR, true);
				model.addAttribute(MESSAGE,"You cannot disable yourself");
				model.addAttribute("editMode", true);
				model.addAttribute("userDetails", userDetails);

				return "addUsersDetails";
			}
		}
		if(usr.isSuperAdmin()) {
			if(!userDetails.getEnabled().equals("enabled")) {
				model.addAttribute(SHOW_ERROR, true);
				model.addAttribute(MESSAGE,"You cannot disable super user.");
				model.addAttribute("editMode", true);
				model.addAttribute("userDetails", userDetails);

				return "addUsersDetails";
			}
		}
		if (result.hasErrors()) {
			model.addAttribute(SHOW_ERROR, true);
			model.addAttribute(MESSAGE, result.getAllErrors().get(0).getDefaultMessage());
			model.addAttribute("editMode", true);
			model.addAttribute("userDetails", userDetails);

			return "addUsersDetails";
		}

		userService.persistUser(customUserdecorator.getCustomUser());

		return "redirect:allUsers";

	}

	@RequestMapping(value = "addUser")
	public String addUser(HttpServletRequest request, UserBean userDetails, ModelMap model) {

		ModelAndView v = new ModelAndView("addUsersDetails");
		String userName = request.getParameter("usern");
		UserBean vo = new UserBean();

		if (userName != null && !userName.trim().equals("")) {
			UserDetail usr = userService.getUser(userName);
			if (usr != null) {
				vo.setDob(usr.getDob());
				vo.setUname(userName);
				vo.setEmail(usr.getEmail());
				if (usr.isEnabled()) {
					vo.setEnabled("enabled");
				} else {
					vo.setEnabled("disabled");
				}

				model.addAttribute("editMode", true);

			}

		}

		model.addAttribute("userDetails", vo);

		return "addUsersDetails";
	}

	@RequestMapping(value = "deleteUser")
	public String deleteUser(HttpServletRequest request, UserBean userDetails, ModelMap model, Principal principal) {

		ModelAndView v = new ModelAndView("redirect:allUsers");
		String userName = request.getParameter("usern");

		if (userName != null && !userName.trim().equals("")) {
			UserDetail usr = userService.getUser(userName);

			if (usr != null) {
				if (principal.getName().equals(usr.getName())) {
					model.addAttribute(SHOW_ERROR, true);
					model.addAttribute(MESSAGE, "You cannot delete yourself.");

				} else

				if (usr.isSuperAdmin()) {
					model.addAttribute(SHOW_ERROR, true);
					model.addAttribute(MESSAGE, "You cannot delete super user.");

				} else {
					usr.setEnabled(false);
					usr.setUserStatus(3);
					usr.setUsername(createAnonymousUsername(usr.getId()));
					usr.setEmail("");
					Calendar cal = Calendar.getInstance();
					usr.setDob(cal.getTime());
					String token = RandomStringUtils.randomAlphanumeric(8);
					usr.setPassword(token);
					userService.persistUser(usr);
				}
			}

		}
		model.addAttribute("users", getAllUserList());
		return "allUsersDetails";
	}

	private String createAnonymousUsername(Integer userId) {

		return "DELETED-USER-" + String.valueOf(userId);

	}

	private String createAnonymousEmail() {
		return UUID.randomUUID() + "@example.com";
	}


	@RequestMapping("allUsers")
	public ModelAndView allPersons() {
		logger.debug("Getting all users");
		ModelAndView mav = new ModelAndView("allUsersDetails");
		mav.addObject("users", getAllUserList());
		return mav;
	}

	private List<UserBean> getAllUserList() {
		List<UserDetail> users = userService.getAllUsers();
		List<UserBean> beanList = new ArrayList<UserBean>();
		for (UserDetail user : users) {
			UserBean userBean = new UserBean();
			userBean.setUname(user.getUsername());
			userBean.setDobDisplay(dateFormat.format(user.getDob()));
			userBean.setDisplayStatus(UserStatusType.getUserStatus(user.getUserStatus()));
			userBean.setEmail(user.getEmail());
			userBean.setCreatedDate(dateFormat.format(user.getCreatedDate()));
			beanList.add(userBean);

		}

		return beanList;
	}

}

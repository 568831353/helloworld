package com.lsx.spring.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsx.spring.model.User;
import com.lsx.spring.service.IUserService;
/*
 * �û���½������
 * 
 * 
 * */
@Controller
//@SessionAttributes
public class LoginController {
	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	@RequestMapping(value="/login",method= RequestMethod.GET)
	public String login() {
		return"login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,HttpSession session /*Model model*/) {
		User user = userService.login(username, password);
	    session.setAttribute("loginUser", user);
//    model.addAttribute("loginUser",user);     ���ַ�ʽʵ�ֽ��û����浽session��
		return "redirect:/user/users";
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session /*Model model*/) {
	//	model.asMap().remove("loginUser");
	//	session.invalidate();
		session.removeAttribute("loginUser");
		session.invalidate();   //��sessionʧЧ
		return "redirect:/login";
	}
}

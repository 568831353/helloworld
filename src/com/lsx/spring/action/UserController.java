package com.lsx.spring.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lsx.spring.model.User;
import com.lsx.spring.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}
    @Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value={"/users","/"},method=RequestMethod.GET)
        public String list(Model model) {
            model.addAttribute("pagers", userService.find());
			return "user/list";  	
        }
	@RequestMapping(value="/add",method= RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new User());
		return "user/add";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated User user,BindingResult br) {
		if(br.hasErrors()) {
			return "user/add";
		}
           userService.add(user);
		   return "redirect:/user/users";
    }
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
           userService.delete(id);
		   return "redirect:/user/users";
    }
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		   User user  = userService.load(id);
		   model.addAttribute(user);
		   return "user/update";
    }
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(@Validated User user,BindingResult br,@PathVariable int id,Model model) {
		   if(br.hasErrors()) {
			   return"user/update";
		   }
		   userService.update(user);
		   return "redirect:/user/users";
    }

}

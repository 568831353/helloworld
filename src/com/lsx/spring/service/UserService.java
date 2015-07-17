package com.lsx.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lsx.spring.dao.UserDao;
import com.lsx.spring.model.Pager;
import com.lsx.spring.model.User;
import com.lsx.spring.model.UserException;

@Service("userService")
public class UserService implements IUserService {
    private UserDao userDao;
    
     
	public UserDao getUserDao() {
		return userDao;
	}
    @Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		User u = userDao.loadByUsername(user.getUsername());
		if(u!=null)  throw new UserException("用户名已存在！");
		userDao.add(user);

	}

	@Override
	public void delete(int id) {
		userDao.delete(id);

	}

	@Override
	public void update(User user) {
		userDao.update(user);

	}

	@Override
	public User load(int id) {
		
		return userDao.load(id);
	}

	@Override
	public List<User> list() {
		
		return userDao.list();
	}

	@Override
	public Pager<User> find() {
		
		return userDao.find();
	}

	@Override
	public User login(String username, String password) {
		User u = userDao.loadByUsername(username);
		if(u==null) throw new UserException("登陆用户不存在"); 
		if(!u.getPassword().equals(password))
		throw new UserException("密码不正确");
		return u;
	}

}

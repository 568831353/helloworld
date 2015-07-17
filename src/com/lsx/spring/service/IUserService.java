package com.lsx.spring.service;
import java.util.List;

import com.lsx.spring.model.Pager;
import com.lsx.spring.model.User;

public interface IUserService {
	  public void add(User user);
      public void delete(int id);
      public void update(User user);
      public User load(int id);
      public List<User> list();
      public Pager<User> find();
      public User login(String username,String password);

}

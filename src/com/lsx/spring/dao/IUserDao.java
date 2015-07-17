package com.lsx.spring.dao;

import com.lsx.spring.model.Pager;
import com.lsx.spring.model.User;

import java.util.List;

public interface IUserDao {
         public void add(User user);
         public void delete(int id);
         public void update(User user);
         public User load(int id);
         public List<User> list();
         public Pager<User> find();
         public User loadByUsername(String username);
}

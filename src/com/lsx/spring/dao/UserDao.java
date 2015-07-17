package com.lsx.spring.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.lsx.spring.model.Pager;
import com.lsx.spring.model.SystemContext;
import com.lsx.spring.model.User;

@Repository("userDao")
public class UserDao  implements IUserDao {
    private SessionFactory sessionFactory;
    
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
   @Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
 
	@Override
	public void add(User user) {
           Session session = sessionFactory.getCurrentSession();
           session.save(user);
	}

	@Override
	public void delete(int id) {
		System.out.println(id);
		Session session = sessionFactory.getCurrentSession();
		User user = this.load(id);
        session.delete(user);  
	}

	@Override
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.update(user);
	}

	@Override
	public User load(int id) {
	   Session session = sessionFactory.getCurrentSession();
		return  (User) session.load(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
	    Session session = sessionFactory.getCurrentSession();
		return  session.createQuery("from User").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<User> find() {
		Session session = sessionFactory.getCurrentSession();
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = session.createQuery("from User");
		query.setFirstResult(offset).setMaxResults(size);
		List<User> datas = query.list();
		Pager<User> us = new Pager<User>();
		us.setDatas(datas);
		us.setOffset(offset);
		long total = (Long)session
				.createQuery(" select count(*) from User")
				.uniqueResult();
		us.setTotal(total);
		return us;
	}

	@Override
	public User loadByUsername(String username) {
	    Session session = sessionFactory.getCurrentSession();
		return (User)session.createQuery(" from User where username = ?")
				.setParameter(0, username).uniqueResult();
	}

}

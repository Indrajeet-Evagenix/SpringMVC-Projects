package com.becoder.dao;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.becoder.entity.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public int saveUser(User user) {
		int i = (Integer) hibernateTemplate.save(user);
		return i;
	}

	public User login(String email, String password) {

		String sql = "from User where email=:em and password=:pwd";

		User user = (User) hibernateTemplate.execute(s -> {
			Query q = s.createQuery(sql);
			q.setString("em", email);
			q.setString("pwd", password);

			return q.uniqueResult();
		});

		return user;
	}

//	@Override
//	public User loginCheck(String email) {
//		String sql = "select email from user_dtls";
//		
//		
//
//		User user = (User) hibernateTemplate.execute(s -> {
//			Query q = s.createQuery(sql);
//			q.setString("em", email);
//
//			return q.uniqueResult();
//		});
//
//		return user;
//	}

}

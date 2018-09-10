package com.webexz.springmvc.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webexz.springmvc.entity.Users;

public class DeleteUsers {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Users.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Users user = session.get(Users.class, "DEMO");
			System.out.println(user.getUsername() + ' ' + user.getPassword());
			session.delete(user);
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}
}
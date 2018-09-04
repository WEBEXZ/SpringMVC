package com.webexz.springmvc.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webexz.springmvc.entity.Users;

public class UsersMain {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Users.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Users tmp = new Users("WEBEXZ", "WEBEXZ");
			session.beginTransaction();
			session.save(tmp);
			session.getTransaction().commit();
			System.out.println("OK");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}
}
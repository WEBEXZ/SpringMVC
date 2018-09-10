package com.webexz.springmvc.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webexz.springmvc.entity.Users;

public class ReadUsers {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Users.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Usign Hibernate");
			session.beginTransaction();
			Users user = session.get(Users.class, "WEBEXZ");
			System.out.println(user.getUsername() + ' ' + user.getPassword());
			
			System.out.println("Usign HQL");
			List<Users> users = session.createQuery("from Users").getResultList();
			displayUsers(users);
			
			users = session.createQuery("from Users s where s.password = 'DEMO'").getResultList();
			displayUsers(users);
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

	private static void displayUsers(List<Users> users) {
		for(Users theUser : users) {
			System.out.println(theUser);
		}
	}
}
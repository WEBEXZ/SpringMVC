package com.webexz.springmvc.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.webexz.springmvc.entity.Users;

public class UpdateUsers {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Users.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Users user = session.get(Users.class, "WEBEXZ");
			System.out.println(user.getUsername() + ' ' + user.getPassword());
			
			user.setPassword("admin");
			
			Users updateUser = session.get(Users.class, "WEBEXZ");
			System.out.println(updateUser.getUsername() + ' ' + updateUser.getPassword());
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Users set password = 'admin'").executeUpdate();
			session.getTransaction().commit();
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
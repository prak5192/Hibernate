package com.prakash.hibernate.dto;

import javax.xml.ws.soap.Addressing;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateTest {
	
	SessionFactory sessionFactory = null;
	
	public SessionFactory getHibernateSessionFactory(){
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			this.sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			return this.sessionFactory;
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
			return null;
		}
	}
	
	
	public Session getHibernateSession(){
		if(this.sessionFactory != null){
			return this.getHibernateSessionFactory().openSession();
		}else{
			return null;
		}
		
	}
		
	void createOrUpdateUserDetails(UserDetails obj){
		SessionFactory sessionFactory = getHibernateSessionFactory();
		Session session;
		if(sessionFactory != null){
			session = this.getHibernateSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(obj);
			tr.commit();
			session.close();
		}
	}
	
	void sendObject(){
		// Adding one element
		UserDetails obj = new UserDetails();
		obj.setUserName("Rajiv Ranjan");
		createOrUpdateUserDetails(obj);
		
		// Adding a list
		
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("Starting Application");
		HibernateTest obj = new HibernateTest();
		obj.sendObject();
		System.out.println("Application Ended");
	}
		
}

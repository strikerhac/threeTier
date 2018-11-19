package com.qarri.three_tier;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBhandler {
	private Configuration config;
	private SessionFactory factory;
	private Session session;
	ServiceRegistry serviceRegistry;

	public DBhandler() {
		config = new Configuration();
		config.addAnnotatedClass(Person.class);
		config.configure();
	}

	public void save(Person p) {
		init_conn();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		close_conn();
	}

	public void delete(String username) {
		init_conn();
		session.beginTransaction();
		Person person = session.get(Person.class, username);
		session.delete(person);
		session.getTransaction().commit();
		close_conn();
	}

	public void update(Person p) {
		init_conn();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		close_conn();
	}

	public Person get(String username) {
		init_conn();
		session.beginTransaction();
		Person person = session.get(Person.class, username);
		session.getTransaction().commit();
		close_conn();
		return person;
	}

	public void init_conn() {
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		this.factory = config.buildSessionFactory(serviceRegistry);
		this.session = factory.openSession();
		
	}

	public void close_conn() {
		this.session.close();
        this.factory.close();
        this.serviceRegistry.close();
	}
}

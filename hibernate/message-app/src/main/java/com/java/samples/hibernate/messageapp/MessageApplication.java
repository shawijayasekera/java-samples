package com.java.samples.hibernate.messageapp;

import java.util.List;
import java.util.Scanner;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.java.samples.hibernate.messageapp.model.Message;

public class MessageApplication {

	public static SessionFactory sessionFactory;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String m = "";
		System.out.println("Enter a message: ");
		m = in.nextLine();

		try {

			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml").build();
			Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metaData.getSessionFactoryBuilder().build();
		} catch (Throwable e) {

			System.out.println("Failed to create session factory object: " + e);
			throw new ExceptionInInitializerError(e);
		}

		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Short msgId = null;

		try {

			tx = session.beginTransaction();
			Message msg = new Message();
			msg.setMessage(m);
			msgId = (Short) session.save(msg);
			List<?> messages = session.createQuery("FROM Message").list();
			messages.stream().forEach((mg) -> {
				Message message = (Message) mg;
				System.out.println("message: " + message.getMessage());
			});
			tx.commit();
		} catch (HibernateException e) {

			if (tx != null) {

				tx.rollback();
				e.printStackTrace();
			}
		} finally {

			session.close();
		}
	}
}

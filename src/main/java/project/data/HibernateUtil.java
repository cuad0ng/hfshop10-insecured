package project.data;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import project.model.*;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();

				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hfx");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "$o_Nic332177");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				/*
				 * settings.put(Environment.DRIVER, "org.postgresql.Driver");
				 * settings.put(Environment.URL,
				 * "jdbc:postgresql://ec2-52-71-23-11.compute-1.amazonaws.com:5432/d8goeb4rl2i53l"
				 * ); settings.put(Environment.USER, "zuemuiubojsrln");
				 * settings.put(Environment.PASS,
				 * "e3d7920e1972f0f610f272efcb0c1d0d3e8f28f1aa3e4cf127576a045b054a4f");
				 * settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				 * settings.put(Environment.SHOW_SQL, "true");
				 */
				/*
				 * settings.put(Environment.DRIVER, "org.postgresql.Driver");
				 * settings.put(Environment.URL,
				 * "jdbc:postgresql://ec2-52-71-23-11.compute-1.amazonaws.com:5432/d8goeb4rl2i53l"
				 * ); settings.put(Environment.USER, "zuemuiubojsrln");
				 * settings.put(Environment.PASS,
				 * "e3d7920e1972f0f610f272efcb0c1d0d3e8f28f1aa3e4cf127576a045b054a4f");
				 * settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				 * settings.put(Environment.SHOW_SQL, "true");
				 */
//
//				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Product.class);
				configuration.addAnnotatedClass(Category.class);
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Review.class);
				configuration.addAnnotatedClass(Order.class);
				configuration.addAnnotatedClass(OrderDetail.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				// System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
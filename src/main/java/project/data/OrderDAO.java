package project.data;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import project.model.Order;
import project.model.OrderDetail;
import project.model.Product;


public class OrderDAO {
	public void saveOrderDetail(OrderDetail orderDetail) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(orderDetail);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void saveOrder(Order order) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(order);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public List<Order> getListOrderByEmail(String name){
		
		Transaction transaction = null;
		List<Order> listOrder = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an object
			listOrder = session.createQuery("from Order where Email=: name")
					   .setParameter("name",name).list();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return listOrder;

	}
	
}

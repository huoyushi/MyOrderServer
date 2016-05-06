package com.huoyushi.MyOrderServer.DAO.Impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.stereotype.Repository;

import com.huoyushi.MyOrderServer.DAO.UserManagerDAO;
import com.huoyushi.MyOrderServer.Entity.Customer;
import com.huoyushi.MyOrderServer.Entity.Seller;

@Repository("UserManagerDAO")
public class UserManagerDAOImpl implements UserManagerDAO {
	
	@PersistenceContext(name="persitentunit")
	private EntityManager em;
	@Override
	public boolean addCustomer(Customer customer) {
		try{
			if(em.find(Customer.class, customer.getCustomerid())!=null)
				return false;
			em.persist(customer);
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	@Override
	public boolean addSeller(Seller seller) {
		try{
			if(em.find(Seller.class, seller.getSellerid())!=null)
				return false;
			em.persist(seller);
			System.out.println(seller.getSellerid());
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
    
	@Override
	public Seller findSeller(String id, String psd) {
	
			 String jpql="select seller from  Seller seller where seller.sellerid=:id and seller.psd=:psd and seller.isauthorize=:isau";
			 List<Seller> sellers=em.createQuery(jpql)
						.setParameter("id", id)
						.setParameter("psd", psd)
						.setParameter("isau", "Y")
						.getResultList();
				if(sellers.isEmpty()) return null;
				else return sellers.get(0);
		}
	
	@Override
	public Customer findCustomer(String id, String psd) {
		System.out.println("hh"+id+psd);
		  String jpql="select customer from  Customer customer where customer.customerid=:id and customer.psd=:psd";
		    
			 List<Customer> customers=em.createQuery(jpql)
						.setParameter("id", id)
						.setParameter("psd", psd)
						.getResultList();
				if(customers.isEmpty()) return null;
				else return customers.get(0);
	}
	@Override
	public List<Seller> findSellerlist() {
		System.out.println("sellerlist");
		String jpql="select seller from  Seller seller where seller.isauthorize=:isau";
		List<Seller> sellers=em.createQuery(jpql).setParameter("isau", "Y").getResultList();
		return sellers;
	}
	@Override
	public boolean authorize(String sellerid) {
		try {
			Seller seller=em.find(Seller.class,sellerid);
			seller.setIsauthorize("Y");
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Seller findSellerbyID(String id) {
		return em.find(Seller.class, id);
	}
	@Override
	public Customer finCustomerbyID(String id) {
		return em.find(Customer.class, id);
	}

}

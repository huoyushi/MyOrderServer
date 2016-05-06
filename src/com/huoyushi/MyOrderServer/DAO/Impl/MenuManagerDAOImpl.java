package com.huoyushi.MyOrderServer.DAO.Impl;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;

import com.huoyushi.MyOrderServer.DAO.MenuManagerDAO;
import com.huoyushi.MyOrderServer.Entity.Menu;
import com.huoyushi.MyOrderServer.Entity.Seller;


@Repository("MenuManagerDAO")
public class MenuManagerDAOImpl implements MenuManagerDAO{
	
	@PersistenceContext(name="persitentunit")
	private EntityManager em;
	@Override
	public boolean addMenu(Menu menu) {
		try {
			System.out.println("addmenu");
			em.persist(menu);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List<Menu> findMenulist(String sellerid) {
		System.out.println(sellerid);
		Seller seller=em.find(Seller.class, sellerid);
		 String jpql="select menu from  Menu menu where menu.seller=:seller";
		 List<Menu> menus=em.createQuery(jpql)
					.setParameter("seller", seller)
					.getResultList();
		 for (Menu menu : menus) {
				System.out.println(menu.getMenuid());
				
			}
			if(menus.isEmpty()) return null;
			
			else return menus;
	}
	@Override
	public boolean deleteMenu(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateMenu(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}

package com.huoyushi.MyOrderServer.DAO;

import java.util.List;

import com.huoyushi.MyOrderServer.Entity.Menu;

public interface MenuManagerDAO {
	public boolean addMenu(Menu menu);
	public List<Menu> findMenulist(String sellerid);
	public boolean  deleteMenu(int id);
	public boolean  updateMenu(int id);
}

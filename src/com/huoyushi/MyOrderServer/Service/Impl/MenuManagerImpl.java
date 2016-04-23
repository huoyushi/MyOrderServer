package com.huoyushi.MyOrderServer.Service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huoyushi.MyOrderServer.DAO.MenuManagerDAO;
import com.huoyushi.MyOrderServer.Entity.Menu;
import com.huoyushi.MyOrderServer.Service.MenuManager;
@Service("MenuManagerService")
public class MenuManagerImpl implements MenuManager{
	@Autowired(required=true)
    MenuManagerDAO menuManagerDao;
	@Override
	@Transactional
	public boolean addMenu(Menu menu) {
		return menuManagerDao.addMenu(menu);
	}
	@Override
	public List<Menu> findMenulist(String sellerid) {
		return menuManagerDao.findMenulist(sellerid);
	}
}

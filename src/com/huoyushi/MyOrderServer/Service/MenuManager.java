package com.huoyushi.MyOrderServer.Service;

import java.util.List;


import com.huoyushi.MyOrderServer.Entity.Menu;

public interface MenuManager {
	public boolean addMenu(Menu menu);
    public List<Menu>findMenulist(String sellerid);
}

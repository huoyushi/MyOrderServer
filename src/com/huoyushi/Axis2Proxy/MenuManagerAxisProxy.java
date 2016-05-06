package com.huoyushi.Axis2Proxy;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.huoyushi.MyOrderServer.Entity.Menu;
import com.huoyushi.MyOrderServer.Service.MenuManager;
import com.huoyushi.util.SerializeTools;

public class MenuManagerAxisProxy {
	
	MenuManager menuManager;
	public MenuManager getMenuManager() {
		return menuManager;
	}
	public void setMenuManager(MenuManager menuManager) {
		this.menuManager = menuManager;
	}
	public String addMenu(String menu){
		Menu menu2 = null;
		try {
			 System.out.println(menu);
			menu2 = (Menu)SerializeTools.json2Object(menu, Menu.class);
			menu2.setMenuid(null);
			menu2.string2byte();
			if(menuManager.addMenu(menu2))
				return "success";
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "error";
		}
		return "error";
		
	}
	public String getMenulist(String sellerid) throws JsonParseException, JsonMappingException, IOException{
		if(menuManager.findMenulist(sellerid)==null)
			return "empty";
		String string=SerializeTools.list2Json(menuManager.findMenulist(sellerid), 4);
		System.out.println(string);
		return string;
	}
}

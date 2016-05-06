package com.huoyushi.MyOrderServer.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huoyushi.MyOrderServer.Entity.Menu;
import com.huoyushi.MyOrderServer.Service.MenuManager;


@Controller
public class MenuManagerController {
	@Autowired(required=true)
	private  MenuManager menuManager;
	@RequestMapping("getmenulist")
	public String  getSellerlist(String sellerid, HttpSession session){
		List<Menu> list=menuManager.findMenulist(sellerid);
		session.setAttribute("menulist", list);
		return "orders2";
	}

}

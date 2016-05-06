package com.huoyushi.MyOrderServer.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huoyushi.MyOrderServer.Service.*;
import com.huoyushi.MyOrderServer.Entity.*;

@Controller
public class UserManagerController {
	@Autowired(required=true)
	private  UserManager userManager;
	@Autowired(required=true)
	private  OrderManager orderManager;
	@RequestMapping("/test11")
	@ResponseBody
	public Customer test11(Customer s1){
		System.out.println(s1.getUname()+".........");
		Customer s = new Customer();
		s.setCustomerid("123");
		s.setUname("hh");
		System.out.println("test11........");
		return s;
	}
	@RequestMapping("/stuLogin")
	public String login(String MOBILENUMBER,String PASSWORD,String groupid,HttpServletRequest request,HttpSession session){
		System.out.println(PASSWORD+MOBILENUMBER);
		if(groupid.equals("1"))
		{
		Seller seller=(Seller) userManager.login(MOBILENUMBER, PASSWORD, 1);
		System.out.println(seller.getSellerid());
		//Student s=sm.login(MOBILENUMBER, PASSWORD);
		if(seller!=null){
			List<Order> list=orderManager.getOrderlist(seller.getSellerid(), 0);
			session.setAttribute("seller", seller);
			session.setAttribute("orders", list);
			return "getorders";
		}
		
			return "redirect:login.html";
	
		}
		if(groupid.equals("2"))
		{
		Customer customer=(Customer) userManager.login(MOBILENUMBER, PASSWORD, 2);
		System.out.println(customer.getCustomerid());
		//Student s=sm.login(MOBILENUMBER, PASSWORD);
		if(customer!=null){
			List<Seller> list=userManager.getSellers();
			for (Seller seller : list) {
				System.out.println(seller.getSellerid());
				
			}
			session.setAttribute("customer", customer);
			session.setAttribute("sellerlist", list);
			
			System.out.println(customer.getUname());
			return "resturants";
		}
		else{
				return "redirect:login.html";
			}
		}
		
		
		return "redirect:login.html";
		
		
	}
	@RequestMapping("/stuRegist")
	public String regist(Customer customer,HttpServletRequest request,HttpSession session){
		System.out.println(customer.getUname()+"........");
		String rs="error";
		if(customer.getCustomerid()!=null)
    
        	rs=userManager.registerCustomer(customer);
		else {
			 System.out.println("id null");
		}
        
		if(rs.equals("Success"))
		{
			session.setAttribute("customer", customer);
		
			return "resturants";
		}
		else return "redirect:login.html";
	}
	@RequestMapping("/logout")
	public String logout(Customer customer,HttpServletRequest request,HttpSession session){
		session.invalidate();
		return "redirect:login.html";
	}
	
      @RequestMapping("/checkout")
      public String checkout(Customer customer,HttpServletRequest request,HttpSession session) {
    
    	  Customer rs=(Customer)session.getAttribute("customer");
    	  System.out.println(rs.getUname());
//    	  ConnectionFactory factory = new ActiveMQConnectionFactory(
//  				"failover://tcp://127.0.0.1:61616");
//
//  		Connection con = factory.createConnection();
//  		con.start();
//  		Session sen = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
//  	    Queue queue = sen.createQueue(rs.getNAME());
//  		MessageProducer producer = sen.createProducer(queue);
//  		TextMessage msg=sen.createTextMessage(rs.getNAME());
//  		producer.send(msg);
//  
//  		con.stop();
//     
//  		con.close();
    	  return null;
    } 
	

	
	
	
	
}
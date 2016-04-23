package com.huoyushi.Axis2Proxy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huoyushi.MyOrderServer.Entity.Customer;
import com.huoyushi.MyOrderServer.Entity.Seller;
import com.huoyushi.MyOrderServer.Service.UserManager;
import com.huoyushi.util.JsonUtil;
import com.huoyushi.util.SerializeTools;

public class UserManagerAxisProxy {
	UserManager userManager;
	ObjectMapper objectMapper = new ObjectMapper();
	
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	public String login(String id, String psd,int groupid){
		System.out.println(id);
		if(groupid==2)
		{
			Customer customer=new Customer();
			customer=(Customer) userManager.login(id, psd,groupid);
			
			try {
				if(customer!=null)
				{
					System.out.println(customer.getCustomerid());
					String string=SerializeTools.object2Json(customer, 2);
					System.out.println(string);
					if(!string.isEmpty())
					return string;
				}
				return "error";
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				return "error";
			}
		}
		if(groupid==1)
		{
			Seller seller=new Seller();
			seller=(Seller) userManager.login(id, psd,groupid);
			try {
				if(seller!=null)
				{
					System.out.println("hhhere");
					String string=SerializeTools.object2Json(seller, 1);
					System.out.println(string);
					if(!string.isEmpty())
					return string;
				}
				return "error";
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				return "error";
			}
		}
		return null;
		
	}
	public String registerCustomer(String customer) throws JsonParseException, JsonMappingException, IOException {
		 Customer customer1=null;
		  customer1=new SerializeTools().json2Object(customer, Customer.class);
		  System.out.println(customer1.getCustomerid());
		    return userManager.registerCustomer(customer1);
	}
	public String registerSeller(String seller) throws JsonParseException, JsonMappingException, IOException{
		Seller seller1=new SerializeTools().json2Object(seller, Seller.class);
		seller1.setIsauthorize("N");
		System.out.println(seller1.getSellerid());
		return userManager.registerSeller(seller1);
		}
	
	public String getPendinglist() throws IOException{
		System.out.println("qingqiu");
		String pendinglist=SerializeTools.list2Json(userManager.getpendinglist(),1);
		if(pendinglist==null||pendinglist.isEmpty())
			return "empty";
		return pendinglist;
	}
	public String getSellerlist() throws IOException{
		List<Seller>sellers=userManager.getSellers();
		if(sellers==null)
			return "empty";
		if(sellers.isEmpty())
			return "empty";
		String string=SerializeTools.list2Json(sellers,1);
		System.out.println(string);
		return string;
	}
	public String authorize(String sellerid) {
		if(userManager.authorize(sellerid))
			return "success";
		return "error";
	}
}

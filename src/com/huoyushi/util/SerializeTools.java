package com.huoyushi.util;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.databinding.utils.ConverterUtil.ObjectConversionException;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huoyushi.MyOrderServer.Entity.Customer;
import com.huoyushi.MyOrderServer.Entity.Menu;
import com.huoyushi.MyOrderServer.Entity.Order;
import com.huoyushi.MyOrderServer.Entity.Seller;


public class SerializeTools {
	
	public static <T>T json2Object(String jsonString, Class<T> pojoCalss) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(jsonString, pojoCalss);
	}
	public static <T> List<T> fromListJson(String str,Class<T> clazz){  
        return JSONArray.parseArray(str, clazz);  
    }  
	public static String object2Json(Object object,int flag) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		switch (flag) {
		case 1:
			{
		        Seller seller=(Seller) object;
				return objectMapper.writeValueAsString(seller);
			}
	
		case 2:
			{
			        Customer customer=(Customer) object;
					return objectMapper.writeValueAsString(customer);
			}
		default:
			break;
		}
		return "";
	}
	public static String list2Json(Object object,int flag) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		
		switch (flag) {
		case 1:
			String returnstring="[";
			{
				List<Seller>sellers=(List<Seller>)object;
				for (Seller seller : sellers) 
				{
					System.out.println(seller.toString());
					returnstring=returnstring+seller.toString()+",";
				   
				} 
				returnstring=returnstring.substring(0, returnstring.length()-1);
				returnstring=returnstring+"]";
				return returnstring;
			}
		case 2:
			String returnstring1="[";
			{
				List<Order>orders=(List<Order>)object;
				for (Order order : orders) 
				{
					System.out.println(order.toString());
					returnstring1=returnstring1+objectMapper.writeValueAsString(order)+",";
				   
				} 
				returnstring1=returnstring1.substring(0, returnstring1.length()-1);
				returnstring1=returnstring1+"]";
				return returnstring1;
			}
			
		case 3:
			String returnstring11="[";
			{
				List<Menu>menus=(List<Menu>)object;
				for (Menu menu : menus) 
				{
					System.out.println(menu.toString());
					returnstring11=returnstring11+menu.toString()+",";
				   
				} 
				returnstring11=returnstring11.substring(0, returnstring11.length()-1);
				returnstring11=returnstring11+"]";
				return returnstring11;
			}
			
		default:
			break;
			
		}
		return "empty";
	}
}

package com.axis2.service;

import javax.jms.Destination;

import com.huoyushi.jms.Producer;

import daoTest.TestDAO;

public class TestService {
	TestDAO testDAO;
     Producer producer;
	 Destination destination;
	public Producer getProducer() {
		return producer;
	}
	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public TestDAO getTestDAO() {
		return testDAO;
	}
	public void setTestDAO(TestDAO testDAO) {
		this.testDAO = testDAO;
	}
	public String getnewString(String s){
		return "suc"+s;
	}
	public String adduser(int id){
		
		return testDAO.adduser(id);
	}
	public int add(int x,int y){
		return x+y;
	}
	public String Sendmessage(String s) {
		
		producer.sendMessage(destination, s);
		return "hh";
		
	}
}
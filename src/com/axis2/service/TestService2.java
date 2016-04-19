package com.axis2.service;

import daoTest.TestDAO;

public class TestService2 {
	TestDAO testDAO;
	public TestDAO getTestDAO() {
		return testDAO;
	}
	public void setTestDAO(TestDAO testDAO) {
		this.testDAO = testDAO;
	}
	public String getusername(int id){
		return testDAO.getuser(id);	
	}

}

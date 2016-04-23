package com.huoyushi.jms;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;
import com.huoyushi.MyOrderServer.Entity.Seller;

public class RegisterConsumer {
	private JmsTemplate jmsTemplate;
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	public Seller Receive(Destination destination){
		//System.out.println(jmsTemplate.receiveAndConvert(destination));
		return (Seller) jmsTemplate.receiveAndConvert(destination);
	}

}

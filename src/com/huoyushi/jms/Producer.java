package com.huoyushi.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class Producer{
	 private JmsTemplate jmsTemplate;  
     
	    public void sendMessage(Destination destination, final String message) {  
	        System.out.println("---------------生产者发送消息-----------------");
	        System.out.println("---------------生产者发了一个消息：" + message);  
	        jmsTemplate.send(destination, new MessageCreator() {  
				@Override
				public Message createMessage(Session arg0) throws JMSException {
					// TODO Auto-generated method stub
					return arg0.createTextMessage(message); 
				}  
	        });  
	    }
	    public JmsTemplate getJmsTemplate() {  
	        return jmsTemplate;  
	    }   
	    public void setJmsTemplate(JmsTemplate jmsTemplate) {  
	        this.jmsTemplate = jmsTemplate;  
	    }
}

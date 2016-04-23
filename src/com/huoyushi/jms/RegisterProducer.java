package com.huoyushi.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.huoyushi.MyOrderServer.Entity.Seller;

public class RegisterProducer{
	 private JmsTemplate jmsTemplate;  
	    public void sendMessage(Destination destination, final Seller message) {  
	        jmsTemplate.send(destination, new MessageCreator() {  
				@Override
				public Message createMessage(Session arg0) throws JMSException {
					return arg0.createObjectMessage(message);
					
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

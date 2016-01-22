package edu.paideia.hibernate.wexa3.service;

import java.util.Collection;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import edu.paideia.hibernate.wexa3.model.Message;

@Transactional
@Service
public class MessageService {
	
	@Autowired
	SessionFactory em;
	
	
	@SuppressWarnings("unchecked")
	public Collection<Message> findAll(){

		Message m1 = new Message();
		m1.setText("Mensaje5");
		em.getCurrentSession().persist(m1);
		List<Message> messages = em.getCurrentSession().createQuery("SELECT m FROM Message m").list();
		return Lists.newArrayList(messages);
	}
	
	public void save(Message msg){
		em.getCurrentSession().persist(msg);
	}

}

package daoTest;
import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.test.Mytable;

public class TestDAO {
	private HibernateTemplate hibernateTemplate;  
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public String adduser(int id){
		Mytable mytable=new Mytable();
		mytable.setIdnewTable(id);
		mytable.setNewTablecol("daggggg");
		this.hibernateTemplate.save(mytable);
		return "success";
	}
	public String getuser(int id){
		Mytable mytable=this.hibernateTemplate.get(Mytable.class, id);
		return mytable.getNewTablecol();
	}
}
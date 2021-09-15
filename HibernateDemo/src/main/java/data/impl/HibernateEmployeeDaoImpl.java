package data.impl;

import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import data.EmployeeDao;
import model.Employee;
import util.HibernateUtil;

@Repository("hibernateDao")
public class HibernateEmployeeDaoImpl implements EmployeeDao{
	
	private static final List<Employee> ArrayList = null;


	@Autowired
	SessionFactory sessionFactory;
	
	
	Transaction tx=null;
	public int addEmployee(Employee emp){
	
		System.out.println("Adding employee (in HibernateDao)");
		Session session=null;
		Integer id;
		try{
			
		//SessionFactory sf=HibernateUtil.getSessionFactory();
			
		session =sessionFactory.openSession();
		tx=session.beginTransaction();
		id = (Integer)session.save(emp);  //insert an employee record in db
		
		tx.commit(); //only the changes are persisted to database
		return id;
	}catch (Exception e){
		tx.rollback();
		return 0;
	}
		finally{
			if(session!=null)
				session.close();
	}
		
	}
	
	@Override
	public boolean delete(Employee emp) {
		// TODO Auto-generated method stub
		return EmployeeDao.super.delete(emp);
	}

	@Override
	public List<Employee> getEmployees(int empId) {
		// TODO Auto-generated method stub
		List <Employee> empList = new ArrayList<Employee>();
		Session session = sessionFactory.openSession();
		
		Employee emp = session.get(Employee.class,new Integer(empId));
		empList.add(emp);
		return empList;
	}

	
}

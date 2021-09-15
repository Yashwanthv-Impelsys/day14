package service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import data.EmployeeDao;
import data.impl.HibernateEmployeeDaoImpl;
import model.Employee;

@Service
public class EmployeeService {
	@Autowired
	@Qualifier("hibernateDao")
	EmployeeDao employeeDao;
	@PostConstruct
	public void setup(){
	
	}
	public List<Employee> displayEmployees(int empId){
		return employeeDao.getEmployees(empId);
	}
	public int addEmployeeDetails(Employee emp){
		int empId;
		System.out.println("Adding employee (in service)");
		
		empId = employeeDao.addEmployee(emp);
		return empId;
	}
}

/*HibernateEmployeeDaoImpl dao;
public int addEmployeeDetails(Employee emp){
	System.out.println("Adding employee (in service)");
	//perform business logic here
	boolean flag=false;
		flag=dao.addEmployee(emp);
	return 0;*/
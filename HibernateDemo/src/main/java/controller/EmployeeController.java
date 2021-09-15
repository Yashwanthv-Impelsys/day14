package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import model.Employee;
import model.Employee.EmployeeFactory;
import service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;
	@RequestMapping("/")
	public String home(Model model){
		System.out.println("In home");
		Employee emp = new Employee();
		emp.setEmpName("abcd");
		emp.setEmpPhoneNum("941");
		emp.setExperience("3");
		emp.setGender("M");
		
		int empId = service.addEmployeeDetails(emp);
		
		
		 List<Employee> list = service.displayEmployees(empId);
		 for(Employee e: list)
			 System.out.println(e);
		
	//	service.addEmployeeDetails(emp);
		
		 model.addAttribute("empList",list);
		//model.addAttribute("employee",EmployeeFactory.create());
		return "home";
	}
	
	@ModelAttribute
	public void commStuff(Model model){
		model.addAttribute("HeaderStatus", "Welcome to Impelsys!");
		model.addAttribute("emp", new Employee());
	}
	@RequestMapping("/index")
	public String addemp(){
		return "add";
	}
	@RequestMapping("/tryAgain")
	public String tryAgain(){
		return "add";
	}
	@RequestMapping("showLogin")
	public String showLogin(){
		return "login";
	}
	
	@ModelAttribute
	public void commonStuff(Model model){
		model.addAttribute("HeaderStatus","Enter Employee details");
		model.addAttribute("emp",EmployeeFactory.create());
	}

	@RequestMapping("/add")
	public String addEmployee(@ModelAttribute("emp") Employee emp){
		System.out.println("Adding employee (in controller)");
		 int flag = 1;
		
		 flag=service.addEmployeeDetails(emp);
		 if(true)
			 return "success";
		 return "error";
		
	}
	
}

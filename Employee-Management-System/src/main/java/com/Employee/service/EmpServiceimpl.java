package com.Employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.Employee.entity.Employee;
import com.Employee.repository.EmpRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class EmpServiceimpl implements EmpService {
    
    @Autowired
	private EmpRepository empRepository;
	
	@Override
	public Employee saveEmp(Employee emp) {
	
		return empRepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmp() {

		return empRepository.findAll();
	}

	@Override
	public Employee getEmpById(int id) {
	
		
		Employee employee=empRepository.findById(id).get();
		
		return employee;
	}

	@Override
	public boolean deleteEmp(int id) {
		
	Employee employee=empRepository.findById(id).get();
	
	if(employee!=null) {
		
		empRepository.delete(employee);
		return true;
	}
		
	return false;
	}
	public void removeSessionMessage() {
		
		HttpSession session=((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		
		session.removeAttribute("msg");
	}

}
	
	
	

   


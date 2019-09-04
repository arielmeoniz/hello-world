package com.pablo.apirest01.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.apirest01.exception.ResourceNotFoundException;
import com.pablo.apirest01.model.Employee;
import com.pablo.apirest01.model.Pets;
import com.pablo.apirest01.model.ResultPets;
import com.pablo.apirest01.repository.EmployeeRepository;
import com.pablo.apirest01.repository.PetsRepository;



@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PetsRepository petsRepository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	
	
	
	
	@GetMapping("/uppercaseemployees")	
	public List<String> getUppercaseEmployees()
	{
		
		List<String> salida= employeeRepository.getAllEmployeesFirstNameUpperCase();
				
		return salida;
		
	}
	
	@GetMapping("/employeePets")	
	public List<ResultPets> getEmployeePets()
	{
		
		List<ResultPets> salida= employeeRepository.getAllEmployeesPets();
				
		return salida;
		
	}
	
	@GetMapping("/employeepetsbyemployeerid/{id}")	
	public List<ResultPets> getEmployeePets(@PathVariable(value="id") Long employeeId)
	{
		
		List<ResultPets> salida= employeeRepository.getEmployeePets(employeeId);
				
		return salida;
		
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long employeeId) throws ResourceNotFoundException
	{
			Employee employee=employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
			return ResponseEntity.ok().body(employee);
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee)
	{
		for (Pets aPet : employee.getPets())
		{
			Optional<Pets> petOpt = petsRepository.findById(aPet.getId());
			if (petOpt.isPresent())
			{
				employee.getPets().remove(aPet);
				employee.getPets().add(petOpt.orElse(null));				
			}
		}		
				return employeeRepository.save(employee);		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long employeeId,
			 @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		
		Employee employee = employeeRepository.findById(employeeId)
			    .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		final Employee updatedEmployee=employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
		
	}
	
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value="id") Long employeeId) throws ResourceNotFoundException
	{
		Employee employee=employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not found: "+employeeId));
		employeeRepository.delete(employee);
		Map<String,Boolean> map=new HashMap<>();
		map.put("deleted", true);
		return map;
		
	}
	

}

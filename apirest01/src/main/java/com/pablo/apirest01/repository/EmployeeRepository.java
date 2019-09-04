package com.pablo.apirest01.repository;



import java.util.List;

import org.springframework.data.jpa.repository.*;



import com.pablo.apirest01.model.Employee;
import com.pablo.apirest01.model.ResultPets;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
	@Query("select upper(e.firstName) from Employee e")
	public List<String> getAllEmployeesFirstNameUpperCase();
	
	@Query("select new com.pablo.apirest01.model.ResultPets(upper(p.name), "
			+ "upper(p.age)) from Employee e, in (e.pets) as p")
	public List<ResultPets> getAllEmployeesPets();
	
	
	@Query("select new com.pablo.apirest01.model.ResultPets(upper(p.name), "
			+ "upper(p.age)) from Employee e, in (e.pets) as p where e.id=?1")
	public List<ResultPets> getEmployeePets(Long idEmployee);

}

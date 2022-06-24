package com.example.first.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findByName(String name);

	@Query("SELECT e FROM Employee e WHERE e.no < 3000")
	List<Employee> findVeteran();

	@Query("SELECT e FROM Employee e WHERE e.name LIKE %:param1%")
	List<Employee> findByNameLikePrefix(@Param("param1") String name);
}

package com.csw.api.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csw.api.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByEmployeeId(Long employeeId);

	@Modifying
	@Transactional
	@Query(value = "delete FROM Employee e where e.schedule.schedId = :id")
	void deleteWithScheduleId(@Param("id") Long id);

	@Modifying
	@Transactional
	@Query(value = "delete FROM Employee e where e.employeeId = :employeeId and e.schedule.schedId = :schedId")
	void deleteSchedule(@Param("employeeId") Long employeeId, @Param("schedId") Long schedId);

	@Query(value = "select e from Employee e where :date between e.schedule.startDate and e.schedule.endDate")
	List<Employee> getDateExistingDetails(@Param("date") Date date);

}
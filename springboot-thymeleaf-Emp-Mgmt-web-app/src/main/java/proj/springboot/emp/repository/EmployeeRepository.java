package proj.springboot.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import proj.springboot.emp.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

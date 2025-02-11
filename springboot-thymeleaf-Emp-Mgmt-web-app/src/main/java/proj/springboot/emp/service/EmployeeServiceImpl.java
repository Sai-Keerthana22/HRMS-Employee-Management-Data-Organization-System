package proj.springboot.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import proj.springboot.emp.model.Employee;
import proj.springboot.emp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository empRepo;
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}
	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.empRepo.save(employee);
		
	}
	@Override
	public Employee getEmployeeById(long id) {
		Optional< Employee > optional = empRepo.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
	}
	@Override
	public void deleteEmployeeById(long id) {
		// TODO Auto-generated method stub
		this.empRepo.deleteById(id);
	}
	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
	    Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
	     Sort.by(sortField).descending();
	 
	    Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
	    return this.empRepo.findAll(pageable);
	}
	

}

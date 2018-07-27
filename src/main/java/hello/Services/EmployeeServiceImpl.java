package hello.Services;

import hello.Models.Employee;
import hello.Repositorys.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl{

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long pId) {
        return employeeRepository.findById(pId);
    }

    public void addEmployee(Employee pEmployee){
        employeeRepository.save(pEmployee);
    }

    public void deleteEmployeeByID(Long pId){
        employeeRepository.deleteById(pId);
    }

    public void deleteEmployeeByName(Employee pEmployee){
        employeeRepository.delete(pEmployee);
    }

    public void deleteAllEmployees(){
        employeeRepository.deleteAll();
    }

    public void saveEmployee(Employee pEmployee){
        employeeRepository.save(pEmployee);
    }
}

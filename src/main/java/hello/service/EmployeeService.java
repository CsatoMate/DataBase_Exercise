package hello.service;

import hello.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();

    Optional<Employee> findById(Long pId);

    void addEmployee(Employee pEmployee);

    void deleteEmployeeByID(Long pId);

    void deleteEmployeeByName(Employee pEmployee);

    void saveEmployee(Employee pEmployee);
}

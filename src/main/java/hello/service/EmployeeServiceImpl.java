package hello.service;

import hello.model.Employee;
import hello.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long pId) {
        return employeeRepository.findById(pId);
    }

    @Override
    public void addEmployee(Employee pEmployee) {
        employeeRepository.save(pEmployee);
    }

    @Override
    public void deleteEmployeeByID(Long pId) {
        employeeRepository.deleteById(pId);
    }

    @Override
    public void deleteEmployeeByName(Employee pEmployee) {
        employeeRepository.delete(pEmployee);
    }


    @Override
    public void saveEmployee(Employee pEmployee) {
        employeeRepository.save(pEmployee);
    }


    /**Business Logic START
    * Delete Employee by ID */
    public Employee deleteByID(Long pId){
        Optional<Employee> aDeleted = findById(pId);
        if (aDeleted.isPresent()){
            Employee aTemp = aDeleted.get();
            deleteEmployeeByID(pId);

            return aTemp;
        }
        else {
            return null;
        }
    }

    /** Delete Employee by Name */
    public List<Employee> deleteByName(String pName){
        List<Employee> allEmployee = findAll();
        ArrayList<Employee> aSorted = new ArrayList<>();
        for (Employee emp: allEmployee) {
            if (emp.getName().equals(pName)){
                deleteEmployeeByName(emp);
                aSorted.add(emp);
            }
        }
        if (aSorted.size() > 0){
            return aSorted;
        }
        else {
            return null;
        }
    }

    /** Update Employee by ID */
    public Employee update(Long pId, String pName){
        Optional<Employee> updateEmployee = findById(pId);
        if (updateEmployee.isPresent()){
            Employee aTemp = updateEmployee.get();
            aTemp.setName(pName);
            saveEmployee(aTemp);
            return aTemp;
        }
        else{
            return null;
        }
    }




}



package hello.controller;

import java.util.List;

import hello.model.Employee;
import hello.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    /** Return all Employees from database */
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    /** Add new Employee to database */
    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee pEmployee){
        return employeeService.addEmployee(pEmployee);
    }

    /** Delete Employee by ID */
    @DeleteMapping("/deleteById/{pId}")
    public Employee deleteEmployeeID(@PathVariable Long pId) {
        return employeeService.deleteByID(pId);
    }

    /** Delete Employee by Name */
    @DeleteMapping("/delete/{pName}")
    public List<Employee> deleteEmployeeName(@PathVariable String pName) {
        return employeeService.deleteByName(pName);
    }

    /** Update Employee by ID */
    @PutMapping("/update/{pId}")
    public Employee updateByID(@RequestBody Employee pEmployee, @PathVariable Long pId){
        return employeeService.update(pId, pEmployee);
    }

}
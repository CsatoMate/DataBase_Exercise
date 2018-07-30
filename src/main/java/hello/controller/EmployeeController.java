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
    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public Employee addEmployee(@RequestParam(name = "name") String pName){
        Employee aEmployee = new Employee(pName);
        employeeService.addEmployee(aEmployee);
        return aEmployee;
    }

    /** Delete Employee by ID */
    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET}, params = "id")
    public Employee deleteEmployeeID(@RequestParam(name = "id") Long pId) {
        return employeeService.deleteByID(pId);
    }

    /** Delete Employee by Name */
    @RequestMapping(value = "/delete", method = {RequestMethod.DELETE, RequestMethod.GET}, params = "name")
    public List<Employee> deleteEmployeeName(@RequestParam(name = "name") String pName) {
        return employeeService.deleteByName(pName);
    }

    /** Update Employee by ID */
    @RequestMapping(value = "/updateByID={id}", method = {RequestMethod.PUT, RequestMethod.GET})
    public Employee updateByID(@PathVariable(value = "id") Long pId, @RequestParam(name = "name") String pName){
        return employeeService.update(pId, pName);
    }

}
package hello.Controllers;

import java.util.List;
import java.util.Optional;

import hello.Models.Employee;
import hello.Services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    /** Return all Employees from database */
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    /** Add new Employee to database */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String addEmployee(@RequestParam(name = "name") String pName){
        Employee aEmployee = new Employee();
        aEmployee.setName(pName);
        employeeService.addEmployee(aEmployee);
        return "Adding " + pName + " succesfully";
    }

    /** Delete Employee by ID */
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET, params = "id")
    public String deleteEmployeeID(@RequestParam(name = "id") Long pId) {
        Optional<Employee> deletedEmployee = employeeService.findById(pId);
        if (deletedEmployee.isPresent()){
            Employee aTemp = deletedEmployee.get();
            employeeService.deleteEmployeeByID(pId);
            return aTemp.toString() + " deleted!";
        }
        else{
            return pId + " ID is not found!";
        }
    }

    /** Delete Employee by Name */
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET, params = "name")
    public String deleteEmployeeName(@RequestParam(name = "name") String pName) {
        List<Employee> allEmployee = employeeService.findAll();
        int aCount = 0;
        for (Employee emp: allEmployee) {
            if (emp.getName().equals(pName)){
                employeeService.deleteEmployeeByName(emp);
                aCount++;
            }
        }
        if (aCount > 0){
            return pName + "(" + aCount + " pcs) record deleting is successfully";
        }
        else {
            return pName + " is not found in database!";
        }
    }

    /** Delete all Employees from database */
    @RequestMapping(value = "/deleteAllEmployees", method = RequestMethod.GET)
    public String deleteAllEmployees(){
        employeeService.deleteAllEmployees();
        return "All Employees deleted from database";
    }

    /** Update Employee by ID */
    @RequestMapping(value = "/updateEmployeeByID", method = RequestMethod.GET)
    public String updateByID(@RequestParam(name = "id") Long pId){
        Optional<Employee> updateEmployee = employeeService.findById(pId);
        if (updateEmployee.isPresent()){
            Employee aTemp = updateEmployee.get();
            aTemp.setName("módosult");
            employeeService.saveEmployee(aTemp);
            return "Update is successfully";
        }
        else{
            return "ID is not found in database";
        }
    }

}
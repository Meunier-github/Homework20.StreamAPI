package pro.sky.Homework20.StreamAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/employee")

public class EmployeeController {
    private final pro.sky.Homework20.StreamAPI.EmployeeService EmployeeService;


    public EmployeeController(pro.sky.Homework20.StreamAPI.EmployeeService EmployeeService) {
        this.EmployeeService = EmployeeService;
    }


    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam(value = "departmentId") Integer department) {
        return EmployeeService.maxSalary(department);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam(value = "departmentId") Integer department) {
        return EmployeeService.minSalary(department);
    }

    @GetMapping(path = "/all")
    public List<Employee> allDepartment(@RequestParam(value = "departmentId") Integer department) {
        return EmployeeService.allDepartment(department);
    }

    @GetMapping(path = "/allDepartment")
    public Map<Integer, List<Employee>> allDepartment() {
        return EmployeeService.allDepartment();
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam(value = "firstName") String firstName,
                        @RequestParam(value = "lastName") String lastName,
                        @RequestParam(value = "secondName") String secondName,
                        @RequestParam(value = "department") Integer department,
                        @RequestParam(value = "salary") Integer salary) {

        return EmployeeService.add(firstName, lastName, secondName, department, salary);

    }


}

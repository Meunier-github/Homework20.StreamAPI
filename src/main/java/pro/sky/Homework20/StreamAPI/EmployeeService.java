package pro.sky.Homework20.StreamAPI;

import org.springframework.stereotype.Service;
import pro.sky.Homework20.StreamAPI.Exception.EmployeeAlreadyAddedException;
import pro.sky.Homework20.StreamAPI.Exception.EmployeeStorageIsFullException;

import java.util.*;
import java.util.logging.Level;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;


@Service
public class EmployeeService implements EmployeeInterface {

    List<Employee> employees = new ArrayList<>();
    static int counter = 0;

    public Employee add(String firstName, String lastName, String secondName, int department, int salary) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {


        Employee employee = new Employee(firstName, lastName, secondName, department, salary);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(counter, employee);
        counter++;
        return employee;

    }

    public Employee maxSalary(int department) {
        Employee employee = employees.stream()
                .filter(d -> d.getDepartment() == department)
                .max(Comparator.comparingInt(e -> e.getSalary())).get();
        return employee;
    }

    public Employee minSalary(int department) {
        Employee employee = employees.stream()
                .filter(d -> d.getDepartment() == department)
                .min(Comparator.comparingInt(e -> e.getSalary())).get();
        return employee;
    }

    public List<Employee> allDepartment(int department) {
        List<Employee> listAllDepartment = employees
                .stream()
                .filter(d -> d.getDepartment() == department)
                .collect(Collectors.toList());
        return listAllDepartment;
    }

    public Map<Integer, List<Employee>> allDepartment() {
        Map<Integer, List<Employee>> listAllDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return listAllDepartment;
    }

}

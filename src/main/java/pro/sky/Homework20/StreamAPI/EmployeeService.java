package pro.sky.Homework20.StreamAPI;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee add(String firstName, String lastName, String secondName, int department, int salary);

    Employee maxSalary(int department);

    Employee minSalary(int department);

    List<Employee> allDepartment(int department);

    Map<Integer, List<Employee>> allDepartment();


}

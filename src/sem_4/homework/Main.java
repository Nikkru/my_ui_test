package sem_4.homework;

import java.util.List;

public class Main {
    EmployeesGuide employeesGuide = new EmployeesGuide();

    public static void main(String[] args) {
        EmployeesGuide employeesGuide = new EmployeesGuide();
        employeesGuide.addEmployee(new Employee(001, "Smith", "1230", 5));
        employeesGuide.addEmployee(new Employee(002, "Bob", "1232", 1));
        employeesGuide.addEmployee(new Employee(003, "Marta", "1234", 6));
        employeesGuide.addEmployee(new Employee(004, "Sam", "1235", 7));
        employeesGuide.addEmployee(new Employee(005, "John", "1231", 7));
        employeesGuide.addEmployee(new Employee(006, "Anna", "1238", 2));
        employeesGuide.addEmployee(new Employee(007, "Smith", "1239", 3));

        List<String> employees5YP = employeesGuide.getEmployeesNamesByExp(5);
        List<String> employeesPhoneNumbersByNameSmithList = employeesGuide.getEmployeesPhoneNumberByName("Smith");
        Employee employee = employeesGuide.getEmployeeById(002);
        System.out.println(employee);
    }
}

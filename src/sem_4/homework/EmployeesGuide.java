package sem_4.homework;

import java.util.*;
import java.util.stream.Collectors;

/*
1. Добавить метод, который ищет сотрудника по стажу (может быть список)
2. Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
3. Добавить метод, который ищет сотрудника по табельному номеру
4. Добавить метод добавление нового сотрудника в справочник
*/

public class EmployeesGuide {
    Map<Integer, Employee> employeesMap = new HashMap<>();

    public void addEmployee(Employee employee) {
        employeesMap.put(employee.id, employee);
    }

    public List<String> getEmployeesNamesByExp(Integer thisExp) {
        List<String> namesList = new ArrayList<>();
//        Map<Integer, Employee> employeesMapTmp =
        Map<Integer, Employee> employeesMapTmp = employeesMap.entrySet().stream().
                filter(a -> a.getValue().exp.equals(thisExp)).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        employeesMapTmp.forEach((key, value) -> {
//            System.out.println(key + " : " + value);
            namesList.add(value.name);
        });
        System.out.println(employeesMapTmp.size());
        System.out.println("List of employees with " + thisExp + " years experience: " + namesList.toString());
        return namesList;
    }

    public List<String> getEmployeesPhoneNumberByName(String thisName) {
        List<String> phoneNumbers = new ArrayList<>();
        Map<Integer, Employee> employeesMapTmp = employeesMap.entrySet().stream().
                filter(a -> a.getValue().name.equals(thisName)).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        employeesMapTmp.forEach((key, value) -> {
            phoneNumbers.add(value.phoneNumber);
        });
        System.out.println("List of phone numbers employees with name: " + thisName + phoneNumbers.toString());
        return phoneNumbers;
    }

    public Employee getEmployeeById(Integer thisId) {
        Employee employee = employeesMap.get(thisId);
        System.out.println(employee.toString());
        return employee;

    }
}

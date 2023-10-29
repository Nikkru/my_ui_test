package sem_4.homework;

public class Employee {
    final Integer id;
    final String name;
    String phoneNumber;
    Integer exp;

    public Employee(Integer id, String name, String phoneNumber, Integer exp) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.exp = exp;
    }

    public Integer getExp() {
        return exp;
    }
}

package sem_4.homework;

import java.lang.reflect.Field;

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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");
        result.append(this.getClass().getName());
        result.append("Object {");
        result.append(newLine);
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            result.append(field.getName());
            result.append(": ");
            try {
                result.append(field.get(this));
            } catch (IllegalAccessException e) {
                System.out.println(e);
            }
            result.append(newLine);
        }
        result.append("}");
        return result.toString();
    }
}

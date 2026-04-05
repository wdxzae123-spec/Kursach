import java.util.Objects;

public class Employee {
    private static int idCounter = 1;

    private final int id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private int department;      // от 1 до 5
    private double salary;       // от 50 до 450

    public Employee(String firstName, String lastName, String patronymic, int department, double salary) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        setDepartment(department);
        setSalary(salary);
    }

    /**
     * Геттеры
     */
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    /**
     * Сеттеры для отдела и зарплаты
     */
    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Отдел должен быть от 1 до 5");
        }
        this.department = department;
    }

    public void setSalary(double salary) {
        if (salary < 50 || salary > 450) {
            throw new IllegalArgumentException("Зарплата должна быть в диапазоне 50–450");
        }
        this.salary = salary;
    }

    /**
     * Бухгалтерское сравнение(equals)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return Double.compare(employee.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }

    /**
     * Полный вывод информации
     */
    @Override
    public String toString() {
        return String.format("ID: %d | ФИО: %s %s %s | Отдел: %d | Зарплата: %.2f",
                id, lastName, firstName, patronymic, department, salary);
    }

    /**
     * Выводит краткую информацию о сутруднике( Имя и зарплату)
     */
    public void printShortInfo() {
        System.out.printf("Сотрудник: %s %s, зарплата: %.2f%n", firstName, lastName, salary);
    }
}

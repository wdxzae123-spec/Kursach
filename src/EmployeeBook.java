public class EmployeeBook {private final Employee[] employees;
    private static final int MAX_EMPLOYEES = 10;

    public EmployeeBook() {
        employees = new Employee[MAX_EMPLOYEES];
    }

    // Получить список всех сотрудников
    public void printAllEmployees() {
        System.out.println("Список всех сотрудников:");
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp);
            }
        }
    }

    // Подсчитать среднюю зарплату
    public double calculateAverageSalary() {
        double sum = 0;
        int count = 0;
        for (Employee emp : employees) {
            if (emp == null) break;
            sum += emp.getSalary();
            count++;
        }
        return count == 0 ? 0 : sum / count;
    }

    // Подсчитать налоги
    public double calculateTaxes(String type) {
        double totalTax = 0;
        for (Employee emp : employees) {
            if (emp == null) break;
            double salary = emp.getSalary();
            double taxRate;
            switch (type.toUpperCase()) {
                case "PROPORTIONAL":
                    taxRate = 0.13;
                    break;
                case "PROGRESSIVE":
                    if (salary <= 150) taxRate = 0.13;
                    else if (salary <= 350) taxRate = 0.17;
                    else taxRate = 0.21;
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестный тип налога: " + type);
            }
            totalTax += salary * taxRate;
        }
        return totalTax;
    }

    // Индексация зарплат в отделе на процент
    public void indexSalaryByDepartment(int department, double percent) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Отдел должен быть от 1 до 5");
        }
        for (Employee emp : employees) {
            if (emp == null) continue;
            if (emp.getDepartment() != department) continue;
            if (percent == 0) continue;
            double newSalary = emp.getSalary() * (1 + percent / 100);
            emp.setSalary(newSalary);
        }
    }
    public void findFirstEmployeeByDepartmentAndSalary(int department, double wage) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Отдел должен быть от 1 до 5");
        }
        for (int i = 0; i < employees.length; i++) {
            Employee emp = employees[i];
            if (emp == null) break;
            if (emp.getDepartment() == department && emp.getSalary() > wage) {
                System.out.print("Порядковый номер в списке: " + (i + 1) + ". ");
                emp.printShortInfo();
                return;
            }
        }
        System.out.println("Сотрудник не найден.");
    }
    public void findFirstEmployeesBySalary(double wage, int employeeNumber) {
        int found = 0;
        int index = 0;
        while (index < employees.length && found < employeeNumber) {
            Employee emp = employees[index];
            if (emp == null) break;
            if (emp.getSalary() < wage) {
                emp.printShortInfo();
                found++;
            }
            index++;
        }
        if (found == 0) {
            System.out.println("Сотрудников с зарплатой ниже " + wage + " не найдено.");
        }
    }

    // Проверить, есть ли сотрудник в массиве (equals)
    public boolean containsEmployee(Employee employee) {
        for (Employee emp : employees) {
            if (emp == null) break;
            if (emp.equals(employee)) {
                return true;
            }
        }
        return false;
    }

    // Добавить сотрудника в первую свободную ячейку
    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    //Получить сотрудника по id
    public Employee getEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp == null) break;
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }
}

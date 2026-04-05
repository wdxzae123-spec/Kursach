public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();
        Employee emp1 = new Employee("Иван", "Иванов", "Иванович", 1, 120);
        Employee emp2 = new Employee("Петр", "Петров", "Петрович", 2, 200);
        Employee emp3 = new Employee("Сидор", "Сидоров", "Сидорович", 3, 80);
        Employee emp4 = new Employee("Анна", "Смирнова", "Алексеевна", 4, 300);
        Employee emp5 = new Employee("Елена", "Кузнецова", "Владимировна", 5, 400);
        Employee emp6 = new Employee("Дмитрий", "Васильев", "Сергеевич", 1, 150);
        Employee emp7 = new Employee("Ольга", "Попова", "Игоревна", 2, 250);
        Employee emp8 = new Employee("Алексей", "Соколов", "Александрович", 3, 90);
        Employee emp9 = new Employee("Татьяна", "Михайлова", "Павловна", 4, 350);
        Employee emp10 = new Employee("Николай", "Федоров", "Николаевич", 5, 420);
        Employee emp11 = new Employee("Мария", "Морозова", "Андреевна", 1, 180);

        System.out.println("Добавление сотрудников:");
        System.out.println("emp1: " + book.addEmployee(emp1));
        System.out.println("emp2: " + book.addEmployee(emp2));
        System.out.println("emp3: " + book.addEmployee(emp3));
        System.out.println("emp4: " + book.addEmployee(emp4));
        System.out.println("emp5: " + book.addEmployee(emp5));
        System.out.println("emp6: " + book.addEmployee(emp6));
        System.out.println("emp7: " + book.addEmployee(emp7));
        System.out.println("emp8: " + book.addEmployee(emp8));
        System.out.println("emp9: " + book.addEmployee(emp9));
        System.out.println("emp10: " + book.addEmployee(emp10));
        System.out.println("emp11: " + book.addEmployee(emp11));
        System.out.println();

        // Список всех сотрудников
        book.printAllEmployees();
        System.out.println();

        // Средняя зарплата
        System.out.printf("Средняя зарплата: %.2f%n", book.calculateAverageSalary());
        System.out.println();

        // Налоги
        System.out.printf("Налоги (пропорциональные): %.2f%n", book.calculateTaxes("PROPORTIONAL"));
        System.out.printf("Налоги (прогрессивные): %.2f%n", book.calculateTaxes("PROGRESSIVE"));
        System.out.println();

        // Индексация зарплат в отделе 1 на 10%
        System.out.println("Индексация зарплат в отделе 1 на 10%:");
        book.indexSalaryByDepartment(1, 10);
        book.printAllEmployees(); // покажем изменения
        System.out.println();

        // Поиск первого сотрудника в отделе 2 с зарплатой > 210
        System.out.println("Поиск в отделе 2 с зарплатой > 210:");
        book.findFirstEmployeeByDepartmentAndSalary(2, 210);
        System.out.println();

        // Поиск первых 3 сотрудников с зарплатой < 200
        System.out.println("Первые 3 сотрудника с зарплатой < 200:");
        book.findFirstEmployeesBySalary(200, 3);
        System.out.println();

        // Проверка наличия сотрудника по зарплате
        Employee searchEmp = new Employee("", "", "", 1, 120); // зарплата 120
        System.out.println("Сотрудник с зарплатой 120 присутствует? " + book.containsEmployee(searchEmp));
        System.out.println();

        // Получение сотрудника по id
        System.out.println("Поиск по id=5:");
        Employee found = book.getEmployeeById(5);
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Сотрудник не найден");
        }
    }
}
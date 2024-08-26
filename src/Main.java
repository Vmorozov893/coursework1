import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private final static Random RANDOM = new Random();
    private final static String[] NAMES = {"Иван", "Петр", "Андрей", "Михаил", "Павел", "Олег"};
    private final static String[] SURNAMES = {"Иванов", "Петров", "Андреев", "Михайлов", "Павлов", "Олегов"};
    private final static String[] PATRONYMIC_NAMES = {"Иванович", "Петрович", "Андреевич", "Михайлович", "Павлович", "Олегович"};
    private static Employee[] EMPLOYEES = new Employee[10];

    private static void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(0, SURNAMES.length)] + " " + NAMES[RANDOM.nextInt(0, NAMES.length)] + " " + PATRONYMIC_NAMES[RANDOM.nextInt(0, PATRONYMIC_NAMES.length)];
            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(50_000, 100_000));
        }
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        initEmployees();
        print();
        System.out.println("Сумма зп сотрудников: " + calculateSumOfSalaries());
        System.out.println("Сотрудник с наименьшей зп: " + findEmployeeWithMinSalary());
        System.out.println("Сотрудник с наибольшей зп: " + findEmployeeWithMaxSalary());
        System.out.println("Средняя зп: " + calculateAverageOfSalaries());
        printFullName();
        salaryIndexing(25);
        print();
        System.out.println("Сотрудник с наименьшей зп в отделе 3: " + findEmployeeWithMinSalaryInTheDepartment(3));
        System.out.println("Сотрудник с наибольшей зп в отделе 1: " + findEmployeeWithMaxSalaryInTheDepartment(1));
        System.out.println("Сумма зп сотрудников в отделе 4: " + calculateSumOfSalariesInTheDepartment(4));

    }

    private static void print() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int calculateSumOfSalaries() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMinSalary == null || employeeWithMinSalary.getSalary() > employee.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMaxSalary == null || employeeWithMaxSalary.getSalary() < employee.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    private static double calculateAverageOfSalaries() {
        return (double) calculateSumOfSalaries() / EMPLOYEES.length;
    }

    private static void printFullName() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }

    //далее повышенная сложность
    private static void salaryIndexing(int percent) {
        for (Employee employee : EMPLOYEES) {
            employee.setSalary((int) (employee.getSalary() * (1 + (double) percent / 100)));
        }
    }

    private static Employee findEmployeeWithMinSalaryInTheDepartment(int department) {
        Employee employeeWithMinSalary = null;
        for (Employee employee : EMPLOYEES) {
            if ((employeeWithMinSalary == null || employeeWithMinSalary.getSalary() > employee.getSalary()) && employee.getDepartment() == department) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxSalaryInTheDepartment(int department) {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : EMPLOYEES) {
            if ((employeeWithMaxSalary == null || employeeWithMaxSalary.getSalary() < employee.getSalary()) && employee.getDepartment() == department) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    private static int calculateSumOfSalariesInTheDepartment(int department){
        int sum = 0;
        for(Employee employee : EMPLOYEES){
            if(employee.getDepartment()==department){
                sum+=employee.getSalary();
            }
        }
        return sum;
    }

}
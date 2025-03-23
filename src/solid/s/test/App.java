package solid.s.test;

import solid.s.solution.Employee;
import solid.s.solution.EmployeeStore;
import solid.s.solution.SalaryCalculator;

public class App {
    public static void main(String[] args) {
        Employee employee = new Employee("TuneOfCode", 5000, "IT");
        SalaryCalculator calculator = new SalaryCalculator();
        EmployeeStore store = new EmployeeStore();

        double bonus = calculator.calculateBonus(employee);
        System.out.println("Bonus: " + bonus);

        store.saveToDatabase(employee);
    }
}

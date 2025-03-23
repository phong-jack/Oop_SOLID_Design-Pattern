package solid.s.solution;

public class SalaryCalculator {

    // Trách nhiệm 2: Tính toán lương thưởng
    public double calculateBonus(Employee employee) {
        if (employee.getDepartment().equals("Sales")) {
            return employee.getSalary() * 0.2; // 20% lương cho bộ phận Sales
        } else {
            return employee.getSalary() * 0.1; // 10% lương cho các bộ phận khác
        }
    }
}

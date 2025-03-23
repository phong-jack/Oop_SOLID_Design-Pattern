package solid.s.solution;

public class EmployeeStore {

    // Trách nhiệm 3: Lưu dữ liệu vào cơ sở dữ liệu
    public void saveToDatabase(Employee employee) {
        // Giả lập lưu vào cơ sở dữ liệu
        System.out
                .println("Saving employee " + employee.getName() + " to database with salary: " + employee.getSalary()
                        + "$ at the department: " + employee.getDepartment());
    }
}

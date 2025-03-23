package solid.s.context;

public class Employee {
    private String name;
    private double salary;
    private String department;

    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    // Trách nhiệm 1: Quản lý thông tin nhân viên
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    // Trách nhiệm 2: Tính toán lương thưởng
    public double calculateBonus() {
        if (department.equals("Sales")) {
            return salary * 0.2; // 20% lương cho bộ phận Sales
        } else {
            return salary * 0.1; // 10% lương cho các bộ phận khác
        }
    }

    // Trách nhiệm 3: Lưu dữ liệu vào cơ sở dữ liệu
    public void saveToDatabase() {
        // Giả lập lưu vào cơ sở dữ liệu
        System.out.println("Saving employee " + name + " to database with salary: " + salary);
    }
}

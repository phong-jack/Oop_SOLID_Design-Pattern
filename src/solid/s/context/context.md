# Ví dụ về vi phạm Single Responsibility Principle (SRP)

Nguyên tắc **Single Responsibility Principle (SRP)** trong SOLID yêu cầu mỗi lớp hoặc module chỉ nên có một lý do để thay đổi, tức là chỉ chịu trách nhiệm cho một chức năng duy nhất.

---

## Ví dụ về vi phạm Single Responsibility Principle (SRP)

Giả sử chúng ta có một lớp `Employee` vừa quản lý thông tin nhân viên, vừa tính toán lương thưởng, vừa lưu trữ dữ liệu vào cơ sở dữ liệu:

```java
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
```

# Vấn đề

Lớp Employee có ba trách nhiệm riêng biệt:

1. Quản lý thông tin nhân viên: Lưu trữ và truy xuất dữ liệu (name, salary, department).
2. Tính toán lương thưởng: Xử lý logic kinh doanh liên quan đến lương (calculateBonus).
3. Lưu trữ dữ liệu: Giao tiếp với cơ sở dữ liệu (saveToDatabase).

# Giải quyết

1. Tạo lớp `Employee` để quản lý thông tin nhân viên.
2. Tạo lớp `SalaryCalculator` để quản lý tính toán lương thưởng.
3. Tạo lớp `EmployeeStore` để lưu trữ dữ liệu của nhân viên.

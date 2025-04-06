# Ví dụ về vi phạm Liskov Substitution Principle (LSP)

Nguyên tắc **Liskov Substitution Principle (LSP)** trong SOLID yêu cầu các đối tượng của một lớp con (subclass) phải có thể thay thế được lớp cha (superclass) mà không làm thay đổi đi tính đúng đắn của chương trình. Mục đích của việc này là đảm bảo tính đúng đắn trong lập trình hướng đối tượng và tránh việc lớp con phá vỡ các giả định hoặc phá vỡ hợp đồng đối với lớp cha.

---

## Ví dụ về vi phạm Liskov Substitution Principle (LSP)

Giả sử chúng ta có một lớp cha `Bird` và hai lớp con `Sparrow` (chim sẻ) và `Penguin` (chim cánh cụt). Lớp cha định nghĩa phương thức `fly()`, nhưng chim cánh cụt không thể bay, dẫn đến vi phạm LSP.

```java
public class Bird {
    public void fly() {
        System.out.println("Flying...");
    }
}

public class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying high!");
    }
}

public class Penguin extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins can't fly!");
    }
}

class BirdWatcher {
    public static void makeBirdFly(Bird bird) {
        bird.fly(); // Giả định tất cả Bird đều bay được
    }

    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin();

        makeBirdFly(sparrow); // OK: "Sparrow is flying high!"
        makeBirdFly(penguin); // Lỗi: UnsupportedOperationException
    }
}
```

# Vấn đề

1. Không thể thay thế: `Penguin` là một lớp con của `Bird`, nhưng khi thay `Bird` bằng Penguin trong `makeBirdFly()`, chương trình bị lỗi. Điều này phá vỡ giả định rằng mọi `Bird` đều có thể bay.
2. Hành vi không nhất quán: Lớp cha `Bird` ngụ ý tất cả các con của nó đều có khả năng `fly()`, nhưng `Penguin` không đáp ứng được, dẫn đến hành vi không mong muốn.

# Giải quyết

1. Tạo `Flyable` interface giành cho các loại chim biết bay.
2. `implements` interface đó giành cho các lớp chim phù hợp.

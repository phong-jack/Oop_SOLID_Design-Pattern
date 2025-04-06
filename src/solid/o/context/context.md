# Ví dụ về vi phạm Open Closed Principle (OCP)

Nguyên tắc **Open Closed Principle (OCP)** trong SOLID yêu cầu một lớp hoặc một module nên có thể mở rộng hoặc đóng để sửa đổi được. Có nghĩa là khi cần thêm chức năng mới cần mở rộng mã thay vì sửa đổi mã hiện có.

---

## Ví dụ về vi phạm Open Closed Principle (OCP)

Giả sử chúng ta có một lớp `PaymentProcessor` chịu trách nhiệm xử lý các phương thức thanh toán khác nhau. Ban đầu, nó chỉ hỗ trợ thanh toán bằng thẻ tín dụng, nhưng sau đó cần thêm thanh toán bằng PayPal. Thay vì mở rộng, chúng ta sửa đổi trực tiếp mã nguồn:

```java
public class PaymentProcessor {
    public void processPayment(String paymentType, double amount) {
        if (paymentType.equals("CreditCard")) {
            // Logic xử lý thanh toán bằng thẻ tín dụng
            System.out.println("Processing Credit Card payment of $" + amount);
        } else if (paymentType.equals("PayPal")) {
            // Logic xử lý thanh toán bằng PayPal
            System.out.println("Processing PayPal payment of $" + amount);
        } else {
            throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        }
    }
}

class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment("CreditCard", 100.0);
        processor.processPayment("PayPal", 50.0);
    }
}
```

# Vấn đề

1. Sửa đổi mã hiện có: Mỗi khi cần hỗ trợ một phương thức thanh toán mới (ví dụ: Bitcoin, BankTransfer) phải vào lớp `PaymentProcessor` và thêm một nhánh `else if` mới. Điều này làm thay đổi mã nguồn hiện tại.
2. Không mở rộng được dễ dàng: Thay vì thêm chức năng mới thông qua việc mở rộng (ví dụ: tạo lớp mới), chúng ta phải sửa trực tiếp logic cũ, tăng nguy cơ lỗi và khó bảo trì.

# Giải quyết

Sử dụng tính chất của OOP: `Kế thừa (extends)` hoặc sử dụng các `Giao diện (interface)`.

1. Tạo `Payment` interface.
2. Tạo các class giành cho từng loại phương thức thanh toán và `implement` tới `Payment` interface.
3. Cập nhật `PaymentProcessor` class.

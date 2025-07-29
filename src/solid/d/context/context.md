# Ví dụ về vi phạm Dependency Inversion Principle (DIP)

Nguyên tắc **Dependency Inversion Principle (DIP)** trong SOLID yêu cầu các modules cấp cao không nên phụ thuộc vào các modules cấp thấp. Cả hai nên phụ thuộc vào abstraction.

---

## Ví dụ về vi phạm Dependency Inversion Principle (DIP)

Giả sử đang viết một ứng dụng gửi thông báo trong hệ thống bán hàng. Bạn tạo một class `EmailService` để gửi email:

```java
public class EmailService {
    public void sendEmail(String to, String message) {
        // Gửi email đến khách hàng
        System.out.println("Sending email to " + to + ": " + message);
    }
}
```

Và bạn viết một class `OrderProcessor` (Xử lý đơn hàng) như sau:

```java
public class OrderProcessor {
    private EmailService emailService;

    public OrderProcessor() {
        this.emailService = new EmailService(); // 👈 Khởi tạo trực tiếp
    }

    public void processOrder(String customerEmail) {
        // Xử lý đơn hàng
        emailService.sendEmail(customerEmail, "Your order was processed.");
    }
}
```

# Vấn đề

1. ✅ Ứng dụng ban đầu chạy tốt: đặt hàng → gửi email.

2. ❌ Nhưng sau đó:

- Khách hàng yêu cầu gửi thông báo qua SMS hoặc các kênh khác như Telegram, Push notification...

- Team muốn thay đổi hệ thống gửi email mới (ví dụ dùng thư viện khác, API bên thứ ba...)

# Hậu quả:

1. Class `OrderProcessor` bị gắn chặt với `EmailService` – bạn phải sửa đổi code bên trong nó để dùng dịch vụ khác.

2. Mọi thay đổi nhỏ ở phần gửi thông báo đều khiến class cấp cao bị ảnh hưởng.

3. Không thể tái sử dụng hoặc mở rộng mà không chỉnh sửa mã cũ → dễ sai, khó test.

# Giải quyết

1. Tạo riêng abstraction/interface và cho phụ thuộc vào đó.
2. `implements` interface đó giành cho các lớp phù hợp.

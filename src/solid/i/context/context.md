# Ví dụ về vi phạm Interface Segregation Principle (ISP)

Nguyên tắc **Interface Segregation Principle (ISP)** trong SOLID yêu cầu các class không nên bị ép buộc phải phụ thuộc vào nhiều interface mà chúng không sử dụng.

---

## Ví dụ về vi phạm Interface Segregation Principle (ISP)

Giả sử đang xây dựng một hệ thống quản lý thiết bị văn phòng với các loại máy móc như:

- Máy in đa năng (in, scan, fax)

- Máy in thường (chỉ in)

Để đồng bộ các loại máy, bạn tạo một interface chung:

```java
public interface Machine {
    void print(Document doc);
    void scan(Document doc);
    void fax(Document doc);
}
```

Nhưng rồi bạn thêm một máy in đơn năng:

```java
public class OldPrinter implements Machine {
    public void print(Document doc) {
        // thực hiện in
    }

    public void scan(Document doc) {
        // ❌ không hỗ trợ
        throw new UnsupportedOperationException();
    }

    public void fax(Document doc) {
        // ❌ không hỗ trợ
        throw new UnsupportedOperationException();
    }
}
```

# Vấn đề

1. ✅ Interface Machine có vẻ tiện dụng – gom tất cả khả năng lại một chỗ.

2. ❌ Nhưng các lớp như `OldPrinter` bị ép phải implement các phương thức mà nó không hỗ trợ (`scan`, `fax`).

# Giải quyết

1. Tạo riêng từ interface `print`, `scan`, `fax`.
2. `implements` interface đó giành cho các máy in phù hợp.

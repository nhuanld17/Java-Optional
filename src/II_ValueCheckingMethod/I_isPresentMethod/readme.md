### Phương thức `isPresent()` trong Java `Optional`

#### Giới Thiệu
Phương thức `isPresent()` là một trong những phương thức quan trọng của lớp `Optional` trong Java, được dùng để **kiểm tra xem `Optional` có chứa giá trị hay không**. Nó trả về `true` nếu `Optional` có chứa giá trị (không phải `null`), và trả về `false` nếu `Optional` rỗng (không chứa giá trị nào, hoặc giá trị là `null`).

#### Cú pháp:
```java
public boolean isPresent()
```
Phương thức này không nhận bất kỳ tham số nào và trả về một giá trị kiểu `boolean`:
- `true`: nếu `Optional` có chứa giá trị.
- `false`: nếu `Optional` rỗng.

#### Mục đích sử dụng:
Phương thức `isPresent()` giúp kiểm tra sự tồn tại của giá trị trong `Optional` trước khi bạn cố gắng lấy giá trị bên trong đó bằng phương thức `get()`. Điều này giúp tránh các lỗi `NoSuchElementException` nếu bạn gọi `get()` trên một `Optional` rỗng.

#### Cách sử dụng

```java
Optional<String> optional = Optional.of("Hello, Java");

if (optional.isPresent()) {
    System.out.println("Giá trị bên trong Optional: " + optional.get());
} else {
    System.out.println("Optional rỗng, không có giá trị.");
}
```

#### Giải thích:
1. `Optional.of("Hello, Java")`: Tạo một `Optional` chứa giá trị `"Hello, Java"`.
2. `optional.isPresent()`: Kiểm tra xem `Optional` có chứa giá trị hay không.
3. Nếu giá trị tồn tại (`isPresent()` trả về `true`), phương thức `get()` sẽ được gọi để lấy giá trị bên trong và in ra.
4. Nếu `Optional` rỗng, câu lệnh trong khối `else` sẽ chạy.

#### Ví dụ cụ thể:

##### Ví dụ 1: Sử dụng `isPresent()` với giá trị không `null`
```java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Java Optional");

        if (optional.isPresent()) {
            System.out.println("Giá trị tồn tại: " + optional.get());  // In ra: Giá trị tồn tại: Java Optional
        } else {
            System.out.println("Không có giá trị!");
        }
    }
}
```

Trong ví dụ này, `Optional` chứa chuỗi `"Java Optional"`, nên `isPresent()` trả về `true`, và giá trị được in ra.

##### Ví dụ 2: Sử dụng `isPresent()` với giá trị `null`
```java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> optional = Optional.ofNullable(null); // Optional rỗng

        if (optional.isPresent()) {
            System.out.println("Giá trị tồn tại: " + optional.get());
        } else {
            System.out.println("Optional rỗng, không có giá trị!");  // In ra: Optional rỗng, không có giá trị!
        }
    }
}
```

Trong ví dụ này, `Optional` được tạo với giá trị `null` (sử dụng `Optional.ofNullable()`), nên `isPresent()` trả về `false` và câu lệnh `"Optional rỗng, không có giá trị!"` được in ra.

#### Một số lưu ý:
- **Phương thức `isPresent()` không nên được lạm dụng**. Thay vì kết hợp `isPresent()` và `get()` để lấy giá trị, bạn có thể sử dụng các phương thức như `ifPresent()` để viết mã ngắn gọn và an toàn hơn.

#### Ví dụ thay thế bằng `ifPresent()`:
```java
Optional<String> optional = Optional.of("Hello, Java");
optional.ifPresent(value -> System.out.println("Giá trị bên trong Optional: " + value));
```

Trong ví dụ này, bạn có thể tránh việc kiểm tra `isPresent()` và `get()` riêng biệt bằng cách dùng `ifPresent()`. Nó an toàn và dễ đọc hơn, vì `ifPresent()` sẽ chỉ thực hiện hành động khi có giá trị.

---

### Tổng kết:
- `isPresent()` được sử dụng để **kiểm tra sự tồn tại của giá trị** bên trong `Optional`.
- Trả về `true` nếu giá trị không phải `null`, và `false` nếu `Optional` rỗng.
- Sử dụng `isPresent()` kết hợp với `get()` là cách cơ bản để kiểm tra và lấy giá trị, nhưng có thể được thay thế bởi các phương pháp tiện lợi hơn như `ifPresent()` nhằm đơn giản hóa mã và đảm bảo an toàn khi làm việc với giá trị null.
### Phương thức `ifPresent(Consumer<T> action)` trong Java `Optional`

#### Giới thiệu
Phương thức `ifPresent()` là một trong những phương pháp quan trọng trong lớp `Optional` của Java. Phương thức này giúp bạn **thực hiện một hành động nào đó** nếu giá trị bên trong `Optional` **không bị null**. Nó sử dụng một **Consumer** làm tham số, đại diện cho hành động bạn muốn thực hiện trên giá trị có trong `Optional`.

Phương thức này có hai lợi ích chính:
1. Giúp tránh việc kiểm tra null một cách thủ công.
2. Cung cấp một cách viết code rõ ràng và gọn gàng hơn, đặc biệt khi bạn chỉ muốn thực hiện hành động **nếu có giá trị** trong `Optional`.

#### Cú pháp:
```java
void ifPresent(Consumer<? super T> action)
```

- **Consumer<T>**: Đây là một interface **hàm chức năng** trong Java, đại diện cho một hành động nhận một tham số đầu vào và **không trả về kết quả**.
- **action**: Hành động mà bạn muốn thực hiện trên giá trị bên trong `Optional` (nếu tồn tại).

Nếu `Optional` có giá trị (không rỗng), phương thức sẽ gọi `action.accept(value)` với giá trị bên trong `Optional`. Nếu `Optional` rỗng, không có hành động nào được thực hiện.

#### Cách hoạt động:
1. Nếu giá trị trong `Optional` **tồn tại** (không null), hành động được thực hiện trên giá trị đó.
2. Nếu giá trị **không tồn tại** (Optional rỗng), **không có hành động nào xảy ra** và chương trình tiếp tục chạy mà không ném ngoại lệ.

#### Ví dụ dễ hiểu:

##### Ví dụ 1: Kiểm tra và in giá trị
```java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Tạo Optional với giá trị không null
        Optional<String> optional = Optional.of("Hello, Java!");

        // Sử dụng ifPresent để in giá trị nếu có
        optional.ifPresent(value -> System.out.println("Giá trị là: " + value));
    }
}
```
**Giải thích:**
- Trong ví dụ này, `optional` chứa giá trị `"Hello, Java!"`.
- Phương thức `ifPresent()` sẽ kiểm tra xem `Optional` có giá trị không. Vì giá trị tồn tại, nó sẽ thực hiện hành động (in ra giá trị).
- Kết quả in ra: **Giá trị là: Hello, Java!**

##### Ví dụ 2: Optional rỗng
```java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        // Tạo Optional rỗng
        Optional<String> optional = Optional.ofNullable(null);

        // Sử dụng ifPresent, nhưng không có hành động nào được thực hiện
        optional.ifPresent(value -> System.out.println("Giá trị là: " + value));
    }
}
```
**Giải thích:**
- Ở đây, `optional` là một `Optional` rỗng (nó chứa `null`).
- Vì không có giá trị, **hành động không được thực hiện**, và chương trình chạy tiếp mà không có gì được in ra.

##### Ví dụ 3: Tích hợp hành động phức tạp hơn
Bạn có thể dùng `ifPresent()` cho các hành động phức tạp hơn, chẳng hạn như xử lý dữ liệu hay cập nhật trạng thái.

```java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Java Optional");

        // Xử lý giá trị bên trong Optional
        optional.ifPresent(value -> {
            String upperCaseValue = value.toUpperCase(); // Chuyển đổi thành chữ hoa
            System.out.println("Chữ hoa: " + upperCaseValue);
        });
    }
}
```

**Giải thích:**
- Giá trị `"Java Optional"` được lấy ra nếu có, sau đó nó được chuyển thành chữ hoa và in ra.
- Kết quả: **Chữ hoa: JAVA OPTIONAL**

### Khi nào nên dùng `ifPresent()`?

- Bạn nên dùng `ifPresent()` khi bạn muốn **thực hiện hành động** trên giá trị **nếu nó tồn tại**, thay vì kiểm tra thủ công xem giá trị có null hay không.

Ví dụ:
- Gửi email chỉ khi địa chỉ email không phải null.
- Ghi file log chỉ khi dữ liệu log không rỗng.

#### So sánh với cách kiểm tra null truyền thống:

##### Cách kiểm tra null thông thường:
```java
String value = "Hello";
if (value != null) {
    System.out.println("Giá trị là: " + value);
}
```

##### Sử dụng `Optional` với `ifPresent()`:
```java
Optional<String> optional = Optional.ofNullable("Hello");
optional.ifPresent(value -> System.out.println("Giá trị là: " + value));
```

- **Ưu điểm**: Sử dụng `ifPresent()` giúp mã nguồn **sạch sẽ hơn**, ít điều kiện kiểm tra null và rõ ràng hơn về ý định rằng hành động chỉ nên xảy ra khi có giá trị.

### Lời kết:
Phương thức `ifPresent()` trong Java giúp bạn xử lý các trường hợp có thể có giá trị (hoặc không) một cách tường minh và gọn gàng hơn. Nó giúp tránh được việc kiểm tra null một cách thủ công và làm cho mã nguồn dễ đọc, dễ bảo trì hơn.
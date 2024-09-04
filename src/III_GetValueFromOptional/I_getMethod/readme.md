### Phương thức `get()` trong `Optional` Java

Phương thức `get()` của lớp `Optional` được sử dụng để **lấy giá trị** bên trong đối tượng `Optional`. Tuy nhiên, việc sử dụng `get()` cần phải được xem xét cẩn thận, vì nếu `Optional` không chứa giá trị (tức là `Optional.empty()`), nó sẽ ném ra **ngoại lệ** `NoSuchElementException`.

### Cú pháp của phương thức `get()`

```java
T get()
```

- **Trả về**: Giá trị của kiểu dữ liệu `T` bên trong `Optional` nếu nó có tồn tại.
- **Ngoại lệ**: Ném `NoSuchElementException` nếu `Optional` rỗng (không chứa giá trị).

### Cách sử dụng `get()`:

Khi bạn chắc chắn rằng `Optional` đang chứa giá trị, bạn có thể gọi `get()` để lấy giá trị đó. Tuy nhiên, nếu không chắc chắn liệu `Optional` có chứa giá trị hay không, bạn nên kiểm tra bằng các phương thức như `isPresent()` hoặc các cách an toàn hơn như `orElse()`, `orElseThrow()`.

### Ví dụ sử dụng `get()`

#### Ví dụ 1: `Optional` có chứa giá trị
Trong trường hợp này, `Optional` chứa giá trị và việc gọi `get()` sẽ trả về giá trị đó.

```java
import java.util.Optional;

public class OptionalGetExample {
    public static void main(String[] args) {
        // Tạo một Optional chứa giá trị "Java"
        Optional<String> optional = Optional.of("Java");

        // Kiểm tra và lấy giá trị bên trong
        if (optional.isPresent()) {
            String value = optional.get(); // Lấy giá trị "Java"
            System.out.println("Giá trị bên trong Optional: " + value);
        }
    }
}
```

**Kết quả**:
```
Giá trị bên trong Optional: Java
```

#### Ví dụ 2: `Optional` rỗng (không chứa giá trị)
Trong trường hợp này, nếu bạn gọi `get()` trên một `Optional` rỗng, nó sẽ ném ra ngoại lệ.

```java
import java.util.Optional;

public class OptionalEmptyExample {
    public static void main(String[] args) {
        // Tạo một Optional rỗng
        Optional<String> emptyOptional = Optional.empty();

        // Gọi get() mà không kiểm tra isPresent()
        String value = emptyOptional.get(); // Ném ngoại lệ NoSuchElementException
    }
}
```

**Kết quả**:
```
Exception in thread "main" java.util.NoSuchElementException: No value present
```

#### Ví dụ 3: Kiểm tra trước khi dùng `get()`
Để tránh ngoại lệ `NoSuchElementException`, bạn nên **kiểm tra** xem `Optional` có chứa giá trị hay không trước khi gọi `get()`.

```java
import java.util.Optional;

public class SafeOptionalExample {
    public static void main(String[] args) {
        Optional<String> emptyOptional = Optional.empty();

        // Kiểm tra isPresent trước khi gọi get()
        if (emptyOptional.isPresent()) {
            String value = emptyOptional.get(); // Không thực thi vì Optional rỗng
            System.out.println("Giá trị: " + value);
        } else {
            System.out.println("Optional rỗng, không có giá trị nào bên trong.");
        }
    }
}
```

**Kết quả**:
```
Optional rỗng, không có giá trị nào bên trong.
```

### Khi nào nên và không nên sử dụng `get()`

#### Nên sử dụng `get()` khi:
- Bạn **chắc chắn rằng `Optional` chứa giá trị**, ví dụ như khi `Optional` được khởi tạo bằng `Optional.of()` (không cho phép null).
- Bạn đã **kiểm tra sự tồn tại của giá trị** bằng cách sử dụng `isPresent()` hoặc `ifPresent()`.

#### Không nên sử dụng `get()` khi:
- Bạn **không chắc chắn** rằng `Optional` có chứa giá trị hay không.
- Trong những tình huống cần xử lý null một cách an toàn hơn, bạn nên sử dụng các phương thức khác như `orElse()`, `orElseGet()` hoặc `orElseThrow()` để đảm bảo không gặp phải ngoại lệ bất ngờ.

### Tổng kết

Phương thức `get()` trong `Optional` Java giúp lấy giá trị bên trong `Optional`, nhưng nó chỉ an toàn khi bạn chắc chắn rằng `Optional` chứa giá trị. Trong trường hợp `Optional` rỗng, gọi `get()` mà không kiểm tra trước sẽ gây ra lỗi **NoSuchElementException**. Vì vậy, bạn cần cẩn thận khi sử dụng `get()` và xem xét các phương pháp an toàn hơn để xử lý giá trị null trong Java.
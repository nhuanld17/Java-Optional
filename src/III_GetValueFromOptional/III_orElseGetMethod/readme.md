### Phương thức `orElseGet(Supplier<? extends T> supplier)` trong Java Optional

Phương thức `orElseGet()` trong Java thuộc lớp `Optional` và được sử dụng để **trả về giá trị** được chứa trong `Optional` nếu giá trị đó **không phải là null**. Tuy nhiên, nếu `Optional` **rỗng** (không chứa giá trị), phương thức này sẽ **gọi một hàm cung cấp** (`Supplier`) để **tạo ra giá trị thay thế** và trả về giá trị đó.

#### Khác biệt giữa `orElse()` và `orElseGet()`
- **`orElse(T other)`**: Trả về giá trị nếu có hoặc trả về giá trị mặc định `other`. Giá trị mặc định này sẽ luôn được **tính toán và cung cấp ngay lập tức**, **dù có được sử dụng hay không**.

- **`orElseGet(Supplier<? extends T> supplier)`**: Tương tự như `orElse()`, nhưng giá trị thay thế sẽ chỉ được tính toán **khi nào cần thiết** (tức là chỉ khi `Optional` rỗng). Điều này giúp tối ưu hóa hiệu năng trong trường hợp việc tạo giá trị thay thế đòi hỏi nhiều tài nguyên.

#### Cấu trúc:
```java
public T orElseGet(Supplier<? extends T> supplier)
```

- **supplier**: Là một hàm cung cấp (một biểu thức lambda hoặc tham chiếu hàm) có thể cung cấp giá trị mặc định nếu `Optional` không chứa giá trị.

### Ví dụ minh họa

#### Ví dụ 1: Sử dụng `orElseGet` với `Optional.empty()`

```java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> optionalValue = Optional.ofNullable(null);

        // Sử dụng orElseGet với Supplier
        String result = optionalValue.orElseGet(() -> "Giá trị thay thế được tạo ra");
        System.out.println(result); // In ra: Giá trị thay thế được tạo ra
    }
}
```

**Giải thích:**
- Ở đây, `Optional.ofNullable(null)` tạo ra một `Optional` rỗng.
- Vì `Optional` không chứa giá trị nào, nên `orElseGet()` sẽ được gọi và trả về chuỗi `"Giá trị thay thế được tạo ra"`.
- Hàm `Supplier` (dùng lambda `() -> "Giá trị thay thế được tạo ra"`) chỉ được thực thi khi giá trị trong `Optional` không tồn tại.

#### Ví dụ 2: So sánh `orElse()` và `orElseGet()`

```java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> optionalValue = Optional.ofNullable("Hello, Java!");

        // Sử dụng orElse
        String result1 = optionalValue.orElse(getDefaultValue());
        System.out.println("Kết quả orElse: " + result1);

        // Sử dụng orElseGet
        String result2 = optionalValue.orElseGet(() -> getDefaultValue());
        System.out.println("Kết quả orElseGet: " + result2);
    }

    public static String getDefaultValue() {
        System.out.println("Hàm tạo giá trị mặc định được gọi!");
        return "Giá trị mặc định";
    }
}
```

**Giải thích:**
- `Optional.ofNullable("Hello, Java!")` tạo ra một `Optional` chứa giá trị `"Hello, Java!"`.
- **Khi dùng `orElse()`**, hàm `getDefaultValue()` sẽ **luôn được gọi**, dù `optionalValue` đã chứa giá trị `"Hello, Java!"`. Kết quả là giá trị `"Hello, Java!"` vẫn được trả về, nhưng việc gọi hàm tạo giá trị mặc định là không cần thiết.
- **Khi dùng `orElseGet()`**, hàm `getDefaultValue()` sẽ **không được gọi** vì giá trị `"Hello, Java!"` đã có sẵn. Điều này làm cho `orElseGet()` hiệu quả hơn khi hàm cung cấp giá trị mặc định phức tạp và tốn tài nguyên.

**Kết quả in ra:**
```
Hàm tạo giá trị mặc định được gọi!
Kết quả orElse: Hello, Java!
Kết quả orElseGet: Hello, Java!
```

#### Ví dụ 3: Khi giá trị trong `Optional` là `null`
```java
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> optionalValue = Optional.ofNullable(null);

        // Sử dụng orElseGet để cung cấp giá trị mặc định
        String result = optionalValue.orElseGet(() -> {
            // Chỉ tính toán giá trị mặc định khi Optional rỗng
            return "Giá trị mặc định phức tạp!";
        });

        System.out.println(result); // In ra: Giá trị mặc định phức tạp!
    }
}
```

**Giải thích:**
- `Optional.ofNullable(null)` tạo ra một `Optional` rỗng.
- Vì `Optional` không chứa giá trị nào, nên `orElseGet()` sẽ **gọi hàm lambda** để cung cấp giá trị `"Giá trị mặc định phức tạp!"`.
- Hàm chỉ được gọi khi `Optional` rỗng, không tạo ra giá trị thay thế trước đó, giúp tiết kiệm tài nguyên.

### Khi nào nên sử dụng `orElseGet()`?
Bạn nên sử dụng `orElseGet()` khi:
1. **Việc tạo giá trị mặc định tốn kém hoặc phức tạp**, và bạn chỉ muốn tính toán nó nếu thực sự cần thiết.
2. Bạn muốn tối ưu hóa mã của mình bằng cách trì hoãn việc tạo ra giá trị thay thế cho đến khi chắc chắn rằng `Optional` không có giá trị.

#### Ví dụ trong tình huống thực tế:

```java
Optional<String> cachedValue = Optional.ofNullable(null);

// Giả sử việc truy xuất từ cơ sở dữ liệu tốn tài nguyên
String result = cachedValue.orElseGet(() -> fetchFromDatabase());

public static String fetchFromDatabase() {
    // Mô phỏng việc lấy dữ liệu từ DB
    System.out.println("Fetching from database...");
    return "Data from DB";
}
```

Trong ví dụ này:
- Nếu `cachedValue` chứa giá trị, thì **`fetchFromDatabase()`** sẽ không bao giờ được gọi.
- Nếu `cachedValue` là `null`, thì việc lấy dữ liệu từ cơ sở dữ liệu mới diễn ra.

### Kết luận
Phương thức `orElseGet(Supplier<? extends T> supplier)` là một công cụ mạnh mẽ giúp bạn:
- Chỉ cung cấp giá trị thay thế **khi cần thiết**.
- **Tối ưu hóa** hiệu suất bằng cách trì hoãn việc tạo ra giá trị mặc định cho đến khi nó thực sự cần được sử dụng.

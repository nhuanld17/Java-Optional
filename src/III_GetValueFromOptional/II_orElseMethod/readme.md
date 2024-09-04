### Phương thức `orElse(T other)` trong Java `Optional`

Phương thức `orElse(T other)` là một trong những phương thức phổ biến nhất của lớp `Optional` trong Java. Nó được sử dụng để trả về giá trị được chứa trong đối tượng `Optional` nếu giá trị đó tồn tại. Nếu `Optional` không chứa giá trị (tức là nó rỗng), phương thức `orElse()` sẽ trả về giá trị mặc định mà bạn đã cung cấp.

#### Cú pháp
```java
public T orElse(T other)
```

- **T**: Kiểu dữ liệu của giá trị được chứa trong `Optional`.
- **other**: Giá trị mặc định mà phương thức sẽ trả về nếu `Optional` không chứa giá trị (tức là rỗng).

#### Cách hoạt động
- Nếu `Optional` chứa một giá trị, phương thức `orElse(T other)` sẽ **trả về giá trị đó**.
- Nếu `Optional` rỗng (không chứa giá trị nào), phương thức sẽ **trả về giá trị mặc định `other`** được cung cấp.

#### Khi nào nên sử dụng `orElse(T other)`?
- Khi bạn muốn đảm bảo rằng một giá trị không bao giờ là `null`, và trong trường hợp giá trị ban đầu không tồn tại, bạn có thể cung cấp một giá trị dự phòng an toàn.
- Khi bạn cần đảm bảo mã của mình không bị gián đoạn bởi lỗi `NullPointerException`, và bạn có sẵn một giá trị hợp lý để thay thế nếu giá trị cần thiết không tồn tại.

### Ví dụ minh họa

#### Ví dụ 1: `Optional` có chứa giá trị

```java
import java.util.Optional;

public class Example {
    public static void main(String[] args) {
        Optional<String> optionalValue = Optional.of("Hello, Java!");

        // Sử dụng orElse để lấy giá trị bên trong Optional
        String value = optionalValue.orElse("Giá trị mặc định");
        System.out.println(value); // Kết quả: "Hello, Java!"
    }
}
```

**Giải thích:**
- Trong ví dụ này, `optionalValue` chứa giá trị `"Hello, Java!"`.
- Vì `Optional` không rỗng, phương thức `orElse("Giá trị mặc định")` trả về giá trị `"Hello, Java!"`.

#### Ví dụ 2: `Optional` không chứa giá trị (rỗng)

```java
import java.util.Optional;

public class Example {
    public static void main(String[] args) {
        Optional<String> optionalValue = Optional.ofNullable(null);

        // Sử dụng orElse để lấy giá trị mặc định
        String value = optionalValue.orElse("Giá trị mặc định");
        System.out.println(value); // Kết quả: "Giá trị mặc định"
    }
}
```

**Giải thích:**
- Trong ví dụ này, `optionalValue` được khởi tạo với giá trị `null` thông qua `Optional.ofNullable(null)`, do đó nó rỗng.
- Khi gọi `optionalValue.orElse("Giá trị mặc định")`, vì `Optional` rỗng nên phương thức trả về giá trị mặc định `"Giá trị mặc định"`.

### Lưu ý khi sử dụng `orElse(T other)`

- **Giá trị mặc định `other` luôn được đánh giá**: Điều này có nghĩa là ngay cả khi `Optional` có chứa giá trị, biểu thức tính toán giá trị mặc định `other` vẫn sẽ được thực hiện. Điều này có thể không mong muốn nếu việc tạo giá trị mặc định tốn kém hoặc phức tạp.

### So sánh `orElse(T other)` và `orElseGet(Supplier<? extends T> other)`

Nếu bạn có một giá trị mặc định cần tính toán phức tạp hoặc tốn kém, bạn nên cân nhắc sử dụng `orElseGet(Supplier<? extends T> other)` thay vì `orElse(T other)`. Phương thức `orElseGet` sẽ chỉ đánh giá giá trị mặc định nếu `Optional` rỗng, giúp tiết kiệm tài nguyên.

```java
Optional<String> optionalValue = Optional.of("Java");

String value = optionalValue.orElseGet(() -> "Giá trị mặc định phức tạp"); // Biểu thức tính toán chỉ được gọi khi cần
```

**Tóm lại**, `orElse(T other)` là một phương thức hữu ích khi bạn cần đảm bảo rằng một giá trị luôn được trả về, bất kể `Optional` có chứa giá trị hay không. Nó giúp mã của bạn trở nên an toàn hơn khi làm việc với các giá trị có thể là null, đồng thời cung cấp cách xử lý linh hoạt cho các tình huống không có giá trị.
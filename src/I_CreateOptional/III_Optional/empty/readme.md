### Phương thức `Optional.empty()` trong Java

#### Giới thiệu

Phương thức `Optional.empty()` được sử dụng để tạo ra một đối tượng `Optional` **rỗng**, tức là đối tượng `Optional` này **không chứa bất kỳ giá trị nào**. Nó là cách bạn biểu thị rằng không có giá trị nào được trả về hay tồn tại trong một trường hợp cụ thể.

`Optional.empty()` rất hữu ích trong các tình huống mà bạn muốn trả về một đối tượng `Optional`, nhưng không có giá trị thực để đưa vào, thay vì trả về `null` như trước đây. Điều này giúp tránh lỗi **NullPointerException** và làm cho mã nguồn trở nên an toàn hơn.

#### Cú pháp

```java
Optional<T> optional = Optional.empty();
```

Trong đó, `T` là kiểu dữ liệu mà bạn muốn biểu diễn bằng `Optional`.

#### Đặc điểm chính của `Optional.empty()`
- Nó tạo ra một đối tượng `Optional` không chứa giá trị nào.
- Có thể sử dụng với bất kỳ loại dữ liệu nào.
- Đối tượng `Optional` được tạo ra bằng `Optional.empty()` được coi là **rỗng** (`isPresent()` sẽ trả về `false`).
- Phương thức `empty()` là **static** và luôn trả về cùng một đối tượng `Optional` rỗng (tương tự như một singleton), giúp tiết kiệm bộ nhớ.

### Ví dụ về sử dụng `Optional.empty()`

#### 1. Trả về một `Optional` rỗng khi không tìm thấy giá trị

Giả sử bạn có một phương thức tìm kiếm tên người dùng trong cơ sở dữ liệu. Nếu không tìm thấy người dùng, thay vì trả về `null`, bạn có thể trả về `Optional.empty()` để chỉ ra rằng không có người dùng nào được tìm thấy.

```java
import java.util.Optional;

public class UserRepository {

    // Giả sử đây là phương thức tìm kiếm người dùng trong cơ sở dữ liệu
    public Optional<String> findUserById(int userId) {
        // Giả sử không tìm thấy người dùng có ID tương ứng
        if (userId <= 0) {
            return Optional.empty(); // Trả về Optional rỗng
        }

        // Nếu tìm thấy, trả về Optional chứa tên người dùng
        return Optional.of("User_" + userId);
    }

    public static void main(String[] args) {
        UserRepository repository = new UserRepository();

        // Tìm kiếm người dùng không tồn tại (trả về Optional rỗng)
        Optional<String> user = repository.findUserById(-1);

        // Kiểm tra xem Optional có chứa giá trị không
        if (user.isPresent()) {
            System.out.println("Tìm thấy người dùng: " + user.get());
        } else {
            System.out.println("Không tìm thấy người dùng.");
        }
    }
}
```

**Giải thích**:
- Khi bạn tìm kiếm một người dùng không tồn tại (với ID là `-1`), phương thức `findUserById()` trả về `Optional.empty()`.
- Sau đó, bạn có thể kiểm tra xem `Optional` đó có chứa giá trị hay không bằng `isPresent()`. Nếu nó rỗng, bạn có thể xử lý tình huống này một cách an toàn mà không lo gặp lỗi **NullPointerException**.

#### 2. Kết hợp với các phương thức khác của `Optional`

Bạn cũng có thể sử dụng `Optional.empty()` kết hợp với các phương thức như `orElse()`, `orElseGet()`, và `orElseThrow()` để đảm bảo chương trình hoạt động đúng cách.

```java
import java.util.Optional;

public class Example {

    public static void main(String[] args) {
        // Tạo một Optional rỗng
        Optional<String> emptyOptional = Optional.empty();

        // Sử dụng orElse để trả về giá trị mặc định nếu Optional rỗng
        String value = emptyOptional.orElse("Giá trị mặc định");
        System.out.println("Giá trị: " + value);  // In ra "Giá trị: Giá trị mặc định"

        // Sử dụng orElseGet để cung cấp giá trị mặc định bằng Supplier
        String valueWithSupplier = emptyOptional.orElseGet(() -> "Cung cấp khi cần");
        System.out.println("Giá trị: " + valueWithSupplier);  // In ra "Giá trị: Cung cấp khi cần"

        // Sử dụng orElseThrow để ném ngoại lệ nếu Optional rỗng
        try {
            String errorValue = emptyOptional.orElseThrow(() -> new IllegalStateException("Không có giá trị!"));
        } catch (Exception e) {
            System.out.println(e.getMessage()); // In ra "Không có giá trị!"
        }
    }
}
```

**Giải thích**:
- `orElse("Giá trị mặc định")`: Nếu `Optional` rỗng, sẽ trả về "Giá trị mặc định".
- `orElseGet(() -> "Cung cấp khi cần")`: Trả về giá trị được cung cấp bởi `Supplier` nếu `Optional` rỗng.
- `orElseThrow()`: Ném ngoại lệ `IllegalStateException` nếu `Optional` rỗng, giúp bạn xử lý lỗi một cách rõ ràng khi cần.

### Kết Luận

Phương thức `Optional.empty()` là một công cụ mạnh mẽ để biểu thị một giá trị rỗng, thay thế cho việc sử dụng `null` trong Java. Nó giúp bạn viết mã rõ ràng hơn, tránh lỗi **NullPointerException** và cung cấp nhiều cách xử lý giá trị rỗng một cách an toàn.
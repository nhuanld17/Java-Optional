### Giới Thiệu và Giải Thích Kỹ Về `Optional.ofNullable(T value)`

`Optional.ofNullable(T value)` là một phương thức tiện ích được cung cấp trong lớp `Optional` của Java từ phiên bản **Java 8**. Mục đích của nó là tạo ra một đối tượng `Optional` dựa trên giá trị truyền vào, và điều quan trọng nhất là phương thức này **xử lý được cả trường hợp giá trị đó là `null`**.

### 1. Chức Năng của `Optional.ofNullable()`

Phương thức này **chấp nhận một đối tượng có thể là `null`** và trả về một đối tượng `Optional`:
- Nếu giá trị truyền vào **không phải `null`**, nó trả về một `Optional` chứa giá trị đó.
- Nếu giá trị truyền vào **là `null`**, nó trả về một `Optional.empty()`.

### 2. Cú pháp

```java
public static <T> Optional<T> ofNullable(T value)
```

### 3. Tại sao cần `Optional.ofNullable()`?

Trong nhiều trường hợp, chúng ta không chắc chắn giá trị đầu vào có thể là `null` hay không. Trước khi có `Optional`, các lập trình viên thường phải kiểm tra null thủ công bằng các câu lệnh `if`:

```java
String value = getSomeValue();
if (value != null) {
    // Xử lý khi giá trị không null
} else {
    // Xử lý khi giá trị là null
}
```

Việc này không chỉ làm cho mã phức tạp mà còn dễ dẫn đến lỗi khi lập trình viên **quên kiểm tra null**, gây ra **NullPointerException**. Với `Optional.ofNullable()`, việc này trở nên dễ dàng hơn và rõ ràng hơn.

### 4. Ví Dụ Minh Họa

#### Ví dụ 1: Trường hợp không `null`
```java
String value = "Hello, Java!";
Optional<String> optionalValue = Optional.ofNullable(value);

if (optionalValue.isPresent()) {
    System.out.println("Giá trị: " + optionalValue.get()); // In ra: Giá trị: Hello, Java!
} else {
    System.out.println("Không có giá trị.");
}
```

- Ở đây, biến `value` không phải là `null`, nên `Optional.ofNullable(value)` sẽ trả về một `Optional` chứa giá trị `"Hello, Java!"`.
- Sử dụng phương thức `isPresent()` để kiểm tra xem có giá trị hay không, và sau đó dùng `get()` để lấy giá trị.

#### Ví dụ 2: Trường hợp là `null`
```java
String value = null;
Optional<String> optionalValue = Optional.ofNullable(value);

if (optionalValue.isPresent()) {
    System.out.println("Giá trị: " + optionalValue.get());
} else {
    System.out.println("Không có giá trị."); // In ra: Không có giá trị.
}
```

- Ở đây, biến `value` là `null`, nên `Optional.ofNullable(value)` sẽ trả về một `Optional.empty()` (Optional rỗng).
- `isPresent()` sẽ trả về `false`, và mã trong phần `else` sẽ được thực thi.

### 5. So sánh `Optional.ofNullable()` và `Optional.of()`

Phân biệt giữa hai phương thức `Optional.of()` và `Optional.ofNullable()` rất quan trọng:

- **`Optional.of(T value)`**: Chỉ dùng khi bạn **chắc chắn giá trị không thể là null**. Nếu bạn truyền vào giá trị null, **sẽ xảy ra ngoại lệ `NullPointerException`**.

```java
String value = null;
Optional<String> optionalValue = Optional.of(value); // Sẽ ném NullPointerException
```

- **`Optional.ofNullable(T value)`**: Sử dụng khi giá trị **có thể là null**. Nó sẽ trả về `Optional.empty()` nếu giá trị là `null`, an toàn và không ném ngoại lệ.

```java
String value = null;
Optional<String> optionalValue = Optional.ofNullable(value); // Trả về Optional.empty()
```

### 6. Cách Sử Dụng `Optional.ofNullable()` Hiệu Quả

- **Thay thế kiểm tra null thủ công**: Khi bạn nhận được giá trị có thể là `null`, thay vì phải sử dụng câu lệnh `if (value != null)`, bạn có thể bọc nó trong `Optional.ofNullable()`.

- **Dùng với các API trả về giá trị có thể là `null`**: Ví dụ, khi truy vấn cơ sở dữ liệu hoặc gọi hàm từ bên thứ ba, giá trị trả về có thể không tồn tại (null), bạn nên sử dụng `Optional.ofNullable()` để tránh lỗi khi làm việc với giá trị không tồn tại.

```java
// Ví dụ giả lập truy vấn cơ sở dữ liệu
String getUserById(int id) {
    // Trả về null nếu không tìm thấy user
    return null;
}

Optional<String> optionalUser = Optional.ofNullable(getUserById(1001));
String user = optionalUser.orElse("Không tìm thấy người dùng"); // Trả về giá trị mặc định nếu null
System.out.println(user); // In ra: Không tìm thấy người dùng
```

### 7. Một Số Phương Pháp Liên Quan Đến `Optional.ofNullable()`

Khi sử dụng `Optional.ofNullable()`, có một số phương pháp tiện ích khác mà bạn có thể kết hợp:

#### a. `orElse(T other)`
Phương thức này trả về giá trị bên trong `Optional` nếu có, nếu không thì trả về giá trị mặc định mà bạn chỉ định.

```java
Optional<String> optionalValue = Optional.ofNullable(null);
String result = optionalValue.orElse("Giá trị mặc định"); // Trả về "Giá trị mặc định"
System.out.println(result); // In ra: Giá trị mặc định
```

#### b. `orElseGet(Supplier<? extends T> supplier)`
Tương tự `orElse()`, nhưng dùng một hàm để cung cấp giá trị thay thế khi giá trị là `null`.

```java
Optional<String> optionalValue = Optional.ofNullable(null);
String result = optionalValue.orElseGet(() -> "Tạo giá trị khi cần");
System.out.println(result); // In ra: Tạo giá trị khi cần
```

#### c. `orElseThrow(Supplier<? extends X> exceptionSupplier)`
Ném ngoại lệ do bạn chỉ định nếu `Optional` là rỗng.

```java
Optional<String> optionalValue = Optional.ofNullable(null);
optionalValue.orElseThrow(() -> new IllegalArgumentException("Giá trị là null!")); // Ném ngoại lệ
```

### Kết Luận

- `Optional.ofNullable()` là một công cụ rất hữu ích khi làm việc với các giá trị có thể là `null`, giúp bạn xử lý null một cách an toàn hơn mà không cần nhiều kiểm tra thủ công.
- Sử dụng nó sẽ giúp mã nguồn trở nên rõ ràng, dễ hiểu và giảm nguy cơ xảy ra lỗi **NullPointerException**.

Bằng cách sử dụng `Optional.ofNullable()`, bạn có thể tạo các logic xử lý rõ ràng hơn khi làm việc với các giá trị không chắc chắn, tăng tính an toàn và tránh được nhiều lỗi khó phát hiện trong mã.
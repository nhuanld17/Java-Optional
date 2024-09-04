### Giới thiệu về `Optional` trong Java

`Optional` là một lớp trong Java từ phiên bản **Java 8** trở đi, được giới thiệu để xử lý các giá trị có thể là **null** một cách an toàn, tránh các lỗi phổ biến liên quan đến **NullPointerException**.

#### Tại sao cần `Optional`?
Trước khi có `Optional`, việc kiểm tra và xử lý các giá trị null trong Java yêu cầu nhiều lệnh điều kiện như:
```java
if (object != null) {
    // thực hiện thao tác với object
}
```
Điều này dễ dẫn đến lỗi nếu bạn quên kiểm tra null, và lỗi **NullPointerException** có thể xảy ra bất kỳ lúc nào. `Optional` cung cấp một cách tiếp cận rõ ràng hơn để xử lý các giá trị có thể không tồn tại, giảm thiểu nguy cơ này.

#### Cách sử dụng `Optional`
Dưới đây là một số phương pháp phổ biến để làm việc với `Optional`:

1. **Tạo một Optional:**
    - `Optional.of(value)`: Tạo một `Optional` với giá trị không phải null.
    - `Optional.ofNullable(value)`: Tạo một `Optional`, giá trị có thể là null.
    - `Optional.empty()`: Tạo một `Optional` rỗng (không chứa giá trị).

```java
String value = "Hello";
Optional<String> optionalValue = Optional.of(value); // Sẽ lỗi nếu value là null

Optional<String> nullableValue = Optional.ofNullable(value); // Cho phép value null
```

2. **Kiểm tra giá trị:**
    - `isPresent()`: Kiểm tra xem có giá trị hay không.
    - `ifPresent(Consumer)`: Thực hiện hành động nếu giá trị có tồn tại.

```java
Optional<String> optional = Optional.of("Java");
if (optional.isPresent()) {
    System.out.println(optional.get()); // In ra "Java"
}
```

3. **Lấy giá trị:**
    - `get()`: Lấy giá trị, nhưng sẽ ném ngoại lệ nếu không có giá trị.
    - `orElse(T other)`: Trả về giá trị nếu tồn tại, nếu không trả về giá trị mặc định.
    - `orElseGet(Supplier)`: Trả về giá trị mặc định bằng cách gọi hàm cung cấp.
    - `orElseThrow(Supplier)`: Ném ngoại lệ nếu không có giá trị.

```java
Optional<String> optional = Optional.ofNullable(null);

String result = optional.orElse("Giá trị mặc định"); // "Giá trị mặc định"
System.out.println(result);
```

4. **Xử lý biến đổi:**
    - `map(Function)`: Áp dụng hàm chuyển đổi nếu có giá trị.
    - `flatMap(Function)`: Giống như `map`, nhưng dùng cho trường hợp hàm trả về `Optional`.

```java
Optional<String> optional = Optional.of("Java");
Optional<Integer> length = optional.map(String::length); // Trả về Optional chứa độ dài của chuỗi
System.out.println(length.get()); // In ra 4
```

### Khi nào nên sử dụng `Optional`?
- Khi phương thức có thể không trả về giá trị và bạn muốn xử lý tình huống không có giá trị một cách rõ ràng.
- Tránh sử dụng `Optional` trong các đối tượng hoặc cấu trúc dữ liệu như là thuộc tính (vì nó có thể làm giảm hiệu suất).

`Optional` giúp làm mã Java an toàn hơn và giảm thiểu các lỗi null trong quá trình xử lý giá trị, đặc biệt hữu ích trong các API hoặc các logic phức tạp.


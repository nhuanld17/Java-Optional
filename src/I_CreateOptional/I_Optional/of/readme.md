### Phương thức `Optional.of(T value)` trong Java

Phương thức `Optional.of(T value)` được sử dụng để tạo ra một đối tượng `Optional` chứa một giá trị **không null**. Nếu giá trị truyền vào là `null`, nó sẽ ném ra ngoại lệ `NullPointerException`. Vì vậy, bạn chỉ nên sử dụng phương thức này khi chắc chắn giá trị không phải là `null`.

#### Cú pháp:
```java
public static <T> Optional<T> of(T value)
```

- **Tham số**: `value` - Giá trị mà bạn muốn đóng gói vào đối tượng `Optional`. Giá trị này **không được phép là null**.
- **Trả về**: Một đối tượng `Optional` chứa giá trị `value`.
- **Ngoại lệ**: Nếu `value` là `null`, nó sẽ ném ngoại lệ `NullPointerException`.

#### Ví dụ:

```java
public class OptionalExample {
    public static void main(String[] args) {
        String name = "Java";

        // Sử dụng Optional.of để tạo Optional chứa giá trị "Java"
        Optional<String> optionalName = Optional.of(name);

        // Kiểm tra và lấy giá trị nếu có
        if (optionalName.isPresent()) {
            System.out.println("Giá trị trong Optional: " + optionalName.get()); // In ra: Giá trị trong Optional: Java
        }
    }
}
```

#### Xử lý khi giá trị là `null`:
Nếu bạn cố gắng sử dụng `Optional.of()` với một giá trị `null`, bạn sẽ gặp lỗi:

```java
public class OptionalExample {
    public static void main(String[] args) {
        String name = null;

        // Gây ra NullPointerException vì name là null
        Optional<String> optionalName = Optional.of(name); 
    }
}
```
Kết quả:
```
Exception in thread "main" java.lang.NullPointerException
```

#### Khi nào nên dùng:
- Bạn nên sử dụng `Optional.of(T value)` khi **biết chắc chắn** rằng giá trị sẽ không phải là `null`. Nếu giá trị có thể là `null`, hãy sử dụng `Optional.ofNullable(T value)` để tránh ném ngoại lệ.

#### Tóm lại:
- `Optional.of()` là cách an toàn để tạo `Optional` khi chắc chắn giá trị không null.
- Nếu giá trị có thể là `null`, hãy cân nhắc sử dụng `Optional.ofNullable()`.
Phương thức `map(Function<? super T, ? extends U> mapper)` trong lớp `Optional<T>` của Java được sử dụng để chuyển đổi (transform) giá trị bên trong `Optional<T>` từ kiểu dữ liệu `T` thành kiểu dữ liệu khác `U`. Nó giúp thao tác trên giá trị nếu giá trị tồn tại (không rỗng), hoặc bỏ qua khi `Optional` là rỗng (empty).

### Cách thức hoạt động
- **Nếu giá trị hiện tại có tồn tại** (`Optional` chứa giá trị), phương thức `map` sẽ áp dụng hàm `mapper` được cung cấp để chuyển đổi giá trị này và trả về một `Optional<U>` với giá trị đã chuyển đổi.
- **Nếu giá trị không tồn tại** (tức là `Optional` rỗng), phương thức sẽ trả về một `Optional.empty()` mà không thực hiện gì cả.

### Cú pháp
```java
public <U> Optional<U> map(Function<? super T, ? extends U> mapper)
```

- **`Function<? super T, ? extends U>`**: Là một functional interface, nhận vào một đối tượng kiểu `T` và trả về một đối tượng kiểu `U`.
- **`Optional<U>`**: Là `Optional` chứa kiểu dữ liệu kết quả `U` sau khi chuyển đổi.

### Giải thích chi tiết
- Phương thức `map` sẽ chỉ được gọi nếu `Optional` hiện có giá trị. Nếu `Optional` là rỗng, `map` không được gọi và một `Optional.empty()` được trả về mà không cần xử lý thêm.
- Điều này giúp tránh việc phải kiểm tra thủ công giá trị có rỗng hay không, giúp mã nguồn rõ ràng và ngắn gọn hơn.

### Ví dụ dễ hiểu

Giả sử chúng ta có một lớp `Person` với thuộc tính `name` và chúng ta muốn lấy độ dài tên của người đó, nhưng `Person` có thể là `null`. Chúng ta sử dụng `Optional` để tránh lỗi `NullPointerException`.

#### Ví dụ với `map`
```java
import java.util.Optional;

class Person {
    private String name;
    
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        // Optional chứa đối tượng Person
        Optional<Person> person = Optional.ofNullable(new Person("John"));
        
        // Sử dụng map để lấy độ dài tên của Person
        Optional<Integer> nameLength = person
            .map(Person::getName)  // Chuyển từ Person thành tên (String)
            .map(String::length);  // Chuyển từ tên (String) thành độ dài (Integer)
        
        // In ra kết quả, nếu có
        nameLength.ifPresent(length -> System.out.println("Name length: " + length));
        
        // Optional rỗng
        Optional<Person> emptyPerson = Optional.empty();
        
        // Sử dụng map với Optional rỗng
        Optional<Integer> emptyLength = emptyPerson
            .map(Person::getName)
            .map(String::length);
        
        // In ra nếu có kết quả, nhưng trường hợp này sẽ không có kết quả
        emptyLength.ifPresent(length -> System.out.println("Name length: " + length));
    }
}
```

### Giải thích ví dụ:
1. **Optional chứa giá trị**: Chúng ta tạo một `Optional` chứa một đối tượng `Person` với tên "John". Sau đó:
    - Dùng `map(Person::getName)` để lấy tên của `Person`.
    - Tiếp tục dùng `map(String::length)` để lấy độ dài của chuỗi tên.
    - Cuối cùng, `ifPresent` để in ra kết quả nếu `Optional` chứa giá trị.

2. **Optional rỗng**: Khi `Optional` là rỗng, phương thức `map` sẽ không thực thi, và kết quả cuối cùng vẫn là `Optional.empty()`, do đó `ifPresent` sẽ không làm gì.

### Lợi ích của việc sử dụng `map`:
- Giúp tránh việc phải kiểm tra thủ công xem giá trị có tồn tại hay không trước khi thao tác.
- Giữ mã nguồn ngắn gọn và dễ đọc hơn bằng cách chuỗi hóa các thao tác trên giá trị của `Optional`.

Phương thức `map` trong `Optional` rất hữu ích khi cần thực hiện các phép chuyển đổi liên tiếp mà không cần lo lắng về lỗi `NullPointerException` khi giá trị không tồn tại.
### Giới thiệu về phương thức `flatMap(Function<? super T, Optional<U>> mapper)` trong `Optional`

Trong Java, lớp `Optional` được sử dụng để đại diện cho một giá trị có thể có hoặc không có (tức là giá trị này có thể là `null`). Phương thức `flatMap(Function<? super T, Optional<U>> mapper)` là một trong những phương thức quan trọng của `Optional`, giúp bạn thực hiện một thao tác nào đó trên giá trị chứa trong `Optional`, đồng thời có thể trả về một `Optional` khác.

### Cách hoạt động của `flatMap`

Phương thức `flatMap` hoạt động dựa trên nguyên tắc sau:

1. **Nếu `Optional` ban đầu rỗng** (không chứa giá trị, tức là `Optional.empty()`), thì phương thức `flatMap` sẽ bỏ qua mapper và trả về `Optional.empty()`.

2. **Nếu `Optional` ban đầu chứa giá trị**, phương thức `flatMap` sẽ áp dụng `mapper` (một hàm chuyển đổi) lên giá trị bên trong `Optional` đó. Kết quả của hàm `mapper` phải là một `Optional<U>`. Phương thức `flatMap` sẽ trả về kết quả này.

### So sánh `flatMap` với `map`

Điểm khác biệt chính giữa `flatMap` và `map` là:

- `map` nhận vào một hàm chuyển đổi `Function<? super T, ? extends U>` và trả về một `Optional<U>`.
- `flatMap` nhận vào một hàm chuyển đổi `Function<? super T, Optional<U>>` và trả về chính kết quả của `Optional<U>`.

### Ví dụ minh họa

Giả sử bạn có một lớp `Person` và lớp này có một phương thức `getAddress()` trả về một `Optional<Address>`. Giả sử tiếp rằng `Address` lại có một phương thức `getCity()` trả về một `Optional<String>`.

```java
class Address {
    private String city;
    
    public Address(String city) {
        this.city = city;
    }
    
    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }
}

class Person {
    private Address address;
    
    public Person(Address address) {
        this.address = address;
    }
    
    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }
}
```

Bây giờ, nếu bạn muốn lấy tên thành phố của một `Person`, bạn có thể làm như sau:

```java
Optional<Person> person = Optional.of(new Person(new Address("New York")));

// Sử dụng flatMap để lấy city
Optional<String> city = person
    .flatMap(Person::getAddress)  // Trả về Optional<Address>
    .flatMap(Address::getCity);   // Trả về Optional<String>

city.ifPresent(System.out::println);  // Kết quả: New York
```

### Giải thích

1. **`person.flatMap(Person::getAddress)`**: Phương thức này lấy `Optional<Address>` từ `Optional<Person>`. Nếu `person` là `Optional.empty()`, thì kết quả cũng sẽ là `Optional.empty()`.

2. **`flatMap(Address::getCity)`**: Sau đó, `flatMap` được áp dụng để lấy `Optional<String>` từ `Optional<Address>`. Nếu `address` là `Optional.empty()`, thì kết quả cũng sẽ là `Optional.empty()`.

Điều này giúp bạn dễ dàng "chuỗi hóa" (chain) các thao tác mà không cần phải liên tục kiểm tra `null` hoặc `Optional.empty()`.

### Kết luận

Phương thức `flatMap` rất hữu ích khi làm việc với các giá trị lồng nhau trong `Optional`, đặc biệt khi bạn cần thực hiện nhiều bước xử lý liên tiếp mà mỗi bước đều có thể không có giá trị. Việc sử dụng `flatMap` giúp mã của bạn trở nên ngắn gọn và rõ ràng hơn, đồng thời giúp giảm thiểu lỗi do xử lý `null`.
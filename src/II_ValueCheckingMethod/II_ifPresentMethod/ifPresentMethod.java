package II_ValueCheckingMethod.II_ifPresentMethod;

import java.util.Optional;

public class ifPresentMethod {
	// ifPresent(Consumer<T> action)
	// Phương thức này cho phép bạn chỉ định một hành động sẽ được thực hiện
	// nếu giá trị có mặt (không null).
	public static void main(String[] args) {
		// Kiểm tra và in giá trị
		// tạo Optional không null
		Optional<String> optional = Optional.of("Hello");
		
		// Sử dụng ifPresent để in giá trị nếu có
		optional.ifPresent(value -> System.out.println(value)); // Hello
		
		// Optional rỗng
		// Tạo optional rỗng
		Optional<String> optional2 = Optional.ofNullable(null);
		
		// Sử dụng ifPresent, nhưng không có hành động nào được thực hiện
		optional2.ifPresent(value -> System.out.println("Giá trị là: "+value));
		
		// Tích hợp các hành động phức tạp hơn
		Optional<String> javaOptional = Optional.of("Java Optional");
		
		// Xử lí giá trị bên trong optional
		javaOptional.ifPresent(value -> {
			String upperCaseValue = value.toUpperCase(); // Chuyển đổi thành chữ hoa
			System.out.println("Chữ hoa: " + upperCaseValue);
		});
	}
}

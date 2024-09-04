package II_ValueCheckingMethod.I_isPresentMethod;

import java.util.Optional;

public class isPresentMethod {
	// isPresent(): Phương thức này trả về true nếu có giá trị và false
	// nếu không có giá trị.
	// Khuyến khích sử dụng ifPresent() hơn là isPresent()
	public static void main(String[] args) {
		// VD:
		Optional<String> optional = Optional.of("hello");
		
		if (optional.isPresent()) {
			System.out.println("Giá trị bên trong Optional: " + optional.get());
		} else {
			System.out.println("Optional rỗng, không có giá trị");
		}
		// Giá trị bên trong Optional: hello
		
		// Sử dụng isPresent() với giá trị không null
		Optional<String> optional2 = Optional.of("hello");
		if (optional2.isPresent()) {
			System.out.println("Giá trị bên trong optional2: " + optional2.get());
		} else {
			System.out.println("Optional 2 không có giá trị");
		}
		// Giá trị bên trong optional2: hello
		
		// Sử dụng isPresent() với giá trị null
		Optional<String> optional3 = Optional.ofNullable(null);
		
		if (optional3.isPresent()) {
			System.out.println("Giá trị bên trong optional3: " + optional3.get());
		} else {
			System.out.println("Optional rỗng, ko chứa giá trị");
		}
		// Optional rỗng, ko chứa giá trị
	}
}

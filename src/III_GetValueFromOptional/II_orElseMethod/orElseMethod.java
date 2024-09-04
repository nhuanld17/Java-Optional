package III_GetValueFromOptional.II_orElseMethod;

import java.util.Optional;

public class orElseMethod {
	// orElse(T other): Nếu Optional có giá trị, nó sẽ trả về giá trị đó,
	// còn nếu không có, nó sẽ trả về một giá trị mặc định mà bạn cung cấp.
	public static void main(String[] args) {
		// Optional không null
		Optional<String> optionalNotNull = Optional.of("Hello");
		
		// Sử dụng orElse để lấy giá trị trong optional
		String value = optionalNotNull.orElse("Giá trị mặc định");
		System.out.println(value); // Hello
		
		// Optional null
		Optional<String> nullOptional = Optional.ofNullable(null);
		
		// Sử dụng orElse để lấy giá trị mặc định
		String value2 = nullOptional.orElse("Giá trị mặc định");
		System.out.println(value2); // Giá trị mặc định
		
		
	}
}

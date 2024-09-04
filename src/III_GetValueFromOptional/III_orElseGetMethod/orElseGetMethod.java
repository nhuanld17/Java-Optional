package III_GetValueFromOptional.III_orElseGetMethod;

import java.util.Optional;

public class orElseGetMethod {
	// orElseGet(Supplier<? extends T> supplier):
	// Tương tự orElse(), nhưng thay vì cung cấp một giá trị mặc định ngay lập tức,
	// bạn có thể cung cấp một hàm cung cấp giá trị (supplier) chỉ được gọi khi
	// Optional rỗng.
	public static void main(String[] args) {
		// Sử dụng orElseget với Optional.empty()
		Optional<String> optionalValue = Optional.ofNullable(null);
		
		// Sử dụng orElseGet với Supplier
		String result = optionalValue.orElseGet(() -> "Giá trị thay thế được tạo ra");
		System.out.println(result);
		// Giá trị thay thế được tạo ra
		
		// So sánh orElse() và orElseGet()
		Optional<String> optionalValue2 = Optional.ofNullable("Java");
		
		// orElse
		String result1 = optionalValue2.orElse(getDefaultValue());
		System.out.println("Kết quả của orElse: " + result1);
		
		// orElseGet
		String result2 = optionalValue2.orElseGet(() -> getDefaultValue());
		System.out.println("Kết quả orElseGet: " + result2);
		
		
		// Khi giá trị của Optional là null
		Optional<String> optionalValue3 = Optional.ofNullable(null);
		
		// Sử dụng orElseGet để cung cấp giá trị mặc định
		String result3 = optionalValue3.orElseGet(() -> {
			return "Giá trị mặc định phức tạp";
		});
		
		System.out.println(result3);
		// Giá trị mặc định phức tạp
	}
	
	public static String getDefaultValue(){
		System.out.println("Hàm tạo giá trị mặc định được gọi");
		return "Giá trị mặc định";
	}
}

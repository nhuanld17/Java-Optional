package III_GetValueFromOptional.I_getMethod;

import java.util.Optional;

public class getMethod {
	// get(): trả về giá trị bên trong Optional, nhưng nếu Optional rỗng,
	// nó sẽ ném ngoại lệ NoSuchElementException
	// Sử dụng khi chắc chắn Optional có chứa giá trị.
	public static void main(String[] args) {
		// Optional có chứa giá trị
		Optional<String> optional = Optional.of("KVAAV");
		
		// Kiểm tra và lấy giá trị bên trong
		if (optional.isPresent()){
			String value = optional.get(); // Lấy giá trị từ "Java"
			System.out.println("Giá trị bên trong optional: " + value);
		}
		// Giá trị bên trong optional: KVAAV
		
		// Optional không chứa giá trị
		Optional<String> emptyOptional = Optional.empty();
		
		// Gọi hàm get() mà ko qua kiểm tra isPresent()
		String value = emptyOptional.get(); // Ném ngoại lệ NoSuchElementException
		
		// Kiểm tra trước khi dùng get()
		Optional<String> emptyOptional1 = Optional.empty();
		
		if (emptyOptional.isPresent()){
			System.out.println("Giá trị: " + emptyOptional.get());
		} else {
			System.out.println("Optional rỗng, không có giá trị");
		}
	}
}

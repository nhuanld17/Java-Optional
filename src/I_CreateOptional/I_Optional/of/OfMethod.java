package I_CreateOptional.I_Optional.of;

import java.util.Optional;

public class OfMethod {
	// Optional.of(T value): tạo đối tượng Optional chứa 1 giá trị không null
	// Ném ra ngoại lệ NullPointerException nếu truyền vào 1 giá trị null
	// Chỉ sử dụng khi chắc chắn giá trị không null
	public static void main(String[] args) {
		// Tạo 1 Optional với giá trị không phải là null
		String name = "Trịnh Thần";
		Optional<String> optionalName = Optional.of(name);
		
		// Kiểm tra xem giá trị có tồn tại hay không
		if (optionalName.isPresent()) {
			System.out.println("Giá trị trong Optional: " + optionalName.get());
		}
		// Giá trị trong Optional: Trịnh Thần
		
		// Trường hợp truyền vào giá trị null - sẽ ném NullPointerException
		try {
			Optional<String> nullValue = Optional.of(null); // Ném ngoại lệ
		} catch (NullPointerException e){
			System.out.println("Lỗi: Giá trị không được là null");
		}
		
	}
}

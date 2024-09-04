package III_GetValueFromOptional.IV_orElseThrowMethod;

import java.util.NoSuchElementException;
import java.util.Optional;

public class orElseThrowMethod {
	// orElseThrow(Supplier<? extends X> exceptionSupplier)
	// Thay vì trả về giá trị mặc định khi không có giá trị, phương thức này sẽ ném
	// ngoại lệ mà bạn cung cấp.
	public static void main(String[] args) {
		// Tìm kiếm người dùng, trả về ngoại lệ nếu không tìm thấy
		Optional<String> user = findByUserId(1);
		
		// Nếu không có giá trị, ném ngoại lệ NoSuchElementException
		String result = user.orElseThrow(() -> new NoSuchElementException("User with id = 1 not found"));
		
		System.out.println(result); // Alice
	}
	// Hàm giả lập tìm kiếm người dùng theo ID
	private static Optional<String> findByUserId(int i) {
		if (i == 1){
			return Optional.of("Alice");
		} else {
			return Optional.empty();
		}
	}
}

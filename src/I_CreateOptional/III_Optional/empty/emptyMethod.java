package I_CreateOptional.III_Optional.empty;

import java.util.Optional;

public class emptyMethod {
	// Optional.empty(): Tạo 1 Optional rỗng (không chứa giá trị nào)
	public static void main(String[] args) {
		// Trả về 1 Optional rỗng khi không tìm thấy giá trị
		Optional<String> user = findByUserId(-1);
		
		// Kiếm tra xem Optional có chứa giá trị hay không
		if (user.isPresent()) {
			System.out.println("Tìm thấy người dùng: " + user.get());
		} else {
			System.out.println("Đéo tìm được");
		}
	}
	
	// Phương thức tìm kiếm người dùng trong csdl
	public static Optional<String> findByUserId(int userId) {
		if (userId <= 0) {
			return Optional.empty(); // Trả về 1 Optional rỗng
		}
		
		// Nếu tìm thấy, trả về Optional chứa tên người dùng
		return Optional.of("User_" + userId);
	}
}

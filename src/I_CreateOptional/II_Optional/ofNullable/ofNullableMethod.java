package I_CreateOptional.II_Optional.ofNullable;

import java.util.Optional;

public class ofNullableMethod {
	// Optional.ofNullable(T value):
	// Dùng khi giá trị có thể là null hoặc không null.
	// Nếu giá trị là null, nó sẽ tạo ra một Optional rỗng.
	public static void main(String[] args) {
		// Tạo 1 Optional với 1 giá trị không null
		String name = "Trịnh Thần";
		Optional<String> optionalName = Optional.ofNullable(name);
		
		if (optionalName.isPresent()) {
			System.out.println("Name: "+optionalName.get());
		} else {
			System.out.println("Đéo có giá trị");
		}
		
		// Tạo 1 Optional với giá trị null
		String name2 = null;
		Optional<String> optionalName2 = Optional.ofNullable(name2);
		
		if (optionalName2.isPresent()) {
			System.out.println("Name2: "+optionalName2.get());
		} else {
			System.out.println("Đéo có giá trị");
		}
		
		// Biến name2 là null, nên Optional.ofNullable(name2) trả về
		// 1 Optional.empty() (optional rỗng)
		// isPresent() sẽ trả trả về False và trả về thông báo
	}
}

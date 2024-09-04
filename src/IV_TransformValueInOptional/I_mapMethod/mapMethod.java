package IV_TransformValueInOptional.I_mapMethod;

import java.util.Optional;

public class mapMethod {
	// map(Function<? super T,? extends U> mapper)
	// Biến đổi giá trị bên trong Optional<T> từ kiểu dữ liệu T thành kiểu
	// dữ liệu khác U (Optional<U>).
	// Nếu Optional<T> không null -- Biến đổi giá trị --> Optional<U>
	// Nếu Optional<T> null --> trả về Optional.empty() mà không thực hiện gì cả
	public static void main(String[] args) {
		// Optional chứa đối tượng Person
		Optional<Person> person = Optional.ofNullable(new Person("Nhuan"));
		
		// Sử dụng map để lấy độ dài của Person
		Optional<Integer> nameLength = person
				.map(p -> p.getName()) // Kiểu Person -> String
				.map(name -> name.length()); // String -> Integer
		nameLength.ifPresent(nameLength1 -> {
			System.out.println("nameLength: " + nameLength1);
		});
		// nameLength: 5
		
		// Sử dụng map với Optional rỗng
		Optional<Person> emptyPerson = Optional.empty();
		
		Optional<Integer> emptyLength = emptyPerson
				.map(p -> p.getName().length());
		
		// In ra nếu có kết quả, nhưng trường hợp này sẽ không có kết quả
		emptyLength.ifPresent(emptyLength1 -> {
			System.out.println("emptyLength: " + emptyLength1);
		});
	}
}

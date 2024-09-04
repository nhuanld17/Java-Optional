package IV_TransformValueInOptional.II_flatMapMethod;

import java.util.Optional;

public class flatMapMethod {
	// flatMap(Function<? super T, Optional<U>> mapper):
	// Nếu Optional ban đầu null, flatMap trả về Optional.empty()
	// Nếu Optional ban đầu không null, flatMap sẽ áp dụng hàm chuyển đổi
	// lên giá trị bên trong optional, trả về Optional<U>
	public static void main(String[] args) {
		// Lấy tên thành phố của 1 Person
		Optional<Person> person = Optional.of(new Person(new Address("Huế")));
		
		// Dùng flatMap để lấy city
		Optional<String> cityName = person
				.flatMap(p -> p.getAddress()) // Trả về Optional<Address>
				.flatMap(a -> a.getCity()); // trả về Optional<String>
		
		cityName.ifPresent(System.out::println);
	}
}

package IV_TransformValueInOptional.II_flatMapMethod;

import java.util.Optional;

public class Person {
	private Address address;
	
	public Person(Address address) {
		this.address = address;
	}
	
	public Optional<Address> getAddress() {
		return Optional.ofNullable(address);
	}
}

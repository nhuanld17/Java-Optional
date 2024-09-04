package IV_TransformValueInOptional.II_flatMapMethod;

import javax.swing.text.html.Option;
import java.util.Optional;

public class Address {
	private String city;
	
	public Address(String city) {
		this.city = city;
	}
	
	public Optional<String> getCity(){
		return Optional.ofNullable(city);
	}
}

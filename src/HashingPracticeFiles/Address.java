package HashingPracticeFiles;

import java.util.Objects;

public class Address {

	
	private int streetNumber;
	private String streetName, city, state, zip;

	public Address(int streetNumber, String streetName, String city, String state, String zip) {
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	public int getStreetNumber() {
		return streetNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public String getZip() {
		return zip;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Address) {
			Address other = (Address) obj;
			return Integer.compare(this.streetNumber, other.streetNumber)==0 &&
					this.streetName.equals(other.streetName) &&
					this.city.equals(other.city) &&
					this.state.equals(other.state) &&
					this.zip.equals(other.zip);
		} else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return Objects.hash(streetNumber, streetName, city, state, zip);
	}
	
}

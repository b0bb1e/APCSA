package dataLab;

public class EmergencyManager {
	private String address;
	private int zipCode;
	
	public EmergencyManager(String a, int zc) {
		address = a;
		zipCode = zc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipcode(int zipcode) {
		this.zipCode = zipcode;
	}
}

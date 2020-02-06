package hh.swd40.carproject.domain;

public class Car {
	
	// attribuutit
	private String merkki;
	private Integer valmistusvuosi;
	
	// konstruktorit
	
	public Car() {
		super();
		this.merkki = null;
		this.valmistusvuosi = null;
	}
	// getterit

	public Car(String string, int i) {
		// TODO Auto-generated constructor stub
	}

	public String getMerkki() {
		return merkki;
	}
	// setterit
	public void setMerkki(String merkki) {
		this.merkki = merkki;
	}

	public Integer getValmistusvuosi() {
		return valmistusvuosi;
	}

	public void setValmistusvuosi(Integer valmistusvuosi) {
		this.valmistusvuosi = valmistusvuosi;
	}

	
	
	
	
	
		// toString
	@Override
	public String toString() {
		return "Car [merkki=" + merkki + ", valmistusvuosi=" + valmistusvuosi + "]";
	}
	

}

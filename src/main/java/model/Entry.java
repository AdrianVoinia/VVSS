package model;

public class Entry {
	private int id;
	private int value;
	private String typeEntry;//cost or income
	private int idMember;
	
	
	public Entry(String typeEntry,int id, int value,int idM){
		this.typeEntry=typeEntry;
		this.id=id;
		this.value=value;
		this.idMember=idM;
	}
	public void setType(String newType) {
		typeEntry = newType;
	}
	
	public String getType() {
		return typeEntry;
	}

	public void setValue(int newValue) {
		this.value = newValue;
	}

	public int getValue() {
		return value;
	}
	public void setMember(int newMember) {
		this.idMember= newMember;
	}

	public int getIdMember() {
		return idMember;
	}
	public String toString() {
		String e=" ID of the member is: " +this.idMember+", and the type: " + this.typeEntry + " with the value: " + this.value;
		return e;   
	}
	
}

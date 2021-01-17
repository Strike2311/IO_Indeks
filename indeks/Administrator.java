package indeks;

public class Administrator extends Uzytkownik {
	private int ID;
	private String haslo;
	private String mail;
	private int uprawnienia=3;

	public Administrator(int ID, String haslo, String mail, int uprawnienia) {
		super(ID,haslo,uprawnienia);
		this.ID = ID;
		this.haslo = haslo;
		this.mail = mail;
	}
	public boolean equals(Student check){
		if(this.getID() != check.getID() || this.getHaslo() != check.getHaslo() || this.getUprawnienia() != this.getUprawnienia()
				|| this.getMail() != check.getMail()) return false;

		return true;
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}

	
}
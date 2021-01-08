
public class Administrator extends Uzytkownik{
	private int ID;
	private String haslo;
	private String mail;
	private int uprawnienia;

	public Administrator(int ID, String haslo, String mail, int uprawnienia) {
		super(ID,haslo,uprawnienia);
		this.ID = ID;
		this.haslo = haslo;
		this.mail = mail;
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
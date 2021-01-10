import java.util.ArrayList;

public class Prowadzacy extends Uzytkownik {
	private String imie;
	private String nazwisko;
	private int ID;
	private String haslo;
	private String mail;
	private int uprawnienia=2;

	public Prowadzacy(int ID, String haslo, String mail,int uprawnienia, String imie, String nazwisko) {
		super(ID,haslo,uprawnienia);
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.ID = ID;
		this.haslo = haslo;
		this.mail = mail;
	}
	public boolean equals(Student check){
		if(this.getID() != check.getID() || this.getHaslo() != check.getHaslo() || this.getUprawnienia() != this.getUprawnienia()
				|| this.getMail() != check.getMail() || this.getImie() != check.getImie() || this.getNazwisko() != check.getNazwisko()
				) return false;

		return true;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	

}

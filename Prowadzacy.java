import java.util.ArrayList;

public class Prowadzacy extends Uzytkownik {
	private String imie;
	private String nazwisko;
	private int ID;
	private String haslo;
	private String mail;
	private int uprawnienia;

	public Prowadzacy(String imie, String nazwisko, int ID, String haslo, String mail,int uprawnienia) {
		super(ID,haslo,uprawnienia);
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.ID = ID;
		this.haslo = haslo;
		this.mail = mail;
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

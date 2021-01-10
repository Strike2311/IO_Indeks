import java.util.ArrayList;


public class Student extends Uzytkownik{
private String imie;
private String nazwisko;
private int ID;
private String haslo;
private String mail;
private ArrayList<Ocena> oceny = new ArrayList<Ocena>();
private String wydzial;
private String kierunek;
private int uprawnienia=1;

public Student(int ID, String haslo, String mail,int uprawnienia,String imie, String nazwisko, String wydzial, String kierunek) {
	super(ID,haslo,uprawnienia);
	this.imie = imie;
	this.nazwisko = nazwisko;
	this.ID = ID;
	this.haslo = haslo;
	this.mail = mail;
	this.wydzial = wydzial;
	this.kierunek = kierunek;
	
}
public boolean equals(Student check){
	if(this.getID() != check.getID() || this.getHaslo() != check.getHaslo() || this.getUprawnienia() != this.getUprawnienia()
	|| this.getMail() != check.getMail() || this.getImie() != check.getImie() || this.getNazwisko() != check.getNazwisko() ||
			this.getKierunek() != check.getKierunek() || this.getWydzial() != check.getWydzial()) return false;

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
public ArrayList<Ocena> getOceny() {
	return oceny;
}
public void setOceny(ArrayList<Ocena> oceny) {
	this.oceny = oceny;
}
public String getWydzial() {
	return wydzial;
}
public void setWydzial(String wydzial) {
	this.wydzial = wydzial;
}
public String getKierunek() {
	return kierunek;
}
public void setKierunek(String kierunek) {
	this.kierunek = kierunek;
}


}

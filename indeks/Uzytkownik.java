package indeks;

public class Uzytkownik {
private int ID;
private String haslo;
private int uprawnienia;
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getHaslo() {
	return haslo;
}
public void setHaslo(String haslo) {
	this.haslo = haslo;
}
public int getUprawnienia() {
	return uprawnienia;
}
public void setUprawnienia(int uprawnienia) {
	this.uprawnienia = uprawnienia;
}
public Uzytkownik(int id, String haslo, int uprawnienia) {
	this.ID= id;
	this.haslo = haslo;
	this.uprawnienia = uprawnienia;
}

public boolean equals(Uzytkownik check){
	if(this.getID() != check.getID() || this.getHaslo() != check.getHaslo() || this.getUprawnienia() != this.getUprawnienia()){
		return false;
	}
	return true;
}
}

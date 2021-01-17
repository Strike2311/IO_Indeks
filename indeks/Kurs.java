package indeks;

import java.util.ArrayList;

public class Kurs {

	private String nazwa;
	private String kod;
	private int ID_Prowadzacego;
	private String dzien;
	private String godzina;
	private ArrayList<Student> lista = new ArrayList<Student>(); 
	
	
	public Kurs(String nazwa, String kod, int ID_Prowadzacego, String dzien, String godzina) {
		this.nazwa = nazwa;
		this.kod = kod;
		this.ID_Prowadzacego = ID_Prowadzacego;
		this.dzien = dzien;
		this.godzina = godzina;
	}
	
	public ArrayList<Student> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Student> lista) {
		this.lista = lista;
	}

	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getKod() {
		return kod;
	}
	public void setKod(String kod) {
		this.kod = kod;
	}
	public int getID_Prowadzacego() {
		return ID_Prowadzacego;
	}
	public void setID_Prowadzacego(int iD_Prowadzacego) {
		ID_Prowadzacego = iD_Prowadzacego;
	}
	public String getDzien() {
		return dzien;
	}
	public void setDzien(String dzien) {
		this.dzien = dzien;
	}
	public String getGodzina() {
		return godzina;
	}
	public void setGodzina(String godzina) {
		this.godzina = godzina;
	}
	
	

	
}

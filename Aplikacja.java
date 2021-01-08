import java.util.ArrayList;
import java.util.Scanner;
public class Aplikacja {
	
private ArrayList<Prowadzacy> prowadzacy = new ArrayList<Prowadzacy>();
private ArrayList<Student> studenci = new ArrayList<Student>();
private ArrayList<Administrator> administratorzy = new ArrayList<Administrator>();
private ArrayList<Uzytkownik> uzytkownicy = new ArrayList<Uzytkownik>();

Scanner scan = new Scanner(System.in);
public static Uzytkownik aktualny_Uzytkownik = new Uzytkownik(0, null, 0);
public ArrayList<Prowadzacy> getProwadzacy() {
	return prowadzacy;
}
public void setProwadzacy(ArrayList<Prowadzacy> prowadzacy) {
	this.prowadzacy = prowadzacy;
}
public ArrayList<Student> getStudenci() {
	return studenci;
}
public void setStudenci(ArrayList<Student> studenci) {
	this.studenci = studenci;
}
public ArrayList<Administrator> getAdministrztorzy() {
	return administratorzy;
}
public void setAdministrztorzy(ArrayList<Administrator> administrztorzy) {
	this.administratorzy = administrztorzy;
}
public ArrayList<Uzytkownik> getUzytkownicy() {
	return uzytkownicy;
}
public void setUzytkownicy(ArrayList<Uzytkownik> uzytkownicy) {
	this.uzytkownicy = uzytkownicy;
}

public Student wyszukaj_ID_Studenta(Student id) { return null; }

public Student wyswietl_dane_Studenta(Student student) { return null; }

public void aktualizuj_oceny_Studenta(Student student) {  }

public void zaloguj_sie(ArrayList<Uzytkownik> uzytkownicy,ArrayList<Prowadzacy> prowadzacy,ArrayList<Student> studenci,ArrayList<Administrator> administratorzy) {
	int wybor_uzytkownika;
	wybor_uzytkownika=scan.nextInt();
	int id=scan.nextInt();
	String haslo=scan.next();
	if(sprawdzenie_poprawnosci_danych(id,haslo)==false) zaloguj_sie(uzytkownicy, prowadzacy, studenci, administratorzy);
	switch(wybor_uzytkownika) {
	case 1:
		for(Student student : studenci) {
			if(student.getID()==id)
				aktualny_Uzytkownik = student;
			return;
		}
		break;
	case 2:
		for(Prowadzacy prowadzacy1 : prowadzacy) {
			if(prowadzacy1.getID()==id)
				aktualny_Uzytkownik = prowadzacy1;
			
			return;
		}	
		break;
	case 3:
		for(Administrator administrator : administratorzy) {
			if(administrator.getID()==id)
				aktualny_Uzytkownik = administrator;
			return;
		}
		break;
	default: 
		break;
	}
}

public boolean sprawdzenie_poprawnosci_danych(int ID, String haslo) { 
	
	if (haslo.length() < 8) {   
        return false;  
    } 
	else if(ID < 100000 || ID >= 1000000) 
		return false;
	
	else 
	{      
        char c;  
        int digitCount = 0;   
        int letterCount = 0;
        for (int i = 0; i < haslo.length(); i++) {  
            c = haslo.charAt(i);  
            if (!Character.isLetterOrDigit(c)) {          
                return false;  
            } 
            else if (Character.isDigit(c)) {  
                digitCount++;  
                 
            }
            else if (Character.isLetter(c)) {  
                letterCount++;  
                 
            }  
          
        }
        if (digitCount < 1 || letterCount < 1){     
        return false;  
        }  
    } 
    return true;  
}

	

public void wyswietl_dane_personalne(int ID) { }

public void aktualizuj_dane_uzytkownika(int ID) { }

public Uzytkownik wyszukaj_ID_uzytkownika(int ID) { 
	
	return null; }

public void dodaj_nowego_uzytkownika(String dane[]) {  }

public static void main(String []args) {
	boolean result;
	Uzytkownik uzytkownik1 = new Uzytkownik(1,"haslo",0);
	Uzytkownik uzytkownik2 = new Uzytkownik(2,"haslo",0);
	Uzytkownik uzytkownik3 = new Uzytkownik(3,"haslo",0);
	
	Student student1 = new Student("ja", "xyz", 2, "haslo", "mail", "wydzial", "kierunek", 1);
	ArrayList<Ocena> oceny = student1.getOceny();
	Ocena ocena = new Ocena();
	Kurs kurs = new Kurs(null, null, 0, null, null);
	ocena.setKurs(kurs);
	student1.getOceny().add(ocena);
	ocena.getKurs().equals(ocena);
	ArrayList<Uzytkownik> uzytkownicy = new ArrayList<Uzytkownik>();
	ArrayList<Administrator> administratorzy = new ArrayList<Administrator>();
	ArrayList<Prowadzacy> prowadzacy = new ArrayList<Prowadzacy>();
	ArrayList<Student> studenci = new ArrayList<Student>();
	uzytkownicy.add(uzytkownik1);
	uzytkownicy.add(uzytkownik2);
	uzytkownicy.add(uzytkownik3);
	studenci.add(student1);
	Aplikacja aplikacja = new Aplikacja();
	result=aplikacja.sprawdzenie_poprawnosci_danych(1,"haslo");
	System.out.println(result);
	aplikacja.zaloguj_sie(
	uzytkownicy, prowadzacy, studenci, administratorzy);
	System.out.println(aktualny_Uzytkownik.getID()+" " +aktualny_Uzytkownik.getUprawnienia());
}
}

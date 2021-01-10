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

public Student wyszukaj_ID_Studenta(int id) {
	for (Student student : studenci) {
		if (student.getID() == id)
			return student;
	}
	System.out.println("Taki student nie istnieje");
	return null; }

public Student wyswietl_dane_Studenta(Student student) {
	System.out.println("ID : " + student.getID());
	System.out.println("Imie : " + student.getImie());
	System.out.println("Nazwisko : " +student.getNazwisko());
	System.out.println("Kierunek : " + student.getKierunek());
	System.out.println("Wydział : " + student.getWydzial());
	System.out.println("Mail : " + student.getMail());
	return null; }

public void aktualizuj_oceny_Studenta(Student student,String [] dane) {
	ArrayList<Ocena> oceny_studenta;
	 oceny_studenta = student.getOceny();
	 Ocena ocena = new Ocena();
	 for(Ocena ocena_studenta : oceny_studenta){
	 	if(ocena.getKurs().equals(ocena_studenta)==true){
	 		ocena_studenta.setWartosc(Float.parseFloat(dane[0]));
	 		return;
		}
	 }
	 student.getOceny().add(ocena);
}

	public Uzytkownik zaloguj_sie( ArrayList<Prowadzacy> prowadzacy, ArrayList<Student> studenci, ArrayList<Administrator> administratorzy) {
		int wybor_uzytkownika;
		wybor_uzytkownika = scan.nextInt();
		int id = scan.nextInt();
		scan.nextLine();
		String haslo = scan.nextLine();
		if (sprawdzenie_poprawnosci_danych(id, haslo) == false)
			zaloguj_sie(prowadzacy, studenci, administratorzy);
		switch (wybor_uzytkownika) {
			case 1:
				for (Student student : studenci) {
					if (student.getID() == id)
						aktualny_Uzytkownik = student;
					return aktualny_Uzytkownik;
				}
				break;
			case 2:
				for (Prowadzacy prowadzacy1 : prowadzacy) {
					if (prowadzacy1.getID() == id)
						aktualny_Uzytkownik = prowadzacy1;

					return aktualny_Uzytkownik;
				}
				break;
			case 3:
				for (Administrator administrator : administratorzy) {
					if (administrator.getID() == id)
						aktualny_Uzytkownik = administrator;
					return aktualny_Uzytkownik;
				}
				break;
			default:
				break;
		}
		return null;
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

	

public void wyswietl_dane_personalne(int ID) {
	Uzytkownik uzytkownik;
	uzytkownik = wyszukaj_ID_uzytkownika( ID);
	int wybor_uzytkownika = uzytkownik.getUprawnienia();
	switch (wybor_uzytkownika) {
		case 1:
			for(Student student : studenci){
			if(student.getID()==ID){
				System.out.println("Imie : " + student.getImie());
				System.out.println("Nazwisko : " +student.getNazwisko());
				System.out.println("Kierunek : " + student.getKierunek());
				System.out.println("Wydział : " + student.getWydzial());
				System.out.println("Mail : " + student.getMail());

			}
			}

			break;
		case 2:
			for(Prowadzacy profesor : prowadzacy){
			if(profesor.getID()==ID){
				System.out.println("Imie : " + profesor.getImie());
				System.out.println("Nazwisko : " + profesor.getNazwisko());
				System.out.println("Mail : " + profesor.getMail());
			}
			}
			break;
		case 3:
			for(Administrator administrator : administratorzy){
				if(administrator.getID()==ID){
					System.out.println("Mail : " + administrator.getMail());
				}
			}
			break;
		default:
			break;
	}

}

public void aktualizuj_dane_uzytkownika(int ID,String dane[]) {
	Uzytkownik uzytkownik;
	uzytkownik = wyszukaj_ID_uzytkownika( ID);

	if(sprawdzenie_poprawnosci_danych(Integer.parseInt(dane[0]),dane[1])==false){
		System.out.println("Nie można zmienić danych na takie");
		return;
	}
	uzytkownik.setID(Integer.parseInt(dane[0]));
	uzytkownik.setHaslo(dane[1]);
}

public Uzytkownik wyszukaj_ID_uzytkownika(int ID) {
	for (Uzytkownik uzytkownik:uzytkownicy)
	{
		if(ID==uzytkownik.getID()){
			return uzytkownik;
		}
	}
	System.out.println("Nie odnaleziono uzytkownika");
	return null; }


public Uzytkownik dodaj_nowego_uzytkownika(String dane[],int wybor_uzytkownika,ArrayList<Prowadzacy> prowadzacy,
									 ArrayList<Student> studenci, ArrayList<Administrator> administratorzy,ArrayList<Uzytkownik> uzytkownicy) {
	switch (wybor_uzytkownika) {
		case 1:
			Student student = new Student(Integer.parseInt(dane[0]),dane[1],dane[2],Integer.parseInt(dane[3]),dane[4],dane[5],dane[6],dane[7]);
			if(sprawdzenie_poprawnosci_danych(student.getID(), student.getHaslo()) == false){
				System.out.println("Nieprawidłowe hasło lub ID");
				break;
			}
			studenci.add(student);
			uzytkownicy.add(student);
			return student;

		case 2:
			Prowadzacy profesor = new Prowadzacy(Integer.parseInt(dane[0]),dane[1],dane[2],Integer.parseInt(dane[3]),dane[4],dane[5]);
			if(sprawdzenie_poprawnosci_danych(profesor.getID(), profesor.getHaslo()) == false){
				System.out.println("Nieprawidłowe hasło lub ID");
				break;
			}
			prowadzacy.add(profesor);
			uzytkownicy.add(profesor);
			return profesor;
		case 3:
			Administrator administrator = new Administrator(Integer.parseInt(dane[0]),dane[1],dane[2],Integer.parseInt(dane[3]));
			if(sprawdzenie_poprawnosci_danych(administrator.getID(), administrator.getHaslo()) == false){
				System.out.println("Nieprawidłowe hasło lub ID");
				break;
			}
			administratorzy.add(administrator);
			uzytkownicy.add(administrator);
			return administrator;

		default:
			return null;
	}
	return null;
}

public static void main(String []args) {
	boolean result;
	Uzytkownik uzytkownik1 = new Uzytkownik(123456,"haslo123",0);
	Uzytkownik uzytkownik2 = new Uzytkownik(234567,"haslo123",0);
	Uzytkownik uzytkownik3 = new Uzytkownik(345678,"haslo123",0);
	
	Student student1 = new Student(223322, "xyzaaa123", "ja", 1, "Mariusz", "Aaaaaa", "Elektronika", "Informatyka");
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
	result=aplikacja.sprawdzenie_poprawnosci_danych(123456,"haslo123");
	System.out.println(result);
	aplikacja.zaloguj_sie(prowadzacy, studenci, administratorzy);
	System.out.println(aktualny_Uzytkownik.getID()+" " +aktualny_Uzytkownik.getUprawnienia());
}
}

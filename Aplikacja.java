import Views.*;

import java.util.ArrayList;
import java.util.Scanner;
public class Aplikacja {
	
public ArrayList<Prowadzacy> prowadzacy = new ArrayList<Prowadzacy>();
public ArrayList<Student> studenci = new ArrayList<Student>();
public ArrayList<Administrator> administratorzy = new ArrayList<Administrator>();
public ArrayList<Uzytkownik> uzytkownicy = new ArrayList<Uzytkownik>();

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

public Student wyszukaj_ID_Studenta(ProwadzacyView prowadzacyView) {
	String id_studenta_string = prowadzacyView.getIdStudentaField().getText();
	int id_studenta = Integer.parseInt(id_studenta_string);
	for (Student student : studenci) {
		if (student.getID() == id_studenta)
			wyswietl_dane_Studenta(student);
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
Login_View login_view = new Login_View();




	public void init(){
	login_view.getLoginButton().addActionListener(e->zaloguj_sie(prowadzacy,studenci,administratorzy));

}
	public Uzytkownik zaloguj_sie( ArrayList<Prowadzacy> prowadzacy, ArrayList<Student> studenci, ArrayList<Administrator> administratorzy) {
		int wybor_uzytkownika = 0;


		if(login_view.getLoginBox().getSelectedIndex()==0){
			wybor_uzytkownika=1;
		}
		if(login_view.getLoginBox().getSelectedIndex()==1){
			wybor_uzytkownika=2;
		}
		if(login_view.getLoginBox().getSelectedIndex()==2){
			wybor_uzytkownika=3;
		}
		String String_id= login_view.getLoginField().getText();
		int id = Integer.parseInt(String_id);
		String haslo = login_view.getPasswordField().getText();
		System.out.println("wybor uzytkownika " + wybor_uzytkownika + " id " + id + " haslo " + haslo);
		if (sprawdzenie_poprawnosci_danych(id, haslo) == false){
			System.out.println("Wrong login or password");
			}
		switch (wybor_uzytkownika) {
			case 1:
				for (Student student : studenci) {
					if (student.getID() == id && student.getHaslo().equals(haslo)){
						StudentView studentView = new StudentView();
						studentView.idLabel.setText(String_id);
						studentView.getWyswietlDaneButton().addActionListener(e->wyswietl_dane_personalne(id));
						aktualny_Uzytkownik = student;}
					return aktualny_Uzytkownik;
				}
				break;
			case 2:
				for (Prowadzacy prowadzacy1 : prowadzacy) {
					if (prowadzacy1.getID() == id && prowadzacy1.getHaslo().equals(haslo))
						aktualny_Uzytkownik = prowadzacy1;
					ProwadzacyView prowadzacyView = new ProwadzacyView();
					prowadzacyView.getIdField().setText(String_id);


					prowadzacyView.getWyswietlDaneSButton().addActionListener(e->wyszukaj_ID_Studenta(prowadzacyView));
					return aktualny_Uzytkownik;
				}
				break;
			case 3:
				for (Administrator administrator : administratorzy) {
					if (administrator.getID() == id && administrator.getHaslo().equals(haslo))
						aktualny_Uzytkownik = administrator;
					AdministratorView administratorView = new AdministratorView();
					administratorView.getIdField().setText(String_id);
					administratorView.getDodajStudentaButton().addActionListener(e->initNowyStudent());
					administratorView.getDodajProwadzacegoButton().addActionListener(e->initNowyProwadzacy());
					administratorView.getDodajNowegoAdministratoraButton().addActionListener(e->initNowyAdministrator());

					administratorView.getModyfikujStudentaButton().addActionListener(e->initModyfikujStudent(administratorView));
					administratorView.getModyfikujProwadzacegoButton().addActionListener(e->initModyfikujProwadzacy(administratorView));
					administratorView.getModyfikujAdministratoraButton().addActionListener(e->initModyfikujAdministrator(administratorView));
					return aktualny_Uzytkownik;
				}
				break;
			default:
				break;
		}
		System.out.println("There is not user with that login and password");
		return null;
	}

	private void initModyfikujStudent(AdministratorView administratorView) {
		String id_uzytkownika_string = administratorView.getIdUzytkownikaField().getText();
		int id_uzytkownika = Integer.parseInt(id_uzytkownika_string);
		Student student;
		student =  wyszukaj_ID_uzytkownika_studenta(id_uzytkownika,studenci);

		NowyStudentView nowyStudentView = new NowyStudentView();
		int id_studenta;
		id_studenta = student.getID();
		Integer id_studenta_int = new Integer(id_studenta);
		nowyStudentView.getIdField().setText(id_studenta_int.toString());
		nowyStudentView.getHasloField().setText(student.getHaslo());
		nowyStudentView.getImieField().setText(student.getImie());
		nowyStudentView.getMailField().setText(student.getMail());
		nowyStudentView.getNazwiskoField().setText(student.getNazwisko());
		nowyStudentView.getWydzialField().setText(student.getWydzial());
		nowyStudentView.getKierunekField().setText(student.getKierunek());
		nowyStudentView.getAcceptButtom().addActionListener(e->modyfikuj_Studenta(nowyStudentView,student));
	}

	private void modyfikuj_Studenta(NowyStudentView nowyStudentView, Student student) {
		student.setImie(nowyStudentView.getImieField().getText());
		student.setMail(nowyStudentView.getMailField().getText());
		student.setHaslo(nowyStudentView.getHasloField().getText());
		student.setID(Integer.parseInt(nowyStudentView.getIdField().getText()));
		student.setNazwisko(nowyStudentView.getNazwiskoField().getText());
		student.setWydzial(nowyStudentView.getWydzialField().getText());
		student.setKierunek(nowyStudentView.getKierunekField().getText());
	}
	//to podobnie jak studenta będzie
	private void initModyfikujProwadzacy(AdministratorView administratorView){
		String id_uzytkownika_string = administratorView.getIdUzytkownikaField().getText();
		int id_uzytkownika = Integer.parseInt(id_uzytkownika_string);
		Prowadzacy prowadzacy;
		prowadzacy = (Prowadzacy) wyszukaj_ID_uzytkownika(id_uzytkownika);
		NowyProwadzacyView nowyProwadzacyView = new NowyProwadzacyView();
	}
	private void initModyfikujAdministrator(AdministratorView administratorView){
		String id_uzytkownika_string = administratorView.getIdUzytkownikaField().getText();
		int id_uzytkownika = Integer.parseInt(id_uzytkownika_string);
		Administrator administrator;
		administrator = (Administrator) wyszukaj_ID_uzytkownika(id_uzytkownika);
		NowyAdministratorView nowyAdministratorView = new NowyAdministratorView();
	}
	private void initNowyAdministrator(){
		NowyAdministratorView nowyAdministratorView = new NowyAdministratorView();
		nowyAdministratorView.getAcceptButton().addActionListener(e->pobierzDaneAdministratora(nowyAdministratorView));
	}

	private void pobierzDaneAdministratora(NowyAdministratorView nowyAdministratorView) {
		String[] dane = new String[4];
		dane[0] = nowyAdministratorView.getIdField().getText();
		dane[1] = nowyAdministratorView.getHasloField().getText();
		dane[2] = nowyAdministratorView.getMailField().getText();
		dane[3] = "3";
		dodaj_nowego_uzytkownika(dane,3,prowadzacy,studenci,administratorzy,uzytkownicy);
	}

	private void initNowyProwadzacy() {
		NowyProwadzacyView nowyProwadzacyView = new NowyProwadzacyView();
		nowyProwadzacyView.getAcceptButton().addActionListener(e->pobierzDaneProwadzacego(nowyProwadzacyView));
	}

	private void pobierzDaneProwadzacego(NowyProwadzacyView nowyProwadzacyView) {
		String[] dane = new String[6];
		dane[0] = nowyProwadzacyView.getIdField().getText();
		dane[1] = nowyProwadzacyView.getHasloField().getText();
		dane[2] = nowyProwadzacyView.getMailField().getText();
		dane[3] = "2";
		dane[4] = nowyProwadzacyView.getImieField().getText();
		dane[5] = nowyProwadzacyView.getNazwiskoField().getText();
		dodaj_nowego_uzytkownika(dane,2,prowadzacy,studenci,administratorzy,uzytkownicy);
	}

	private void initNowyStudent() {
		NowyStudentView nowyStudentView = new NowyStudentView();

		nowyStudentView.getAcceptButtom().addActionListener(e->pobierzDaneStudenta(nowyStudentView));
	}
	public void pobierzDaneStudenta(NowyStudentView nowyStudentView){
		String[] dane = new String[8];
		dane[0] = nowyStudentView.getIdField().getText();
		dane[1] = nowyStudentView.getHasloField().getText();
		dane[2] = nowyStudentView.getMailField().getText();
		dane[3] = "1";
		dane[4] = nowyStudentView.getImieField().getText();
		dane[5] = nowyStudentView.getNazwiskoField().getText();
		dane[6] = nowyStudentView.getWydzialField().getText();
		dane[7] = nowyStudentView.getKierunekField().getText();
		dodaj_nowego_uzytkownika(dane,1,prowadzacy,studenci,administratorzy,uzytkownicy);
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
		System.out.println("wchodzi");
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

public Student wyszukaj_ID_uzytkownika_studenta(int ID,ArrayList<Student> studenci) {
	for(Student student : studenci){
		if(student.getID()==ID){
			return student;
		}
	}
	throw new IllegalArgumentException("Nie ma studenta o takim ID");
}
public Uzytkownik wyszukaj_ID_uzytkownika(int ID) {
		int wybor_uzytkownika=0;
	for (Uzytkownik uzytkownik:uzytkownicy)
	{
		if(ID==uzytkownik.getID()){
			wybor_uzytkownika = uzytkownik.getUprawnienia();
			switch (wybor_uzytkownika) {
				case 1:
					for(Student student : studenci){
						if(student.getID()==ID){
							return student;
						}
					}

					break;
				case 2:
					for(Prowadzacy prowadzacy1 : prowadzacy){
						if(prowadzacy1.getID()==ID){

							return prowadzacy1;
						}
					}
					break;
				case 3:
					for(Administrator administrator : administratorzy){
						if(administrator.getID()==ID){
							return administrator;
						}
					}
					break;
				default:
					break;
			}
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
	Uzytkownik uzytkownik1 = new Uzytkownik(123556,"haslo123",0);
	Uzytkownik uzytkownik2 = new Uzytkownik(234567,"haslo123",0);
	Uzytkownik uzytkownik3 = new Uzytkownik(345678,"haslo123",0);
	
	Student student1 = new Student(123456, "Marian1234", "ja", 1, "Mariusz", "Aaaaaa", "Elektronika", "Informatyka");
	Prowadzacy prowadzacy1 = new Prowadzacy(345678,"haslo123","mail",2,"Mietek","Kowalski");
	Administrator administrator1 = new Administrator(456789,"haslo123","mail",3);
	ArrayList<Ocena> oceny = student1.getOceny();
	Ocena ocena = new Ocena();
	Kurs kurs = new Kurs(null, null, 0, null, null);
	ocena.setKurs(kurs);
	student1.getOceny().add(ocena);
	ocena.getKurs().equals(ocena);


	Aplikacja aplikacja = new Aplikacja();
	aplikacja.uzytkownicy.add(uzytkownik1);
	aplikacja.uzytkownicy.add(uzytkownik2);
	aplikacja.uzytkownicy.add(uzytkownik3);
	aplikacja.uzytkownicy.add(student1);
	aplikacja.uzytkownicy.add(prowadzacy1);
	aplikacja.studenci.add(student1);
	aplikacja.prowadzacy.add(prowadzacy1);
	aplikacja.administratorzy.add(administrator1);
	aplikacja.uzytkownicy.add(administrator1);

	aplikacja.init();

}
}

package indeks;

import static org.junit.jupiter.api.Assertions.*;

import indeks.Administrator;
import indeks.Aplikacja;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
//import org.testng.annotations.AfterClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AplikacjaTest {

	static Aplikacja test;
	static Dane dane;

	@BeforeAll
	static public void init(){
		dane= new Dane();
		test = new Aplikacja();
	}

	/*
	* Test parametryzowany
	* */
	@ParameterizedTest(name = "{index} => ID = {0}, haslo = {1}")
	@CsvSource({ "123456,  'AlamaKota1',    true",
				 "123,     'AlamaKota2',    false", 
				 "1234567, 'abrakadabra15', false",
				 "123456,  'alamakota',     false",
				 "123456,  '12321315',      false",
				 "123456,  'ala12',         false",
				 "1,        'abrakadabra15', false",
				 "123456,  '',              false"
			})
	void testSprawdzeniePoprawnosciDanych_CSV(int login, String pass, boolean equal) {
		boolean check = test.sprawdzenie_poprawnosci_danych(login, pass);
		assertEquals(check,equal);
	}
	
	@Test
	void testDodanieNowegoUzytkownika() {
		for(int i = 0; i<6; i++){
			Uzytkownik actual = test.dodaj_nowego_uzytkownika(dane.daneDodajUzytkownika[i],Integer.parseInt(dane.daneDodajUzytkownika[i][3]), test.getProwadzacy(), test.getStudenci(), test.getAdministrztorzy(), test.getUzytkownicy());
			switch(Integer.parseInt(dane.daneDodajUzytkownika[i][3])){
				case 1:
					Student expected1 = new Student(Integer.parseInt(dane.daneDodajUzytkownika[i][0]), dane.daneDodajUzytkownika[i][1], dane.daneDodajUzytkownika[i][2],
							Integer.parseInt(dane.daneDodajUzytkownika[i][3]),dane.daneDodajUzytkownika[i][4],(dane.daneDodajUzytkownika[i][5]),
							dane.daneDodajUzytkownika[i][6],dane.daneDodajUzytkownika[i][7]);
					Assertions.assertTrue(expected1.equals(actual));
					break;
				case 2:
					Prowadzacy expected2 = new Prowadzacy(Integer.parseInt(dane.daneDodajUzytkownika[i][0]),dane.daneDodajUzytkownika[i][1],dane.daneDodajUzytkownika[i][2],
							Integer.parseInt(dane.daneDodajUzytkownika[i][3]),dane.daneDodajUzytkownika[i][4],(dane.daneDodajUzytkownika[i][5]));
					Assertions.assertTrue(expected2.equals(actual));
					break;
				case 3:
					Administrator expected3 = new Administrator(Integer.parseInt(dane.daneDodajUzytkownika[i][0]),dane.daneDodajUzytkownika[i][1],dane.daneDodajUzytkownika[i][2],
							Integer.parseInt(dane.daneDodajUzytkownika[i][3]));
					assertTrue(expected3.equals(actual));

					break;
			}

		}


	}


	//@AfterClass
	public static void tearDownClass() {
		test = null;
		dane = null;
	}
}

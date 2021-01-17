import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
//import org.testng.annotations.AfterClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.sql.SQLException;
import java.util.ArrayList;

class AplikacjaTest {

	static Aplikacja test;
	static Dane dane;
	public ArrayList<Student> studenci = new ArrayList<Student>();

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
					assertTrue(expected1.equals(actual));
					studenci.add(expected1);
					break;
				case 2:
					Prowadzacy expected2 = new Prowadzacy(Integer.parseInt(dane.daneDodajUzytkownika[i][0]),dane.daneDodajUzytkownika[i][1],dane.daneDodajUzytkownika[i][2],
							Integer.parseInt(dane.daneDodajUzytkownika[i][3]),dane.daneDodajUzytkownika[i][4],(dane.daneDodajUzytkownika[i][5]));
					assertTrue(expected2.equals(actual));
					break;
				case 3:
					Administrator expected3 = new Administrator(Integer.parseInt(dane.daneDodajUzytkownika[i][0]),dane.daneDodajUzytkownika[i][1],dane.daneDodajUzytkownika[i][2],
							Integer.parseInt(dane.daneDodajUzytkownika[i][3]));
					assertTrue(expected3.equals(actual));

					break;
			}

		}


	}
	@Test
	public void test_wyszukaj_ID_uzytkownika_studenta(){
		//we tu dodaj bo trzeba tą liste studentów gdzieś przechowywać
		//assertDoesNotThrow(()->test.wyszukaj_ID_uzytkownika_studenta(244422,studenci));
		//assertDoesNotThrow(()->test.wyszukaj_ID_uzytkownika_studenta(112233,studenci));
		assertThrows(IllegalArgumentException.class,() -> test.wyszukaj_ID_uzytkownika_studenta(112233,studenci));
		assertThrows(IllegalArgumentException.class,()->test.wyszukaj_ID_uzytkownika_studenta(9999,studenci));


	}
/*
	void testSprawdzeniePoprawnosciDanych(int ID, String haslo) {
		boolean output = test.sprawdzenie_poprawnosci_danych(248834, "AlamaKota1"); //poprawny zapis
		assertTrue(output);
		
		output = test.sprawdzenie_poprawnosci_danych(121, "AlamaKota1");//bledny zapis, za kr�tkie ID
		assertFalse(output);
		
		output = test.sprawdzenie_poprawnosci_danych(211121, "12345678");//b��dny zapis, brak liter
		assertFalse(output);
		
		output = test.sprawdzenie_poprawnosci_danych(211121, "abcdefgh");//b��dny zapis, brak cyfr
		assertFalse(output);
		
		output = test.sprawdzenie_poprawnosci_danych(211121, "1!345`~78");//b��dny zapis, znaki specjalne
		assertFalse(output);
		
		output = test.sprawdzenie_poprawnosci_danych(2112214, "12345678");//b��dny zapis, za d�ugie ID
		assertFalse(output);
	}
*/

	//@AfterClass
	public static void tearDownClass() {
		test = null;
		dane = null;
	}
}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class AplikacjaTest {

	static Aplikacja test = new Aplikacja();
	static Dane dane = new Dane();
	
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
	
	//@Test
	//void testSprawdzeniePoprawnosciDanych() {
	//	for(int i=0; i<6; i++) {
	//	boolean check = test.sprawdzenie_poprawnosci_danych(Integer.parseInt(dane.daneSprawdzeniePoprawnosciDanych[i][1]), dane.daneSprawdzeniePoprawnosciDanych[i][2]);
	//	assertEquals(Boolean.parseBoolean(dane.daneSprawdzeniePoprawnosciDanych[i][3]),check);
//		}
	//	
	//}
	
	/*
	void testSprawdzeniePoprawnosciDanych(int ID, String haslo) {
		boolean output = test.sprawdzenie_poprawnosci_danych(248834, "AlamaKota1"); //poprawny zapis
		assertTrue(output);
		
		output = test.sprawdzenie_poprawnosci_danych(121, "AlamaKota1");//bledny zapis, za krótkie ID
		assertFalse(output);
		
		output = test.sprawdzenie_poprawnosci_danych(211121, "12345678");//b³êdny zapis, brak liter
		assertFalse(output);
		
		output = test.sprawdzenie_poprawnosci_danych(211121, "abcdefgh");//b³êdny zapis, brak cyfr
		assertFalse(output);
		
		output = test.sprawdzenie_poprawnosci_danych(211121, "1!345`~78");//b³êdny zapis, znaki specjalne
		assertFalse(output);
		
		output = test.sprawdzenie_poprawnosci_danych(2112214, "12345678");//b³êdny zapis, za d³ugie ID
		assertFalse(output);
	}
	*/
	
	@AfterClass
	public static void tearDownClass() {
		test = null;
	}
}

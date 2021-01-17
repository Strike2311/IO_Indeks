package testyfitnessfixture;
        import fit.ColumnFixture;
        import indeks.Administrator;
        import indeks.Prowadzacy;
        import indeks.Student;
        import indeks.Uzytkownik;
        import org.junit.jupiter.api.Assertions;

        import java.util.IllegalFormatCodePointException;

        import static org.junit.jupiter.api.Assertions.assertTrue;

public class testSprawdzeniePoprawnosciDanych extends ColumnFixture{
   String dane[];
   public boolean sprawdzeniePoprawnosciDanych() throws ArrayIndexOutOfBoundsException, NumberFormatException{
       boolean check;
           try {
                 check = SetUp.aplikacja.sprawdzenie_poprawnosci_danych(Integer.parseInt(dane[0]), dane[1]);
           }
           catch(ArrayIndexOutOfBoundsException e ){
                return false;

           }
           catch(NumberFormatException e){
                return false;
           }
           return check;
   }
    public boolean testDodanieNowegoUzytkownika() {
            Uzytkownik actual = SetUp.aplikacja.dodaj_nowego_uzytkownika(dane, Integer.parseInt(dane[3]), SetUp.aplikacja.getProwadzacy(), SetUp.aplikacja.getStudenci(), SetUp.aplikacja.getAdministrztorzy(), SetUp.aplikacja.getUzytkownicy());
            switch (Integer.parseInt(dane[3])) {
                case 1:
                    Student expected1 = new Student(Integer.parseInt(dane[0]), dane[1], dane[2],
                            Integer.parseInt(dane[3]), dane[4], (dane[5]),
                            dane[6], dane[7]);
                    return expected1.equals(actual);
                case 2:
                    Prowadzacy expected2 = new Prowadzacy(Integer.parseInt(dane[0]), dane[1], dane[2],
                            Integer.parseInt(dane[3]), dane[4], (dane[5]));
                    return expected2.equals(actual);

                case 3:
                    Administrator expected3 = new Administrator(Integer.parseInt(dane[0]), dane[1], dane[2],
                            Integer.parseInt(dane[3]));
                    return expected3.equals(actual);

            }


        return false;
   }
}
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

}
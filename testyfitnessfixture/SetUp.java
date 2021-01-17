package testyfitnessfixture;
import fit.Fixture;
import indeks.Aplikacja;

public class SetUp extends Fixture{
    static Aplikacja aplikacja;
    public SetUp() {
        aplikacja = new Aplikacja();
    }
}
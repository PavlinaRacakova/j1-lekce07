package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#kdyMaSvatek(String)} když se zadané jméno ve Svatky nachází
     */
    @Test
    void returnCorrectMonthDayIfNameIsPresent() {
        //Arrange
        Svatky svatky = new Svatky();
        //Act
        MonthDay vysledek = svatky.kdyMaSvatek("Nataša");
        //Assert
        assertEquals(MonthDay.of(5, 18), vysledek);
    }

    /**
     * Testuje metodu {@link Svatky#kdyMaSvatek(String)} když se zadané jméno ve Svatky nenachází
     */
    @Test
    void returnNullIfNameIsNotPresent() {
        //Arrange
        Svatky svatky = new Svatky();
        //Act
        MonthDay vysledek = svatky.kdyMaSvatek("Eva");
        //Assert
        assertNull(vysledek);
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)} když se zadané jméno ve Svatky nachází
     */
    @Test
    void isTrueIfGivenNameIsInTheMap() {
        //Arrange
        Svatky svatky = new Svatky();
        String jmeno = "Nataša";
        //Act
        boolean vysledek = svatky.jeVSeznamu(jmeno);
        //Assert
        assertTrue(vysledek);
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)} když se zadané jméno ve Svatky nenachází
     */
    @Test
    void isFalseIfGivenNameIsNotInTheMap() {
        //Arrange
        Svatky svatky = new Svatky();
        String jmeno = "Eva";
        //Act
        boolean vysledek = svatky.jeVSeznamu(jmeno);
        //Assert
        assertFalse(vysledek);
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void returnCorrectNumberOfNamesStoredInTheMap() {
        //Arrange
        Svatky svatky = new Svatky();
        int ocekavanyPocetJmen = 37;
        //Act
        int zjistenyPocetJmen = svatky.getPocetJmen();
        //Assert
        assertEquals(ocekavanyPocetJmen, zjistenyPocetJmen);
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        //TODO Zkontrolovat, že seznam jmen má správný počet položek.
        //Arrange
        Svatky svatky = new Svatky();
        int ocekavanyPocetPolozek = 37;
        //Act
        int zjistenyPocetPolozek = svatky.getSeznamJmen().size();
        //Assert
        assertEquals(ocekavanyPocetPolozek, zjistenyPocetPolozek);
    }

    /**
     * Testuje zda metoda {@link Svatky#pridatSvatek(String, MonthDay)} přidá svátek do seznamu
     */
    @Test
    void nameIsAddedtoTheMapUsingMonthDay() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        //Arrange
        Svatky svatky = new Svatky();
        String testovaciJmeno = "Pavlína";
        MonthDay testovaciSvatek = MonthDay.of(2, 20);
        //Act
        svatky.pridatSvatek(testovaciJmeno, testovaciSvatek);
        boolean vysledek = svatky.jeVSeznamu(testovaciJmeno);
        //Assert
        assertTrue(vysledek);
    }

    /**
     * Testuje zda metoda {@link Svatky#pridatSvatek(String, MonthDay)} uloží správné datum svátku do seznamu
     */
    @Test
    void newlyAddedNameHasCorrectNameDayUsingMonthDay() {
        //Arrange
        Svatky svatky = new Svatky();
        String testovaciJmeno = "Pavlína";
        MonthDay testovaciSvatek = MonthDay.of(2, 20);
        //Act
        svatky.pridatSvatek(testovaciJmeno, testovaciSvatek);
        MonthDay vyslednySvatek = svatky.kdyMaSvatek(testovaciJmeno);
        //Assert
        assertEquals(testovaciSvatek, vyslednySvatek);
    }

    /**
     * Testuje zda metoda {@link Svatky#pridatSvatek(String, int, int)} přidá svátek do seznamu
     */
   @Test
    void nameIsAddedtoTheMapUsingIntInt() {
        //Arrange
        Svatky svatky = new Svatky();
        String testovaciJmeno = "Pavlína";
        int testovaciMesicSvatku = 10;
        int testovaciDenSvatku = 29;
        //Act
        svatky.pridatSvatek(testovaciJmeno, testovaciDenSvatku, testovaciMesicSvatku);
        boolean vysledek = svatky.jeVSeznamu(testovaciJmeno);
        //Assert
        assertTrue(vysledek);
    }

    /**
     * Testuje zda metoda {@link Svatky#pridatSvatek(String, int, int)} uloží správné datum do seznamu
     */
    @Test
    void newlyAddedNameHasCorrectNameDayUsingIntInt() {
        //Arrange
        Svatky svatky = new Svatky();
        String testovaciJmeno = "Pavlína";
        int testovaciMesicSvatku = 10;
        int testovaciDenSvatku = 29;
        MonthDay ocekavanySvatek = MonthDay.of(testovaciMesicSvatku, testovaciDenSvatku);
        //Act
        svatky.pridatSvatek(testovaciJmeno, testovaciDenSvatku, testovaciMesicSvatku);
        MonthDay vyslednySvatek = svatky.kdyMaSvatek(testovaciJmeno);
        //Assert
        assertEquals(ocekavanySvatek, vyslednySvatek);
    }

    /**
     * Testuje zda metodu {@link Svatky#pridatSvatek(String, int, Month)} přidá svátek do seznamu
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        //TODO Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        //Arrange
        Svatky svatky = new Svatky();
        String testovaciJmeno = "Pavlína";
        Month testovaciMesicNarozeni = Month.DECEMBER;
        int testovaciDenNarozeni = 13;
        //Act
        svatky.pridatSvatek(testovaciJmeno, testovaciDenNarozeni, testovaciMesicNarozeni);
        boolean vysledek = svatky.jeVSeznamu(testovaciJmeno);
        //Assert
        assertTrue(vysledek);
    }


    @Test
    void renameAgain() {
        //Arrange
        Svatky svatky = new Svatky();
        String testovaciJmeno = "Pavlína";
        Month testovaciMesicNarozeni = Month.DECEMBER;
        int testovaciDenNarozeni = 13;
        MonthDay ocekavanyDenNarozeni = MonthDay.of(testovaciMesicNarozeni, testovaciDenNarozeni);
        //Act
        svatky.pridatSvatek(testovaciJmeno, testovaciDenNarozeni, testovaciMesicNarozeni);
        MonthDay vyslednyDenNarozeni = svatky.kdyMaSvatek(testovaciJmeno);
        //Assert
        assertEquals(ocekavanyDenNarozeni, vyslednyDenNarozeni);
    }


    /**
     * Testuje metodu {@link Svatky#smazatSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        //TODO Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
        //Arrange
        Svatky svatky = new Svatky();
        String vymazavaneJmeno = "Emil";
        int ocekevanyPocetZaznamu = 36;
        //Act
        svatky.smazatSvatek(vymazavaneJmeno);
        int skutecnyPocetZaznamu = svatky.getPocetJmen();
        //Assert
        assertEquals(ocekevanyPocetZaznamu, skutecnyPocetZaznamu);
    }
}

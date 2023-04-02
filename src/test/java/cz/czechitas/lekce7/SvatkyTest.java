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
    void returnsCorrectMonthDayIfNameIsPresentInTheMap() {
        //Arrange
        Svatky svatky = new Svatky();
        String jmeno = "Nataša";
        MonthDay ocekavanySvatek = MonthDay.of(5, 18);
        //Act
        MonthDay zjistenySvatek = svatky.kdyMaSvatek(jmeno);
        //Assert
        assertEquals(ocekavanySvatek, zjistenySvatek);
    }

    /**
     * Testuje metodu {@link Svatky#kdyMaSvatek(String)} když se zadané jméno ve Svatky nenachází
     */
    @Test
    void returnsNullIfNameIsNotPresentInTheMap() {
        //Arrange
        Svatky svatky = new Svatky();
        String jmeno = "Eva";
        //Act
        MonthDay vysledek = svatky.kdyMaSvatek(jmeno);
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
    void returnsCorrectNumberOfNamesDefaultlyStoredInTheMap() {
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
    void returnsCorrectlySizedSetOfStoredNames() {
        //Arrange
        Svatky svatky = new Svatky();
        int ocekavanyPocetPolozek = 37;
        //Act
        int zjistenyPocetPolozek = svatky.getSeznamJmen().size();
        //Assert
        assertEquals(ocekavanyPocetPolozek, zjistenyPocetPolozek);
    }

    /**
     * Testuje zda metoda {@link Svatky#pridatSvatek(String, MonthDay)} přidá svátek do mapy
     */
    @Test
    void nameIsAddedToTheMapUsingMonthDay() {
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
     * Testuje zda metoda {@link Svatky#pridatSvatek(String, MonthDay)} uloží správné datum svátku do mapy
     */
    @Test
    void newlyAddedNameHasCorrectNameDayUsingMonthDay() {
        //Arrange
        Svatky svatky = new Svatky();
        String testovaciJmeno = "Pavlína";
        MonthDay testovaciSvatek = MonthDay.of(2, 20);
        //Act
        svatky.pridatSvatek(testovaciJmeno, testovaciSvatek);
        MonthDay zjistenySvatek = svatky.kdyMaSvatek(testovaciJmeno);
        //Assert
        assertEquals(testovaciSvatek, zjistenySvatek);
    }

    /**
     * Testuje zda metoda {@link Svatky#pridatSvatek(String, int, int)} přidá svátek do mapy
     */
    @Test
    void nameIsAddedToTheMapUsingIntInt() {
        //Arrange
        Svatky svatky = new Svatky();
        String testovaciJmeno = "Evženie";
        int testovaciMesicSvatku = 10;
        int testovaciDenSvatku = 29;
        //Act
        svatky.pridatSvatek(testovaciJmeno, testovaciDenSvatku, testovaciMesicSvatku);
        boolean vysledek = svatky.jeVSeznamu(testovaciJmeno);
        //Assert
        assertTrue(vysledek);
    }

    /**
     * Testuje zda metoda {@link Svatky#pridatSvatek(String, int, int)} uloží správné datum do mapy
     */
    @Test
    void newlyAddedNameHasCorrectNameDayUsingIntInt() {
        //Arrange
        Svatky svatky = new Svatky();
        String testovaciJmeno = "Evženie";
        int testovaciMesicSvatku = 10;
        int testovaciDenSvatku = 29;
        MonthDay ocekavanySvatek = MonthDay.of(testovaciMesicSvatku, testovaciDenSvatku);
        //Act
        svatky.pridatSvatek(testovaciJmeno, testovaciDenSvatku, testovaciMesicSvatku);
        MonthDay zjistenySvatek = svatky.kdyMaSvatek(testovaciJmeno);
        //Assert
        assertEquals(ocekavanySvatek, zjistenySvatek);
    }

    /**
     * Testuje zda metoda {@link Svatky#pridatSvatek(String, int, Month)} přidá svátek do mapy
     */
    @Test
    void nameIsAddedToTheMapUsingIntMonth() {
        //Arrange
        Svatky svatky = new Svatky();
        String testovaciJmeno = "Rastislava";
        Month testovaciMesicSvatku = Month.DECEMBER;
        int testovaciDenSvatku = 13;
        //Act
        svatky.pridatSvatek(testovaciJmeno, testovaciDenSvatku, testovaciMesicSvatku);
        boolean vysledek = svatky.jeVSeznamu(testovaciJmeno);
        //Assert
        assertTrue(vysledek);
    }

    /**
     * Testuje zda metoda {@link Svatky#pridatSvatek(String, int, Month)} uloží správné datum do mapy
     */
    @Test
    void newlyAddedNameHasCorrectNameDayUsingIntMonth() {
        //Arrange
        Svatky svatky = new Svatky();
        String testovaciJmeno = "Rastislava";
        Month testovaciMesicSvatku = Month.DECEMBER;
        int testovaciDenSvatku = 13;
        MonthDay ocekavanySvatek = MonthDay.of(testovaciMesicSvatku, testovaciDenSvatku);
        //Act
        svatky.pridatSvatek(testovaciJmeno, testovaciDenSvatku, testovaciMesicSvatku);
        MonthDay zjistenySvatek = svatky.kdyMaSvatek(testovaciJmeno);
        //Assert
        assertEquals(ocekavanySvatek, zjistenySvatek);
    }

    /**
     * Testuje metodu {@link Svatky#smazatSvatek(String)}
     */
    @Test
    void numberOfStoredNamesIsReducedIfNameIsDeleted() {
        //Arrange
        Svatky svatky = new Svatky();
        String vymazavaneJmeno = "Emil";
        int ocekevanyPocetJmen = 36;
        //Act
        svatky.smazatSvatek(vymazavaneJmeno);
        int zjistenyPocetJmen = svatky.getPocetJmen();
        //Assert
        assertEquals(ocekevanyPocetJmen, zjistenyPocetJmen);
    }
}

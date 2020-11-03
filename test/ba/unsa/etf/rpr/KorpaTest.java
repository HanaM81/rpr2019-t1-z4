package ba.unsa.etf.rpr;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KorpaTest {
    private Korpa k;
    private Artikl a;

    @BeforeEach
    void setUp() {
        k=new Korpa();
        a=new Artikl("laptop",2500,"4321");
    }
    @Test
    void testDodavanjaArtiklaUkorpu() {
        boolean dodavanje=k.dodajArtikl(a);
        assertTrue(dodavanje);
    }

    @Test
    void testBrojaArtikalaUKorpi() {
        k.dodajArtikl(a);
        assertEquals(1,k.getBr());

    }
    @Test
    void testDodavanjaArtikalaUPunuKorpu() {
        for(int i =0; i<50; i++) {
            Artikl artikl= new Artikl("biciklo",3000,String.valueOf(i));
            k.dodajArtikl(artikl);
        }
        boolean dodavanje=k.dodajArtikl(new Artikl("torba",50,"6589"));
        assertAll("korpa puna",
                () -> assertFalse(dodavanje),
                () -> assertEquals(50,k.getBr())
                );

    }
    @Test
    void testIzbacivanjaArtiklaIzKorpe() {
        k.dodajArtikl(a);
        Artikl izbacen=k.izbaciArtiklSaKodom("4321");
        assertAll("izbacivanje",
                () -> assertEquals(a.getKod(),izbacen.getKod()),
                () -> assertEquals(a.getCijena(),izbacen.getCijena()),
                () -> assertEquals(0,k.getBr())
                );
    }



}

package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductoSubastadoTest {
    private ProductoSubastado tele;
    private Subastador a;
    private Subastador b;
    private Subastador c;

    @BeforeEach
    void setUp(){
        tele = new ProductoSubastado("Televisor");
        tele.reset();
        a = new Subastador("gonzager", tele);
        b = new Subastador("diazdan", tele);
        c = new Subastador("martomau", tele);
        a.reset();
        b.reset();
        c.reset();
        tele.agregarSubastador(a);//Gonzager
        tele.agregarSubastador(c);//Martomau
    }

    @Test
    @DisplayName("se verifica que los subastadores gonzager y martomau reciben correctamente la última oferta realizada.")
    void test1(){
        c.ofertar();//oferta 10
        assertEquals(10, a.getUltimaOferta());
        a.ofertar();//oferta +10 = 20
        assertEquals(20, c.getUltimaOferta());
        c.ofertar();//oferta +10 = 30
        assertEquals(30, a.getUltimaOferta());
        
    }

    @Test
    @DisplayName("se verifica que la última oferta registrada pertenece efectivamente al subastador martomau")
    void test2(){
        c.ofertar();
        a.ofertar();
        c.ofertar();
        assertEquals(tele.getUltimoOfertanteNombre(), c.getNombre());
    }

    @Test
    @DisplayName("al intentar agregar una nueva oferta de diazdan (que no está participando), se verifica que se lanza la excepción correspondiente.")
    void test3(){
        c.ofertar();
        a.ofertar();
        c.ofertar();
        DominioException exception = assertThrows(
                DominioException.class,
                () ->b.ofertar()
        );

        assertEquals("El subastador no participa en la subasta", exception.getMessage());
        
    }
    @Test
    @DisplayName("se verifica que la cantidad de ofertas registradas sea 3.")
    void test4(){
        c.ofertar();
        a.ofertar();
        c.ofertar();
        assertEquals(3, tele.getOfertasRecibidas().size());
    }

    @Test
    void seQuitaUnSubastador(){
        assertEquals(2,tele.getSubastadores().size());//Habia dos
        tele.quitarSubastador(a);// Se quita uno
        assertEquals(1,tele.getSubastadores().size());// queda solo uno
    }
}

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DenemeTest { // Tüm test işlemlerini JUnit4 ile yaptım.  
    
    public DenemeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        /*System.out.println("Cleaning the screen...");
        if (System.getProperty("os.name").startsWith("Window"))
            Runtime.getRuntime().exec("cls");
        else
            try {
                Runtime.getRuntime().exec("clear");
        } catch (IOException ex) {
            Logger.getLogger(DenemeTest.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    @After
    public void tearDown() { //Boştaki nesneler temizleniyor
        Runtime r=Runtime.getRuntime();
        System.out.println("Collecting the garbage....");
        r.gc();
    }

    @Test
    public void isBasDirektorNull(){ //Basdirektor nesnesinin yaratılıp yaratılamadığının testi
        BasDirektor basDirektor = BasDirektor.getBasDirektor();
        assertNotNull("Baş direktör yaratılamadı...", basDirektor);
    }

    @Test
    public void isBasDirektorSingle(){ //Basdirektor nesnesinin Singleton pattern gereği sadece bir tane yaratılıp yaratılmadığının testi
        BasDirektor basDirektor = BasDirektor.getBasDirektor();
        BasDirektor basDirektor2 = BasDirektor.getBasDirektor();
        assertEquals("failure - object are not equal", basDirektor, basDirektor2);
    }
    
}
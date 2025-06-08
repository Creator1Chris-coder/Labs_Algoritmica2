package Algo2_Lab_Work_Sem11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

class EsSerializable implements Serializable {
    private static final long serialVersionUID = 1L;
}

class Data implements Serializable {
    private static final long serialVersionUID = 1L;

    private String seraSerializado;
    private transient String noSeraSerializado1;
    private transient int noSeraSerializado2 = 2;
    private EsSerializable seraSerializado2 = new EsSerializable();

    public String getNoSeraSerializado1() {
        return noSeraSerializado1;
    }

    public int getNoSeraSerializado2() {
        return noSeraSerializado2;
    }

    public EsSerializable getSeraSerializado2() {
        return seraSerializado2;
    }

    public Data(String seraSerializado, String noSeraSerializado) {
        this.seraSerializado = seraSerializado;
        this.noSeraSerializado1 = noSeraSerializado;
        this.noSeraSerializado2 = 10;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Data otro = (Data) obj;
        return seraSerializado.equals(otro.seraSerializado);
    }
}

public class SerializableYNoSerializableTest {
    private File testFile = null;
    private final Data d1 = new Data("111", "AAA");

    @BeforeEach
    public void init() {
        try {
            testFile = File.createTempFile("abc", "txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void unSoloData() {
        try (
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(testFile));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(testFile))
        ) {
            out.writeObject(d1);
            Data d = (Data) in.readObject();
            assertEquals(d1, d);
            assertNull(d.getNoSeraSerializado1());
            assertEquals(0, d.getNoSeraSerializado2());
            assertNotNull(d.getSeraSerializado2());
        } catch (FileNotFoundException e) {
            fail("Fallo con archivo");
            e.printStackTrace();
        } catch (IOException e) {
            fail("Fallo con archivo");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            fail("Fallo con casting");
            e.printStackTrace();
        }
    }
}

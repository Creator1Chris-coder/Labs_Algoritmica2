package Algo2_Lab_Work_Sem11;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObjectStreamConceptoTest {
    private File testFile = null;
    private Object[] data;

    @BeforeEach
    public void init() {
        data = new Object[]{"Abc", 10, 2.5};
        try {
            testFile = File.createTempFile("abc", "txt");
        } catch (IOException e) {
            fail("No se pudo crear tempfile");
            e.printStackTrace();
        }
    }

    @Test
    public void comoUnSoloObject() {
        try (
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(testFile));
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(testFile))
        ) {
            out.writeObject(data);
            Object[] dataReaded = (Object[]) in.readObject();
            assertArrayEquals(data, dataReaded);
            for (Object object : dataReaded) {
                System.out.println(object);
            }
        } catch (Exception e) {
            fail("Excepción durante test: " + e.getClass().getSimpleName());
            e.printStackTrace();
        }
    }

    @Test
    public void objectElementoPorElemento() {
        try (
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(testFile))
        ) {
            for (Object object : data) {
                out.writeObject(object);
            }
        } catch (IOException e) {
            fail("IOException en escritura");
            e.printStackTrace();
        }

        try (
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(testFile))
        ) {
            for (int i = 0; i < data.length; i++) {
                Object dataReaded = in.readObject();
                assertEquals(data[i], dataReaded);
            }
        } catch (Exception e) {
            fail("IOException/ClassNotFoundException en lectura");
            e.printStackTrace();
        }
    }

    @Test
    public void stringYPrimitivosElementoPorElemento() throws ClassNotFoundException {
        int[] numeros1 = {1, 2, 3};
        int[] numeros2 = {4, 5};

        try (
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(testFile))
        ) {
            out.writeUTF((String) data[0]);
            out.writeInt((Integer) data[1]);
            out.writeDouble((Double) data[2]);
            out.writeObject(numeros1);
            out.writeObject(numeros2);
        } catch (IOException e) {
            fail("IOException en escritura");
            e.printStackTrace();
        }

        try (
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(testFile))
        ) {
            assertEquals(data[0], in.readUTF());
            assertEquals(((Integer) data[1]).intValue(), in.readInt());
            assertEquals(((Double) data[2]).doubleValue(), in.readDouble());
            assertArrayEquals(numeros1, (int[]) in.readObject());
            assertArrayEquals(numeros2, (int[]) in.readObject());

            for (int i : numeros2) {
                System.out.println(i);
            }
        } catch (IOException e) {
            fail("IOException en lectura");
            e.printStackTrace();
        }
    }

    @Test
    public void objetosDeUnListElementoPorElemento() throws ClassNotFoundException {
        List<Integer> lista = Arrays.asList(1, 2, 3);
        List<Integer> lista2 = new ArrayList<>();

        try (
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(testFile))
        ) {
            for (Integer numero : lista) {
                out.writeObject(numero);
            }
        } catch (IOException e) {
            fail("IOException en escritura");
            e.printStackTrace();
        }

        try (
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(testFile))
        ) {
            while (true) {
                try {
                    Integer o = (Integer) in.readObject();
                    lista2.add(o);
                } catch (EOFException e) {
                    break;
                }
            }
            assertEquals(lista, lista2);
        } catch (IOException e) {
            fail("IOException en lectura");
            e.printStackTrace();
        }
    }

    @Test
    public void siSeGrabaComoUnSoloObjetoTendriaQueLeerIgual() throws ClassNotFoundException {
        List<Integer> lista = Arrays.asList(1, 2, 3);
        List<Integer> lista2 = new ArrayList<>();

        try (
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(testFile))
        ) {
            out.writeObject(lista);
        } catch (IOException e) {
            fail("IOException en escritura");
            e.printStackTrace();
        }

        try (
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(testFile))
        ) {
            lista2 = (List<Integer>) in.readObject();
            assertEquals(lista, lista2);
        } catch (IOException e) {
            fail("IOException en lectura");
            e.printStackTrace();
        }
    }
}

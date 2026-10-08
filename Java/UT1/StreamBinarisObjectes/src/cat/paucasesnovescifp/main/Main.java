package cat.paucasesnovescifp.main;

import cat.paucasesnovescifp.dades.Empleat;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    static void main() {
        ArrayList<Empleat> llistaEmpleats = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("empleats.dat"))){
            while (true) {
                Empleat empleat = (Empleat) ois.readObject();
                llistaEmpleats.add(empleat);
            }
        } catch (EOFException e) {

        } catch (IOException | ClassNotFoundException e) {
            IO.println(e.getMessage());
        }


        Empleat marc = new Empleat(2841, "Marc", "Sánchez Alonso", LocalDate.now(), "Chapa y pintura", 23);
        llistaEmpleats.add(marc);

        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("llistaEmpleats.dat"))){
            ous.writeObject(llistaEmpleats);

        } catch (EOFException e) {
            IO.println(e.getMessage());
        } catch (IOException e) {
        IO.println(e.getMessage());
        }

    }
}

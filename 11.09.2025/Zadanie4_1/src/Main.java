
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
            File plik =  new File("C:\\Users\\student\\Desktop\\11.09.2025\\liczby.txt");
            Scanner czytnik = new Scanner(plik);
            String linia = "";
            int liczbaZnakow = 0;
            int licznik = 0;
            int pierwsza = 0;
            Boolean czyPierwsza = false;

            while (czytnik.hasNextLine()) {
                linia = czytnik.nextLine();
                liczbaZnakow = linia.length();
                if (linia.charAt(0) == linia.charAt(liczbaZnakow - 1)) {
                    licznik++;
                    if (!czyPierwsza) {
                        pierwsza = Integer.parseInt(linia);
                        czyPierwsza = true;
                    }
                }
            }
            System.out.print(licznik + " ");
            System.out.print(pierwsza);
        }
}
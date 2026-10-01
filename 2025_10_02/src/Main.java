import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main {

    public static int wynik(int[] wyniki){
        int punkty = 0;
        int ilosc_elementu = 0;
        for (int i = 1; i <= 6; i++){
            for (int j = 0; j < wyniki.length; j++){
                if (wyniki[j] == i){
                    ++ilosc_elementu;
                }
            }
            if (ilosc_elementu > 1){
                punkty = punkty + ilosc_elementu * i;

            }
            ilosc_elementu = 0;
        }

        return punkty;
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ilosc_rzutow;
        int rzut;
        String powtorz = "";
        while (true) {
            do {
                System.out.println("Ile kostek chcesz rzucić (3 - 10)");
                ilosc_rzutow = scanner.nextInt();
                System.out.println(ilosc_rzutow);
            }
            while ((ilosc_rzutow < 3 || ilosc_rzutow > 10));

            int[] wyniki = new int[ilosc_rzutow];

            for (int i = 0; i < ilosc_rzutow; i++) {
                rzut = (int) (Math.round(Math.random() * 5) + 1);
                System.out.println("kostka " + (i + 1) + ": " + rzut);
                wyniki[i] = rzut;
            }

            System.out.println("Ilość punktów: " + wynik(wyniki));

            System.out.println("Jeszcze raz? (t/n)");
            powtorz = scanner.next();
            if (powtorz.equals("n")) {
                break;
            }
        }
    }
}


import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File plik =  new File("C:\\Users\\student\\Desktop\\11.09.2025\\liczby.txt");
        Scanner czytnik = new Scanner(plik);
        int linia;
        int dzielnik = 2;
        List<Integer> noweDzielniki = new ArrayList<Integer>();
        List<Integer> stareDzielniki = new ArrayList<Integer>();

        while (czytnik.hasNextInt()) {
            linia = czytnik.nextInt();
            dzielnik = 2;
            while (linia > 1){
                if (linia % dzielnik == 0){
                    linia = linia/dzielnik;
                    noweDzielniki.add(dzielnik);
                }
                else{
                    dzielnik++;
                }
            }

            if (noweDzielniki.size() > stareDzielniki.size()){
                stareDzielniki.clear();
                stareDzielniki.addAll(noweDzielniki);
            }

            noweDzielniki.clear();


        }
        int liczba = 1;
        for (int x : stareDzielniki){
            liczba = liczba * x;
        }
        System.out.print(liczba + " " + stareDzielniki.size());
    }
}
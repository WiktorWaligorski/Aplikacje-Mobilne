import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException
    {
        System.out.println("\n4.1: ");
        cztery1();
        System.out.println("\n4.2a: ");
        cztery2();
        System.out.println("\n4.2b: ");
        cztery22();
        System.out.println("\n4.3a: ");
        cztery3();
        System.out.println("\n4.3b: ");
        cztery33();
    }

    public static void cztery1() throws FileNotFoundException
    {
        int ilosc = 0;
        Boolean firstOne = true;
        String first = "";
        File plik = new File("25.09\\Dane_2205\\liczby.txt");
        Scanner sc = new Scanner(plik);
        while (sc.hasNextLine()) {
            char[] liczba = sc.nextLine().toCharArray();
            if (liczba[0] == liczba[liczba.length - 1]) {
                if (firstOne) {
                    firstOne = false;
                    for (int i = 0; i < liczba.length; i++) {
                        first += liczba[i];
                    }
                }
                ilosc++;
            }
        }
        sc.close();
        System.out.println(ilosc);
        System.out.println(first);
    }

    public static void cztery2() throws FileNotFoundException
    {
        File plik = new File("25.09\\Dane_2205\\liczby.txt");
        Scanner sc = new Scanner(plik);
        int najwiecejdzielniki = 0;
        int dzielniki = 0;
        int ogliczba = 0;
        int najliczba = 0;
        while (sc.hasNextLine())
        {
            int liczba = Integer.parseInt(sc.nextLine());
            ogliczba = liczba;

            for (int i = 2; liczba > 2; i++)
            {
                if(liczba%i == 0 || liczba == i)
                {
                    dzielniki++;
                    liczba = liczba/i;
                    i = 1;
                }

                if(dzielniki > najwiecejdzielniki)
                {
                    najwiecejdzielniki = dzielniki;
                    najliczba = ogliczba;
                }

                //System.out.println(liczba);
            }
            dzielniki = 0;
        }
        System.out.println(najliczba);
        System.out.println(najwiecejdzielniki);
    }

    public static void cztery22() throws FileNotFoundException
    {
        File plik = new File("25.09\\Dane_2205\\liczby.txt");
        Scanner sc = new Scanner(plik);
        int najwiecejdzielniki = 0;
        int ogliczba = 0;
        int najliczba = 0;
        while (sc.hasNextLine())
        {
            int liczba = Integer.parseInt(sc.nextLine());
            ArrayList<Integer> roznedzielniki = new ArrayList<>();
            ogliczba = liczba;

            for (int i = 2; liczba > 2; i++)
            {
                if(liczba%i == 0)
                {
                    if(!roznedzielniki.contains(i))
                    {
                        roznedzielniki.add(i);
                    }
                    liczba = liczba/i;
                }
            }
            if(roznedzielniki.size() > najwiecejdzielniki)
            {
                najwiecejdzielniki = roznedzielniki.size();
                najliczba = ogliczba;
            }
        }
        System.out.println(najliczba);
        System.out.println(najwiecejdzielniki);
    }

    public static void cztery3() throws IOException
    {
        File plik = new File("25.09\\Dane_2205\\liczby.txt");
        Scanner sc = new Scanner(plik);
        ArrayList<Integer> liczby = new ArrayList<>();
        int iletrojek = 0;
        File nowyP = new File("25.09\\Dane_2205\\trojki.txt");
        FileWriter czystka = new FileWriter("25.09\\Dane_2205\\trojki.txt", false);
        czystka.write("");
        czystka.close();

        while(sc.hasNextLine())
        {
            int liczba = Integer.parseInt(sc.nextLine());
            liczby.add(liczba);
        }
        for(int i = 0; i < liczby.size(); i++)
        {
            for(int j = 0; j < liczby.size(); j++)
            {
                for(int k = 0; k < liczby.size(); k++)
                {
                    if(liczby.get(i) != liczby.get(j) && liczby.get(i) != liczby.get(k) && liczby.get(j) != liczby.get(k))
                    {
                        if(liczby.get(k) % liczby.get(j) == 0 && liczby.get(j) % liczby.get(i) == 0)
                        {
                            FileWriter pisacz = new FileWriter("25.09\\Dane_2205\\trojki.txt", true);
                            pisacz.write(liczby.get(i) + " " + liczby.get(j) + " " + liczby.get(k) + "\n");
                            pisacz.close();
                            iletrojek++;
                        }
                    }
                }
            }
        }
        System.out.println(iletrojek);
    }

    public static void cztery33() throws IOException
    {
        File plik = new File("25.09\\Dane_2205\\liczby.txt");
        Scanner sc = new Scanner(plik);
        ArrayList<Integer> liczby = new ArrayList<>();
        int ilepiatek = 0;

        while(sc.hasNextLine())
        {
            int liczba = Integer.parseInt(sc.nextLine());
            liczby.add(liczba);
        }
        for(int i = 0; i < liczby.size(); i++)
        {
            for(int j = 0; j < liczby.size(); j++)
            {
                for(int k = 0; k < liczby.size(); k++)
                {
                    for(int l = 0; l < liczby.size(); l++)
                    {
                        for(int m = 0; m < liczby.size(); m++)
                        {
                            if(liczby.get(i) != liczby.get(j) && liczby.get(i) != liczby.get(k) && liczby.get(i) != liczby.get(l) && liczby.get(i) != liczby.get(m) &&
                                    liczby.get(j) != liczby.get(k) && liczby.get(j) != liczby.get(l) && liczby.get(j) != liczby.get(m)
                                    && liczby.get(k) != liczby.get(l) && liczby.get(k) != liczby.get(m)
                                    && liczby.get(l) != liczby.get(m))
                            {
                                if(liczby.get(m) % liczby.get(l) == 0 && liczby.get(l) % liczby.get(k) == 0 && liczby.get(k) % liczby.get(j) == 0 && liczby.get(j) % liczby.get(i) == 0)
                                {
                                    ilepiatek++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ilepiatek);
    }
}
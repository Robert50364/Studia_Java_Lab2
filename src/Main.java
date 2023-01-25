import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        //Skaner dla wczytywanie nicku gracza
        Scanner scan = new Scanner(System.in);

        System.out.print("Witaj wpisz swoj nick: ");
        String player = scan.nextLine();

        System.out.print("Podaj ile prób chcerz mieć: ");
        int proby = scan.nextInt();

        new Window(player, proby);
    }
}
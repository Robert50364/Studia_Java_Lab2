import java.util.Random;

public class GameControler
{
    private int points;
    private int trys;
    private int nubmerOfTrys;

    private int los = 0;

    /**
     * Funkcja dodaje punkty w zależności co wylosowaliśmy i jaki przycisk nadusiliśmy
     * @param button Numer przycisku ktróry wduszamy
     */
    public void sprawdzPrzycisk(int button)
    {
        losuj();
        if(button == 0)
        {
            if(los == 1)
            {
                points++;
            }
        }else{
            if(los == 0)
            {
                points++;
            }
        }
        addTry();
    }

    /**
     * Funkcja ta losuje nam liczbę
     */
    private void losuj()
    {
        los = new Random().nextInt(2);
    }

    /**
     * Ustawia maksymalną ilość prób do wykorzystania podczas gry
     * @param x Liczba maksymalnej ilości prób
     */
    public void setMaxTrys(int x)
    {
        nubmerOfTrys = x;
    }

    /**
     * Dodaje kolejną próbe do licznika prób w grze
     */
    private void addTry()
    {
        trys++;
    }

    /**
     * Funckja ta sprawdza czy wykorzystaliśmy wszystkie próby.
     * @return zwraca 1 dla końca gry i 0 dla gry która dalej się toczy.
     */
    public int checkTrys()
    {
        if(trys >= nubmerOfTrys)
        {
            return 1;
        }else {
            return 0;
        }
    }


    /**
     * Funckja ta zeruje liczbę punktów i prób
     */
    public void restart()
    {
        trys=0;
        points = 0;
    }

    /**
     * Zwraca liczbę wykożystanych już prób w grze.
     * @return
     */
    public int zwrocProby()
    {
        return trys;
    }

    /**
     * Funkcja ta zwaraca ilość puntków jaką zdobyliśmy
     * @return
     */
    public int zwrocPunkty()
    {
        return points;
    }

}

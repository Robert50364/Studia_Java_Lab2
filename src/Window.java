import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame
{

    GameControler gc = new GameControler();
    JButton btn=new JButton();
    JButton btn2=new JButton();
    JLabel tyt = new JLabel();
    JTextArea tx2 = new JTextArea();

    /**
     * Funckja tworzy i ustawia odpowiednie teksty podczas startu gry od nowa
     * @param first parametr mówi nam czy gra jest włączana po raz pierwszy, 0 oznacza ze gra jest po restarcie
     */
    private void Start(int first)
    {
        if(first == 1)
        {
            add(btn);
            add(btn2);
            add(tyt);
            add(tx2);
        }
        btn.setText("First choice");
        btn2.setText("Second choice");
        tyt.setText("Bomba czy Diament?");
        tx2.setText("Tutaj pojawią się zdobyte\n przez Ciebie punkty");
    }

    /**
     * Funckja ta ustawia tekst na odpowiedni dla skończonej gry
     */
    private void EndGame()
    {
        tyt.setText("Game Over");
        btn.setText("Restart");
        btn2.setText("Gry");
    }

    Window(String tekst, int proby)
    {
        String t = tekst;
        gc.setMaxTrys(proby);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Konfiguracja okna
        setSize(400, 400);
        setLayout(new GridLayout(2, 2, 10, 10));
        setTitle("Witaj "+t+" Ilość prób: "+proby);

        //Przyciski i pola
        Start(1);

        //Konfiguracja przycisku (dzialanie)
        btn.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(gc.checkTrys()==1)
                {
                    gc.restart();
                    Start(0);
                }else{
                    gc.sprawdzPrzycisk(0);
                    tyt.setText("Próba: " + gc.zwrocProby());
                    tx2.setText("Ilość punktów: "+ gc.zwrocPunkty());
                    if(gc.checkTrys()==1)
                    {
                        EndGame();
                    }
                }
            }
        });

        btn2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(gc.checkTrys()==1)
                {
                    gc.restart();
                    Start(0);
                }else {
                    gc.sprawdzPrzycisk(1);
                    tyt.setText("Próba: " + gc.zwrocProby());
                    tx2.setText("Ilość punktów: "+ gc.zwrocPunkty());
                    if(gc.checkTrys()==1)
                    {
                        EndGame();
                    }
                }
            }
        });

        setVisible(true);
    }
}
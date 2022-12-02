import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    Main(){
        JFrame pg=new JFrame("Tic Tac Toe");
        JLabel tit=new JLabel("Tic Tac Toe");
        JButton next=new JButton("NEXT");
        next.setFont(new Font("Poppins",Font.BOLD,18));
        next.setBounds(150,190,80,40);
        next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Game();
                pg.dispose();
            }
        });
        pg.add(next);
        tit.setFont(new Font("Poppins",Font.BOLD,20));
        tit.setForeground(Color.blue);
        tit.setBounds(130,80,250,50);
        pg.add(tit);
        pg.setResizable(false);
        pg.setSize(400,400);
        pg.getContentPane().setBackground(Color.PINK);
        pg.setLayout(null);
        pg.setLocationRelativeTo(null);
        pg.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pg.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}

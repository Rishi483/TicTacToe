
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    protected JButton[] btn=new JButton[9];
    JLabel t=new JLabel("Player 1's Turn");
    int[] logic = {0};
    public Game(){
        JFrame m=new JFrame("Tic Tac Toe");
        m.setResizable(false);
        m.setSize(600,655);
        JPanel top=new JPanel();
        top.setBounds(0,0,600,55);
        top.setBackground(new Color(40,40,40));
        t.setBounds(202,10,205,32);
        t.setFont(new Font("Poppins",Font.BOLD,25));
        t.setForeground(Color.WHITE);
        JButton reset=new JButton("RESET");
        reset.setFont(new Font("Poppins",Font.BOLD,20));
        reset.setForeground(Color.white);
        reset.setBackground(Color.red);
        reset.setOpaque(true);
        reset.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        reset.setBounds(470,6,130,43);
        reset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //reset actionlistner
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Game();
                m.dispose();
            }
        });
        m.add(reset);
        m.add(t);
        m.add(top);


        //grid part

        JPanel grid=new JPanel();
        grid.setBounds(0,55,600,600);
        grid.setBackground(Color.GRAY);
        for(int i=0;i<9;i++){
            btn[i]=new JButton();
            int x;
            if(i%3==0){
                x=0;
            }
            else if(i%3==1){
                x=200;
            }
            else{
                x=400;
            }
            btn[i].setBounds(x,(i/3)*200+55,200,200);
            btn[i].setBorder(BorderFactory.createEtchedBorder());
            btn[i].setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            m.add(btn[i]);
        }
        for(int i=0;i<9;i++){
            int finalI=i;
            btn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(logic[0] %2==0 && btn[finalI].getText()!="O" && btn[finalI].getText()!="X"){
                        btn[finalI].setText("O");
                        btn[finalI].setFont(new Font("Poppins",Font.ITALIC,60));
                        btn[finalI].setForeground(Color.blue);
                        t.setText("Player 2's Turn");
                        check();
                        logic[0]++;
                    }
                    else if(btn[finalI].getText()!="O" && btn[finalI].getText()!="X"){
                        btn[finalI].setText("X");
                        btn[finalI].setFont(new Font("Poppins",Font.ITALIC,60));
                        btn[finalI].setForeground(Color.red);
                        t.setText("Player 1's Turn");
                        check();
                        logic[0]++;
                    }

                }
            });
        }
        m.add(grid);
        m.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        m.setLayout(null);
        m.setLocationRelativeTo(null);
        m.setVisible(true);
    }
    void check(){
        if(logic[0]==8){
            t.setText("Game Draw");
        }
        String[] one={"678","012","345","048","246","036","147","258"};
        for(int i=0;i<8;i++){
            int o1=(one[i].charAt(0)-'0');
            int o2=(one[i].charAt(1)-'0');
            int o3=(one[i].charAt(2)-'0');

            if(btn[o1].getText()=="O" && btn[o2].getText()=="O" && btn[o3].getText()=="O"){
                t.setText("Player 1 Wins");
                btn[o1].setBackground(Color.green);
                btn[o1].setOpaque(true);
                btn[o2].setBackground(Color.green);
                btn[o2].setOpaque(true);
                btn[o3].setBackground(Color.green);
                btn[o3].setOpaque(true);
                for(int j=0;j<9;j++){
                    if(j!=o1 && j!=o2 && j!=o3){
                        if(btn[j].getText()!="O" && btn[j].getText()!="X"){
                            btn[j].setEnabled(false);
                        }
                    }
                }
            }
            else if(btn[o1].getText()=="X" && btn[o2].getText()=="X" && btn[o3].getText()=="X"){
                t.setText("Player 2 Wins");
                btn[o1].setBackground(Color.green);
                btn[o1].setOpaque(true);
                btn[o2].setBackground(Color.green);
                btn[o2].setOpaque(true);
                btn[o3].setBackground(Color.green);
                btn[o3].setOpaque(true);
                for(int j=0;j<9;j++){
                    if(j!=o1 && j!=o2 && j!=o3){
                        if(btn[j].getText()!="O" && btn[j].getText()!="X"){
                            btn[j].setEnabled(false);
                        }
                    }
                }
            }

        }
    }
    public static void main(String[] args) {
        new Game();
    }
}

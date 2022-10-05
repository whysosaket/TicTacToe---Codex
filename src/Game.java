import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {
    JFrame frame ;
    JButton buttons[][]=new JButton[3][3];
    JButton src = new JButton();

    JMenuBar mb = new JMenuBar();
    JMenu file;//rs,ex;
    JMenuItem restart, exit;

    // Loading Images
    ImageIcon xi = new ImageIcon("blue x.png");
    ImageIcon oi = new ImageIcon("red o.png");

    int x,y;
    int input=2;

    Font font;
    Game()
    {

        frame=new JFrame("Tic Tac Toe");

        file = new JMenu("File");

        restart = new JMenuItem ("Restart");
        restart.addActionListener(this);
        file.add(restart);
        exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        file.add(exit);
        mb.add(file);
        frame.setJMenuBar(mb);



        //b[row][column]

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                buttons[i][j] = new JButton();
                frame.add(buttons[i][j]);
                buttons[i][j].setText("");
                buttons[i][j].setBackground(Color.gray);
                /*if((j+1)%2==0 && (i+1)%2==0)
                    b[i][j].setBackground(Color.gray);
                else if((j+1)%2!=0 && (i+1)%2!=0)
                    b[i][j].setBackground(Color.gray);
                else
                    b[i][j].setBackground(Color.white);*/

                buttons[i][j].addActionListener(this);

            }

        }

        frame.setLayout(new GridLayout(3,3,5,5));
        //setting grid layout of 8 rows and 8 columns

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        font = new Font ("Courier",Font.BOLD,00);
    }


    public static void main(String[] args)
    {
        new Game();
    }

    String r = null;
    int cnt=0;

    public void actionPerformed(ActionEvent e)
    {
        //f.setDefaultCloseOperation(popup());
        if(e.getSource() == restart)restart();
        if(e.getSource() == exit)System.exit(0);

        //if((int) e.getKeyCode()==27){restart();}
        if(e.getSource() instanceof JButton)
            src = (JButton)e.getSource();

        if(src.getText()!=""){JOptionPane.showMessageDialog(frame,"invalid move"); }
        else
        {
            if(cnt%2!=0)
            {
                src.setText("o");
                src.setIcon(oi);
                src.setFont(font);

            }
            if(cnt%2==0)
            {
                src.setText("x");
                src.setIcon(xi);
                src.setFont(font);

            }
            cnt++;


            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(e.getSource()== buttons[i][j])
                    {x=i;y=j;}
                }
            }
            if(buttons[0][0].getText()== buttons[1][1].getText()&& buttons[0][0].getText()== buttons[2][2].getText()&& buttons[0][0].getText()!="")
            {
                r= buttons[0][0].getText();endAction(x,y,cnt);
            }
            else if(buttons[0][0].getText()== buttons[0][1].getText()&& buttons[0][2].getText()== buttons[0][0].getText()&& buttons[0][0].getText()!="")
            {
                r= buttons[0][0].getText();endAction(x,y,cnt);
            }
            else if(buttons[0][0].getText()== buttons[1][0].getText()&& buttons[2][0].getText()== buttons[0][0].getText()&& buttons[0][0].getText()!="")
            {
                r= buttons[0][0].getText();endAction(x,y,cnt);
            }
            else if(buttons[1][0].getText()== buttons[1][1].getText()&& buttons[1][2].getText()== buttons[1][0].getText()&& buttons[1][0].getText()!="")
            {
                r= buttons[1][0].getText();endAction(x,y,cnt);
            }
            else if(buttons[0][1].getText()== buttons[1][1].getText()&& buttons[2][1].getText()== buttons[1][1].getText()&& buttons[1][1].getText()!="")
            {
                r= buttons[0][1].getText();endAction(x,y,cnt);
            }

            if(buttons[2][2].getText()== buttons[1][2].getText()&& buttons[2][2].getText()== buttons[0][2].getText()&& buttons[0][2].getText()!="")
            {
                r= buttons[2][2].getText();endAction(x,y,cnt);
            }
            else if(buttons[2][2].getText()== buttons[2][1].getText()&& buttons[2][2].getText()== buttons[2][0].getText()&& buttons[2][0].getText()!="")
            {
                r= buttons[2][2].getText(); endAction(x,y,cnt);
            }
            else if(buttons[2][0].getText()== buttons[1][1].getText()&& buttons[1][1].getText()== buttons[0][2].getText()&& buttons[0][2].getText()!="")
            {
                r= buttons[2][0].getText(); endAction(x,y,cnt);
            }
            else if(cnt==9)
            {
                //x=-1;y=-1;
                r="d";endAction(x,y,cnt);
                //endAction(x,y,cnt);
            }
            // if(r=="x"){end(r);}
            // else if(r=="0"){end(r);}
            // else if(r=="d"){end(r);}
        }
    }
    public void restart()
    {
        frame.dispose();
        new Game();
    }

    public void endAction(int x1,int y1,int cnt1)
    {


        input = JOptionPane.showConfirmDialog(frame, buttons[x1][y1].getText()+" won \n want to restart?");
        if(input == 1)System.exit(0);
        else if(input == 0)restart();


    }
    public void draw()
    {
        input = JOptionPane.showConfirmDialog(frame,"draw\n want to restart ?");
        if(input == 1)System.exit(0);
        else if(input == 0)restart();
        //input = 2;
    }
}

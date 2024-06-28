package src.minesweeper;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameWin extends JFrame{
    
    int winWidth = GameUtil.winWidth;
    int winHeight = GameUtil.winHeight;

    Image offImage = null;
    MapBot mapBot = new MapBot();
    MapTop mapTop = new MapTop();
    boolean begin = false;

    void launch()
    {
        this.setVisible(true);
        this.setTitle("minesweeper");
        this.setLocationRelativeTo(null);
            this.setSize(GameUtil.winWidth, GameUtil.winHeight);
            this.setLocationRelativeTo(null);
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    super.mouseClicked(e);
                    switch (GameUtil.state) {
                        case 0:
                            if (e.getButton() == 1)
                            {
                                GameUtil.left = true;
                                GameUtil.mousex = e.getX();
                                GameUtil.mousey = e.getY();
                            }
                            if (e.getButton() == 3)
                            {
                                GameUtil.right = true;
                                GameUtil.mousex = e.getX();
                                GameUtil.mousey = e.getY();
                            }
                        case 1:
                        case 2:
                            if (e.getButton() == 1)
                            {
                                if (e.getX() > winWidth / 2 - 15 && e.getX() < winWidth / 2 + 15
                                && e.getY() > 35 && e.getY() < 65)
                                {
                                    mapBot.reGame();
                                    mapTop.reGame();
                                    GameUtil.state = 0;
                                }
                            }
                            break;
                    }
                }
            });
            while (true)
            {
                repaint();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    


    @Override
    public void paint(Graphics g)
    {
    
            offImage = this.createImage(winWidth, winHeight);
            Graphics gOff = offImage.getGraphics();
            mapBot.paintSelf(gOff);
            mapTop.paintSelf(gOff);
            g.drawImage(offImage, 0, 0, this);
        
    }

    public static void main(String[] args)
    {
        GameWin gameWin = new GameWin();
        gameWin.launch();
    }
}

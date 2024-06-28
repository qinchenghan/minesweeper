package src.minesweeper;
import java.awt.Color;
import java.awt.Graphics;

public class GameSelect {
    void difficulty(int level)
    {
        switch (level) {
            case 1:
                GameUtil.level = 1;
                GameUtil.num_x = 9;
                GameUtil.num_y = 9;
                GameUtil.num_mines = 10;
                break;
            case 2:
                GameUtil.level = 2;
                GameUtil.num_x = 16;
                GameUtil.num_y = 16;
                GameUtil.num_mines = 40;
                break;
            case 3:
                GameUtil.level = 3;
                GameUtil.num_x = 30;
                GameUtil.num_y = 16;
                GameUtil.num_mines = 99;
                break;
        
            default:
                break;
        }
    }

    boolean difficulty()
    {
        if (GameUtil.mousex > 100 && GameUtil.mousex < 400)
        {
            if (GameUtil.mousey > 50 && GameUtil.mousey < 150)
            {
                GameUtil.level = 1;
                GameUtil.state = 0;
                return true;
            }
            if (GameUtil.mousey > 200 && GameUtil.mousey < 300)
            {
                GameUtil.level = 2;
                GameUtil.state = 0;
                return true;
            }
            if (GameUtil.mousey > 350 && GameUtil.mousey < 450)
            {
                GameUtil.level = 3;
                GameUtil.state = 0;
                return true;
            }
        }
        return false;
    }

    void paintSelf(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.drawRect(100, 50, 300, 100);
        g.drawRect(100, 200, 300, 100);
        g.drawRect(100, 350, 300, 100);
        g.setColor(Color.BLACK);
        g.drawString("BEGINNER", 200, 50);
        g.drawString("INTERMEDIATE", 200, 200);
        g.drawString("EXPERT", 200, 350);
        
    }
}

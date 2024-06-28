package src.minesweeper;
import java.awt.*;

public class MapBot {
    
    int winWidth = GameUtil.winWidth;
    int winHeight = GameUtil.winHeight;
    BotMine botMine = new BotMine();
    {
        botMine.newMine();
    }

    void reGame()
    {
        GameUtil.dataBot = new int[GameUtil.num_x + 2][GameUtil.num_y + 2];
        botMine.newMine();
    }

    void paintSelf(Graphics g)
    {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, winWidth, winHeight);
        g.setColor(Color.RED);
        for (int i = 1; i <= GameUtil.num_x; i++)
        {
            for (int j = 1; j <= GameUtil.num_y; j++)
            {
                int x = i * GameUtil.block;
                int y = GameUtil.top - GameUtil.edge + j * GameUtil.block;
                int data = GameUtil.dataBot[i][j];
                if (data == -1)
                {
                    g.drawImage(GameUtil.mine, x, y, null);
                }
                else if (data >= 0 && data <= 8)
                {
                    g.drawImage(GameUtil.nums[data], x, y, null);
                }
            }
        }
        int numFlag = 0;
        for (int i = 1; i <= GameUtil.num_x; i++)
        {
            for (int j = 1; j <= GameUtil.num_y; j++)
            {
                if (GameUtil.dataTop[i][j] == 1)
                {
                    numFlag++;
                }
            }
        }
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(Integer.toString(GameUtil.num_mines - numFlag), GameUtil.edge, 65);

        switch (GameUtil.state) {
            case 0:
                g.drawImage(GameUtil.smile, winWidth / 2 - 15, 35, null);
                break;
            case 1:
                g.drawImage(GameUtil.vic, winWidth / 2 - 15, 35, null);
                break;
            case 2:
                g.drawImage(GameUtil.sad, winWidth / 2 - 15, 35, null);
        }
    }
}

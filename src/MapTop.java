package src;
import java.awt.*;

public class MapTop {
    
    int winWidth = GameUtil.winWidth;
    int winHeight = GameUtil.winHeight;
    int tempx;
    int tempy;

    void reGame()
    {
        GameUtil.dataTop = new int[GameUtil.num_x + 2][GameUtil.num_y + 2];
        
    }

    void logic()
    {
        tempx = -1;
        tempy = -1;
        int mousex = GameUtil.mousex;
        int mousey = GameUtil.mousey;
        if (mousex > GameUtil.edge && mousex < GameUtil.winWidth - GameUtil.edge && mousey > GameUtil.top && mousey < GameUtil.winHeight - GameUtil.edge)
        {
            tempx = (int) Math.ceil((mousex - GameUtil.edge) / GameUtil.block) + 1;
            tempy = (int) Math.ceil((mousey - GameUtil.top) / GameUtil.block) + 1;
            if (GameUtil.left)
            {
                if (GameUtil.dataTop[tempx][tempy] == 0)
                {
                    GameUtil.dataTop[tempx][tempy] = -1;
                }
                if (GameUtil.dataBot[tempx][tempy] == 0)
                {
                    openSpace(tempx, tempy);
                }
                GameUtil.left = false;
            }
            else if (GameUtil.right)
            {
                if (GameUtil.dataTop[tempx][tempy] == 0)
                {
                    GameUtil.dataTop[tempx][tempy] = 1;
                    GameUtil.num_flag++;
                }
                else if (GameUtil.dataTop[tempx][tempy] == 1)
                {
                    GameUtil.dataTop[tempx][tempy] = 0;
                    GameUtil.num_flag--;
                }
                else if (GameUtil.dataTop[tempx][tempy] == -1)
                {
                    if (GameUtil.dataBot[tempx][tempy] > 0 && GameUtil.dataBot[tempx][tempy] <= 8)
                    {
                        openNum(tempx, tempy);
                    }
                }
                GameUtil.right = false;
            }
        }
        boom();
        win();
        GameUtil.left = false;
        GameUtil.right = false;
    }

    void seeMine()
    {
        for (int i = 1; i <= GameUtil.num_x; i++)
        {
            for (int j = 1; j <= GameUtil.num_y; j++)
            {
                if (GameUtil.dataBot[i][j] == -1 && GameUtil.dataTop[i][j] != 1)
                {
                    GameUtil.dataTop[i][j] = -1;
                }
                else if (GameUtil.dataBot[i][j] == -1 && GameUtil.dataTop[i][j] == -1)
                {
                    GameUtil.dataTop[i][j] = 2;
                }
                if (GameUtil.dataBot[i][j] != -1 && GameUtil.dataTop[i][j] == 1)
                {
                    GameUtil.dataTop[i][j] = 3;
                }
            }
        }
    }

    void openNum(int x, int y)
    {
        if (GameUtil.dataBot[x][y] > 0 && GameUtil.dataBot[x][y] <= 8)
        {
            int count = 0;
            for (int i = x - 1; i <= x + 1; i++)
            {
                for (int j = y - 1; j <= y + 1; j++)
                {
                    if (GameUtil.dataTop[i][j] == 1)
                    {
                        count++;
                    }
                }
            }
            if (count == GameUtil.dataBot[x][y])
            {
                for (int i = x - 1; i <= x + 1; i++)
                {
                    for (int j = y - 1; j <= y + 1; j++)
                    {
                        if (GameUtil.dataTop[i][j] == 0)
                        {
                            GameUtil.dataTop[i][j] = -1;
                        }
                        if (GameUtil.dataBot[i][j] == 0)
                        {
                            if (i >= 1 && i <= GameUtil.num_x && j >= 1 && j <= GameUtil.num_y)
                            {
                                openSpace(i, j);
                            }
                        }
                    }
                }
            }
        }
    }

    boolean win()
    {
        for (int i = 1; i <= GameUtil.num_x; i++)
        {
            for (int j = 1; j <= GameUtil.num_y; j++)
            {
                if (GameUtil.dataBot[i][j] != -1)
                {
                    if (GameUtil.dataTop[i][j] != -1)
                    {
                        return false;
                    }
                }
            }
        }
        System.out.println("Victory!");
        GameUtil.state = 1;
        for (int i = 1; i <= GameUtil.num_x; i++)
        {
            for (int j = 1; j <= GameUtil.num_y; j++)
            {
                if (GameUtil.dataTop[i][j] == 0)
                {
                    GameUtil.dataTop[i][j] = 1;
                }
            }
        }
        return true;
    }

    boolean boom()
    {
        for (int i = 1; i <= GameUtil.num_x; i++)
        {
            for (int j = 1; j <= GameUtil.num_y; j++)
            {
                if (GameUtil.dataBot[i][j] == -1 && GameUtil.dataTop[i][j] == -1)
                {
                    System.out.println("Game Over!");
                    GameUtil.state = 2;
                    seeMine();
                    return true; 
                }
            }
        }
        return false;
    }

    void openSpace(int x, int y)
    {
        if (GameUtil.dataBot[x][y] == 0 && GameUtil.dataTop[x][y] == -1)
        {
            for (int i = x - 1; i <= x + 1; i++)
            {
                for (int j = y - 1; j <= y + 1; j++)
                {
                    if (GameUtil.dataTop[i][j] == 0)
                    {
                        if (GameUtil.dataTop[i][j] != -1)
                        {
                            GameUtil.dataTop[i][j] = -1;
                        }
                        if (GameUtil.dataBot[i][j] == 0 && GameUtil.dataTop[i][j] == -1)
                        {
                            if (i >= 1 && i <= GameUtil.num_x && j >= 1 && j <= GameUtil.num_y)
                            {
                                openSpace(i, j);
                            }
                        }
                    }
                }
            }
        }
    }

    void paintSelf(Graphics g)
    {
        logic();
        for (int i = 1; i <= GameUtil.num_x; i++)
        {
            for (int j = 1; j <= GameUtil.num_y; j++)
            {
                int x = i * GameUtil.block;
                int y = GameUtil.top - GameUtil.edge + j * GameUtil.block;
                int data = GameUtil.dataTop[i][j];
                if (data == 0)
                {
                    g.drawImage(GameUtil.unexplored, x, y, null);
                }
                else if (data == 1)
                {
                    g.drawImage(GameUtil.flag, x, y, null);
                }
                else if (data == 2)
                {
                    g.drawImage(GameUtil.explode, x, y, null);
                }
                else if (data == 3)
                {
                    g.drawImage(GameUtil.wrong, x, y, null);
                }
            }
        }
    }
}

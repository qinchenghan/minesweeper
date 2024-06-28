package src;
import java.util.*;

public class BotMine {

    int winWidth = GameUtil.winWidth;
    int winHeight = GameUtil.winHeight;

    void newMine()
    {
        Set<Integer> coor_set = new HashSet<>();
        Random rand = new Random();
        while (coor_set.size() < GameUtil.num_mines)
        {
            int x = rand.nextInt(GameUtil.num_x) + 1;
            int y = rand.nextInt(GameUtil.num_y) + 1;
            coor_set.add(x * 100 + y);
        }
        for (int coor : coor_set)
        {
            int x = coor / 100;
            int y = coor % 100;
            GameUtil.dataBot[x][y] = -1;
        }
        for (int coor : coor_set)
        {
            int x = coor / 100;
            int y = coor % 100;
            for (int i = x - 1; i <= x + 1; i++)
            {
                for (int j = y - 1; j <= y + 1; j++)
                {
                    if (GameUtil.dataBot[i][j] != -1)
                    {
                        GameUtil.dataBot[i][j] += 1;
                    }
                }
            }
        }
    }
}

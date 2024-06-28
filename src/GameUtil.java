package src;
import java.awt.*;

public class GameUtil {
    
    //window
    static int edge = 30;
    static int block = 30;
    static int top = 70;
    static int num_x = 30;
    static int num_y = 16;
    static int num_mines = 99;
    static int num_flag = 0;
    static int mousex;
    static int mousey;
    static boolean left = false;
    static boolean right = false;
    static int state = 0;
    static int level;
    static int winWidth = edge * 2 + num_x * block;
    static int winHeight = top + edge + num_y * block;
    static int[][] dataBot = new int[num_x + 2][num_y + 2];
    static int[][] dataTop = new int[num_x + 2][num_y + 2];
    static Image mine = Toolkit.getDefaultToolkit().getImage("img/mine.png");
    static Image flag = Toolkit.getDefaultToolkit().getImage("img/flag.png");
    static Image unexplored = Toolkit.getDefaultToolkit().getImage("img/unexplored.png");
    static Image explode = Toolkit.getDefaultToolkit().getImage("img/explode.png");
    static Image wrong = Toolkit.getDefaultToolkit().getImage("img/wrong.png");
    static Image smile = Toolkit.getDefaultToolkit().getImage("img/smile.png");
    static Image sad = Toolkit.getDefaultToolkit().getImage("img/sad.png");
    static Image vic = Toolkit.getDefaultToolkit().getImage("img/vic.png");
    static Image[] nums = new Image[9];
    static
    {
        nums[0] = Toolkit.getDefaultToolkit().getImage("img/space.png");
        for (int i = 1; i <= 8; i++)
        {
            nums[i] = Toolkit.getDefaultToolkit().getImage("img/" + i + ".png");
        }
    };
}

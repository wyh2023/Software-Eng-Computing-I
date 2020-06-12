/**
 * Created by lujxu on 2017/10/24.
 */
public class Player {

    private int x;
    private int y;
    private String symbol;//用来表示此player的符号，如X，Y
    private boolean isHide; // 当前状态， true表示隐身， 此处为了方便，用小写表示隐身状态，如x

    public Player( String symbol, int x, int y, boolean isHide){
        this.x=x;
        this.y=y;
        this.symbol=symbol;
        this.isHide=isHide;
    }

    /**
     *请在这里编写代码
     * 计算两者之间的距离
     * @param player
     * @return 二者之间的距离，最后结果保留整数，向下取整
     */
    public int calDistance(Player player){
        int player_x = player.x;
        int player_y = player.y;
        int dis_x = player_x - this.x;
        int dis_y = player_y - this.y;
        double result = (dis_x*dis_x) + (dis_y*dis_y);
        int ret = (int) Math.sqrt(result);
        return ret;
    }

    /**
     * 请在这里编写代码
     * 根据输入的指令进行移动，指令有：'U', 'D', 'L', 'R'， 分别表示上，下，左，右；其中，上下改变x，左右改变y
     * @param move
     */
    public  void  move(char move){
        switch (move){
            case 'U':
                this.x--;
                break;
            case 'D':
                this.x++;
                break;
            case 'L':
                this.y--;
                break;
            case 'R':
                this.y++;
                break;
        }
    }

    /**
     * 请在此方法中编写代码
     * @return 当前player的符号，若isHide为true,则用小写字母表示， 否则用大写字母表示
     */
    public String getSymbol() {
        if(this.isHide){
            this.symbol = this.symbol.toLowerCase();
        }else{
            this.symbol = this.symbol.toUpperCase();
        }
        return this.symbol;
    }

    /**
     * @return x轴坐标
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return y轴坐标
     */
    public int getY() {
        return y;
    }


}


/**
 * Created by Shifang on 2017/10/21.
 * 游戏类，请补全代码，如有必要，你可以添加一些方法
 */

public class Game {

    public static void main(String[] args){
        Game game=new Game("2;0,0,1;1,1,2");
        Result result=game.playGame("R00,L01,D01,U10,L11");
    }

    private Map map;
    private Player player_X;
    private Player player_Y;

    /**
     *
     * @param initInfo 传入初始化参数,格式为:
     *                 M;x1,y1,hp1;x2,y2,hp2
     *                 分别表示
     *                 M : 棋盘宽度和高度(棋盘为方形)
     *                 x1,y1,hp1 : X 的初始位置,血量
     *                 x2,y2,hp2 : Y 的初始位置,血量
     */
    public Game(String initInfo){
        String[] infoArray = initInfo.split(";|,");
        int n = Integer.parseInt(infoArray[0]);
        int x1 = Integer.parseInt(infoArray[1]);
        int y1 = Integer.parseInt(infoArray[2]);
        int hp1 = Integer.parseInt(infoArray[3]);
        int x2 = Integer.parseInt(infoArray[4]);
        int y2 = Integer.parseInt(infoArray[5]);
        int hp2 = Integer.parseInt(infoArray[6]);
        player_X = new Player(x1,y1,hp1,"X");
        player_Y = new Player(x2,y2,hp2,"Y");
        map=new Map(n,player_X,player_Y);
    }

    /**
     *
     * @param steps 传入两方依次走的步骤, X 先走, 两个玩家之间用","分开,
     *              每个玩家有 3 个参数,分别为'方向','是否攻击','是否隐身'
     *              方向用 U,D,L,R 分别表示上,下,左,右
     *              是否攻击,用 1 表示攻击,用0表示不攻击
     *              是否隐身,用 1 表示隐身,用0表示不隐身
     *              输入示例：
     *                U01,L10
     *              表示 X 向上走 1 步,不攻击,隐身; Y 向左走 1 步,攻击,不隐身
     *              在游戏过程中，如果有任意一方玩家角色死亡（生命值为 0 ），则对手胜利，比如若 X 生命值被减为 0 ，则输出 Y_WIN
     *              若走完所有的步骤,双方都没有死亡,则输出 DRAW
     * @return 游戏结果
     */
    public Result playGame(String steps){
        map.print();
        Result ret = Result.DRAW;
        String[] list =steps.split(",");
        char[][] list_trim = new char[list.length][3];
        for(int i=0; i<list.length; i++){
            list_trim[i] = list[i].toCharArray();
        }
        for(int i=0;i<list.length;i++){
            if(i%2==0){ //x
                if(operate(player_X, list_trim, i, player_Y)){
                    map.print();
                    return Result.X_WIN;
                }
                map.print();
            }else{
                if(operate(player_Y, list_trim, i, player_X)){
                    map.print();
                    return Result.Y_WIN;
                }
                map.print();
            }
        }
        return ret;
    }

    public boolean operate(Player player, char[][] steps, int index, Player opposite){
        player.move(steps[index][0]);
        if(steps[index][1]=='1'){
            if(player.calDistance(opposite) <= player.getGun().getRange()){
                opposite.Damaged(player.getGun().getDamage());
            }
        }
        if(steps[index][2]=='1'){
            player.makeInvisible();
        }else{
            player.makeVisible();
        }
        return opposite.getHealthPoint() <= 0;
    }
}

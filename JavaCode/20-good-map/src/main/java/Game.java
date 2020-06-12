/**
 * Created by lujxu on 2017/10/30.
 */
public class Game {

    public static void main(String[] args){
        String initInfo = "4;1,1,false;2,2,true";
        String steps = "R,L,D,L";
        String lineBreak=System.getProperty( "line.separator" );
        System.out.println("- - - -"+lineBreak+"- - - -"+lineBreak+"y - X -"+lineBreak+"- - - -"+lineBreak+Result.DRAW+lineBreak);
        Game game = new Game(initInfo);
        game.playGame(steps);
    }

    private Player player_X;
    private Player player_Y;
    private Map map;

    /**
     *此方法请勿修改！
     * @param initInfo 传入初始化参数,格式为: n;x1,y1,isHideX;x2,y2,isHideY 分别表示
     * 				   n为地图大小，
     * 				   x1、y1为X初始位置
     *				   x2、y2为Y初始位置
     *				   isHideX、isHideY分别表示X,Y的状态，即是否隐身，隐身为true, 否则为false
     */
    public Game(String initInfo) {
        String[] infoArray = initInfo.split(";|,");
        int n = Integer.parseInt(infoArray[0]);
        int x1 = Integer.parseInt(infoArray[1]);
        int y1 = Integer.parseInt(infoArray[2]);
        int x2 = Integer.parseInt(infoArray[4]);
        int y2 = Integer.parseInt(infoArray[5]);
        boolean isHide1=Boolean.parseBoolean(infoArray[3]);
        boolean isHide2=Boolean.parseBoolean(infoArray[6]);
        player_X = new Player("X",x1,y1,isHide1);
        player_Y = new Player("Y",x2,y2,isHide2);
        map=new Map(n,player_X,player_Y);
    }

    /**
     *此方法请勿修改！
     * @param steps 运动轨迹，X,Y交替运动，输入格式为mx1,my1,mx2,my2.....
     * @return player_X与player_Y之间的距离
     */
    public  int playGame(String steps){
        String list[]=steps.split(",");
        for(int i=0;i<list.length;i++){
            if(i%2==0){ //x
                player_X.move(list[i].trim().charAt(0));
            }else{
                player_Y.move(list[i].trim().charAt(0));
            }

        }
        map.print();
        System.out.println(map.resultEvaluation());
        return player_X.calDistance(player_Y);
    }
}

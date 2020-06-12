/**
 * Created by lujxu on 2017/10/25.
 */
public class Map {
    private final String MAP_DEFAULT="-";
    private  int size;
    private Player d1;
    private Player d2;

    public Map(int size, Player d1, Player d2){
        setSize(size);
        this.d1=d1;
        this.d2=d2;
    }

    /**
     * 请在此方法中编辑代码
     * 返回当前地图中两个player的位置信息，或二者位置重合，则返回枚举类Result中的ENCOUNTER; 否则，返回DRAW
     * @return
     */
    public Result resultEvaluation(){
        int X_x = this.d1.getX();
        int X_y = this.d1.getY();
        int Y_x = this.d2.getX();
        int Y_y = this.d2.getY();
        if(X_x == Y_x && X_y == Y_y){
            return Result.ENCOUNTER;
        }else{
            return Result.DRAW;
        }
    }

    /**
     * 请在此方法中编辑代码
     * 打印地图信息
     * player的位置用Player.getSymbol()表示，其余位置用MAP_DEFAULT表示，注意每个位置之间都用空格隔开
     * 若x,y二者重合则优先输出x
     */
    public void  print(){
        for(int i=0; i<this.size; i++){
            for(int j=0; j<this.size; j++){
                if(check(this.d1, i, j)){
                    System.out.print(this.d1.getSymbol());
                }else if(check(this.d2, i, j)){
                    System.out.print(this.d2.getSymbol());
                }else{
                    System.out.print(MAP_DEFAULT);
                }
                if(j != this.size-1 ){
                    System.out.print(" ");
                }
            }
            System.out.print(System.getProperty( "line.separator" ));
        }
    }


    public boolean check(Player player, int x, int y){
        return x == player.getX() && y == player.getY();
    }

    public void setSize(int size) {
        this.size = size;
    }

}

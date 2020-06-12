import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Created by Shifang on 2017/11/3.
 * 测试用例
 */
public class GameTest {

    ByteArrayOutputStream bytes = null;
    String lineSeparator = System.getProperty("line.separator");

    @org.junit.Before
    public void setUp(){
        bytes=new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));
    }

    @org.junit.After
    public void tearDown(){
        System.setOut(System.out);
    }

    //2*2
    @Test
    public void testPlayGame2(){
        Game game=new Game("2;0,0,1;0,1,1");
        Result result=game.playGame("D11,L11,R11,D11");
        assertEquals(Result.X_WIN,result);
        assertEquals("  0 1" +lineSeparator+
                "0 X Y" +lineSeparator+
                "1 - -" +lineSeparator+
                "X : 1" +lineSeparator+
                "Y : 1" +lineSeparator+
                "  0 1" +lineSeparator+
                "0 - Y" +lineSeparator+
                "1 x -" +lineSeparator+
                "X : 1" +lineSeparator+
                "Y : 0"+lineSeparator,bytes.toString());
    }

    //2*2
    @Test
    public void testPlayGame3(){
        Game game=new Game("2;1,0,1;0,1,2");
        Result result=game.playGame("R10,L00,U11");
        assertEquals(Result.X_WIN,result);
        assertEquals("  0 1" +lineSeparator+
                "0 - Y" +lineSeparator+
                "1 X -" +lineSeparator+
                "X : 1" +lineSeparator+
                "Y : 2" +lineSeparator+
                "  0 1" +lineSeparator+
                "0 - Y" +lineSeparator+
                "1 - X" +lineSeparator+
                "X : 1" +lineSeparator+
                "Y : 1" +lineSeparator+
                "  0 1" +lineSeparator+
                "0 Y -" +lineSeparator+
                "1 - X" +lineSeparator+
                "X : 1" +lineSeparator+
                "Y : 1" +lineSeparator+
                "  0 1" +lineSeparator+
                "0 Y x" +lineSeparator+
                "1 - -" +lineSeparator+
                "X : 1" +lineSeparator+
                "Y : 0" +lineSeparator,bytes.toString());
    }

    // 2*2
    @Test
    public void testPlayGame4(){
        Game game=new Game("2;0,0,1;1,1,2");
        Result result=game.playGame("R00,L01,D01,U10,L11");
        assertEquals(Result.Y_WIN,result);
        assertEquals("  0 1" +lineSeparator+
                "0 X -" +lineSeparator+
                "1 - Y" +lineSeparator+
                "X : 1" +lineSeparator+
                "Y : 2" +lineSeparator+
                "  0 1" +lineSeparator+
                "0 - X" +lineSeparator+
                "1 - Y" +lineSeparator+
                "X : 1" +lineSeparator+
                "Y : 2" +lineSeparator+
                "  0 1" +lineSeparator+
                "0 - X" +lineSeparator+
                "1 y -" +lineSeparator+
                "X : 1" +lineSeparator+
                "Y : 2" +lineSeparator+
                "  0 1" +lineSeparator+
                "0 - -" +lineSeparator+
                "1 y x" +lineSeparator+
                "X : 1" +lineSeparator+
                "Y : 2" +lineSeparator+
                "  0 1" +lineSeparator+
                "0 Y -" +lineSeparator+
                "1 - x" +lineSeparator+
                "X : 0" +lineSeparator+
                "Y : 2" +lineSeparator,bytes.toString());
    }

    //3*3
    @Test
    public void testPlayGame5(){
        Game game=new Game("3;0,0,3;1,1,3");
        Result result=game.playGame("R10,R10,L10,D10,D10,D10,L10");
        assertEquals(Result.X_WIN,result);
        assertEquals("  0 1 2" +lineSeparator+
                "0 X - -" +lineSeparator+
                "1 - Y -" +lineSeparator+
                "2 - - -" +lineSeparator+
                "X : 3" +lineSeparator+
                "Y : 3" +lineSeparator+
                "  0 1 2" +lineSeparator+
                "0 - X -" +lineSeparator+
                "1 - Y -" +lineSeparator+
                "2 - - -" +lineSeparator+
                "X : 3" +lineSeparator+
                "Y : 2" +lineSeparator+
                "  0 1 2" +lineSeparator+
                "0 - X -" +lineSeparator+
                "1 - - Y" +lineSeparator+
                "2 - - -" +lineSeparator+
                "X : 2" +lineSeparator+
                "Y : 2" +lineSeparator+
                "  0 1 2" +lineSeparator+
                "0 X - -" +lineSeparator+
                "1 - - Y" +lineSeparator+
                "2 - - -" +lineSeparator+
                "X : 2" +lineSeparator+
                "Y : 1" +lineSeparator+
                "  0 1 2" +lineSeparator+
                "0 X - -" +lineSeparator+
                "1 - - -" +lineSeparator+
                "2 - - Y" +lineSeparator+
                "X : 1" +lineSeparator+
                "Y : 1" +lineSeparator+
                "  0 1 2" +lineSeparator+
                "0 - - -" +lineSeparator+
                "1 X - -" +lineSeparator+
                "2 - - Y" +lineSeparator+
                "X : 1" +lineSeparator+
                "Y : 0" +lineSeparator,bytes.toString());
    }

    //3*3
    @Test
    public void testPlayGame6(){
        Game game=new Game("3;0,1,2;0,2,2");
        Result result=game.playGame("L11,D11,D01,L01");
        assertEquals(Result.DRAW,result);
        assertEquals("  0 1 2" +lineSeparator+
                "0 - X Y" +lineSeparator+
                "1 - - -" +lineSeparator+
                "2 - - -" +lineSeparator+
                "X : 2" +lineSeparator+
                "Y : 2" +lineSeparator+
                "  0 1 2" +lineSeparator+
                "0 x - Y" +lineSeparator+
                "1 - - -" +lineSeparator+
                "2 - - -" +lineSeparator+
                "X : 2" +lineSeparator+
                "Y : 1" +lineSeparator+
                "  0 1 2" +lineSeparator+
                "0 x - -" +lineSeparator+
                "1 - - y" +lineSeparator+
                "2 - - -" +lineSeparator+
                "X : 1" +lineSeparator+
                "Y : 1" +lineSeparator+
                "  0 1 2" +lineSeparator+
                "0 - - -" +lineSeparator+
                "1 x - y" +lineSeparator+
                "2 - - -" +lineSeparator+
                "X : 1" +lineSeparator+
                "Y : 1" +lineSeparator+
                "  0 1 2" +lineSeparator+
                "0 - - -" +lineSeparator+
                "1 x y -" +lineSeparator+
                "2 - - -" +lineSeparator+
                "X : 1" +lineSeparator+
                "Y : 1" +lineSeparator,bytes.toString());
	}
}

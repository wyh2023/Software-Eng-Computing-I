在 GoodMap 的基础上，我们期望能根据它实现一个游戏，规则如下：

1. 游戏中有两个玩家，分别用 X，Y 表示
2. 游戏地图为正方形，初始时，会向系统输入地图的大小，玩家的初始位置和血量
3. 每个玩家都有一个武器，也就是 Gun，它的伤害值是 1，射程是 3，这个武器的伤害值和射程在整个游戏过程中保持不变
4. 一个玩家可以攻击另一个玩家，假如 X 攻击 Y，如果 Y 到 X 的距离小于等于枪的射程（3），那么 Y 就受到 1 点伤害，生命值减 1；
   如果 Y 到 X 的距离大于3，那么 Y 不受到伤害
5. 游戏为回合制，X 和 Y 轮流行动，X 先行动。
   每个回合，玩家需要向上下左右任意一个方向移动，选择是否隐身，和是否攻击对方，每个玩家的动作用一个长度为3的字符串表示，
   每个字符依次表示 '方向','是否攻击','是否隐身'，如：
   U01
   表示当前玩家向上走一步，不攻击对方，隐身；
   两个玩家的动作用','分隔，比如，一个完整的行动序列为
   U01,L10
   表示 X 向上走 1 步,不攻击,隐身; Y 向左走 1 步,攻击,不隐身
6. 在游戏初始时，需要打印游戏的初始状态，即地图和玩家在地图上的位置，以及两个玩家的初始血量；
   在任意一个玩家的回合之后，同样要打印地图和玩家在地图上的位置，以及两个玩家的当前血量
   例如，在输入为
   Game game=new Game("3;0,0,1;0,1,1"); //地图大小，玩家的初始位置和初始血量
   Result result=game.playGame("D11,L11,R11,D11"); //玩家行动的序列
   打印的结果应该为

  0 1 2
0 X Y -
1 - - -
2 - - -
X : 1
Y : 1
  0 1 2
0 - Y -
1 x - -
2 - - -
X : 1
Y : 0

    注意玩家在当前回合若隐身，需要用小写字母表示其在地图上的位置
    打印玩家血量则一律用大写字母表示
7. 在游戏过程中，需要判断游戏结果，游戏结果有3种
    1) 如果走完所有的回合，双方血量都大于 0 ，那么没有玩家死亡，返回 DRAW
    2) 如果 X 在某回合死亡，则 Y 胜利，返回 Y_WIN
    3) 如果 Y 在某回合死亡，则 X 胜利，返回 X_WIN
   注意游戏可能在中途结束，比如，输入共有 10 个回合，但玩家 Y 在第 5 个回合就死了，那么在第 5 个回合返回 X_WIN，之后的回合就不用继续了
现有n*n大小的地图，甲乙双方降落在地图上的某个点，且甲乙双方能运动。

现给定初始位置，**运动状态**和运动方向，求最终甲乙之间的距离，**判断二者是否相遇**，并打印最终的地图。
运动状态：每位player都有一个状态为isHide, 表示是否隐身  
运动方向如下：

            L：左移一位
            R：右移一位
            D：下移一位
            U：上移一位

说明：现有Game类，Map类，Player类和Result类。 
Game由一个Map对象和两个Player对象组成，我们在Game类中对Map和Player进行了初始化，确定了Map的大小和Player的初始位置及状态。

	  Game类的playGame方法，根据输入的运动方向字符串，循环地让甲、乙移动；每次移动后都计算甲乙之间距离并返回。
	  当移动结束后，让Map对象打印地图信息。
	  甲、乙在移动后的最终位置可能重合（即二者相遇），若重合，打印地图信息时只需打印甲的状态

要求：要实现的是Map类中的resultEvaluation()、 print()方法和Player类中calDistance(Player player)、move(char move)、getSymbol()方法。
	  
Game类输入格式：n为地图大小，x、y为初始位置横纵坐标，isHide表示是否隐身(隐身用小写字母表示)，以空格隔开，后面一行为移动方向序列。
先输入甲的信息，再输入乙的信息。

                n;x1,y1,isHideX;x2,y2,isHideY
                mx1,my1,mx2,my2,mx3,my3

	其中，x、y方向如下所示：
		    —— ——> y方向
	   |
	   |
	   V
	  x方向
	  
示例：   		5;0,0,false;4,4,true  
                 R,U,R,L,D,U

打印地图格式：

            地图中的每一行成一行
            甲用X表示，乙用Y表示
            其他地区用定义好的MAP_DEFAULT表示（-）,每个字符中间用空格隔开
            example:
               - - - - -  
               - - X - -  
               - - - y -  
               - - - - -  
               - - - - -
               
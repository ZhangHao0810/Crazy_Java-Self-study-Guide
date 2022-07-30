package 集合框架类.Collections.一个简单的扑克牌游戏;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther： ZhangHao
 * @Date： 2019/9/23 10:33
 * @Description： 基本的类。
 */
public class PokeGame {
    //定义玩家数量
    private final int Play_Num = 5;
    //定义牌
    private String[] types = {"♦", "♣", "♥", "♠"};
    private String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "K", "A"};

    //cards存放所有牌
    private List<String> cards = new LinkedList<String>();
    //players存放所有玩家。
    private String[] players = new String[Play_Num];
    //playersCards存放某个玩家的所有手牌
    private List<String>[] playersCards = new List[Play_Num];

    /**
     * @param
     * @return void
     * @author Zhanghao
     * @date 2019/9/23 10:39
     * @Description: 初始化扑克牌，放入52张。
     * 使用Shuffle 方法将他们按随机顺序排列。
     */
    public void initCards() {
        for (int i = 0; i < types.length; i++) {
            for (int j = 0; j < values.length; j++) {
                cards.add(types[i] + values[j]);
            }
        }

        Collections.shuffle(cards);
    }

    /**
     * @author Zhanghao
     * @date 2019/9/23 10:49
     *
     * @param names
     * @return void
     * @Description: 初始化玩家，数量不多于Player_Name,不少于2；
    */
    public void initPlayer(String... names) {
        if (names.length > Play_Num || names.length < 2) {
            System.out.println("玩家数量不对");//此处使用异常机制会更合理。
            return;
        }else {

            for (int i = 0;i<names.length;i++){
                players[i] = names[i];
            }
        }
    }

    /**
     * @author Zhanghao
     * @date 2019/9/23 11:00
     * 
     * @param 	
     * @return void
     * @Description: 初始化每个玩家的手牌，开始为空
     * 使用长度为0 的LinkedList表示
    */
    public void initPlayerCards(){
        for ( int i = 0;i<players.length;i++){
            if (players[i] != null&& !players[i].equals("")){
                playersCards[i] = new LinkedList<String>();
            }
        }

    }

    /**
     * @author Zhanghao
     * @date 2019/9/23 11:02
     * 
     * @param 	
     * @return void
     * @Description: 输出全部的牌。用于测试。      
    */
    public void showAllCards(){
        for (String card :cards){
            System.out.print(card+" ");
        }
    }

    /**
     * @author Zhanghao
     * @date 2019/9/23 11:15
     *
     * @param first	首先得牌的玩家。
     * @return void
     * @Description: 发牌，从牌库中依次发牌。先发给参数玩家后面的玩家，再发给前面的玩家。
     * 发牌功能不完善，每次只能发给一个人一张牌，应该一次性发完。
     *
    */
    public void deliverCard(String first){

        int firstPos = ArrayUtils.search(players,first);

        /**
         * @Description:  给参数之后的玩家发牌。
        */
        for (int i =firstPos;i<Play_Num;i++){
            if (players[i]!=null){
                playersCards[i].add(cards.get(0));
                cards.remove(0);
            }
        }

        /**
         * @Description:  给参数玩家之前的玩家发牌。
        */
        for (int i=0;i<firstPos;i++){
            if (players[i] != null) {
                playersCards[i].add(cards.get(0));
                cards.remove(0);
            }
        }
    }

    /**
     * @author Zhanghao
     * @date 2019/9/24 20:40
     *
     * @param
     * @return void
     * @Description: 用来展示此刻选手的手牌。仅限于展示作用。
    */
    public void showPlayerCards(){
        for ( int i=0;i<Play_Num; i++){
            if (players[i] != null){
                System.out.println(players[i]+": ");
                for (String card :playersCards[i]){
                    System.out.print(card + "\t");
                }
            }
            System.out.println();
        }

    }

    /**
     * @Description:    当前的功能为：发牌。
     * @Author:         ZhangHao
     * @CreateDate:     2019/9/24 20:39
    */
    public static void main(String[] args) {
        PokeGame pokeGame = new PokeGame();

        pokeGame.initCards();
        pokeGame.initPlayer("普通玩家","人民币玩家");
        pokeGame.initPlayerCards();

        pokeGame.showAllCards();
        System.out.println("\n"+"--------------------------");

        pokeGame.deliverCard("人民币玩家");//这里如果能把玩家设置成枚举类型就好了，待完善。
        pokeGame.showPlayerCards();

/**
 * 发牌程序还不完善
 *
 * 还需要增加很多需求。以满足扑克牌游戏的规则
*/

        pokeGame.deliverCard("普通玩家");
        pokeGame.showPlayerCards();


    }





}

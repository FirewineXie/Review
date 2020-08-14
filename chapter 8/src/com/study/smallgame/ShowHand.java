package com.study.smallgame;



import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-23-14:06
 */
public class ShowHand {

    //定义该游戏最多支持多少个玩家
    private final int PLAY_NUM =5;

    //定义扑克牌的所有花色和数值
    private String[] types = {"方块" , "草花" , "红心" , "黑桃"};
    private String[] values= {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};

    //cards 是一局游戏中剩下的牌数
    private List<String> cards = new LinkedList<String>();

    //定义所有的玩家
    private String[] players = new String[PLAY_NUM];

    //所有玩家手上的扑克牌
    private List<String>[] playersCards = new List[PLAY_NUM];

    /**
     * 初始化扑克牌，放入52张扑克牌
     * 并且使用shuffle将他们随即排列
     */

    public void initCards(){
        for (int i= 0;i<types.length;i++){
            for (int j=0;j<values.length;j++){
                cards.add(types[i] + values[j]);
            }
        }
        //随机排列
        Collections.shuffle(cards);
    }
     /**
      * 初始化玩家，为每个玩家分派用户名
      */

     public void intPlayer(String...names){
         if (names.length > PLAY_NUM || names.length <2){
             //校验玩家数量，此处使用异常机制更合理
             System.out.println("玩家数量不对");
             return ;
         }else {
             //初始玩家用户名
             for (int i=0;i<names.length;i++){
                 players[i] = names[i];
             }
         }
     }

    /**
     * 初始化玩家手上的扑克牌，开始游戏时每个玩家手上的扑克牌为空
     * 程序使用一个长度为0 的LinkedList来表示
     */
    public void initPlayerCarde(){
        for (int i=0;i <players.length;i++){
            if (players[i] != null && !players[i].equals("")){
                playersCards[i] = new LinkedList<String>();
            }
        }
    }
    /**
     * 输出全部扑克牌，该方法没有实际作用，仅用做测试
     */
    public void showAllCards(){
        for (String card : cards){
            System.out.println(card);
        }
    }

    /**
     * 拍扑克牌 
     * @param first  最先派给谁
     */
    public  void deliverCard(String first){
        //调用 ArrayList 工具类的search方法
        //查询出指定元素在数组中的索引
        int firstPos = ArrayUtils.search(players,first);
        //依次给位于指定玩家之后的每个玩家派扑克牌

        for (int i = firstPos; i < PLAY_NUM ; i++){
            if (players[i] != null){
                playersCards[i].add(cards.get(0));
                cards.remove(0);
            }
        }
        //依次给位于该指定玩家之前的每个玩家拍扑克牌
        for(int i=0;i<firstPos;i++){
            if (players[i] != null){
                playersCards[i].add(cards.get(0));
                cards.remove(0);
            }
        }
    }
    /**
     * 要输出玩家手上的扑克牌
     * 此处没有添加第一章牌不可见
     */
    public void showPlayerCards(){
        for (int i=0;i<PLAY_NUM;i++){
            //当该玩家不为空时，
            if (players[i] != null){
                System.out.println(players[i] + ":");
                for (String card : playersCards[i]){
                    System.out.println(card + "\t");
                }
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {

        ShowHand sh = new ShowHand();
        sh.intPlayer("电脑玩家","1");
        sh.initCards();
        sh.initPlayerCarde();
        //下面测试所有 扑克牌
        //sh.showAllCards();
        System.out.println("++++++++++++++");

        sh.deliverCard("孙悟空");
        sh.showPlayerCards();
        /**
         * 这个地方需要增加：
         * 牌面最大得玩家下注
         * 其他玩家是否继续下注
         * 游戏是否只剩下一个玩家
         * 如果是最后一张牌，，比较玩家的牌面大小
         */
        sh.deliverCard("电脑玩家");
        sh.showPlayerCards();
    }

}

package com.study6.practice_6;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-02-17:04
 */
 enum gameState{
    正在游戏,已放弃;

}
public class Game {
    private String player;
    private String location;//可以使上下左右，也可以是1234


    private int[][] mount = new int[5][];//每个人手里面有多少张牌
    boolean gameing ;//true和false来判断是否继续要牌
    private int n = 52;//剩余牌数

    public void sendPok(){

    }

    public boolean isGameing() {
        return gameing;
    }

    public void setGameing(boolean gameing) {
        this.gameing = gameing;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int[][] getMount() {
        return mount;
    }

    public void setMount(int[][] mount) {
        this.mount = mount;
    }
}

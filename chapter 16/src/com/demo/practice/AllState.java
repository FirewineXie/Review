package com.demo.practice;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: AllState
 * @Create : 2019/12/28
 * @Description :
 */
public class AllState {

    public static void main(String[] args) {
        Thread t =  new Thread(()-> {
            for (int i = 0; i< 20;i++){
                System.out.println(".....");
            }
        });
        //观察状态
        Thread.State state = t.getState();
        System.out.println(state);

        t.start();
        state = t.getState();
        System.out.println(state);


      /* while (state != Thread.State.TERMINATED){
           try {
               Thread.sleep(200);
               state = t.getState();
               System.out.println(state);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }

       }*/

        while (true){
            //活动的线程数
            int num = Thread.activeCount();
            System.out.println(num);

            if (num == 1){
                break;
            }
            try {
                Thread.sleep(200);
                state = t.getState();
                System.out.println(state);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

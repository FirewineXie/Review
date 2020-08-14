package com.demo.practice;

/**
 * @author Firewine
 * @version : 1.0
 * @Program Name: TDownloader
 * @Create : 2019/12/27
 * @Description :
 */
public class TDownloader  extends  Thread{

    //远程路径
    private String url;
    //存储名字
    private String name;

    public TDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader wd = new WebDownloader();
        wd.download(url,name);

    }

    public static void main(String[] args) {

        TDownloader td1  = new TDownloader("http://dmimg.5054399.com/allimg/pkm/pk/22.jpg","22.jpg");
        TDownloader td2  = new TDownloader("http://file02.16sucai.com/d/file/2014/0704/e53c868ee9e8e7b28c424b56afe2066d.jpg","11.jpg");
        TDownloader td3  = new TDownloader("http://g.hiphotos.baidu.com/zhidao/pic/item/c83d70cf3bc79f3d6e7bf85db8a1cd11738b29c0.jpg","33.jpg");
        TDownloader td4  = new TDownloader("http://file02.16sucai.com/d/file/2014/0829/372edfeb74c3119b666237bd4af92be5.jpg","44.jpg");


        td1.start();
        td2.start();
        td3.start();
        td4.start();
    }


}

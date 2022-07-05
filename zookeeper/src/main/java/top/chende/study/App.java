package top.chende.study;

import org.apache.zookeeper.*;

/**
 * Hello world!
 *
 */
public class App 
{
    // zookeeper集群的ip和端口
    private String connectString = "localhost:2181";
    /*
    session超时的时间: 时间不宜设置太小。因为zookeeper和加载集群环境会因为性能等原因而延迟略高，
    如果时间太少，还没有创建好客户端，就开始操作节点。会报错的。
    （心急吃不了热豆腐）
     */
    private int sessionTimeout = 60 * 1000;

    //zookeeper客户端对象
    private ZooKeeper zkClient;


    public void init() throws Exception {
        zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println("得到监听反馈，再进行的业务处理代码！");
                System.out.println(watchedEvent.getType());
            }
        });
    }

    public void createNode() throws Exception {
        String str = zkClient.create("/tws", "laosun".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("已创建节点: " + str);
    }

    public static void main( String[] args )
    {

        App app=new App();
        try {
            app.init();
            app.createNode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println( "Hello World!" );
    }
}

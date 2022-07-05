package top.chende.study.redis;

//import redis.clients.jedis.HostAndPort;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisCluster;
//import redis.clients.jedis.JedisPool;
//
//import java.util.HashSet;
//import java.util.Set;

public class RedisDemo {

//    public static void main(String[] args) {
//        JedisPool pool = new JedisPool("localhost", 6379);
//        try (Jedis jedis = pool.getResource()) {
//            String res= jedis.set("clientName", "Jedis");
//            System.out.println(res);
//
//            String s= jedis.get("clientName");
//            System.out.println(s);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public void clust(){
//        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
//        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7379));
//        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7380));
//        JedisCluster jedis = new JedisCluster(jedisClusterNodes);
//    }
}

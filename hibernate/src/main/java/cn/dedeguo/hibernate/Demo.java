package cn.dedeguo.hibernate;

import cn.dedeguo.hibernate.po.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.Serializable;

public class Demo {
    public static void main(String[] args) {

        //insert();
        testUpdate();
    }

    public static  void testUpdate() {
        //加载 Hibernate 核心配置文件
        Configuration configuration = new Configuration().configure();
        //创建一个 SessionFactory 用来获取 Session 连接对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取session 连接对象
        Session session = sessionFactory.openSession();
        //开始事务
        Transaction transaction = session.beginTransaction();
        //创建实体对象
        User user = new User();
        user.setId(3);
        //设置需要修改的字段
        user.setUserName("更新用户名");
        //直接调用 update() 方法进行修改
        session.update(user);
        //提交事务
        transaction.commit();
        //释放资源
        session.close();
        sessionFactory.close();
    }


    public static void started(){
        //Hibernate 加载核心配置文件（有数据库连接信息）
        Configuration configuration = new Configuration().configure();
        //创建一个 SessionFactory 用来获取 Session 连接对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取session 连接对象
        Session session = sessionFactory.openSession();
        //开始事务
        Transaction transaction = session.beginTransaction();
        //根据主键查询 user 表中的记录
        User user = session.get(User.class, 1);
        System.out.println(user);
        //提交事务
        transaction.commit();
        //释放资源
        session.close();
        sessionFactory.close();
    }

    public static  void insert(){
        //加载 Hibernate 核心配置文件
        Configuration configuration = new Configuration().configure();
        //创建一个 SessionFactory 用来获取 Session 连接对象
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取session 连接对象
        Session session = sessionFactory.openSession();
        //开始事务
        Transaction transaction = session.beginTransaction();
        //创建实体类对象
        User user = new User();

        user.setUserName("编程帮新增用户");
        user.setPwd("654321");
        //向 user 表中插入数据,返回值为新增数据的主键 id
        Serializable save = session.save(user);
        System.out.println("新增数据的主键 id:"+save);
        //提交事务
        transaction.commit();
        //释放资源
        session.close();
        sessionFactory.close();
    }
}

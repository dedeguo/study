package cn.dedeguo.hibernate;

import cn.dedeguo.hibernate.po.Event;
import org.geolatte.geom.Point;
import org.geolatte.geom.codec.Wkt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.spatial.Spatial;


public class Demo2 {

    public static void main(String[] args) {

        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure( "hibernate.cfg.xml" )
                .build();
        Metadata metadata = new MetadataSources( standardRegistry )
                .addAnnotatedClass( Event.class ).buildMetadata();
        SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();

        SessionFactory sessionFactory = sessionFactoryBuilder.build();

        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Event event=new Event();
        event.setId(3l);
        event.setName("chende");

        Point p= (Point) Wkt.fromWkt("Point(4 1)");

        event.setLocation(p);
        session.save(event);
        transaction.commit();
        //释放资源
        session.close();
        sessionFactory.close();
    }

    public void test(){
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure( "hibernate.cfg.xml" )
                .build();
        Metadata metadata = new MetadataSources( standardRegistry )
                .addAnnotatedClass( Event.class ).buildMetadata();
        SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();

        SessionFactory sessionFactory = sessionFactoryBuilder.build();

        Session session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Event event=new Event();
        event.setId(2l);
        event.setName("chende");

        Point p= (Point) Wkt.fromWkt("Point(4 1)");

        event.setLocation(p);
        session.save(event);
        transaction.commit();
        //释放资源
        session.close();
        sessionFactory.close();
    }
}

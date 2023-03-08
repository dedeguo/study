package top.chende.study.es;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.elasticsearch.xpack.sql.jdbc.EsDataSource;

public class JdbcDemo {

    public static void main(String[] args) {
        String address="jdbc:es://192.168.31.254:9200";
        EsDataSource dataSource =new EsDataSource();
        dataSource.setUrl(address);
        try {
           Connection connection = dataSource.getConnection();
           Statement statement = connection.createStatement();
           ResultSet resultSet= statement.executeQuery("select * from bank where city='Brogan' limit 10");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

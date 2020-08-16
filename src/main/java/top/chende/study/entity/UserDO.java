package top.chende.study.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerators;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;

@Data
//@Table(name = "user")
@Entity
public class UserDO {

    @Id
   // @GenericGenerators()
    private Integer id;

    private String userName;

    private String pwd;

    private String test;

    public static void main(String[] args) {

    }


}

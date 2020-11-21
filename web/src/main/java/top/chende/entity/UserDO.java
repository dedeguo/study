package top.chende.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "user_do_123")
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

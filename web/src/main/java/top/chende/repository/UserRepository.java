package top.chende.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.chende.study.entity.UserDO;

@Repository
public interface UserRepository extends JpaRepository<UserDO,Integer> {

}

package top.chende.mongodb;


public interface DemoDao {

void saveDemo(DemoEntity demoEntity);
void removeDemo(Long id);
void update(DemoEntity demoEntity);
DemoEntity findDemoEntityById(Long id);
}

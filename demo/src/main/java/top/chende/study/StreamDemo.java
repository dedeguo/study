package top.chende.study;

import com.alibaba.fastjson.JSON;
import top.chende.study.entity.People;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("A","B","C","D");
        ConcurrentHashMap<String,String> map=new ConcurrentHashMap<>();
        map.containsKey("asda");
        //list.stream().flatMap(e->e.toString())
//        Map<String, List<String>> map = list.stream().map((element)->{
//            Map<String, List<String>> map2 = new HashMap<>();
//            map2.put(element, Arrays.asList(element));
//            return map2;
//        });

        //SizedRefSortingSink s;
//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl","");
//        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).sorted().collect(Collectors.toList());
//        System.out.println( JSON.toJSON(filtered));
//       List<String> ss = strings.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
//        System.out.println(JSON.toJSONString(ss));
//
//       List<People> peopleList = strings.stream().filter(s -> !s.isEmpty()).map(s -> new People(s,s) ).collect(Collectors.toList());
//        System.out.println(JSON.toJSONString(peopleList));
    }
}

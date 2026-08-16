package Hashing;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SampleClass {
    public static void main(String[] args){
        HashMap<Integer,String> nameMap = new HashMap<>();
        nameMap.put(1,"Alice");
        nameMap.put(2,"Deb");
        nameMap.put(3,"Ryan");
        nameMap.put(4,"Rivan");
        List<String> result = nameMap.values().stream().filter(name -> name.startsWith("A")).sorted().collect(Collectors.toList());
        System.out.println("Return the result"+result);

    }

}

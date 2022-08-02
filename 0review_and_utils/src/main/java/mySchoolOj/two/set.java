package mySchoolOj.two;

import java.util.*;

public class set {
    public static void main(String[] args){
        Set<String> set = new HashSet<>();
        setSet(set);
        printSet(set);

        set = new LinkedHashSet<>();
        setSet(set);
        printSet(set);

        set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                return o2.compareTo(o1);
            }
        });
        setSet(set);
        printSet(set);
    }

    public static void setSet(Set<String> set){
        set.add("b");
        set.add("d");
        set.add("c");
        set.add("a");
        set.add("e");
    }

    public static void printSet(Set<String> set){
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
            System.out.print(" ");
        }
        System.out.println();

    }
}

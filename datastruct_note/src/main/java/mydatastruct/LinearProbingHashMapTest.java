package mydatastruct;

public class LinearProbingHashMapTest {
    public static void main(String[] args) {
        System.out.println("==========>插入一批元素");
        LinearProbingHashMap<Object, Object> objectObjectLinearProbingHashMap = new LinearProbingHashMap<>();
        objectObjectLinearProbingHashMap.put(49, 16);
        objectObjectLinearProbingHashMap.put("Aa", 1);
        objectObjectLinearProbingHashMap.put(34, 78);
        objectObjectLinearProbingHashMap.put(17, 85);
        //Aa与BB的hash值是一样的
        objectObjectLinearProbingHashMap.put("BB", 2);
        objectObjectLinearProbingHashMap.put(36, 36);
        objectObjectLinearProbingHashMap.put(21, 37);
        objectObjectLinearProbingHashMap.put(9, 87);
        objectObjectLinearProbingHashMap.put("兓", 62);
        objectObjectLinearProbingHashMap.put(46, 43);
        objectObjectLinearProbingHashMap.put("呵呵", 3);
        objectObjectLinearProbingHashMap.put("嘻嘻", 4);
        System.out.println(objectObjectLinearProbingHashMap);
        System.out.println("size:" + objectObjectLinearProbingHashMap.size());
        System.out.println(objectObjectLinearProbingHashMap);

        System.out.println("==========>删除 BB");
        Object delete = objectObjectLinearProbingHashMap.delete("BB");
        System.out.println(delete);
        System.out.println("size:" + objectObjectLinearProbingHashMap.size());
        System.out.println(objectObjectLinearProbingHashMap);

        System.out.println("==========>插入(46,44) 重复添加46,将会替换value");
        Object put = objectObjectLinearProbingHashMap.put(46, 44);
        System.out.println(put);
        System.out.println("size:" + objectObjectLinearProbingHashMap.size());
        System.out.println(objectObjectLinearProbingHashMap);

        System.out.println("==========>插入null 将会尝试添加到第一个元素");
        Object putNull = objectObjectLinearProbingHashMap.put(null, "nullnull");
        System.out.println(putNull);
        System.out.println("size:" + objectObjectLinearProbingHashMap.size());
        System.out.println(objectObjectLinearProbingHashMap);

        System.out.println("==========>获取null 对应的value");
        Object o = objectObjectLinearProbingHashMap.get(null);
        System.out.println(o);

        System.out.println("==========>扩容");
        objectObjectLinearProbingHashMap.put("BB", 5);
        System.out.println("size:" + objectObjectLinearProbingHashMap.size());
        System.out.println(objectObjectLinearProbingHashMap);

        System.out.println("==========>获取BB 对应的value");
        Object bb = objectObjectLinearProbingHashMap.get("BB");
        System.out.println(bb);

        System.out.println("==========>删除 34");
        Object delete34 = objectObjectLinearProbingHashMap.delete(34);
        System.out.println(delete34);
        System.out.println("size:" + objectObjectLinearProbingHashMap.size());
        System.out.println(objectObjectLinearProbingHashMap);
    }
}


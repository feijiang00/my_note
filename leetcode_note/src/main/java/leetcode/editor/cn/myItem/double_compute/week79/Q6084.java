package leetcode.editor.cn.myItem.double_compute.week79;

import java.util.Map;
import java.util.TreeMap;

/**
 * @date 2022/5/28 23:28
 */
public class Q6084 {


    /**
     * 两个数组，无非就是计数+统计集合，最后输出单词最多的名字
     * 需要一个map保存名字，treemap自动排序挺好
     */
    class Solution {
        public String largestWordCount(String[] messages, String[] senders) {
            TreeMap<String, Integer> map = new TreeMap<>();
            String name;//人名
            Integer num;//消息数量
            for(int i=0;i<senders.length;i++){
                //统计，第一条i，发件人和信息，对应存储到map中
                num = messages[i].split(" ").length;

                //在map中遍历，如果存在则更新，不存在则新建
                if(map.containsKey(senders[i])){
                    //更新
                    num = num + map.get(senders[i]);
                    map.put(senders[i],num);
                }else{
                    //新建
                    map.put(senders[i],num);
                }
            }
            return map.firstKey();
        }
    }
}

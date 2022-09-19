package leetcode.editor.cn.myItem.double_compute.week68;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @date 2021/12/25 22:43
 */
public class Q5947 {

    class Solution {
        /**
         * 这题是真的贱
         * 不仅仅后面要做的菜有用到之前的菜，而且之前的菜还会用到后面的菜，也就是说你不能按从头到后顺便去遍历
         * 后来啊，这个蠢家伙，真的从后往前遍历了，呵呵，还是没过你猜怎么着？这有个菜啊，他前面有，后面也有，欸嘿，
         * 思路：队列，没有完成的菜推送的队列中，不停循环队列，直到没有菜做出来为止
         * @param recipes
         * @param ingredients
         * @param supplies
         * @return
         */
        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            //recipes表示菜,
            List<String> tmp = new ArrayList<>();

            List<String> dish = new ArrayList<>();
            List<String> dish2 = new ArrayList<>();
            Set<String> dish3 = new HashSet<>();

            for(int i=0;i<recipes.length;i++){
                tmp = ingredients.get(i);
                //在tmp中去遍历
                boolean flag = true;
                for (String s : tmp) {
                    //对于tmp中的菜，如果supplies中有就行
                    boolean f = false;
                    for (String supply : supplies) {
                        if(supply.equals(s)){
                            f = true;
                        }
                    }
                    //还需要在dish看看有没有
                    for (String dish1 : dish) {
                        if(dish1.equals(s)){
                            f = true;
                        }
                    }
                    if(!f){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    dish.add(recipes[i]);
                    dish3.add(recipes[i]);
                    //做出来了添加到原材料中
                }
            }

            //从后往前
            for(int i = recipes.length-1;i>=0;i--){
                tmp = ingredients.get(i);
                //在tmp中去遍历
                boolean flag = true;
                for (String s : tmp) {
                    //对于tmp中的菜，如果supplies中有就行
                    boolean f = false;
                    for (String supply : supplies) {
                        if(supply.equals(s)){
                            f = true;
                        }
                    }
                    //还需要在dish看看有没有
                    for (String dish1 : dish2) {
                        if(dish1.equals(s)){
                            f = true;
                        }
                    }
                    if(!f){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    dish2.add(recipes[i]);
                    dish3.add(recipes[i]);
                    //做出来了添加到原材料中
                }
            }

            List<String> dishh = new ArrayList<>(dish3);

            return dishh;

        }
    }

}



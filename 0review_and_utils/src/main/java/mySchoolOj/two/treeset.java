package mySchoolOj.two;

import java.util.Iterator;
import java.util.TreeSet;

public class treeset {
    public static void main(String[] args){

                //String类型降序
                // creating a TreeSet
                TreeSet<String> treeStr = new TreeSet<String>();
                TreeSet<String> treeReverseStr= new TreeSet<String>();
                // adding in the tree set
                treeStr.add("1");
                treeStr.add("13");
                treeStr.add("17");
                treeStr.add("2");
                // creating reverse set
                treeReverseStr = (TreeSet) treeStr.descendingSet();
                // create descending set
                Iterator iteratorStr;
                iteratorStr = treeReverseStr.iterator();
                // displaying the Tree set data
                System.out.println("Tree set data in reverse order for String type: ");
                while (iteratorStr.hasNext()) {
                    System.out.println(iteratorStr.next() + " ");
                }

                //Integer类型降序
                TreeSet<Integer> tree = new TreeSet<Integer>();
                TreeSet<Integer> treeReverse = new TreeSet<Integer>();
                tree.add(1);
                tree.add(13);
                tree.add(17);
                tree.add(2);
                // creating reverse set
                treeReverse = (TreeSet) tree.descendingSet();
                // create descending set
                Iterator iterator2;
                iterator2 = treeReverse.iterator();
                // displaying the Tree set data
                System.out.println("Tree set data in reverse order for Integer type: ");
                while (iterator2.hasNext()) {
                    System.out.println(iterator2.next() + " ");
                }
            }


}

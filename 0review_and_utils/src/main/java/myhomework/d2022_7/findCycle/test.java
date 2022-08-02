package myhomework.d2022_7.findCycle;

import java.util.ArrayList;
public class test {
	static private final int POINT_NUM = 5;//定义图边长
	static private int[][] e={
			{0,1,0,0,0},
			{0,0,1,0,0},
			{0,0,0,1,1},
			{0,1,0,0,0},
			{0,0,0,0,0}};
	//存储遍历图时存储的环
	static ArrayList<Integer> trace=new ArrayList<Integer>();
	static boolean hasCycle=false;//判断图是否有环
	public static void main(String[] args) {
		findCycle(0);//从图中的某个起点出发
		if(!hasCycle)
			System.out.println("对不起，图中无环路");
	}
	//找环算法
	static void findCycle(int v)
	{

		int j = trace.indexOf(v);//indexOf() 方法可返回某个指定的字符串值在字符串中首次出现的位置。如果没有找到匹配的字符串则返回 -1
		if(j!=-1)
		{
			hasCycle=true;
			System.out.print("Cycle:");
			while(j<trace.size())
			{
				System.out.print((char)( trace.get(j).intValue()+'a')+" ");
				j++;
			}
			System.out.print("\n");
			return;
		}
		trace.add(v);

		for(int i=0;i<POINT_NUM;i++)
		{
			//根据矩阵图中的数据找到这条点，看是否有下一条边
			if(e[v][i]==1)
				findCycle(i);
		}
		trace.remove(trace.size()-1);
	}
}
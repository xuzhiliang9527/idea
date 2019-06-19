package randomcout;

import java.util.ArrayList;
//1000000个数的排号功能实现
public class Demo {
	public static void main(String[] args) {
		fun1();
	}
	static void fun() {
		long start = System.currentTimeMillis();
		ArrayList<Integer> al = new ArrayList<Integer>(1000000);
		for(int index = 0;index<1000000;index++)
			al.add(index);
		for(int index = 1000000;index>0;index--) {
			int tmp = (int) (Math.random()*index);
			System.out.println("wncd"+al.get(tmp));
			al.remove(tmp);
		}
		System.out.println("使用ArrayList集合总用时："+(System.currentTimeMillis()-start)+"ms");
	}
	
	static void fun1() {
		int num = 0;
		long start = System.currentTimeMillis();
		int[] al = new int[1000000];
		for(int index = 0;index<1000000;index++)
			al[index] = index;
		for(int index = 1000000-1;index>=0;index--) {
			num++;
			int tmp = (int) (Math.random()*index);
			System.out.println("wncd"+al[tmp]);
			al[tmp] = al[index];
			}
		System.out.println("直接使用数组总用时："+(System.currentTimeMillis()-start)+"ms");
		System.out.println("总共输出："+num+"个数；");
	}
}

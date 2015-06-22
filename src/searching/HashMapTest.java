package searching;
import java.util.*;

public class HashMapTest{
	public static void main(String[] args){
		HashMap<Student, Integer> map = new HashMap<Student, Integer>();
		map.put(new Student(1), 1);
		map.put(new Student(2), 2);
		map.put(new Student(2), 250);
		map.put(new Student(3), 3);
		Out.println(map);
		int i = -10;
		Out.println(Integer.toBinaryString(i));
		i = (-10) >> 31;
		Out.println(Integer.toBinaryString(i));
	}
}

class Student{
	private int v;

	public Student(int i){
		v = i;
	}

	public int v(){
		return v;
	}

	public String toString(){
		return v + "";
	}

	public boolean equals(Object k){
		return ((Student)k).v() == v;
	}

//	public int hashCode(){
//		return 1;
//	}


}
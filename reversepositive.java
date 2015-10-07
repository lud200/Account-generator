package AccountGenerator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class reversepositive {
	public static void main(String args[]){
//		int[] a = {0, -1, 3, 4, 5, -2};
//		Queue<Integer> negative = new LinkedList<Integer>();
//		Queue<Integer> positive = new LinkedList<Integer>();
//		for(int i=0; i<a.length; i++){
//			if(a[i]<0){
//				negative.add(a[i]);
//			}
//			else{
//				positive.add(a[i]);
//			}
//		}
//		Queue<Integer> fin = new LinkedList<Integer>();
//		fin.addAll(negative);
//		fin.addAll(positive);
//		System.out.print("\t"+fin.toString());
		findnums f = new findnums();
		f.find();
	}
}
class findnums{
	public void find(){
		int sum = 3;
		int[] a = {4, 5, 2, 1, 3};
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		for(int i=0; i<a.length; i++){
			h.put(a[i], 0);
			int val = sum - a[i];
			if(h.containsKey(val)){
				System.out.println(val+"\t"+ a[i]);
			}
		}
	}
}

/*
 * Experience designing, implementing and supporting highly scalable applications and web services
Experience with SQL and NoSQL database technologies
Multithreaded or event-driven programming
Excellent analytical and problem solving skills
Excellent written and verbal communication skills
Ability to thrive in a cross-functional team on high profile, critical projects
Preferred Experience:
Java, C, C++
NoSQL databases such as Cassandra, HBase Linux
 */

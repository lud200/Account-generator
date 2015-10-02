package AccountGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class swap {
	public static void main(String args[]){
		
		String str = "malayalam";
		String rev = "";
		for(int i=0; i<str.length(); i++){
			rev = str.charAt(i)+rev;
		}
		System.out.println(rev);
		/*
		char[] ch = {'h', 'e', ' ' , 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};
		
		String[] str = new String[5];
		int j=0;
		String s="";
		for(int i=0;i<ch.length;i++){
			if(str[j]==null){
				str[j]="";
			}
			str[j]=str[j]+ch[i];
			if(ch[i]==' '){
				j++;
				str[j] = " ";
				j++;
			}
		}
		
		LinkedList<String> l = new LinkedList<String>();
		for(int i=0;i<str.length;i++){
			l.add(str[i]);
		}
		
		Collections.reverse(l);
		
		for(String rev : l){
			System.out.print(rev);
		}*/
	}

}

package AccountGenerator;

import java.util.Stack;

public class queuefromStacks {
	public static void main(String[] args){
		Queue q = new Queue();
		q.push(2);
		q.push(3);
		q.push(6);
		System.out.println(q.pop());
		System.out.println(q.pop());
		
	}
	
}

class Queue{
	Stack<Integer> inbox = new Stack<Integer>();
	Stack<Integer> outbox = new Stack<Integer>();
	
	//Insert the elements into inbox.
	public void push(int i){
		inbox.push(i);
	}
	
	//Insert the elements to outbox when outbox is empty
	public int pop(){
		if(outbox.isEmpty()){
			while(!inbox.isEmpty()){
				int i=inbox.pop();
				outbox.push(i);
			}			
		}
		return outbox.pop();
	}
}

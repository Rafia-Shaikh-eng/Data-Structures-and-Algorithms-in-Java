package Postfix_eval;

public class stack {
	//properties
	//as an array
	int[] expression; //declared array 
	int top;//peek
	
	//constructor
	stack(int size){
		expression=new int[size];//allocating memory -> new -> size
		top=-1;
	}
	//method#01 -> push
	void push(int c) {
		if(top==-1) {
			top++;//0 //index of given array
			expression[top]=c;	
			System.out.printf("push(%d)\n",c);
		}
		else {
			//overflow condition
			if(top>=expression.length) {
				System.out.println("Overflow!");
			}
			else {
				top++;
				expression[top]=c;
				System.out.printf("push(%d)\n",c);
			}
		}
		
	}
	int pop() {
		//underflow condition
		if(top<=-1) {
			System.out.println("Underflow!");
			return -1;
		}
			
		else {
			int temp=top;
			top--;
			return expression[temp];
		}
	}
	
}

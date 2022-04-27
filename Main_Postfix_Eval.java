package Postfix_eval;
import java.util.*;
public class Main_Postfix_Eval {

	public static int Evaluate_postfix(String expression) {
		System.out.println("Expression : "+expression);
		//create the object of stack class
		stack stack_obj=new stack(expression.length());
		for(int i=0; i<expression.length(); i++) {
			char c=expression.charAt(i);
			if(Character.isDigit(c)){
				int operand=Character.getNumericValue(c);
				stack_obj.push(operand);
			}
			else {
				int opn1=stack_obj.pop();
				int opn2=stack_obj.pop();
				switch(c) {
				case '+':
					System.out.println("operator : "+c);
					System.out.println("pop : "+opn1+","+opn2);
					System.out.println("Result : "+(opn2+opn1));
					stack_obj.push(opn2+opn1);
					break;
				case '-':
					System.out.println("operator : "+c);
					System.out.println("pop : "+opn1+","+opn2);
					System.out.println("Result : "+(opn2-opn1));
					stack_obj.push(opn2-opn1);
					break;
				case '*':
					System.out.println("operator : "+c);
					System.out.println("pop : "+opn1+","+opn2);
					System.out.println("Result : "+(opn2*opn1));
					stack_obj.push(opn2*opn1);
					break;
				case '/':
					System.out.println("operator : "+c);
					System.out.println("pop : "+opn1+","+opn2);
					System.out.println("Result : "+(opn2/opn1));
					stack_obj.push(opn2/opn1);
					break;
				}
				
			}
			
		}
		
		return stack_obj.pop();
	}
	
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter expression : ");
		String expresion=in.nextLine();
		System.out.println("Final Result : "+Evaluate_postfix(expresion));;
	}

}

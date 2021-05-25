import java.util.Scanner;
import java.lang.Math;

public class TAC {
	//Function to get the precedence of the operators in the string
	private static final char[][] precedence = {
			{'/', '1'},
			{'*', '1'},
			{'+', '2'},
			{'-', '2'}
		};
		
		private static int precedenceOf(String t)
		{
			char charact = t.charAt(0);
			for (int i=0; i < precedence.length; i++)
			{
				if (charact== precedence[i][0])
				{
	 				return Integer.parseInt(precedence[i][1]+"");
				}
			}
			return -1;
		}
		
        
	public static void main(String[] args) {
		//To Scan the input from the user
		Scanner Scan = new Scanner(System.in);
		
		char[] OprPre =  {'*','/','+','-'} ;
		int[] Checked ;
		char character;
		int count =0 ;
		String Var;
		String[][] operators = new String[10][2];
		String Operate ;
			
		//Creating an object  of the quadruple class to store the values and use the function "table" to create the Quadruple Table
		Quadruple Qua = new  Quadruple () ;
		Triple Tri =new Triple();
		
		//Initializing the expression and getting the expression from the user
		System.out.println("Enter The expression");
		 String expr = Scan.nextLine();
		 char exprChar[]=new char[expr.length()] ;
		 Checked = new int[expr.length()];
		  
		 // setting each character of expression to each item in the array exprChar
		 for(int i = 0 ; i < expr.length(); i++) {
			 exprChar[i] = expr.charAt(i);
			 System.out.print(exprChar[i]);			 
		 }
		 System.out.println("\n");
		 //for loop to get the operations and the positions
		 for (int i=0; i < expr.length(); i++)
			{
				character = expr.charAt(i);
				for (int j=0; j < OprPre.length; j++)
				{
					if (character== OprPre[j])
					{
						operators[count][0] = character+"";
						operators[count][1] = i+"";
						count++;	
					}
				}
			}
		 
		 //loop to arrange the operators according to precedence
		 for (int i=count-1; i >= 0; i--)
			{
				for (int j=0; j < i; j++)
				{
					if (precedenceOf(operators[j][0]) > precedenceOf(operators[j+1][0]))
					{
						Var = operators[j][0];
						operators[j][0] = operators[j+1][0];
						operators[j+1][0] = Var;
						Var= operators[j][1];
						operators[j][1] = operators[j+1][1];
						operators[j+1][1] = Var;
					}				
				}
			}
		 for (int i=0; i < count; i++)
			{
				int j = Integer.parseInt(operators[i][1]+"");
				String op1="", op2="";
				if (Checked [j-1]== 1)
				{
					if (precedenceOf(operators[i-1][0]) == precedenceOf(operators[i][0]))
					{
						op1 = "t"+i;
					}
					else
					{
						for (int x=0; x < count; x++)
						{
							if ((j-2) == Integer.parseInt(operators[x][1]))
							{
								op1 = "t"+(x+1)+"";
							}
						}
					}
				}
				else
				{
					op1 = expr.charAt(j-1)+"";
				}
				if (Checked[j+1]==1)
				{
					for (int x=0; x < count; x++)
					{
						if ((j+2) == Integer.parseInt(operators[x][1]))
						{
							op2 = "t"+(x+1)+"";
						}
					}
				}
				else
				{
					op2 = expr.charAt(j+1)+"";
				}
				System.out.println("t"+(i+1)+" = "+op1+operators[i][0]+op2);
				Checked[j] = Checked[j-1] = Checked[j+1] = 1;
				
				
				Operate = operators[i][0];
				//A condition statement to make the minus sign Uminus in the quadruple Table
				if (Operate.charAt(0 )=='-') {
					Operate= "Uminus";
				}
			    
				Qua.ple(Operate, op1, op2);
				
				//To set the Strings for the triple representation
				 if (op1.charAt(0) == 't') {
					 op1= "("+Math.abs(i-1) +")";
					 
				 }
				 if (op2.charAt(0) == 't') {
					 op2= "("+Math.abs(i-2) +")";
					 
				 }
				 		
				Tri.ple(Operate, op1, op2);
				
			}
		       Qua.Table();
		       Tri.Table();
		 
   }
}

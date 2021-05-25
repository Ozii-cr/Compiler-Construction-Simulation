
public class Triple {
	String[] Arr1 =new String[10];
	String[]Arr2 =new String[10];
	String[] Arr3 =new String[10];
	public static int i = 0;
	 public void ple(String var1 ,String var2 ,String var3){
		 Arr1[i] = var1;
		 Arr2[i] =var2;
		 Arr3[i] =var3;
		 i++;
	 }
	 public void Table() {
		 System.out.println("");
		 System.out.println("\t\tTRIPLE");
		 System.out.println("# \t Op \t Arg1 \t Arg2 ");
		 for(int j=0 ;j <i ;j++) {
			
			 System.out.println(j +"\t" + Arr1[j] +"\t"+ Arr2[j] +"\t"+Arr3[j] );
		 }
		 
		 
	 }

}

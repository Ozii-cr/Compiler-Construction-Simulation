package p1;
import java.util.Scanner;


import java.io.*;
public class eClosure
{
static int qno = 8; //No of states
static int ecloc;

/*Declaring 2d array for delta on a & b*/
static int d[][]=
{
{-1,-1},
{-1,-1},
{3,-1},
{-1,-1},
{-1,5},
{-1,-1},
{-1,-1},
{-1,-1}
};

/*Declaring 2d array for delta on e */
static int de[][]= new int[8][5];

/*Initializing 2d array for delta on e */
static void initde ()
{
/*Initializing 2d e array with -1:NULL */
for (int i=0;i<8;i++) {
	for (int j=0;j<5;j++){ 
		de[i][j]=-1; 
		}
	}
/*Initializing 2d e array*/ 
de[0][0]=1;
de[0][1]=7; 
de[1][0]=2; 

de[1][1]=4;
de[3][0]=6;
de[5][0]=6;
de[6][0]=7;
de[6][1]=1; 
} 
/*Calculate e-closure*/ 
static int eclo[][] = new int[8][50]; 
/*Initialize 2d array of eclo[][]*/
static void initeclo() {
	for (int i=0;i<8;i++){
		for (int j=0;j<50;j++) {
			eclo[i][j]=-1;
			}
		}
	}
public static void main(String args[]){
	/* Initialize all*/
	initde(); 
	initeclo();
	int i,j; 
	BufferedReader obj= new BufferedReader (new InputStreamReader (System.in)); 
	/* Finding e-closure */ for (i=0;i<8;i++) {
		eclop = i; 
		ecloc = 0; 
		feclo(i);
		} 
	/* Displaying e-closure */
	System.out.println("Enter State no:"); 
	int sno=Integer.parseInt(obj.readLine());
	System.out.println("E-closure of "+sno); 
	for (i=0;i<50;i++) {
		if (eclo[sno][i]!=-1) {
			System.out.print(eclo[sno][i]+" ");
			} 
		} System.out.println();
		} 
static int eclop=0;
//temp int for holding element no which is under process static int ecloc=0; 
//temp int for holding current position in array 
/*Calculating e-closure*/ 
static void feclo(int n) { 
	
	/*Adding n in eclo*/
	if (checkeclo(n)==0) {
		eclo[eclop][ecloc] = n;
		ecloc++; 
		}
	/*Adding remaining*/ 
	for (int i=0;i<5;i++) {
		if (de[n][i]!=-1) {
			int ele = de[n][i];
			if (checkeclo(ele)==0) {
				eclo[eclop][ecloc] = ele;
				ecloc++; 
				}
			feclo(de[n][i]);	
			} 
		} 
	}
/*Checking if element is already present in e-closure or not*/ 
static int checkeclo(int ele) { 
	for (int i=0;i<50;i++) { 
		if (eclo[eclop][i]==ele) { 
			return 1;
			} 
		} 
	return 0; 
    }
}

 
/* OUTPUT Enter State no: 3 E-closure of 3 3 6 7 1 2 4 Enter State no: 6 E-closure of 6 6 7 1 2 4 */ [/java]

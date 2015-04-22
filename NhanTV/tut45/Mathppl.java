package ppl;

public class Mathppl {
	public static void main(String [] args){
		char option;
		do{
//			try {
//				Runtime.getRuntime().exec("cls");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			TextIO.putln("a.determine the remainder after integer division using only subtractione");
			TextIO.putln("b.determine the integer division using only addition and subtraction");
			TextIO.putln("c.determine the middle one of three numbers");
			TextIO.putln("d.determine whether or not a string is a palindrom");
			TextIO.putln("e.determine if an integer is a prime");
			TextIO.putln("q to quyt");
			TextIO.putln("enter your choice");
			option = TextIO.getlnChar();
			switch(option){
			case 'a':
				TextIO.putln("enter dividen:");
				int a = TextIO.getlnInt();
				TextIO.putln("enter divisor:");
				int b = TextIO.getlnInt();
				remainder(a,b);
				break;
			case 'b':
				TextIO.putln("this method has not been done yet");
				break;
			case 'c':
				TextIO.putln("enter 3 number A,B,C:");
				double A = TextIO.getlnDouble();
				double B = TextIO.getlnDouble();
				double C = TextIO.getlnDouble();
				double mid = middle(A,B,C);
				TextIO.putln("the middle number is:"+ mid);
				break;
			case 'd':
				TextIO.putln("enter the string:");
				String str = TextIO.getln();
				boolean pld = isPalindrom(str);
				if(pld == true) TextIO.putln("the string is palindrom");
				else TextIO.putln("the string is not palindrom");
				break;
			case 'e': 
				TextIO.putln("enter number:");
				int s = TextIO.getlnInt();
				if (isPrime(s)==true)  TextIO.putln("the number is prime");
				else TextIO.putln("the number is not prime");
				break;
			}
		}while( option != 'q');
	}
	
	/**
	 * determine the remainder after integer division using only subtraction. Ignore the possibility of division by zero.
	 * @requires: divisor != 0
	 * @modifies:
	 * @effects: remain <- a
	 * while remain > divisor
	 * 		remain= a-divisor 
	 */
	public static void remainder(int a, int divisor){
		if(divisor !=0){
			int remain=a;
			while(remain >divisor) remain=remain-divisor;
			TextIO.putln("remainder is:"+remain);
			}
		else {
			TextIO.putln("division by zero");
		}
	}
	
	/**
	 * determine the middle one of three numbers
	 * @requires:
	 * @effects: 
	 * 		if (a-b)(b-c)<0 then b is the middle
	 * 		if (b-c)(c-a)<0 then c is the middle
	 * 		if (c-a)(a-b)<0 then a is the middle
	 */
	public static double middle (double a, double b, double c){
		double subab = a-b;
		double subbc = b-c;
		double subca = c-a;
		if(subab*subbc < 0) 
			return b;
		else if (subbc*subca <0) 
			return c;
		else 
			return a;
	}
	
	/**
	 * determine whether or not a string is a palindrom
	 * @requires:
	 * @modifies:
	 * @effects:
	 * 		for each i in a
	 * 			if charAt(i) != charAt(length-i)
	 * 			then ispalindrome = false
	 */
	public static boolean isPalindrom(String a){
		boolean ispalindrom = true;
		for(int i=0;i<(a.length()-1);i++){
			if(a.charAt(i) != a.charAt(a.length()-1-i)) ispalindrom = false;
		}
		return ispalindrom;
	}
	
	/**
	 * determine if an integer is a prime
	 *@requires:
	 *@modifies:
	 *@effects:
	 *		for each i smaller than a
	 *			if a%i != 0 
	 *			prime<- false
	 */
	public static boolean isPrime(int a){
		boolean prime=true;
		for(int i=2;i<a;i++){
			if(a%2==0)	prime = false;
		}
		return prime;
	}
}

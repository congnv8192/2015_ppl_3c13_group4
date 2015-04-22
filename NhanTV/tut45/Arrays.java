package ppl;

import java.io.IOException;

public class Arrays {
	public static void main(String[] args){
		char option;
		do{
//			try {
//				Runtime.getRuntime().exec("cls");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			TextIO.putln("a.count the number of elements of an array of integers that are negative");
			TextIO.putln("b.find the minimum element in an array of integers");
			TextIO.putln("c.determine whether an array of integers is in ascending order");
			TextIO.putln("d.find the length of an array of CHARs");
			TextIO.putln("e.find the median of an array of reals, that is the array value closest to the middle");
			TextIO.putln("f.compare 2 arrays of real");
			TextIO.putln("g.compute the frequencies of each element of an array of reals");
			TextIO.putln("q to quyt");
			TextIO.putln("enter your choice");
			option = TextIO.getlnChar();
			switch(option){
			case 'a':
				int i=countNegative(getIntArr());
				TextIO.putln("number of negative element:"+i);
				break;
			case 'b':
				TextIO.putln("min is "+ min(getIntArr()));
				break;
			case 'c':
				boolean b = isAscSorted(getIntArr());
				if(b==true)
					TextIO.putln("array is in ascending order");
				else TextIO.putln("array is not in ascending order");
				break;
			case 'd':
				int l = length(getCharArr());
				TextIO.putln("length of the array: "+ l);
				break;
			case 'e': 
				double med = median(getDoubleArr());
				TextIO.putln("median is: "+ med);
				break;
			case 'f':
				TextIO.putln("the array a:");
				double [] arr1 = getDoubleArr();
				TextIO.putln("the array b:");
				double [] arr2 = getDoubleArr();
				compare(arr1,arr2);
				break;
			case 'g':
				freq(getDoubleArr());
				break;
			}
		}while( option != 'q');
		
	}
	
	/**
	 * count the number of element in the array that is negative
	 * @requires: 
	 * @modifies:
	 * @effects: for i<-1 to array.length  do  if(Array[i]<0) count <- count + 1
	 *  the loop runs from 0 to the length of array if the element is smaller than 0, raise the value of count 1
	 * @param array
	 * @return
	 */
	public static int countNegative (int [] array){
		int count =0;
		for(int i=0; i<array.length; i++){
			if(array[i]<0){
				count++;
			}
		}
		return count;
	}
	
	/**
	 * @param arr
	 * @requires : array is not empty
	 * @effects: 
	 * min<-0
	 * 	foreach int i in arr
	 * 		if i<min
	 * 			min= i  
	 * @return min
	 */
	public static int min (int [] arr){
		int min=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]<min)
				min=arr[i];
		}
		return min;
	}
	
	/**
	 * check whether the array is in ascending order 
	 * @modifies:
	 * @effects: foreach i in arr
	 * 		if a[i] > a[i+1]
	 * 		return false, end the loop
	 * 		else return true
	 * @param arr
	 * @return
	 */
	public static boolean isAscSorted(int [] arr){
		boolean issorted=true;
		for (int i=0;i<(arr.length-1);i++){
			if(arr[i]>arr[i+1]){
			issorted = false;
			break;
			}
		}
		return issorted;
	}

	/** 
	 * find the length of character array, character null is consider as the end of the array
	 * @requires:
	 * @modifies:
	 * @effects:
	 * foreach i in arr
	 * 		if i!=null
	 * 		count++;
	 * 	else break
	 * @param arr
	 * @return
	 */
	public static int length(char [] arr){

		int count=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i] != '\u0000') count++;
			else break;
		}
		return count;
	}
	
	/**
	 * find the median of an array of reals, that is the array value closest to the middle
	 * @require:
	 * @modifies:
	 * @effects: if number of elements that small than a[i] is equal to the number of elements that larger than a[i]
	 *  then a[i] is median
	 */
	public static double median(double [] arr){
		double med=0;
		for(int i=0;i<arr.length;i++){
			int smaller=0,larger=0;
			for(int j=0;j<arr.length;j++){
				if(arr[i]>arr[j]) smaller++;
				else if (arr[i]<arr[j]) larger++;
			}
			if(arr.length%2==1){
				if (smaller == larger){
				med = arr[i];
				break;
				}
			}
			else if(Math.abs(smaller - larger)==1){
				med = arr[i];
				break;
			}
			TextIO.putln("l"+larger+" s"+smaller);
		}
		return med;
	}

	/**
	 * check how many element in a appear in b
	 * @require:
	 * @modifies:
	 * @effect: 
	 * for each i in a
	 * 		for each j in b
	 * 			if i =j then count <- count+1
	 */
	public static int contain(double [] a,  double [] b){
		int count=0;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<b.length;j++){
				if(a[i] == b[j]){
					count++;
					break;
				}
			}
		}
		return count;
	}
	
	/**
	 * compare 2 array a with b determine if a  contains b, a has intersection with b, or a = b
	 * @requires:
	 * @modifies:
	 * @effects: if all element of a appear in b and a is smaller than b then a is subset of b
	 *  if length of a is equal to b's and ad all element of a appear in b then a=b
	 */
	public static void compare(double [] a, double[] b){
		int contain;
		if (a.length>b.length){
			contain = contain(b,a);
			if(contain == b.length) TextIO.putln("b is subset of a");
			else if(contain < b.length & contain >0) TextIO.putln("a has intersection with b");
			else if(contain == 0) TextIO.putln("a is diferent from b ");
		}
		else if(b.length>a.length){
			contain = contain(a,b);
			if(contain == a.length) TextIO.putln("a is subset of b");
			else if(contain < a.length & contain >0) TextIO.putln("a has intersection with b");
			else if(contain == 0) TextIO.putln("a is diferent from b ");
		}
		else {
			contain = contain(a,b);
			if(contain < a.length & contain>0 ) TextIO.putln("a has intersection with b");
			else if(contain == a.length) TextIO.putln("a is equal to b");
			else if(contain == 0) TextIO.putln("a is diferent from b ");
		}
	}

	/**
	 * compute the frequencies of each element of an array of reals
	 * @requires:
	 * @effects: for each i in a
	 * 				for each j in a
	 * 					if a[i] = a[j] then count-< count +1
	 */
	public static void freq(double [] a){
		for(int i=0;i<a.length;i++){
			int count=0;
			for(int j=0;j<a.length;j++){
				if(a[i] == a[j]) count++;
			}
			TextIO.putln("frequenci of "+a[i]+" is:"+count);
		}
	}
	
	/**
	 * get an array of integer
	 * @return
	 */
	public static int [] getIntArr(){
		TextIO.put("enter the number of element");
		int n=TextIO.getlnInt();
		int [] arr = new int [n];
		for(int i=0;i<n;i++){
			TextIO.putln("enter the element no."+(i+1));
			arr[i] = TextIO.getlnInt();
		}
		return arr;
	}
	
	/**
	 * get an array of real
	 * @return
	 */
	public static double [] getDoubleArr(){
		TextIO.put("enter the number of element");
		int n=TextIO.getlnInt();
		double [] arr = new double [n];
		for(int i=0;i<n;i++){
			TextIO.putln("enter the element no."+(i+1));
			arr[i] = TextIO.getlnDouble();
		}
		return arr;
	}
	
	/**
	 * get an array of character
	 * @return
	 */
	public static char [] getCharArr(){
		TextIO.put("enter the number of element");
		int n=TextIO.getlnInt();
		char [] arr = new char [n];
		for(int i=0;i<n;i++){
			TextIO.putln("enter the element no."+(i+1));
			arr[i] = TextIO.getChar();
		}
		return arr;
	}
}
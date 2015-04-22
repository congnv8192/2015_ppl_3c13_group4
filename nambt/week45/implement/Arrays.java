package week45.implement;

import static week45.implement.TextIO.*;

public class Arrays 
{
  private static final char NUL = '0'; 
  
  /**
   * Determine the number of elements of an array of integers that 
   * are negative.
   * 
   * @requires a not eq null
   * @effects result = b.length where 
   *    b = [x1,...,xk], xi in a /\ xi < 0 for all 1<=i<=k, 
   *    e.g. countNegative([-1,0,-2,1]) = 2
   */
  public static int countNegative(int[] a) 
  {
    int count = 0;
    for (int x : a) 
	{  
      if (x < 0) 
	  {
        count++;           
      }
    }

    return count;
  }
  
  /**
   * Determine the minimum element of an array of integers.
   * 
   * @requires a neq null /\ a.length > 0
   * @effects return x in a: (for all y. y in a -> y >= x), 
   *  e.g. min([2,1,3]) = 1
   */
  public static int min(int[] a) 
  {
    int min = a[0];
    
    for (int x: a) 
	{
      if (x < min) 
	  {
        min = x;  
      }
    }
    return min;
  }
  
  /**
   * Determine whether an array of integers is in ascending order.
   * 
   * @requires a neq null /\ a.length > 1
   * @effects 
   *  if for all nat: i,j. (i <= j < a.length -> a[i] <= a[j])
   *    return true
   *  else 
   *    return false
   */
  public static boolean isAscSort(int[] a) 
  {
    int len = a.length;
    
    for (int i = 0; i < len-1; i++) 
	{
      if (a[i] > a[i+1]) 
	  {
        return false;
      }
    }
    return true;
  }
  
  /**
   * Determine the length of a array of characters on the understanding that if
   * it contains the character NUL (the character '\u0000' in Java) 
   * then that and any characters after it are not to be counted
   * 
   * @requires a neq null /\ a.length >0 /\ a[0] neq NUL
   * @effects
   *  if exists k: (for all 0 <= i < k. a[i] neq NUL /\ a[k] = NUL)
   *    return k
   *  else 
   *    return a.length
   */
  public static int length(char[] a) 
  {    
    int len = 0;
    for (char c : a) 
	{
      if (c != NUL) 
	  { 
        len++;        
      } 
	  else 
	  {        
        break;        
      }
    }
    
    return len;
  }
  
  /**
   *  Determine the median of an array of reals, that is the array value closest
   *  to the middle in the sense that as many array elements are smaller than it
   *  as are greater than it.
   *  
   *  @requires a neq null /\ a.length > 0 /\ (for all nat: i,j. (i neq j /\ i,j < a.length -> a[i] neq a[j])) 
   *  
   *  @effects 
   *    return any m such that 0 <= |{x | x in a /\ x >= m}| - |{y | y in a /\ y <= m}|) <= 1 
   */
  public static double median(double[] a) 
  {
    final int half = (a.length+1)/2;
    int count;
    
    for (double x : a) 
	{
      count = 0;
      for (double y : a) 
	  {
        if (y <= x) 
		{ 
          count++;    
        }
      }
      
      if (count == half) 
	  {
        return x;
      }
    }
    return -1D; 
  }
  
  /**
   * Given two arbitrary arrays of reals, a and b, determine if a sub-set, 
   * super-set, intersects with, or = b
   * 
   * @requires a not eq null /\ b not eq null
   * @effects 
   *  if a is disjoint with b 
   *    return -2
   *  else if a is a sub-set of b 
   *    return -1
   *  else if a is equal to b 
   *    return 0
   *  else if a is a super-set of b
   *    return 1
   *  else  //a intersects with b 
   *    return 2
   */
  public static int compare(double[] a, double[] b) 
  {
    int al = a.length;
    int bl = b.length;

    if (al == 0 || bl == 0) 
      return 0;

    double[] a1, a2;
    if (al >= bl) 
	{
      a1 = b;   
      a2 = a;   
    } 
	else 
	{
      a1 = a;   
      a2 = b;   
    }

    int countShared = 0;
    for (int i = 0; i < a1.length; i++) 
	{
      for (int j = 0; j < a2.length; j++) 
	  {
        if (a1[i] == a2[j]) 
		{
          countShared++;  
          break;
        }
      }
    }

    if (countShared == 0) 
	{      
      return -2;
    } else {                     
      if (countShared == al) 
	  {   
        if (al == bl)            
          return 0;
        else                     
          return -1;
      } else if (countShared == bl) 
	  { 
        if (al == bl)            
          return 0;
        else                     
          return 1;
      } 
	  else 
	  {                   
        return 2;
      }             
    }
  }
  
  /**
   * Compute the frequencies of each element of an array of reals.
   * 
   * @requires a not eq null /\ a.length > 0
   * @effects 
   *  return [f0,...,fk]: k = a.length-1 /\ 
   *    fi = |{x | x in a /\ x = a[i]}| for all 0 <= i <= k
   */
  public static int[] freq(double[] a) 
  {
    int[] freq = new int[a.length];
    java.util.Arrays.fill(freq, 1);
  
    /**
     * <pre>
     *  loop through the array, counting the number of each element
     *  and updating the corresponding elements in freq such that
     *     the first element has the freq number, the subsequent 
     *     elements have the position of the first element * -1
     *  if found an element whose freq value is negative number, update it using 
     *  the value of the position in freq set by this number
     */
    double e;
    for (int i = 0; i < a.length; i++) 
	{
      e = a[i];
      if (freq[i] < 0) 
	  {
        freq[i] = freq[(-1 * freq[i]) - 1]; 
        continue;
      }
  
      for (int j = i+1; j < a.length; j++) 
	  {
        if (a[j] == e) 
		{
          freq[i]++;              
          freq[j] = -1 * (i + 1); 
        }
      }
    }
  
    return freq;
  }
  
  /**
   * the main procedure
   * @effects
   *  do 
   *    display a list of the functions and their descriptions and 'Q' or 'q' to quit the program
   *    prompt the user to select a choice
   *    if input is a function
   *      prompt the user to enter input data for the selected function
   *      invoke the function with the specified data
   *      display the result on the standard output
   *      [*]pause until user enters any character on the keyboard
   *  while user input a function
   */
  public static void main(String[] args) 
  {
    final String[][] menuItems = new String[][] 
	{
        {"[1]", "Count num. negative elements of an integer array"},
        {"[2]", "Find the min element of an integer array"},
        {"[3]", "Determine sortedness of an integer array"}, 
        {"[4]", "Count num. characters in an array up to NUL '\u0000'"}, 
        {"[5]", "Find the median of a real array"},
        {"[6]", "Set-compare two real arrays"},
        {"[7]", "compute the frequencies of elements of a real array"},
        {"",""},
        {"[Q]", "Quit the program"}
    };
    
    final char[] allowedInput = {'1', '2', '3', '4', '5', '6', '7', 'q', 'Q'};
    char c;
    
    do 
	{
      Menu.display(menuItems);
      c = Menu.prompt(allowedInput);
      
      switch (c) 
	  {
        case '1':
          int[] data = getlnIntArray();
          int r = countNegative(data);
          putf("countNegative(%s) = %d%n", java.util.Arrays.toString(data), r);
          break;
        case '2': 
          data = getlnIntArray();
          r = min(data);
          putf("min(%s) = %d%n", java.util.Arrays.toString(data), r);
          break;
        case '3': 
          data = getlnIntArray();
          boolean b = isAscSort(data);
          putf("isAscSort(%s) = %b%n", java.util.Arrays.toString(data), b);
          break;
        case '4': 
          char[] cdata = getlnCharArray();
          r = length(cdata);
          putf("length(%s) = %d%n", java.util.Arrays.toString(cdata), r);
          break;
        case '5':
          double[] ddata = getlnDoubleArray();
          double dr = median(ddata);
          putf("median(%s) = %f%n", java.util.Arrays.toString(ddata), dr);
          break;
        case '6': 
          double[] ddata1 = getlnDoubleArray();
          double[] ddata2 = getlnDoubleArray();
          r = compare(ddata1, ddata2);
          putf("compare(%s,%s) = %d%n", java.util.Arrays.toString(ddata1), java.util.Arrays.toString(ddata2), r);
          break;
        case '7':
          ddata = getlnDoubleArray();
          int[] fr = freq(ddata);
          putf("freq(%s) = %s%n", java.util.Arrays.toString(ddata), java.util.Arrays.toString(fr));
          break;
      }
      
      if (!(c == 'q' || c == 'Q')) 
	  {
        put("Press any key to continue...");
        getAnyChar();
      }
    } 
	while (!(c == 'q' || c == 'Q'));
    
    putln("Bye.");
  }

  /**
   * @effects
   *  do
   *    prompt the user to enter an integer array
   *  while input is not valid
   *  return the integer array
   */
  public static int[] getlnIntArray() 
  {
    boolean valid = false, allNumeric;
    int[] arr = null;
    String s, e;
    String[] els;
    
    putln("Enter elements of an integer array (separated by ';'), e.g. 1;2;3");
    do 
	{ 
      s = getln();
      s = s.trim();
      if (!s.equals("") && s.indexOf(";") > -1) 
	  {
        els = s.split(";");
        arr = new int[els.length];
        allNumeric = true;
        for (int i = 0; i < els.length; i++) 
		{
          e = els[i].trim();
          if (!Math.isNumberString(e, false)) 
		  {
            // invalid
            allNumeric = false;
            putln("Invalid, please re-enter:");
            break;
          } 
		  else 
		  {
            arr[i] = Integer.parseInt(e);
          }
        }
        
        if (allNumeric)
          valid = true;
      } 
	  else 
	  {
        putln("Invalid, please re-enter: ");
      }
    } 
	while (!valid);
    
    return arr;
  }
  
  /**
   * @effects
   *  do
   *    prompt the user to enter a character array
   *  while input is not valid
   *  return the character array
   */
  public static char[] getlnCharArray() 
  {
    boolean valid = false, allChar;
    char[] arr = null;
    String s, e;
    String[] els;

    putln("Enter elements of a character array (separated by ';'), e.g. h;e;l;l;o");
    
    do 
	{ 
      s = getln();
      s = s.trim();
      if (!s.equals("") && s.indexOf(";") > -1) 
	  {
        els = s.split(";");
        arr = new char[els.length];
        allChar = true;
        for (int i = 0; i < els.length; i++) 
		{
          e = els[i].trim();
          if (e.equals("") || e.length() > 1) 
		  {
            allChar = false;
            putln("Invalid, please re-enter: ");
            break;
          } 
		  else 
		  {
            arr[i] = e.charAt(0);
          }
        }
        
        if (allChar)
          valid = true;
      } 
	  else 
	  {
        putln("Invalid, please re-enter: ");
      }
    } while (!valid);
    
    return arr;
  }
  
  /**
   * @effects
   *  do
   *    prompt the user to enter a double array
   *  while input is not valid
   *  return the double array
   */
  public static double[] getlnDoubleArray() 
  {
    boolean valid = false, allNumeric;
    double[] arr = null;
    String s, e;
    String[] els;
    putln("Enter elements of a double array (separated by ';'), e.g. 1.0;2.5;3");
    do { 
      s = getln();
      s = s.trim();
      if (!s.equals("") && s.indexOf(";") > -1) 
	  {
        els = s.split(";");
        arr = new double[els.length];
        allNumeric = true;
        for (int i = 0; i < els.length; i++) 
		{
          e = els[i].trim();
          if (!Math.isNumberString(e, true)) 
		  {
            allNumeric = false;
            putln("Invalid, please re-enter: ");
            break;
          } 
		  else 
		  {
            arr[i] = Double.parseDouble(e);
          }
        }
        
        if (allNumeric)
          valid = true;
      } 
	  else 
	  {
        putln("Invalid, please re-enter: ");
      }
    } 
	while (!valid);
    
    return arr;
  }  

  /**
   * A method to test the functions using some test data
   */
  private static void selfTest() 
  {
    int[] a = {-1, 0, 1, -2, 2};
    int c = countNegative(a);
    int ct = 2;
    System.out.printf("countNegative(%s) = %d (expecting %d)%n",java.util.Arrays.toString(a), c, ct);
    assert(c == ct);
    
    int m = min(a);
    int mt = -2;
    System.out.printf("min(%s) = %d (expecting %d)%n", java.util.Arrays.toString(a), m, mt);
    assert(m == mt);
    
    boolean b = isAscSort(a);
    boolean bt = false;
    System.out.printf("isAscSort(%s) = %b (expecting %b)%n", java.util.Arrays.toString(a), b, bt);
    assert(b == bt);
    
    char[] arr = {'h', 'e', 'l', 'l', 'o', '\u0000', 'w'};
    int l = length(arr);
    int lt = 5;
    System.out.printf("length(%s) = %d (expecting %d)%n", java.util.Arrays.toString(arr), l, lt);
    assert(l == lt);

    double[][] darrs = 
	{
        {1d}, //
        {2d, 1d}, //
        {1d, 3d, 2d}, // 
        {4d, 1d, 2d, 3d}, // 
        {100d, 5d, 11d, 1d}, // 
        {5d, 1d, 3d, 2d, 4d}, // 
    };
    
    double[] mts = 
	{
        1d, 1d, 2d, 2d, 5d, 3d
    };
    
    int index=0;
    double e,et;
    for (double[] darr : darrs) 
	{
      e = median(darr);
      et = mts[index++];
      System.out.printf("median(%s) = %f (expecting %f)%n", java.util.Arrays.toString(darr), e, et);
      assert(e == et);
    }
    
    double[] a1 = {-1,-2,3};
    double[] a2 = {1,2,4};
    int p = compare(a1,a2);
    int pt = -2;
    System.out.printf("compare(%s,%s) = %d (expecting %d)%n", java.util.Arrays.toString(a1), 
        java.util.Arrays.toString(a2), p, pt);
    assert(p == pt); 
    
    double[] ar = {1,1,2,3,4,3,5,2};
    
    int[] freq = freq(ar);
    System.out.printf("freq(%s)=%s%n", java.util.Arrays.toString(ar), java.util.Arrays.toString(freq));
  }
}

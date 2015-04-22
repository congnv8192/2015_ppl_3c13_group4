package week45.implement;

import static week45.implement.TextIO.*;

public class Math 
{

  /**
   * Determine the remainder after integer division using only subtraction.
   * Ignore the possibility of division by zero.
   * 
   * @requires y != 0 /\ (x = 0 \/ |x| >= |y|)
   * @effects
   *          return r. (int: r /\
   *          (0 <= |r| < y) /\
   *          exists int: z. (x = yz + r))
   */
  public static int remainder(int x, int y) 
  {
    int dxy = x - y; 
    if (x == 0) 
	{ 
      return 0;
    } 
	else if (dxy >= 0 && dxy < y) 
	{  
      return dxy;
    } 
	else 
	{
      if (dxy >= y && y > 0) 
	  { 
        return remainder(x - y, y);
      } 
	  else if (x <= y && y < 0) 
	  { 
        return remainder(-x, -y);
      } 
	  else if (x > 0 && 0 > y) 
	  { 
        return remainder(x, -y);
      } 
	  else 
	  { 
        return -remainder(-x, y);
      }
    }
  }

  /**
   * Determine the integer division using only addition and subtraction.
   * Ignore division by zero.
   * 
   * @requires y != 0
   * @effects
   *          if |x| < |y|
   *            return 0
   *          else
   *            return int: z. (0 <= |x|-|zy| < |y|)
   */
  public static int div(int x, int y) 
  {
    if (java.lang.Math.abs(x) < java.lang.Math.abs(y)) 
	{
      return 0;
    } 
	else if (x <= y && y < 0) 
	{
      int xminus = 0 - x, yminus = 0 - y;
      return div(xminus, yminus);
    } 
	else if (x > 0 && y < 0) 
	{
      int yminus = 0 - y;
      int d = div(x, yminus);
      return 0 - d; 
    } 
	else if (x < 0 && y > 0) 
	{
      int xminus = 0 - x;
      int d = div(xminus, y);
      return 0 - d; 
    } 
	else 
	{ 
      int z = 1;
      int yz = y;
      int yz1;
      do 
	  {
        yz1 = yz + y;   
        if (yz1 > x) 
		{  
          return z;
        } 
		else 
		{        
          z++;          
          yz += y;      
        }
      } 
	  while (true);
    }
  }

  /**
   * Determine the middle one of three numbers.
   * 
   * @effects
   *          return m: (a <= m <= b for m,a,b. {m,a,b} = {x,y,z})
   */
  public static double middle(double x, double y, double z) 
  {
    double dxy = x - y;
    double dyz = y - z;
    double dzx = z - x;

    if (dxy * dyz >= 0)        
      return y;
    else if (dyz * dzx >= 0)  
      return z;
    else                       
      return x;
  }

  /**
   * Determine whether or not a string is a palindrom
   * (a palindrom reads the same backward and forward, e.g. deed)
   * 
   * @requires s not eq null /\ s.length > 0
   * @effects
   *          if s = s[s.length-1]...s[0], i.e. s is read the same backward and forward
   *          (e.g. deed)
   *            return true
   *          else
   *            return false
   */
  public static boolean isPalin(String s) 
  {
    s = s.toLowerCase();

    char[] chars = s.toCharArray();

    int j = chars.length - 1;
    for (int i = 0; i < j; i++) 
	{
      if (chars[i] != chars[j]) 
        return false;
      j--;            
    }
    return true;
  }

  /**
   * Determine if an integer is a prime.
   * 
   * @requires p >= 1
   * @effects
   *   if p is a prime, i.e. only 1 and p divide p
   *    return true
   *   else
   *    return false
   * @pseudocode
   *  if p <= 2 
   *    return true
   *    
   *  for each multiple m of a number n (2 <= n < p)
   *    if p = m
   *      return false
   *  return true
   */
  public static boolean isPrime(int p) 
  {
    if (p <= 2)
      return true;
    
    // p > 2
    int n, m;
    n = 2;
    while (n < p) 
	{
      for (int i = 1;; i++) 
	  {
        m = i * n;   
        if (p == m)  
          return false;
        else if (p < m) 
		{
          break;
        }
      }
      n++;   
    }
    return true;
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
        {"[1]", "Determine the remainder of an integer division"},
        {"[2]", "Determine the integer division"},
        {"[3]", "Determine the middle one of three numbers"}, 
        {"[4]", "Determine if a string is read the same backward and forward"}, 
        {"[5]", "Determine if an integer is a prime"},
        {"",""},
        {"[Q]uit", "Quit the program"}
    };
    
    final char[] allowedInput = {'1', '2', '3', '4', '5', 'q', 'Q'};
    char c;
    
    do 
	{
      Menu.display(menuItems);
      c = Menu.prompt(allowedInput);
      
      switch (c) 
	  {
        case '1':
          int[] data = getlnIntegers(2);
          int n1 = data[0], n2 = data[1];
          int r = remainder(n1, n2);
          putf("remainder(%d,%d) = %d%n", n1, n2, r);
          break;
        case '2': 
          data = getlnIntegers(2);
          n1 = data[0]; n2 = data[1];
          r = div(n1, n2);
          putf("div(%d,%d) = %d%n", n1, n2, r);
          break;
        case '3': 
          double[] ddata = getlnDoubles(3);
          double d1 = ddata[0], d2 = ddata[1], d3 = ddata[2];
          double dr = middle(d1, d2, d3);
          putf("middle(%f, %f, %f) = %f%n", d1, d2, d3, dr);
          break;
        case '4':
          String sdata = getString();
          boolean br = isPalin(sdata);
          putf("isPalin(%s) = %b%n", sdata, br);
          break;
        case '5':
          int i = getInteger();
          br = isPrime(i);
          putf("isPrime(%d) = %b%n", i, br);
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
   *    prompt the user to enter count number of integers
   *  while input is not valid
   *  return the integers as int[] array
   */
  public static int[] getlnIntegers(int count) 
  {
    boolean valid = false, allNumeric;
    int[] arr = null;
    String s, e;
    String[] els;
    
    putf("Enter %d integers (separated by ';'), e.g. 1;2;3%n", count);
    do 
	{ 
      s = getln();
      s = s.trim();
      if (!s.equals("") && s.indexOf(";") > -1) 
	  {
        els = s.split(";");
        if (els.length != count) 
		{
          putln("Invalid, please re-enter:");
        } 
		else 
		{
          arr = new int[count];
          allNumeric = true;
          for (int i = 0; i < els.length; i++) 
		  {
            e = els[i].trim();
            if (!isNumberString(e, false)) 
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
   *    prompt the user to enter count number of real numbers
   *  while input is not valid
   *  return the real numbers as double[] array
   */
  public static double[] getlnDoubles(int count) 
  {
    boolean valid = false, allNumeric;
    double[] arr = null;
    String s, e;
    String[] els;
    
    putf("Enter %d doubles (separated by ';'), e.g. 1;2.1;3.5%n", count);
    do 
	{ 
      s = getln();
      s = s.trim();
      if (!s.equals("") && s.indexOf(";") > -1) 
	  {
        els = s.split(";");
        if (els.length != count) 
		{
          putln("Invalid, please re-enter:");
        } 
		else 
		{
          arr = new double[count];
          allNumeric = true;
          for (int i = 0; i < els.length; i++) 
		  {
            e = els[i].trim();
            if (!isNumberString(e, true)) 
			{
              // invalid
              allNumeric = false;
              putln("Invalid, please re-enter:");
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
   *    prompt user to enter a string
   *  while input string is empty
   *  
   *  return input string
   */
  private static String getString() 
  {
    String s = null;
    do 
	{
      putln("Enter a string");
      s = getln();
      s = s.trim();
    } 
	while (s.equals(""));
    
    return s;
  }

  /**
   * @effects 
   *  prompt the user to enter an integer
   *  return the input number
   */
  private static int getInteger() 
  {
    int i;
    putln("Enter an integer");
    i = getlnInt();
    
    return i;
  }

  /**
   * A self-test method
   */
  public static void selfTest(String[] args) 
  {
    int x =10, y = 5;
    int d = div(x, y);
    int dt = x/y;
    System.out.printf("div(%d,%d)=%d (expecting %d)%n",x,y,d,dt);
    assert(dt == d);

  }
  
    /** 
   * Determine if a string is a number string
   * @requires
   *  s != null 
   * @effects 
   *  if s contains only digits or the character '.' if real=true
   *    return true
   *  else
   *    return false
   */
  public static boolean isNumberString(String s, boolean real) 
  {
    char[] chars = s.toCharArray();
    
    int len = chars.length;
    char c;
    for (int i = 0; i < len; i++) 
	{
      c = chars[i];
      if (!Character.isDigit(c) && 
             (real && Character.compare(c, '.') != 0))
      {
        return false;
      }
    }
    
    return true;
  }
}

package week45.design;

import static week45.design.TextIO.getln;
import static week45.design.TextIO.getlnInt;
import static week45.design.TextIO.putf;
import static week45.design.TextIO.putln;
import week45.implement.Arrays;

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

  /**
   * Determine the middle one of three numbers.
   * 
   * @effects
   *          return m: (a <= m <= b for m,a,b. {m,a,b} = {x,y,z})
   */
  public static double middle(double x, double y, double z)

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
  
  /**
   * @effects
   *  do
   *    prompt the user to enter count number of integers
   *  while input is not valid
   *  return the integers as int[] array
   */
  public static int[] getlnIntegers(int count)

  /**
   * @effects
   *  do
   *    prompt the user to enter count number of real numbers
   *  while input is not valid
   *  return the real numbers as double[] array
   */
  public static double[] getlnDoubles(int count)
  

  /**
   * @effects 
   *  do 
   *    prompt user to enter a string
   *  while input string is empty
   *  
   *  return input string
   */
  private static String getString()

  /**
   * @effects 
   *  prompt the user to enter an integer
   *  return the input number
   */
  private static int getInteger()  
  
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
}

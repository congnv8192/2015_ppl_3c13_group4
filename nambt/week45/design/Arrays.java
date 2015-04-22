package week45.design;

import static week45.design.TextIO.getln;
import static week45.design.TextIO.putln;

public class Arrays 
{

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
  
  /**
   * Determine the minimum element of an array of integers.
   * 
   * @requires a neq null /\ a.length > 0
   * @effects return x in a: (for all y. y in a -> y >= x), 
   *  e.g. min([2,1,3]) = 1
   */
  public static int min(int[] a)
  
  /**
   * Determine whether an array of integers is in ascending order.
   * 
   * @requires a neq null /\ a.length > 1
   * @effects 
   *  if for all nat: i,j. (i <= j < a.length -> a[i] <= a[j])
   *    return true
   *  else 
   *    return false
   *  
   *  e.g.  
   */
  public static boolean isAscSort(int[] a)
  
  /**
   * Determine the length of a array of characters on the understanding that if
   * it contains the character NUL (the character '\u0000' in Java) 
   * then that and any characters after it are not to be counted
   * 
   * @requires a neq null /\ a.length > 0 /\ a[0] neq NUL
   * @effects
   *  if exists k: (for all 0 <= i < k. a[i] neq NUL /\ a[k] = NUL)
   *    return k
   *  else 
   *    return a.length
   */
  public static int length(char[] a)
  
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
  
  /**
   * Compute the frequencies of each element of an array of reals.
   * 
   * @requires a not eq null /\ a.length > 0
   * @effects 
   *  return [f0,...,fk]: k = a.length-1 /\ 
   *    fi = |{x | x in a /\ x = a[i]}| for all 0 <= i <= k
   */
  public static int[] freq(double[] a)
  
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
   *    prompt the user to enter an integer array
   *  while input is not valid
   *  return the integer array
   */
  public static int[] getlnIntArray()
  
  /**
   * @effects
   *  do
   *    prompt the user to enter a character array
   *  while input is not valid
   *  return the character array
   */
  public static char[] getlnCharArray()
  
  /**
   * @effects
   *  do
   *    prompt the user to enter a double array
   *  while input is not valid
   *  return the double array
   */
  public static double[] getlnDoubleArray()  

}

package week45.implement;

import static week45.implement.TextIO.*;

public class Menu 
{
  
  /**
   * @requires 
   *  menuItems != null /\ menuItems.length > 0 /\ 
   *  menuItems[i].length=2 (for all i < menuItems.length)
   *  
   * @effects
   *  for each tuple <i,d> in menuItems
   *    display i, d st i and d are left-justified on two columns  
   */
  public static void display(String[][] menuItems) 
  {
    if (menuItems == null || menuItems.length == 0) 
	{
      System.err.printf("Invalid input");
      return;
    }
    
    String item, desc;
    int col1Length = 0;
    for (String[] tuple : menuItems) 
	{
      if (tuple.length != 2) 
	  {
        System.err.printf("Invalid input");
        return;
      }
      
      item = tuple[0];
      if (item.length() > col1Length)
        col1Length = item.length();
    }

    // display
    String formatString = "%-"+col1Length+"s:  %s%n";
    
    for (String[] tuple : menuItems) 
	{
      item = tuple[0];
      desc = tuple[1];
      putf(formatString, item, desc);
    }
  }
  
  /**
   * @requires allowed != null /\ allowed.length > 0
   * @effects
   *  do 
   *    prompt the user to enter a valid character in allowed
   *  while input character is not valid
   *  
   *  return the input character
   */
  public static char prompt(char[] allowed) 
  {
    if (allowed == null || allowed.length == 0) 
	{
      System.err.printf("Invalid input");
      return '\u0000';
    }
    
    boolean validChar = false;
    char c;
    do 
	{
      putln("Please select: ");
      c = getlnChar();
      
      for (int i = 0; i < allowed.length; i++) 
	  {
        if (c == allowed[i]) 
		{
          validChar = true;
          break;
        }
      }

    } while (!validChar);
    
    return c;
  }
}

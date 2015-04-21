package week3;

/*  This program evaluates simple expressions such as 2 + 2
       and 34.2 * 7.81, consisting of a number, an operator,
       and another number.  The operators +, -, *, / are allowed.
       The program will read and evaluate expressions until
       the user inputs a line that starts with the number 0.
   */
  
public class Ex33
{
    public static void main(String[] args) {
        double firstNum;    // First number in the expression.
        double secondNum;   // Second number in the expression.
        char operator;      // The operator in the expression.
        double value;       // The value of the expression.
        
        TextIO.putln("Enter expressions such as  2 + 2  or  34.2 * 7.81");
        TextIO.putln("using any of the operators +, -, *, /.");
        TextIO.putln("To end, enter a 0.");
        TextIO.putln();
        
        while (true) {
            /* Get user's input, ending program if first number is 0. */
            
            TextIO.put("? ");
            firstNum = TextIO.getDouble();
            if (firstNum == 0)
            break;
            
            operator = TextIO.getChar();
            secondNum = TextIO.getlnDouble();
          
          /* Compute the value of the expression. */
          
          switch (operator) {
              case '+':
              value = firstNum + secondNum;
                 break;
              case '-':
              value = firstNum - secondNum;
                 break;
              case '*':
              value = firstNum * secondNum;
                 break;
              case '/':
              value = firstNum / secondNum;
                 break;
              default:
              TextIO.putln("Unknown operator: " + operator);
              continue;  // Back to start of loop!
          } // end switch
          
          /* Display the value. */
          
          TextIO.putln("Value is " + value);
          TextIO.putln();
                    
      } // end while
      
      TextIO.putln("Good bye");
   
   }  // end main()

}  // end class SimpleCalculator
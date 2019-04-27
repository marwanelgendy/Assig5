package eg.edu.alexu.csd.datastructure.stack.cs65;

public class ExpressionEvaluator {
    public String infixToPostfix(String expression)
    {
        ImpStack Stack=new ImpStack();
        String result=new String();
        String finalresult=new String();
        for (int i=0;i<expression.length();i++)
        {
            if (expression.charAt(i)==' ')
                continue;
            else if ((int)expression.charAt(i)>=48&&(int)expression.charAt(i)<=58)
            {
                    result += expression.charAt(i);
            }
            else
            {
                result+=" ";
                if (Stack.isEmpty())
                    Stack.push(expression.charAt(i));
                else if(expression.charAt(i)=='(')
                {
                    Stack.push(expression.charAt(i));
                }
                else if (expression.charAt(i)=='/')
                {
                   while (true)
                   {
                       if (Stack.isEmpty())
                           break;
                       else if ((char)Stack.peek()=='+'||(char)Stack.peek()=='-')
                       {
                           break;
                       }
                       else if ((char)Stack.peek()=='*'||(char)Stack.peek()=='/')
                         result+=(char)Stack.pop()+" ";
                       else if((char)Stack.peek()=='(')
                           break;

                   }
                    Stack.push(expression.charAt(i));
                }
                else if (expression.charAt(i)=='*')
                {
                    while (true)
                    {
                        if (Stack.isEmpty())
                            break;
                        else if ((char)Stack.peek()=='+'||(char)Stack.peek()=='-')
                        {
                            break;
                        }
                        else if ((char)Stack.peek()=='*'||(char)Stack.peek()=='/')
                            result+=(char)Stack.pop()+" ";
                        else if((char)Stack.peek()=='(')
                            break;
                    }
                    Stack.push(expression.charAt(i));
                }
                else if (expression.charAt(i)=='+')
                {
                    while (true)
                    {
                        if (Stack.isEmpty())
                        {
                            break;
                        }
                        else if((char)Stack.peek()=='(')
                            break;
                        else
                            result+=(char)Stack.pop()+" ";
                    }
                    Stack.push(expression.charAt(i));
                }
                else if (expression.charAt(i)=='-')
                {
                    while (true)
                    {
                        if (Stack.isEmpty())
                        {
                            break;
                        }
                        else if((char)Stack.peek()=='(')
                            break;
                        else
                            result+=(char)Stack.pop()+" ";
                    }
                    Stack.push(expression.charAt(i));
                }
                else if (expression.charAt(i)==')')
                {
                    while (true) {
                        if ((char) Stack.peek() == '(') {
                            Stack.pop();
                            break;
                        }
                        result += (char) Stack.pop();
                    }
                }
            }
        }
        while (!Stack.isEmpty())
            result+=(char)Stack.pop()+" ";
        for (int i=0;i<result.length();i++)
        {
            if (result.charAt(i)==' ')
                continue;
            finalresult+=result.charAt(i)+" ";
        }
        return finalresult;
    }
   public int evaluate(String expression)
   {
       ImpStack Stack=new ImpStack();
       double result=0;
       double s1,s2,temp=0;
       int i=0;
       while (i<expression.length())
       {
           if (expression.charAt(i)==' ')
           {
               i++;
               continue;
           }
           while ((int)expression.charAt(i)>=48&&(int)expression.charAt(i)<=58)
           {
               temp+=(double)((int)expression.charAt(i)-48);
               if ((int)expression.charAt(i+1)<48||(int)expression.charAt(i+1)>58)
                   break;
               temp*=10;
               i++;
           }
           if (expression.charAt(i)!='/'&&expression.charAt(i)!='*'&&expression.charAt(i)!='+'&&expression.charAt(i)!='-')
             Stack.push(temp);

           if (expression.charAt(i)=='/')
               {
                   s1=(double)Stack.pop();
                   s2=(double)Stack.pop();
                   result=s2/s1 ;
                   Stack.push(result);
               }
           else if (expression.charAt(i)=='*')
               {
                   s1=(double)Stack.pop();
                   s2=(double)Stack.pop();
                   result=s2*s1 ;
                   Stack.push(result);
               }
           else if (expression.charAt(i)=='+')
               {
                   s1=(double)Stack.pop();
                   s2=(double)Stack.pop();
                   result=s2+s1 ;
                   Stack.push(result);
               }
           else if (expression.charAt(i)=='-')
               {
                   s1=(double)Stack.pop();
                   s2=(double)Stack.pop();
                   result=s2-s1 ;
                   Stack.push(result);
               }
            i++;
           temp=0;
       }
       int finalres=(int)result;
       return finalres;
   }
}
interface IExpressionEvaluator
{
    /**
     * Takes a symbolic/numeric infix expression as input and converts it to
     * postfix notation. There is no assumption on spaces between terms or the
     * length of the term
     *
     * @param expression infix expression.
     *
     * @return postfix expression.
     */
    String infixToPostfix(String expression);

    /**
     * Evaluate a postfix numeric expression, with a single space separator.
     *
     * @param expression postfix expression.
     *
     * @return the expression evaluated value.
     */
    int evaluate(String expression);
}
package com.razergene.datastructalgo.stack;

import java.util.Stack;


public class BracketMatch
{
    public static void main(String[] args)
    {
        String str = "{{{a+b}}}(())";
        char[] c = str.toCharArray();
        if (isMatch(c))
        {
            System.out.println("匹配");
        } else
            System.out.println("不匹配");
    }

    
    public static boolean isMatch(char[] c)
    {
        Stack<Character> stack = new Stack<Character>();
        int length = c.length;
        char temp;
        boolean b = true;
        
        for (int i = 0; i < length; i++)
        {
            temp = c[i];
            if (temp == '{' || temp == '[' || temp == '(')
                //碰到开放括号时，就进栈。  
                stack.push(temp);
            
            if (temp == '}' || temp == ']' || temp == ')')
            {
                //碰到闭合括号时，就分情况判断  
                //如果栈已为空，那么肯定是不匹配的了。  
                if (stack.isEmpty())
                {
                    b = false;
                    break;
                } 
                else
                {
                    //如果不为空，则判断栈顶的括号是不是与现有的括号匹配  
                    //是则将栈顶元素做出栈操作,否则肯定又是不匹配。  
                    if ((temp == '}' && stack.peek() == '{') ||
                    	(temp == ']' && stack.peek() == '[') ||
                        (temp == ')' && stack.peek() == '('))
                    {
                        stack.pop();
                    } 
                    else
                    {
                        b = false;
                        break;
                    }
                }
            }
        }

        //当所有闭合括号都匹配完时，如果栈不为空，那么就表示还有开放括号没有匹配。  
        if (!stack.isEmpty())
        {
            return b;
        }
        return b;
    }

}

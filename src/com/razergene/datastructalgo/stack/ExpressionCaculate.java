package com.razergene.datastructalgo.stack;

import java.util.Stack;
import java.util.regex.Pattern;

public class ExpressionCaculate
{
	//中缀表达式转换为后缀表达式：
	//（1）读到数字直接输出到队列中
	//（2）读到运算符t时：如果t的优先级高于栈顶运算符，则进栈；
	//如果t的优先级低于栈顶运算符，从栈顶开始，依次弹出比当前处理的运算符优先级高的运算符，直到一个比它优先级低的或者遇到了一个左括号就停止。
	//（3）读到 ( 时总是将它压入栈中。
	//（4）读到 ) 时将靠近栈顶的第一个 ( 上面的运算符全部依次弹出到输出队列后，再丢弃左括号。
	//（5）中缀表达式全部读完后，若栈中仍有运算符，将其送到输出队列中。
	public static String infixToSuffix(String infix)
	{
		Stack<Character> stack = new Stack<>();
		String suffix = "";
		int length = infix.length();
		for(int i=0; i<length; i++)
		{
			Character temp;//用来接收栈的弹出元素
			char c = infix.charAt(i);
			switch (c)
			{
			case ' ':
				break;
				
			case '(':
				stack.push(c);
				break;
				
			//+-的优先级最低，遇到时把比+-优先级高的元素都弹出来。
			//再把当前符号(+-)加到栈中。
			case '+':
			case '-':
				while(stack.size() != 0)
				{
					temp = stack.pop();
					if(temp == '(')
					{
						stack.push('(');
						break;
					}
					suffix += " " + temp;
				}
				stack.push(c);
				suffix += " ";
				break;
				
			//如果是(+-，则把*/入栈，如果是*/则把栈中的*/弹出栈到输出队列中。
			case '*':
			case '/':
				while(stack.size() != 0)
				{
					temp = stack.pop();
					if(temp == '(' || temp == '+' || temp == '-')
					{
						stack.push(temp);
						break;
					}
					else 
					{
						suffix += "" + temp;
					}
				}
				stack.push(c);
				suffix += "";
				break;
				
			case ')':
				while(stack.size() != 0)
				{
					temp = stack.pop();
					if(temp == '(')
					{
						break;
					}
					else 
					{
						suffix += "" + temp;
					}
				}
				break;

			default:
				suffix += c;
				break;
			}
		}
		
		while(stack.size() != 0)
		{
			suffix += "" + stack.pop();
		}
		return suffix;
	}
	
	
	
	//计算后缀表达式：
	//（1）建立一个栈S，从左到右读入后缀表达式，读到数字就将它转换为数值压入S中
	//（2）读到运算符则从栈中依次弹出两个数分别到Y和X上，然后以X 运算符 Y 的形式计算出结果，再压入S中。
	//（3）如果后缀表达式未读完，就重复上面过程，最后输出栈顶数值结束。
	public static double suffixToArithmetic(String postfix)
	{
		Pattern pattern = Pattern.compile("\\d+||(\\d+\\.\\d+)"); //使用正则表达式 匹配数字
		String strings[] = postfix.split(" ");  //将字符串转化为字符串数组
		for (int i = 0; i < strings.length; i++)
		{
			strings[i].trim();//去掉字符串首尾的空格
		}
		
		Stack<Double> stack = new Stack<Double>();
		for(int i=0; i<strings.length; i++)
		{
			if(strings[i].equals(""))
				continue;
			
			//如果是数字，则进栈
			if ((pattern.matcher(strings[i])).matches())
			{
				stack.push(Double.parseDouble(strings[i]));
			}
			//如果是运算符，弹出运算数，计算结果。
			else 
			{
				double y = stack.pop();
				double x = stack.pop();
				stack.push(caculate(x, y, strings[i])); //将运算结果重新压入栈。
			}
		}
		
		return stack.pop(); //弹出栈顶元素就是运算最终结果。
	}
	
	
	
	private static double caculate(double x, double y, String simble)
    {
        if (simble.trim().equals("+"))
            return x + y;
        if (simble.trim().equals("-"))
            return x - y;
        if (simble.trim().equals("*"))
            return x * y;
        if (simble.trim().equals("/"))
            return x / y;
        return 0;
    }
	
	
	
	public static void main(String[] args)
	{
		String str = "3+(2-5)*6/3";  //其后缀表达式为325-6*3/+
		
		//调用方法：中缀表达式转成后缀表达式
		System.out.println(ExpressionCaculate.infixToSuffix(str));
		
		//调用方法：给出一个算术表达式（中缀表达式），得到计算结果
		System.out.println(ExpressionCaculate.suffixToArithmetic(str));
	}
	
	
	
	
	
	
	
	
	
}

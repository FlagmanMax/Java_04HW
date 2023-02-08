// В калькулятор добавьте возможность отменить последнюю операцию.

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class HW_04_03 
{  
   public static void main(String[] args) 
    {
        System.out.println("Вас приветствует калькулятор!");
        System.out.println("Сначала введите пример в формате 'X x Y'");
        System.out.println("Затем в формате 'x Y'. x - это операция +,-,/,*");
        System.out.println("Можно отменить последнюю операцию командой 'Отмена'");
        System.out.println("Для окончания работы введите 'Выход'\n");
        
        // 0.0: INIT
        Stack<Integer> stackResult = new Stack<>();
        Stack<String> operation = new Stack<>();
        Scanner scan = new Scanner(System.in, "CP866");
        int X,Y;
        int res = 0;
        String string_to_parse;
        String[] string_arr;

        // 0.1: 1st equation input in form "X * Y"
        System.out.print("> ");
        string_to_parse = scan.nextLine();
        
        // 0.2: Parse 1st equation
        string_arr = string_to_parse.split(" ",-1);
        X =  Integer.parseInt(string_arr[0]);
        Y =  Integer.parseInt(string_arr[2]);

        // 0.3: Solve 1st equation
        if (string_arr[1].charAt(0) == '+') {
            res =  X+Y;
        } else if (string_arr[1].charAt(0) == '-') {
            res =  X-Y;
        } else if (string_arr[1].charAt(0) == '/') {
            res =  X/Y;
        } else if (string_arr[1].charAt(0) == '*') {
            res =  X*Y;
        } else
        {
            System.out.println("Some error\n");
            scan.close();
            return;
        }
        
        // 0.4: Push to stack 1st result and equation
        //stackResult.push(String.valueOf(res));
        stackResult.push(0);
        operation.push(string_to_parse);

        // 0.5: Print answer
        System.out.printf("Ответ: %d\n",res);

        while(true)
        {
            // N.1: 1st equation input in form "* Y"
            System.out.print("> ");
            string_to_parse = scan.nextLine();

            if (string_to_parse.equalsIgnoreCase("Отмена"))
            {
                if (!stackResult.empty())
                {
                    res = stackResult.pop();
                    System.out.printf("Отменена операции '%s'\n",operation.pop());
                }
                else
                {
                    System.out.println("Отмена не возможна!\n");
                }
            }
            else if (string_to_parse.equalsIgnoreCase("Выход"))
            {
                System.out.println("Выход из программы!\n");
                break;
            }
            else
            {
                // N.2: Parse N-th equation
                string_arr = string_to_parse.split(" ",-1);
                Y =  Integer.parseInt(string_arr[1]);

                // N.3: Push to stack N-th result and equation
                stackResult.push(res);
                operation.push(string_to_parse);

                // N.4: Solve N-th equation
                if (string_arr[0].charAt(0) == '+') {
                    res += Y;
                } else if (string_arr[0].charAt(0) == '-') {
                    res -= Y;
                } else if (string_arr[0].charAt(0) == '/') {
                    res /=  Y;
                } else if (string_arr[0].charAt(0) == '*') {
                    res *=  Y;
                } else{
                    System.out.println("Some error\n");
                    continue;
                }

            }

            // N.5: Print answer
            System.out.printf("Ответ: %d\n",res);
        }

        scan.close();
    }
}


// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.


import java.util.LinkedList;
import java.util.Scanner;

public class HW_04_02
{
    public static void main(String[] args) 
    {
        System.out.println("Реализуйте очередь, используя следующие методы в формате 'номер}значение' или 'номер' Описание методов:");
        System.out.println("\t1} помещает элемент в конец очереди;");
        System.out.println("\t2} возвращает первый элемент из очереди и удаляет его;");
        System.out.println("\t3} возвращает первый элемент из очереди, не удаляя;");
        System.out.println("\t4} печать очереди;");
        System.out.println("\t5} выход из программы.");
        

        
        LinkedList<Integer> LinkedList = new LinkedList<>();
        
        Scanner scan = new Scanner(System.in, "CP866");
        
        String string_to_parse;
        String[] string_arr;
        int val;
        int checkValue = 0;

        while(checkValue != 5)
        {
            System.out.printf("> ");
            string_to_parse = scan.nextLine();
            string_arr = string_to_parse.split("}");

            checkValue = Integer.parseInt(string_arr[0]);
            switch (checkValue)
            {
                case 1:     // add value to the end
                    enqueue(LinkedList,Integer.parseInt(string_arr[1]));
                    break;
                case 2:     // get the first value and remove it 
                    val = dequeue(LinkedList);
                    System.out.printf("значение первого элемента = %d\n",val);
                    break;
                case 3:     // get the first value
                    val = first(LinkedList);
                    System.out.printf("значение первого элемента = %d\n",val);
                    break;
                case 4:     // print list
                    printLinkedList(LinkedList);
                    break;
                case 5:     // exit
                    System.out.printf("выход из программы\n");
                    break;
                default:    // wrong value
                    System.out.printf("ошибка ввода. Попробуйте еще раз!\n");
                    break;      
            }
        }
        scan.close();
    }  
    public static void enqueue(LinkedList<Integer> LinkedList, int val)
    {
        LinkedList.add(val);
    }
    public static int dequeue(LinkedList<Integer> LinkedList)
    {
        int value = LinkedList.getFirst();
        LinkedList.removeFirst();
        return value;
    }
    public static int first(LinkedList<Integer> LinkedList)
    {
        int value = LinkedList.getFirst();
        return value;
    }
    public static void printLinkedList(LinkedList<Integer> LinkedList)
    {
        System.out.println(LinkedList);
        return;
    }
}

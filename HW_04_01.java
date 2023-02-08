// Пусть дан LinkedList с несколькими элементами.
// Реализуйте метод(не void), который вернет “перевернутый” список.

import java.util.LinkedList;
import java.util.Scanner;

public class HW_04_01 {
    public static void main(String[] args) 
    {
        LinkedList<Integer> LinkedList = new LinkedList<>();
        LinkedList<Integer> LinkedListR = new LinkedList<>();

        System.out.print("Введите длину списка: \n> ");
        Scanner scan = new Scanner(System.in, "CP866");

        Integer len = scan.nextInt();
        for (int i=0;i<len; i++)
        {
            LinkedList.add(i,i);
        }

        scan.close();
        
        System.out.print("Исходный список:\t");
        System.out.println(LinkedList);

        LinkedListR = reverse(LinkedList);
        System.out.print("Перевернутый список:\t");
        System.out.println(LinkedListR);

    }
    public static LinkedList<Integer> reverse(LinkedList<Integer> LinkedList)
    {
        LinkedList<Integer> LinkedListLocal = new LinkedList<>();
        
        Integer len = LinkedList.size();
        for (int i=0;i<len;i++)
        {
            LinkedListLocal.add(i,LinkedList.get(len-i-1) );
        }

        return LinkedListLocal;
    }
}

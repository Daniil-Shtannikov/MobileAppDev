import java.util.*;
import java.lang.*;
import java.io.*;

public class main {

    public static void main (String[] args) throws java.lang.Exception {
//Задача 1: Четное или нечетное число
        Scanner scanner = new Scanner(System.in);
        /*System.out.print("Input a number: ");
        int num = scanner.nextInt();

        if(num%2==0){
            System.out.println("Четное");
        }
        else{
            System.out.println("Нечётное");
        }
//Задача 2: Минимальное из трех чисел
        System.out.print("Input a 3 numbers: ");
        int nums[]=new int[3];
        for(int i = 0; i < nums.length; i++)
        {
            nums[i]= scanner.nextInt();
        }
        int min = Arrays.stream(nums).min().getAsInt();
        System.out.println("min: "+min);

//Задача 3: Таблица умножения
        int nums[]=new int[11];
        for(int i = 1; i < nums.length; i++)
        {
            nums[i]= i * 5;
            System.out.println(nums[i]);
        }
//Задача 4: Сумма чисел от 1 до N

        System.out.println("Введите число: ");
        int N = scanner.nextInt();
        int Sum= 0;

        for(int i = 0; i <= N; i++)
        {
            Sum += i;
        }
        System.out.println("Сумма чисел= " + Sum);

//Задача 5: Число Фибоначчи
        int a = 0, b = 1, i = 0;
        System.out.println("Введите число: ");
        int N = scanner.nextInt();
        while(i < N)
        {
            System.out.print(a + " ");
            int c = a+b;
            a = b;
            b = c;
            i++;
        }

//Задача 6: Проверка простого числа
        System.out.println("Введите число: ");
        int N = scanner.nextInt();
        boolean prost = true;
        for(int i=2; i <= N/2; i++)
        {
            if (N%i == 0)
            {
                prost = false;
                break;
            }
        }
        if (prost)
        {
            System.out.println("Число простое");
        }
        else
        {
            System.out.println("Число не простое");
        }

//Задача 7: Обратный порядок чисел

        System.out.println("Введите число: ");
        int N = scanner.nextInt();
        while(N >= 1)
        {
            System.out.println(N);
            N--;
        }

//Задача 8: Сумма четных чисел
        System.out.println("Введите первое число: ");
        int A = scanner.nextInt();
        System.out.println("Введите второе число: ");
        int B = scanner.nextInt();
        int Sum=0;
        for (; A <= B ;A++ )
        {
            if(A%2==0){
                Sum+=A;
            }
            else{
                continue;
            }
        }
        System.out.println("Сумма четных чисел в промежутке= "+Sum);

//Задача 9: Реверс строки
        System.out.println("Введите строку: ");
        String str = scanner.nextLine();

        StringBuffer strBuffer = new StringBuffer(str);
        strBuffer.reverse();
        System.out.println("Перевернутая строка: "+strBuffer.toString());

//Задача 10: Количество цифр в числе

        System.out.println("Введите число: ");
        int N = scanner.nextInt();
        int count=0;
        while(N>0)
        {
            count++;
            N= N/10;
        }
        System.out.println(count+" цифр");*/

    }
}

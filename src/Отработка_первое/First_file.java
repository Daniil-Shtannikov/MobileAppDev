package Отработка_первое;

public class First_file{
   /* static int factorial(int x){
        if (x <= 1){
            return 1;
        }
        return x * factorial(x - 1);
    }
    static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String rev = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            rev = rev + s.charAt(i);
        }
        return s.equals(rev);
    }
    public static void count(String str)
	{
        int vowCount = 0, conCount = 0;
        for (int i = 0; i < str.length(); i++)
        {
          if ("aeiou".indexOf(str.charAt(i)) != -1)
          {
            vowCount++;
          }
          else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
          {
            conCount++;
          }
        }
        System.out.println("Гласных: " + vowCount);
        System.out.println("Согласных: " + conCount);
	}
   static void Armstrong(int N)
   {
       int mainN=N, count=0,Sum=0;
       Vector<Integer> nums = new Vector<Integer>();

       while(N>0)
       {
           count++;
           nums.add(N%10);
           N=N/10;
       }
       for (int i = 0; i < nums.size(); i++)
       {
           Sum += (int) Math.pow(nums.get(i),count);
       }
       if (Sum == mainN)
           System.out.println("Число Армстронга");
       else
           System.out.println("Не число Армстронга");
   }*/

    public void Main () {
//Задача 1: Четное или нечетное число
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number: ");
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
        System.out.println(count+" цифр");

//Задача 11: Факториал числа

        System.out.println("Введите число: ");
        int N = scanner.nextInt();
        System.out.println("Факториал числа= " + factorial(N));

//Задача 13: Палиндром

        System.out.println("Введите строку: ");
        String s = scanner.nextLine();

        if (isPalindrome(s)) {
            System.out.println("Палиндром");
        } else {
            System.out.println("Не палиндром");
        }

//Задачи 14, 15, 16

        System.out.println("Введите размер массива: ");
        int pos=0, neg=0, neu=0;
        int Sum=0, SIZE = scanner.nextInt();
        int[] nums =new int[SIZE];
        System.out.println("Введите элементы массива: ");
        for(int i = 0; i < SIZE; i++) {
            nums[i] = scanner.nextInt();
            Sum+=nums[i];
            if (nums[i]>0)
            {
                pos++;
            }
            else if (nums[i]<0)
            {
                neg++;
            }
            else
            {
                neu++;
            }
        }
        System.out.println("Максимальный элемент: " + Arrays.stream(nums).max().getAsInt() );
        System.out.println("Сумма элементов: " + Sum);

//Задача 17: Простые числа в диапазоне
    System.out.println("Введите нижнюю границу: ");
    int A = scanner.nextInt();
    System.out.println("Введите верхнюю границу: ");
    int B = scanner.nextInt();
    for (;A<=B ;A++){
        boolean prost = true;
        for(int i=2; i <= A/2; i++)
        {
            if (A%i == 0)
            {
                prost = false;
                break;
            }
        }
        if (prost)
        {
            System.out.println(A);
        }
        else
        {
            continue;
        }
    }

//Задача 18: Подсчет гласных и согласных в строке

    count(scanner.nextLine());

//Задача 19: Перестановка слов в строке

        System.out.println("Введите строку: ");
        String s[]= scanner.nextLine().split(" ");
        String rev = "";
        for (int i = s.length - 1; i >= 0; i--)
        {
            rev += s[i] + " ";
        }
        System.out.println("Строка с перестановкой:");
        System.out.println(rev);

//Задача 20: Число Армстронга

        int N = scanner.nextInt();
        System.out.println("Введите число: ");
        Armstrong(N);*/

    }
}




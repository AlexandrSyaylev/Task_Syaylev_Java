import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        //Составить алгоритм: если введенное число больше 7, то вывести “Привет”
        int inp = 0;
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\R");
        System.out.println("Введите число больше 7 (7 не входит) : ");
        if (sc.hasNextInt()) {
            inp = sc.nextInt();
            if(inp > 7){
                System.out.println("Привет");
            }
        } else {
            System.out.println("Извините, но это явно не число. Перезапустите программу и попробуйте снова!");
        }

        //Составить алгоритм: если введенное имя совпадает с Вячеслав, то вывести “Привет, Вячеслав”, если нет, то вывести "Нет такого имени"
        //Работает с учетом регистра, те вячеслав == "Нет такого имени", для поддерки регистра надо приводить к toLowerCase  сравнивать с "вячеслав", я решил что в условия задания это не входит
        String name ="" ;
        System.out.println("Введите Имя  (с учетом Регистра): ");
        if (sc.hasNext()) {
            name = sc.next();
            System.out.println(name);
        }
        if (name.equals("Вячеслав")) {
        System.out.println("Привет, " + name);

        } else {
            System.out.println("Нет такого имени");
        }

        //Составить алгоритм: на входе есть числовой массив, необходимо вывести элементы массива кратные 3
        //Решение расчитано на целые числа и не работает с дробями (типы float double вызывают исключение).
        // Для решения дробных чисел необходимо менять тип arr на Double, делать Double.parseDouble(s); либо ловить исключение и обрабатывать дробные числа отдельно в новом массиве и выводить отдельно (елси массив не пустой)
        String newString ="";
        System.out.println("Введите массив целых чисел с разделителем ',' : ");

        if (sc.hasNext()){
            //newString = sc.nextLine();
            newString = sc.next();
        }
        String [] arrStr = newString
                .replaceAll(" ","")
                .replaceAll("[a-zA-Zа-яА-Я_]","")
                .replaceAll("\\]","").replaceAll("\\[","")
                .replaceAll("[;!#$%&<>:|]",",")
                .split(",");
        int [] arr = new int[arrStr.length];
        int counterWrite=0;
        for ( int i=0; i < arr.length; i++){
            if (arrStr==null || arrStr.equals("")){
                System.out.println("Введенный массив пустой или не содержит целых чисел");
            }else {
                try{
                    arr[counterWrite] = Integer.valueOf(arrStr[i]);
                    counterWrite++;
                } catch (NumberFormatException e){
                    System.out.println("Введенный массив содержит символы, включая пробел, дробные числа или он не содержит чисел. допустим только массив целых чисел");
                }
            }
        }

        for (int i = 0; i < counterWrite; i++) {
            if (arr[i] % 3 == 0) {
                System.out.println(arr[i]);
            }
        }
        /*   1,2,3,4,5,6,7,8,9,10,11,10,21,77,33
        [1,2,3,4,5,6,7,8,9]
        [1,2,3,4,5t,6,7,8,9]
        [1,2,3,4,5,6t,7,8,9]
        [ 3, 6 , 9 ]
        1, 2, 5, 6 ,9t
        [1,2,-3,3,4,5,-6t,6,7,8,-9,ha-ha,0,27]
        парам пам, клю-клю, -сто, точка.99
        1,2,3.14,4
        */
    }

}

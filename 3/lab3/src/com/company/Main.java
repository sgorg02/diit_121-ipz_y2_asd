package com.company;

import java.util.Scanner;
/*Однозв’язний  кільцевий впорядкований список:
 -додавання
 -видалення за ключем з поверненням елементу
 -пошук за позицією від заданої
 -перегляд елементів*/
public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkList List = new LinkList();
        List.insertFirst("hi", "привет");
        List.insertFirst("drift", "дрифт");
        List.insertFirst("problem", "проблема");
        List.insertFirst("task", "задача");
        int menu_ = 0;
        do {
            Scanner menu = new Scanner(System.in);
            System.out.println("1.Додавання");
            System.out.println("2.Видалення за ключем");
            System.out.println("3.Пошук за позицією");
            System.out.println("4.Перегляд");
            System.out.println("5.Вихід");

            menu_ = menu.nextInt();
            switch (menu_) {
                case 1: {
                    String name, name2;
                    System.out.println("Введіть слово: ");
                    Scanner scannerStringName = new Scanner(System.in);
                    name = scannerStringName.nextLine();
                    System.out.println("Введіть переклад слово: ");
                    Scanner scannerStringName2 = new Scanner(System.in);
                    name2 = scannerStringName2.nextLine();
                    List.insertFirst(name, name2);
                    break;
                }
                case 2: {
                    String key_1;
                    System.out.println("Введіть слово: ");
                    Scanner scannerString_1 = new Scanner(System.in);
                    key_1 = scannerString_1.nextLine();
                    List.delete(key_1);
                    break;
                }
                case 3: {
                    String key_2;
                    System.out.println("Введіть слово: ");
                    Scanner scannerString_2 = new Scanner(System.in);
                    key_2 = scannerString_2.nextLine();
                    List.find(key_2);
                    break;
                }
                case 4: {
                    List.displayList();
                    break;
                }
            }
        }while (menu_ != 5);
    }
}
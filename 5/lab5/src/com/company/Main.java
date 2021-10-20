package com.company;

import java.util.Scanner;

public class Main {
//информаційна частина
    //введення одного елемента
    public static void main(String[] args) {
        int menu;
        int add, del, search;
        String name;
        BinaryTree tree = new BinaryTree();
        do{
            System.out.println("1. Добавление");
            System.out.println("2. Добавлення одного елемента");
            System.out.println("3. Вивод");
            System.out.println("4. Поиск");
            System.out.println("5. Удаление");
            System.out.println("6. Симметричный обход");
            System.out.println("7. Выход");
            Scanner scanner = new Scanner(System.in);
            menu = scanner.nextInt();

            switch (menu){
                case 1:
                    tree.insertNode(180, "Саша");
                    tree.insertNode(163, "Настя");
                    tree.insertNode(190, "Даня");
                    tree.insertNode(170, "Ваня");
                    tree.insertNode(168, "Аня");
                    tree.insertNode(193, "Артем");
                    System.out.println("Ми створили дерево та додали туди 7 дітей");
                    break;
                case 2:
                    System.out.println("Введіть зріст: ");
                    Scanner scanner1 = new Scanner(System.in);
                    add = scanner1.nextInt();
                    System.out.println("Введіть імя: ");
                    Scanner scannerName = new Scanner(System.in);
                    name = scannerName.nextLine();
                    tree.insertNode(add, name);
                    break;
                case 3:
                    tree.printTree();
                    break;
                case 4:
                    System.out.println("Введіть зріст: ");
                    Scanner scanner2 = new Scanner(System.in);
                    search = scanner2.nextInt();
                    Child foundChild = tree.findNodeByValue(search);
                    foundChild.printNode();
                    break;
                case 5:
                    System.out.println("Введіть зріст: ");
                    Scanner scanner3 = new Scanner(System.in);
                    del = scanner3.nextInt();
                    tree.deleteNode(del);
                    tree.printTree();
                    break;
                case 6:
                    tree.printInOrder();
                    break;
                default:
                    if (menu != 7)
                        System.out.println("Неверний номер пункта меню!");
            }

        }while (menu != 7);
    }
}

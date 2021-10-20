package com.company;
import java.util.Stack;

public class BinaryTree {
    private Child rootChild; // корневой узел

    public BinaryTree() { // Пустое дерево
        rootChild = null;
    }

    public Child findNodeByValue(int value) { // поиск узла по значению
        Child currentChild = rootChild;
        while (currentChild.getGrowth() != value) { // поиск покуда не будет найден элемент или не будут перебраны все
            if (value < currentChild.getGrowth()) { // движение влево?
                currentChild = currentChild.getLeftChild();
            } else { //движение вправо
                currentChild = currentChild.getRightChild();
            }
            if (currentChild == null) { // если потомка нет,
                return null;
            }
        }
        return currentChild; // возвращаем найденный элемент
    }

    public void insertNode(int growth, String name) { // метод вставки нового элемента
        Child newChild = new Child();
        newChild.setValue(growth);
        newChild.setName(name);
        if (rootChild == null) { // если корневой узел не существует
            rootChild = newChild;
        }
        else { // корневой узел занят
            Child currentChild = rootChild; // начинаем с корневого узла
            Child parentChild;
            while (true) // мы имеем внутренний выход из цикла
            {
                parentChild = currentChild;
                if(growth == currentChild.getGrowth()) {   // если такой элемент в дереве уже есть, не сохраняем его
                    return;
                }
                else  if (growth < currentChild.getGrowth()) {   // движение влево?
                    currentChild = currentChild.getLeftChild();
                    if (currentChild == null){ // если был достигнут конец цепочки,
                        parentChild.setLeftChild(newChild); //  то вставить слева и выйти из методы
                        return;
                    }
                }
                else { // Или направо?
                    currentChild = currentChild.getRightChild();
                    if (currentChild == null) { // если был достигнут конец цепочки,
                        parentChild.setRightChild(newChild);  //то вставить справа
                        return;
                    }
                }
            }
        }
    }

    public boolean deleteNode(int value) // Удаление узла с заданным ключом
    {
        Child currentChild = rootChild;
        Child parentChild = rootChild;
        boolean isLeftChild = true;
        while (currentChild.getGrowth() != value) { // начинаем поиск узла
            parentChild = currentChild;
            if (value < currentChild.getGrowth()) { // Определяем, нужно ли движение влево?
                isLeftChild = true;
                currentChild = currentChild.getLeftChild();
            }
            else { // или движение вправо?
                isLeftChild = false;
                currentChild = currentChild.getRightChild();
            }
            if (currentChild == null) {
                System.out.println("Такого елемента нету или уже был удален!");
                return false; // yзел не найден
            }
        }

        if (currentChild.getLeftChild() == null && currentChild.getRightChild() == null) { // узел просто удаляется, если не имеет потомков
            if (currentChild == rootChild) // если узел - корень, то дерево очищается
                rootChild = null;
            else if (isLeftChild)
                parentChild.setLeftChild(null); // если нет - узел отсоединяется, от родителя
            else
                parentChild.setRightChild(null);
        }
        else if (currentChild.getRightChild() == null) { // узел заменяется левым поддеревом, если правого потомка нет
            if (currentChild == rootChild)
                rootChild = currentChild.getLeftChild();
            else if (isLeftChild)
                parentChild.setLeftChild(currentChild.getLeftChild());
            else
                parentChild.setRightChild(currentChild.getLeftChild());
        }
        else if (currentChild.getLeftChild() == null) { // узел заменяется правым поддеревом, если левого потомка нет
            if (currentChild == rootChild)
                rootChild = currentChild.getRightChild();
            else if (isLeftChild)
                parentChild.setLeftChild(currentChild.getRightChild());
            else
                parentChild.setRightChild(currentChild.getRightChild());
        }
        else { // если есть два потомка, узел заменяется преемником
            Child heir = receiveHeir(currentChild);// поиск преемника для удаляемого узла
            if (currentChild == rootChild)
                rootChild = heir;
            else if (isLeftChild)
                parentChild.setLeftChild(heir);
            else
                parentChild.setRightChild(heir);
        }
        return true; // элемент успешно удалён
    }

    // метод возвращает узел со следующим значением после передаваемого аргументом.
    // для этого он сначала переходим к правому потомку, а затем
    // отслеживаем цепочку левых потомков этого узла.
    private Child receiveHeir(Child child) {
        Child parentChild = child;
        Child heirChild = child;
        Child currentChild = child.getRightChild(); // Переход к правому потомку
        while (currentChild != null) // Пока остаются левые потомки
        {
            parentChild = heirChild;// потомка задаём как текущий узел
            heirChild = currentChild;
            currentChild = currentChild.getLeftChild(); // переход к левому потомку
        }
        // Если преемник не является
        if (heirChild != child.getRightChild()) // правым потомком,
        { // создать связи между узлами
            parentChild.setLeftChild(heirChild.getRightChild());
            heirChild.setRightChild(child.getRightChild());
        }
        return heirChild;// возвращаем приемника
    }

    public void printInOrder(){ // Семитричний обход
        inOrder(rootChild);
    }

    void inOrder(Child current) { // рекурсивно обходим дерево
        if (current != null) {
            inOrder(current.getLeftChild());
            System.out.println("Имя дитини: " + current.getName() + ", зріст : " + current.getGrowth());
            inOrder(current.getRightChild());
        }
    }

    public void printTree() { // метод для вывода дерева в консоль
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(rootChild);
        int gaps = 32; // начальное значение расстояния между элементами 32
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Child temp = (Child) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getGrowth()); // выводим его значение в консоли
                    localStack.push(temp.getLeftChild()); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("  ");// - если элемент пустой "__"
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }
}
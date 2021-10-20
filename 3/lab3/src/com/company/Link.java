package com.company;


class LinkList {
    private static class Link {
        Word data;
        Link next; // посилання на наступний елемент списку

        public Link(String word, String word_RU) {
            this.data = new Word(word, word_RU);
        }

        public void displayLink() { System.out.println("    " + data); }
        public void displayFind() { System.out.println("Ми знайшли слово: " + data); }
        public void displayDelete() { System.out.println("Ми видалили: " + data); }
    }

    Link first;

    public LinkList() {
        first = null;
    }

    public void insertFirst(String word, String word_RU) {
        Link newLink = new Link(word, word_RU); //створюємо новий елемент списку
        newLink.next = first; //вказали на старий "перший" елемент і таким чином зробили його другим
        first = newLink; // позначили створений елемент, як перший
    }

    public Link find(String key) { // пошук елемента с заданим ключем
        Link current = first; // починаємо пошук з першого елемента
        Link temp = null;

        while (current != null) {
            if(current.data.data.equals(key)){
                current.displayFind();
                temp = current;
                break;
            }

            current = current.next;
        }
        return temp;
    }

    public Link delete(String key) { //видалення елементу по заданому ключу
        Link current = first; // Текущий
        Link previous = first; // предыдущий


        while (current != null) { // пошук елемента

            if(current.data.data.equals(key)){
                if (current == first) { // якщо шуканий елемент - перший
                    first = first.next;
                } else {
                    previous.next = current.next; // якщо шуканий елемент лежить всередині списку, обійдемо його
                }
                current.displayDelete();
            }

            if (current.next == null) {
                return null;    // елемент не знайдено
            } else {
                previous = current; // перейти до наступного елементу
                current = current.next;
            }
        }
        return current;
    }

    public void displayList() {
        Link current = first;
        System.out.println("List (first --> last): ");
            while (current != null) { //доки список не закінчився, відображаємо дані
                current.displayLink(); // відображаємо дані елементу, на якому знаходимося
                current = current.next; // переходимо до наступного елементу
            }
    }
}
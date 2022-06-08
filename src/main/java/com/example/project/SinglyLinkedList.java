package com.example.project;

public class SinglyLinkedList<T> {
    private Node<T> first; // Primero nodo de la lista
    private int size; // Tamano de la lista

    // Constructor (crea lista vacia)
    SinglyLinkedList() {
        first = null;
        size = 0;
    }

    // Retorna el tamano de la lista
    public int size() {
        return size;
    }

    // Devuelve true si la lista esta vazia o false caso contrario
    public boolean isEmpty() {
        return (size == 0);
    }

    // Adiciona v al inicio de la lista
    public void addFirst(T v) {
        Node<T> newNode = new Node<T>(v, first);
        first = newNode;
        size++;
    }

    // Adiciona v al final de la lista
    public void addLast(T v) {
        Node<T> newNode = new Node<T>(v, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null)
                cur = cur.getNext();
            cur.setNext(newNode);
        }
        size++;
    }

    // Retorna el primer valor de la lista (o null si la lista esta vacia)
    public T getFirst() {
        if (isEmpty())
            return null;
        return first.getValue();
    }

    // Retorna el ultimo valor de la lista (o null si la lista esta vazia)
    public T getLast() {
        if (isEmpty())
            return null;
        Node<T> cur = first;
        while (cur.getNext() != null)
            cur = cur.getNext();
        return cur.getValue();
    }

    // Elimina el primer elemento de la lista (si esta vacia no hara nada)
    public void removeFirst() {
        if (isEmpty())
            return;
        first = first.getNext();
        size--;
    }

    // Elimina el ultimo elemento de la lista (si esta vacia no hara nada)
    public void removeLast() {
        if (isEmpty())
            return;
        if (size == 1) {
            first = null;
        } else {
            // Ciclo con for y uso de size para mostrar alternativa al while
            Node<T> cur = first;
            for (int i = 0; i < size - 2; i++)
                cur = cur.getNext();
            cur.setNext(cur.getNext().getNext());
        }
        size--;
    }

    // Convierte la lista para um String
    public String toString() {
        String str = "{";
        Node<T> cur = first;
        while (cur != null) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != null)
                str += ",";
        }
        str += "}";
        return str;
    }

    // NUEVOS METODOS

    // Elimina aquellos nodos de la lista que esten duplicados
    public void deleteDuplicates(){
    	//Si el arreglo está vacío o solo hay un elemento, no hará nada
        if (isEmpty() || (size == 1)) {
            return;
        }else{
        	int aux = 0;
        	Node<T> cur = first;
        	Node<T> cur1 = first;
        	for (int i = 0; i < size; i++){
        		aux++;
        		cur1 = cur1.getNext();
        		if (cur.equals(cur1)){
        			deleteNth(i+aux);
				}
        	}
        }
    }

    // Inserta un nuevo nodo en una posicion especifica de la lista
    public void insertNth(T data, int position){
    	Node<T> newNode = new Node<T>(data, null);
        //=== Si la posición fuera menor o igual a 0 ===
    	if (position <= 0){
        	first = newNode;
        //=== Si fuera igual a 1 ===
        }else if (position == 1){
        	addFirst(data);
        //=== Si fuera igual a 2 ===
        }else if(position==2){
        	Node<T> cur = first.getNext().getNext();
        	first.getNext().setNext(newNode);
        	newNode.setNext(cur);
        	size++;
        //=== Si fuera mayor o igual al tamaño de la lista ===
        }else if(size <= position){
        	addLast(data);
        //=== Si ninguna de las condiciones anteriores se haya cumplido ===
        }else{
            Node<T> cur1 = first;
            for (int i = 0; i <= (position-1); i++) {
				cur1 = cur1.getNext();
			}
            Node<T> cur2 = first;
            for (int i = 0; i <= (position-2); i++) {
				cur2 = cur2.getNext();
			}
            cur2.setNext(newNode);
            newNode.setNext(cur1);
            size++;
        }
    }

    // Elimina el nodo de una posicion especifica de la lista
    public void deleteNth(int position) {
        //=== Si la posición fuera menor o igual a 0 no hará nada ===
    	if (position <= 0){
        	return;
        //=== Si fuera igual a 1 ===
        }else if (position == 1){
        	removeFirst();
        //=== Si fuera igual a 2 ===
        }else if(position==2){
        	Node<T> cur = first.getNext().getNext().getNext();
        	first.getNext().setNext(cur);
        	size--;
        //=== Si fuera mayor o igual al tamaño de la lista ===
        }else if(size <= position){
        	removeLast();
        //=== Si ninguna de las condiciones anteriores se haya cumplido ===
        }else{
            Node<T> cur1 = first;
            for (int i = 0; i <= position; i++) {
				cur1 = cur1.getNext();
			}
            Node<T> cur2 = first;
            for (int i = 0; i <= (position-2); i++) {
				cur2 = cur2.getNext();
			}
            cur2.setNext(cur1);
            size--;
        }
    }

    public static void main(final String[] args) {

        testExercicio1();
        testExercicio2();
        testExercicio3();       

    }

    public static void testExercicio1(){

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();

        list.addLast(47);
        list.addLast(89);
        list.addLast(56);
        list.addLast(89);
        list.addLast(56);

        System.out.println(list);

        list.deleteDuplicates();

        System.out.println(list);
    }

    public static void testExercicio2(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.insertNth('c', 2);

        System.out.println(list);
    }

    public static void testExercicio3(){

        SinglyLinkedList<Character> list = new SinglyLinkedList<Character>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('d');

        System.out.println(list);

        list.deleteNth(2);

        System.out.println(list);
    }

}

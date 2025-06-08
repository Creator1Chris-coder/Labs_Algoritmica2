package Algo2_Lab_Work_Sem7;

public interface Lista<E> {
	boolean add(E e);
	void add(int index, E element); 
	void addFirst(E e);
	void addLast(E e);
	void clear();
	boolean contains(Object o);
	boolean equals(Object o); 
	E get(int index);
	E set(int index, E element);
	int indexOf(Object o);
	boolean isEmpty();
	E remove(int index);
	boolean remove(Object o);
	int size();
}

package com.dsa.datastructures.stack;
import java.util.NoSuchElementException;
/** A linked-node LIFO stack. */
public final class LinkedStack<E> {
 private static final class Node<E>{ E value; Node<E> next; Node(E v,Node<E> n){value=v;next=n;} }
 private Node<E> top; private int size;
 public int size(){return size;} public boolean isEmpty(){return size==0;}
 public void push(E value){top=new Node<>(value,top);size++;}
 public E peek(){if(top==null)throw new NoSuchElementException("Stack is empty");return top.value;}
 public E pop(){E v=peek();top=top.next;size--;return v;}
 public void clear(){top=null;size=0;}
}

package com.dsa.datastructures.queue;
import java.util.NoSuchElementException;
/** A linked-node FIFO queue. */
public final class LinkedQueue<E> {
 private static final class Node<E>{E value;Node<E> next;Node(E v){value=v;}}
 private Node<E> head,tail;private int size;
 public int size(){return size;}public boolean isEmpty(){return size==0;}
 public void enqueue(E v){Node<E> n=new Node<>(v);if(tail==null)head=tail=n;else{tail.next=n;tail=n;}size++;}
 public E peek(){if(head==null)throw new NoSuchElementException("Queue is empty");return head.value;}
 public E dequeue(){E v=peek();head=head.next;if(head==null)tail=null;size--;return v;}
 public void clear(){head=tail=null;size=0;}
}

package com.dsa.datastructures.tree;
import java.util.ArrayList;import java.util.List;import java.util.Objects;
/** Unbalanced binary search tree. Duplicate keys are ignored. */
public final class BinarySearchTree<E extends Comparable<? super E>> {
 private static final class Node<E>{E value;Node<E> left,right;Node(E v){value=v;}}
 private Node<E> root;private int size;
 public int size(){return size;}public boolean isEmpty(){return size==0;}
 public boolean add(E value){Objects.requireNonNull(value,"value");if(root==null){root=new Node<>(value);size++;return true;}Node<E> n=root;while(true){int c=value.compareTo(n.value);if(c==0)return false;if(c<0){if(n.left==null){n.left=new Node<>(value);size++;return true;}n=n.left;}else{if(n.right==null){n.right=new Node<>(value);size++;return true;}n=n.right;}}}
 public boolean contains(E value){Node<E> n=root;while(n!=null){int c=value.compareTo(n.value);if(c==0)return true;n=c<0?n.left:n.right;}return false;}
 public List<E> inOrder(){List<E> out=new ArrayList<>();walk(root,out);return out;}
 private void walk(Node<E> n,List<E> out){if(n==null)return;walk(n.left,out);out.add(n.value);walk(n.right,out);}
}

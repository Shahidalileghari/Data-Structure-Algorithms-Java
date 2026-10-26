package com.dsa.datastructures.heap;
import java.util.ArrayList;import java.util.List;import java.util.NoSuchElementException;import java.util.Objects;
/** Generic binary min-heap. */
public final class BinaryMinHeap<E extends Comparable<? super E>> {
 private final List<E> data=new ArrayList<>();
 public int size(){return data.size();}public boolean isEmpty(){return data.isEmpty();}
 public void add(E value){data.add(Objects.requireNonNull(value));siftUp(data.size()-1);}
 public E peek(){if(data.isEmpty())throw new NoSuchElementException("Heap is empty");return data.get(0);}
 public E removeMin(){E result=peek();E last=data.remove(data.size()-1);if(!data.isEmpty()){data.set(0,last);siftDown(0);}return result;}
 private void siftUp(int i){while(i>0){int p=(i-1)/2;if(data.get(p).compareTo(data.get(i))<=0)break;swap(i,p);i=p;}}
 private void siftDown(int i){while(true){int l=2*i+1,r=l+1,s=i;if(l<data.size()&&data.get(l).compareTo(data.get(s))<0)s=l;if(r<data.size()&&data.get(r).compareTo(data.get(s))<0)s=r;if(s==i)return;swap(i,s);i=s;}}
 private void swap(int a,int b){E t=data.get(a);data.set(a,data.get(b));data.set(b,t);}
}

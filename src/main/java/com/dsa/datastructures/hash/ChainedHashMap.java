package com.dsa.datastructures.hash;
import java.util.Objects;
/** Educational hash map using separate chaining. Null keys are not supported; null values are. */
public final class ChainedHashMap<K,V> {
 private static final class Entry<K,V>{final K key;V value;Entry<K,V> next;Entry(K k,V v,Entry<K,V> n){key=k;value=v;next=n;}}
 private Entry<K,V>[] buckets;private int size;private static final double LOAD_FACTOR=.75;
 @SuppressWarnings("unchecked") public ChainedHashMap(){buckets=(Entry<K,V>[])new Entry[16];}
 public int size(){return size;}public boolean isEmpty(){return size==0;}
 public V put(K key,V value){Objects.requireNonNull(key,"key");if((size+1.0)/buckets.length>LOAD_FACTOR)resize();int i=index(key,buckets.length);for(Entry<K,V> e=buckets[i];e!=null;e=e.next)if(e.key.equals(key)){V old=e.value;e.value=value;return old;}buckets[i]=new Entry<>(key,value,buckets[i]);size++;return null;}
 public V get(K key){Objects.requireNonNull(key,"key");for(Entry<K,V> e=buckets[index(key,buckets.length)];e!=null;e=e.next)if(e.key.equals(key))return e.value;return null;}
 public boolean containsKey(K key){Objects.requireNonNull(key,"key");for(Entry<K,V> e=buckets[index(key,buckets.length)];e!=null;e=e.next)if(e.key.equals(key))return true;return false;}
 public V remove(K key){Objects.requireNonNull(key,"key");int i=index(key,buckets.length);Entry<K,V> prev=null,e=buckets[i];while(e!=null){if(e.key.equals(key)){if(prev==null)buckets[i]=e.next;else prev.next=e.next;size--;return e.value;}prev=e;e=e.next;}return null;}
 private int index(K key,int length){return (key.hashCode()&0x7fffffff)%length;}
 @SuppressWarnings("unchecked") private void resize(){Entry<K,V>[] old=buckets;buckets=(Entry<K,V>[])new Entry[old.length*2];size=0;for(Entry<K,V> bucket:old)for(Entry<K,V> e=bucket;e!=null;){Entry<K,V> next=e.next;put(e.key,e.value);e=next;}}
}

package com.dsa.datastructures.trie;
import java.util.HashMap;import java.util.Map;import java.util.Objects;
/** Trie for case-sensitive strings. */
public final class Trie {
 private static final class Node{final Map<Character,Node> children=new HashMap<>();boolean terminal;}
 private final Node root=new Node();
 public void insert(String word){Objects.requireNonNull(word,"word");Node n=root;for(char c:word.toCharArray())n=n.children.computeIfAbsent(c,k->new Node());n.terminal=true;}
 public boolean contains(String word){Node n=find(word);return n!=null&&n.terminal;}
 public boolean startsWith(String prefix){return find(prefix)!=null;}
 private Node find(String s){Objects.requireNonNull(s,"value");Node n=root;for(char c:s.toCharArray()){n=n.children.get(c);if(n==null)return null;}return n;}
}

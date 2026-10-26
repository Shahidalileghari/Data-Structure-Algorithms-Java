package com.dsa.datastructures.graph;
import java.util.*;
/** Directed or undirected graph using adjacency lists. Vertices are non-null. */
public final class Graph<V> {
 private final Map<V,Set<V>> adjacency=new LinkedHashMap<>();private final boolean directed;
 public Graph(boolean directed){this.directed=directed;}
 public void addVertex(V v){adjacency.computeIfAbsent(Objects.requireNonNull(v),k->new LinkedHashSet<>());}
 public void addEdge(V from,V to){addVertex(from);addVertex(to);adjacency.get(from).add(to);if(!directed)adjacency.get(to).add(from);}
 public Set<V> vertices(){return Collections.unmodifiableSet(adjacency.keySet());}
 public Set<V> neighbors(V v){Set<V> n=adjacency.get(v);if(n==null)throw new IllegalArgumentException("Unknown vertex: "+v);return Collections.unmodifiableSet(n);}
 public List<V> breadthFirstSearch(V start){requireVertex(start);List<V> out=new ArrayList<>();Set<V> seen=new HashSet<>();Queue<V> q=new ArrayDeque<>();q.add(start);seen.add(start);while(!q.isEmpty()){V v=q.remove();out.add(v);for(V next:adjacency.get(v))if(seen.add(next))q.add(next);}return out;}
 public List<V> depthFirstSearch(V start){requireVertex(start);List<V> out=new ArrayList<>();Set<V> seen=new HashSet<>();Deque<V> stack=new ArrayDeque<>();stack.push(start);while(!stack.isEmpty()){V v=stack.pop();if(!seen.add(v))continue;out.add(v);List<V> ns=new ArrayList<>(adjacency.get(v));for(int i=ns.size()-1;i>=0;i--)if(!seen.contains(ns.get(i)))stack.push(ns.get(i));}return out;}
 private void requireVertex(V v){if(!adjacency.containsKey(v))throw new IllegalArgumentException("Unknown vertex: "+v);}
}

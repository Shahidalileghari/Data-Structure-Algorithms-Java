# Data Structure Taxonomy

## Primitive types (Java language types)
Java's primitive types are `byte`, `short`, `int`, `long`, `float`, `double`, `char`, and `boolean`. They are language-level value types, not custom collection data structures. Arrays of primitives (for example, `int[]`) are built-in array objects.

## Non-primitive / reference types
- Arrays and strings
- Classes and objects
- Interfaces and abstract data types
- Collections and custom implementations
- Nodes, trees, graphs, hash tables, heaps, tries

## User-defined abstract data types
- Linear: dynamic array, linked list, stack, queue, deque
- Associative: map, set, hash table
- Hierarchical: tree, heap, trie
- Network: graph
- Specialized: disjoint-set union, Fenwick tree, segment tree

The Java Collections Framework already provides production-tested `List`, `Deque`, `Map`, `Set`, and `PriorityQueue` implementations. This repository implements selected structures from first principles for learning and algorithmic understanding.

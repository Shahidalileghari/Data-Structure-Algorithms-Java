# Data Structures & Algorithms in Java

A professional, modular Java repository covering data structures and algorithms from foundational concepts through advanced implementations. The goal is to provide clear APIs, documented behavior, runnable examples, and automated tests—not merely a collection of snippets.

## Scope

- **Primitive types and operations:** Java primitive types, numeric conversions, bitwise operations, and complexity-aware utility examples.
- **Linear structures:** dynamic arrays, linked lists, stacks, queues, deques.
- **Hash-based structures:** hash table, set, map, collision handling.
- **Trees:** binary search tree, AVL tree, heap / priority queue, trie, segment tree, Fenwick tree.
- **Graphs:** adjacency-list graph, BFS, DFS, topological sorting, shortest paths, minimum spanning tree, connected components.
- **Algorithms:** searching, sorting, recursion, backtracking, greedy methods, divide and conquer, dynamic programming, string matching, graph algorithms.
- **User-defined / abstract data types:** generic classes, interfaces, nodes, records where appropriate, and composable implementations.
- **Testing and examples:** JUnit 5 tests and small runnable demonstrations.

> This repository is an educational and engineering reference. Implementations aim to be correct and readable; performance and API trade-offs are documented where relevant.

## Requirements

- JDK 17 or newer
- Maven 3.9+ (or use the included Maven wrapper if you add one for your environment)

## Build and test

```bash
mvn clean test
```

Compile the project:

```bash
mvn clean package
```

Run the array demo:

```bash
java -cp target/classes com.dsa.demo.DynamicArrayDemo
```

## Repository structure

```text
data-structures-algorithms-java/
├── README.md
├── LICENSE
├── .gitignore
├── pom.xml
├── docs/
│   ├── complexity.md
│   └── roadmap.md
└── src/
    ├── main/java/com/dsa/
    │   ├── demo/
    │   ├── algorithms/
    │   │   ├── searching/
    │   │   ├── sorting/
    │   │   ├── strings/
    │   │   ├── recursion/
    │   │   ├── backtracking/
    │   │   ├── greedy/
    │   │   ├── dynamicprogramming/
    │   │   └── graph/
    │   ├── datastructures/
    │   │   ├── linear/
    │   │   ├── linked/
    │   │   ├── stack/
    │   │   ├── queue/
    │   │   ├── hash/
    │   │   ├── tree/
    │   │   ├── heap/
    │   │   ├── trie/
    │   │   └── graph/
    │   └── utilities/
    └── test/java/com/dsa/
```

## Implemented in this starter release

- Generic `DynamicArray<E>` with capacity growth, indexed access/update, insertion/removal, search, iteration, conversion to array, and clear.
- `SinglyLinkedList<E>` and `DoublyLinkedList<E>`.
- `ArrayStack<E>`, `LinkedStack<E>`, `CircularArrayQueue<E>`, and `LinkedQueue<E>`.
- `ChainedHashMap<K,V>` using separate chaining.
- `BinarySearchTree<E>`, `BinaryMinHeap<E>`, `Trie`, and adjacency-list `Graph<V>` with BFS/DFS.
- Searching: linear search and binary search.
- Sorting: insertion sort, merge sort, and quicksort.
- String palindrome check and Fibonacci dynamic-programming examples.
- JUnit tests for the initial core implementations.

This is a growing reference library, not a claim that every known data structure and algorithm is already implemented. The structure and roadmap identify additional planned topics; items not yet implemented are marked in `docs/roadmap.md`.

## Java type taxonomy

Java primitive types are `byte`, `short`, `int`, `long`, `float`, `double`, `char`, and `boolean`. Reference types include arrays, classes, interfaces, strings, and objects. User-defined abstract data types in this repository include lists, stacks, queues, maps, trees, heaps, tries, and graphs. See [`docs/data-structure-taxonomy.md`](docs/data-structure-taxonomy.md).

## API example: DynamicArray

```java
DynamicArray<Integer> values = new DynamicArray<>();
values.add(10);
values.add(20);
values.insert(1, 15);       // [10, 15, 20]
values.set(0, 5);           // [5, 15, 20]
int first = values.get(0);  // 5
boolean has15 = values.contains(15);
values.removeAt(1);         // [5, 20]
values.remove(Integer.valueOf(20));
```

`DynamicArray<E>` exposes `toArray(IntFunction<T[]>)` for typed array conversion. For example:

```java
Integer[] snapshot = values.toArray(Integer[]::new);
```

## Engineering conventions

- Java 17 language level
- Generic implementations where they make sense
- Javadoc on public APIs
- Explicit index and state validation
- JUnit 5 tests
- No third-party runtime dependencies
- Complexity notes for major operations

## Contributing

1. Create a feature branch.
2. Add or update tests for behavior changes.
3. Run `mvn clean test`.
4. Update documentation and complexity notes.
5. Open a pull request with a focused description.

## License

Distributed under the MIT License. See [`LICENSE`](LICENSE).

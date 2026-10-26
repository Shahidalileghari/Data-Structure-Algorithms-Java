# Complexity Reference

Big-O describes asymptotic growth. Actual performance also depends on constants, memory locality, allocation, and input distribution.

| Structure / operation | Typical time | Notes |
|---|---:|---|
| Dynamic array indexed get/set | O(1) | Backing array access |
| Dynamic array append | Amortized O(1) | Occasional O(n) resize |
| Dynamic array insert/remove by index | O(n) | Shifts elements |
| Singly linked list search/index access | O(n) | Sequential traversal |
| Singly linked list insert/remove at head | O(1) | No traversal |
| Array stack push/pop/peek | O(1) | Amortized push |
| Circular array queue enqueue/dequeue | O(1) amortized | Resizing may cost O(n) |
| Binary search | O(log n) | Input must be sorted |
| Insertion sort | O(n²) worst, O(n) best | Stable; useful for small/nearly sorted data |
| Merge sort | O(n log n) | Stable; O(n) auxiliary memory |

For hash tables, expected O(1) operations depend on a well-distributed hash function and controlled load factor; worst-case behavior can be O(n).

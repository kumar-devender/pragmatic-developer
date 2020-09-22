#### problem statement
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.

For example, in this diagram, 6 and 8 have common ancestors of 4 and 14.
```

          14  13
          |   |
 1   2    4   12
  \ /   / | \ /
   3   5  8  9
    \ / \     \
     6   7     11

```

parentChildPairs = [
 (1, 3), (2, 3), (3, 6), (5, 6), (5, 7), (4, 5),
 (4, 8), (4, 9), (9, 11), (14, 4), (13, 12), (12, 9)
]

Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if and only if they share at least one ancestor.

#### Sample input and output:

hasCommonAncestor(parentChildPairs, 3, 8) => false
hasCommonAncestor(parentChildPairs, 5, 8) => true
hasCommonAncestor(parentChildPairs, 6, 8) => true
hasCommonAncestor(parentChildPairs, 6, 9) => true
hasCommonAncestor(parentChildPairs, 1, 3) => false
hasCommonAncestor(parentChildPairs, 3, 1) => false
hasCommonAncestor(parentChildPairs, 7, 11) => true
hasCommonAncestor(parentChildPairs, 6, 5) => true
hasCommonAncestor(parentChildPairs, 5, 6) => true

#### Solution
Solution of this can be found on the website [Pragmatic developer](https://pragmaticdeveloper.info/find-if-two-nodes-in-a-graph-share-at-least-one-ancestor/) or also in [Pragmatic developer Github repo](https://github.com/kumar-devender/pragmatic-developer/blob/f7c91f61e587848f70285b217260e6b291dc95dd/competitive-programming/src/main/java/info/pragmaticdeveloper/RelationshipsAnalyzer.java)
#### Problem statement
Suppose we have some input data describing a graph of relationships between parents and children over multiple generations. 
The data is formatted as a list of (parent, child) pairs, where each individual is assigned a unique integer identifier.
```
         11
        /  \
       10   12
      /  \
 1   2    5
  \ /    / \
   3    6   7
    \        \
     4        8
```

parentChildPairs2 = [
 (11, 10), (11, 12), (2, 3), (10, 2), (10, 5),
 (1, 3), (3, 4), (5, 6), (5, 7), (7, 8),
]

Our first task is to write a function `public List<Integer> getWithSingleParent(int arr[][]) {}` which return all the nodes that have single parent.
Our next task is to write a function `public List<Integer> getWithZeroParent(int arr[][]) {}` which return all the root nodes i.e node that do not have any parent.

#### Solution
Solution of this can be found on the website [Pragmatic developer](https://pragmaticdeveloper.info/find-if-two-nodes-in-a-graph-share-at-least-one-ancestor/) or also in [Pragmatic developer Github repo](https://github.com/kumar-devender/pragmatic-developer/blob/f7c91f61e587848f70285b217260e6b291dc95dd/competitive-programming/src/main/java/info/pragmaticdeveloper/RelationshipsAnalyzer.java)



You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends. The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.

Write a function that takes in a list of (student ID number, course name) pairs and returns, for every pair of students, a list of all courses they share.

Sample Input:

```
{
{"58", "Linear Algebra"},
{"94", "Art History"},
{"94", "Operating Systems"},
{"17", "Software Design"},
{"58", "Mechanics"},
{"58", "Economics"},
{"17", "Linear Algebra"},
{"17", "Political Science"},
{"94", "Economics"},
{"25", "Economics"},
{"58", "Software Design"}}

```

Sample Output (pseudocode, in any order):

```
{
  "58,17": ["Software Design", "Linear Algebra"]
  "58,94": ["Economics"]
  "58,25": ["Economics"]
  "94,25": ["Economics"]
  "17,94": []
  "17,25": []
}

```





Additional test cases:

Sample Input:
```
{
{"42", "Software Design"},
{"0", "Advanced Mechanics"},
{"9", "Art History"}}
```

Sample output:

```
{
  "0,42": []
  "0,9": []
  "9,42": []
}

```

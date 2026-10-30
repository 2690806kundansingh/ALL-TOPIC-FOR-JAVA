/*
 * 1.Stream API kya hai?
 * "Stream API is a feature introduced in Java 8 that allows
 * us to process collections of data in a declarative and
 * functional style using operations like filter, map, sorted,
 * collect, reduce, etc."
 * 
 * 2.Stream aur Collection mein difference
 * Collection data ko store karti hai.
 * Stream data ko process karta hai.
 * 
 * 3.stream ka basic flow ?
 * Collection
 * ↓
 * stream()
 * ↓
 * Intermediate Operation
 * ↓
 * Intermediate Operation
 * ↓
 * Terminal Operation
 * 
 * 4.how create stream ?
 * from list==
 * list<Integer>number = Array.asList(10,20,30);
 * stream<Integer>stream = number.stream();
 * 
 * from set ==
 * set<String>names = new HashSet<>();
 * names.stream();
 * 
 * from array==
 * int a[] = {10,20,30};
 * Arrays.stream(arr);
 * 
 * 5.stream operations ?
 * it mainly two types ?
 * ==>Intermediate Operation
 * Intermediate operation ka result another Stream hota hai.
 * Ye new Stream return karte hain.
 * filter()
 * map()
 * sorted()
 * distinct()
 * limit()
 * skip()
 * peek()
 * ==>Terminal Operation
 * Terminal operation stream processing ko complete karta hai.
 * forEach()
 * collect()
 * count()
 * reduce()
 * min()
 * max()
 * anyMatch()
 * allMatch()
 * noneMatch()
 * findFirst()
 * findAny()
 * 
 * 8.FIlter()
 * filter() ka use condition ke basis par data select karne
 * ke liye hota hai
 * 
 * 9.map()
 * map() ka use ek value ko another value mein transform karne ke liye hota hai.
 * 
 * 10.Stream Lazy hoti hai
 * "Intermediate operations in Stream API are lazy. They are executed only when a terminal operation is invoked."
 */

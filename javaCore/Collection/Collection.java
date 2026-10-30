/*
 * 1.what is collection interface ? why we use it ,why it come to the picture ?
 * 
 * A Collection in Java that provides classes and interfaces to
 * store, manage, and manipulate a group of objects dynamically.
 * to perform the common task on multiple object.
 * some collection allow duplicate elements and other
 * are do not,some are ordered and other are not.
 * 
 * ==>Why do we use Collections? or why Collection Framework was introduced.
 * -> It provides ready-made data structures.
 * ->list
 * ->set
 * ->Queue
 * ->Map(technically part of the Collections Framework, but it doesn't implement
 * the Collection interface)
 * 
 * 2.why it come to the picture ?
 * "Collections were introduced to overcome the
 * limitations of arrays. Arrays have a fixed size,
 * so they cannot grow dynamically. Operations like
 * insertion, deletion, sorting, and searching require
 * additional code. The Java Collection Framework provides dynamic
 * data structures with built-in methods to efficiently store, retrieve,
 * manipulate, and organize
 * groups of objects. Depending on the requirement, we can use ArrayList,
 * LinkedList, HashSet, TreeSet, PriorityQueue, and others."
 * 
 * 3.METHOD OF COLLECTION INTERFACE
 * add()
 * remove()
 * contains()
 * size()
 * isEmpty()
 * clear()
 * iterator()
 * toArray()
 * addAll()
 * removeAll()
 * stream()
 * removeIf()
 * 
 * 
 * 4.ITERATOR INTERFACE
 * A collection provides an interface which allow sequential acess to the
 * elementof collection.
 * Iterator interface is the root interface for all collection classes
 * it belong to the java.lang.package.
 * methos are ==>
 * ==>public iterator iterator()
 * ==>public boolean hashNext()
 * ==>public onject next()
 * ==>public object remove()
 * ==>public boolean hasPrevious()
 * ==>public object previous()
 * ==>public int nextIndex()
 * ==>public int previousIndex()
 * 
 * 5.Enmeration Interface
 * The Enumeration interface is an old interface in Java used to read elements
 * one by
 * one from legacy collection classes like Vector and Stack.
 * Think of it like reading pages in a book only in the forward direction.
 * does not have remove method.
 * 
 * methods are =>
 * .boolean hashMoreElement()
 * .OObject nextElement()
 * 
 * 6.ListIterator Interface ?
 * It is a child interface of iterator interface which allow a programmer to
 * traverse a list in other dirction and make modification to the undrlying
 * list.
 * 
 * 7.LIST INTERFACE
 * List is an ordered collectiion.it maintain insertion order,and allow
 * duplicate element and allows indexing and use zero based indexing
 * 
 * ==>METHODS ARE----
 * ==>public void add(int index,Object o)
 * ==>public boolean AddAll(int index,collection c)
 * ==>public object get(int index)
 * ==>public listIterator listiterator()
 * ==>public object remove(int index)
 * ==>public Object set(int index object())
 * 
 * 5.ARRAYLIST
 * ArayList support dynamic array that can grow as neede.That is Arraylist can
 * dynamically increase or decrease in size.Arraylist are created with an
 * initail
 * size when this size is exceeded the collection is automatically enlarge.
 * ==>When you add the first element, the internal array is created with a
 * capacity
 * of 10.
 * SIZE => (initialSize) + (InitialSize/2)
 * 
 * 
 * 6.how arrayList work internally ?
 * ""ArrayList is implemented using a dynamic array. Internally it stores
 * elements in an Object[] array. It provides fast random access because
 * elements are stored contiguously, making get() an O(1) operation. When the
 * internal array becomes full, ArrayList creates a larger array (typically 1.5
 * times the previous capacity), copies the existing elements, and then inserts
 * the new one. Appending elements is O(1) on average (amortized), while
 * inserting or deleting in the middle is O(n) because elements need to be
 * shifted.""
 * 
 * 7.VECTOR CLASS
 * Vector is a class in Java that stores multiple objects in a dynamic array. It
 * can automatically increase or decrease its size when elements are added or
 * removed.Vector is a dynamic array that is synchronized (thread-safe), so it
 * can be safely used by multiple threads.
 * default capacity is 10
 * 
 * featres ->
 * Dynamic size (grows automatically)
 * Stores duplicate elements
 * Maintains insertion order
 * Allows null values
 * Thread-safe (Synchronized)
 * 
 * 8.VECTOR VS aRRAYlIST
 * Synchronized (Thread-safe)- Not synchronized
 * Slower -Faster
 * Legacy class -Modern class
 * Automatically grows -Automatically grows
 * Used in multi-threaded applications -Used in single-threaded applications
 * 
 * 9.LINKEDLIST CLASS
 * LinkedList is a class in java that implements the list and Deque interfaces
 * .it store element as nodes,where eath node conttttains :
 * the data(value)
 * .The adrees of the next node
 * .the adress of the previous node
 * 
 * =>methods of liknkedList
 * add() Adds an element
 * addFirst() Adds an element at the beginning
 * addLast() Adds an element at the end
 * get() Returns an element by index
 * getFirst() Returns the first element
 * getLast() Returns the last element
 * remove() Removes an element
 * removeFirst() Removes the first element
 * removeLast() Removes the last element
 * size() Returns the number of elements
 * contains() Checks if an element exists
 * clear()
 * 
 * 
 * 
 * 10.Map Interface
 * The Map interface is used to store data in key-value pairs.
 * both the key and value must be the object
 * Every key must be unique.
 * Values can be duplicated.
 * A key maps to exactly one value.
 * 
 * ==>Method are =>
 * put(key, value) Adds a key-value pair
 * get(key) Returns the value for the key
 * remove(key) Removes the key-value pair
 * containsKey(key) Checks if a key exists
 * containsValue(value) Checks if a value exists
 * keySet() Returns all keys
 * values() Returns all values
 * entrySet() Returns all key-value pairs
 * size() Returns the number of entries
 * clear() Removes all entries
 * isEmpty() Checks if the map is empty
 * 
 * 11. How internally HASHMAP explain in brief ?
 * "HashMap is a class that implements the Map interface.
 * It stores data in the form of key-value pairs.
 * It allows one null key and multiple null values.
 * Internally, it uses a hash table. The key's hashCode() is used to calculate a
 * bucket index,
 * and the key-value pair is stored in that bucket. On average, insertion,
 * searching, and deletion
 * take O(1) time, but in the worst case they can take O(n). From Java 8 onward,
 * if many entries end up in the same bucket, the linked list in that bucket can
 * be converted into a balanced tree to improve performance."
 * initial capacity of hshmap is 16
 * 
 * 
 * key point ->
 * the class whose object you want to add in hashmap as key that class must be
 * ovverirde two mathods
 * .public int hashCode();
 * .public boolean equals(Object o);
 * =>each index of this array is called bucket.
 * => and each bucket is called linkedList.
 * 
 * 12 what is hashcode ?
 * Every Object in java has a hashcode() method.This integer is called the
 * hashcode.
 * java does't diretly use this huge number as an array index,instead it convert
 * it into a bucket index.
 * 
 * 13.why is Map Seperate or why does not extent collection?
 * because collection stores only value. and map store key value pair.
 * 
 * 14.19 Fail fast -> throws concurentModificationException Ex-ArrayListIterator
 * Fail safe -> work on copy no exception Ex-CopyOnWriteArrayList
 * 
 * 15.LINKEDHASHMAP EXPLAIANTION ?
 * LinkedHashMap is a class that implements the Map interface. It stores data in
 * key-value pairs and maintains the insertion order.it maiantain the
 * doubly linkedList internallly .
 * 
 * METHODS ARE =>
 * put(key, value) Adds a key-value pair
 * get(key) Returns the value for a key
 * remove(key) Removes an entry
 * containsKey(key) Checks if a key exists
 * containsValue(value) Checks if a value exists
 * keySet() Returns all keys
 * values() Returns all values
 * entrySet() Returns all key-value pairs
 * size() Returns the number of entries
 * clear() Removes all entries
 * HashMap vs LinkedHashMap
 * HashMap LinkedHashMap
 * Does not maintain order Maintains insertion order
 * Slightly faster Slightly slower (because it maintains order)
 * Uses hashing Uses hashing + a linked list to preserve order
 * 
 * 16.TREEMAP ?
 * TreeMap is a class that implements the Map interface. It stores key-value
 * pairs and automatically sorts the keys in ascending order using a Red-Black
 * Tree. Keys are unique, null keys are not allowed, null values are allowed,
 * and operations like insertion, deletion, and searching take O(log n) time.
 * beacuse the class whose object you want to put in treemap
 * the class must be implementing the Comparable interface.
 * via comaparable interface you can have sorting only
 * onefield of class but comparator interface you can have sort
 * multiple field in same class.
 * 
 * common methods are ->
 * put(key, value) Adds a key-value pair
 * get(key) Returns the value for a key
 * remove(key) Removes an entry
 * firstKey() Returns the smallest key
 * lastKey() Returns the largest key
 * higherKey(key) Returns the next higher key
 * lowerKey(key) Returns the next lower key
 * keySet() Returns all keys in sorted order
 * values() Returns all values
 * size() Returns the number of entries
 * 
 * INTERNAL WORKING OF TREEMAP ?
 * TreeMap stores data using a Red-Black Tree (a self-balancing binary search
 * tree).
 * Because the tree stays balanced, keys remain sorted automatically.
 * Operations like put(), get(), and remove() take O(log n) time.
 * 
 * 17 NAVIGABLE MAP ?
 * 
 * Navigablemap interface ,a new addition in java 6,inherited sorted map
 * to navigation methods that allow for key/values pair searching.
 * the java.util.TreeMap class in java 6 implments Navigablemap
 * 
 * It provides methods to navigate (move around) the map, such as finding:
 * the next key
 * the previous key
 * the nearest key
 * the first key
 * the last key
 * The most common class that implements NavigableMap is TreeMap.
 * 
 * importatnt methods are =>
 * firstEntry()
 * lastEntry()
 * lowerKey()
 * lowerEntry()
 * higherKey()
 * higherEntry(
 * floorKey()
 * ceilingKey()
 * pollFirstEntry()->Removes and returns the first entry.
 * pollLastEntry()->Removes the last entry
 * 
 * 18.IDENTITY MAP ?
 * identity hashmap is a class in java that implements tha map interface and
 * compares key using refersnce equaltu(==) instead of object equalty(equals());
 * 
 * Why do we use IdentityHashMap?
 * when you want two object to be treated as different even if they
 * have the same value,as long as they are different onject in memory.
 * 
 * methods are=>
 * .put()
 * .get()
 * .remove()
 * .containsKey()
 * .containsValue()
 * .size()
 * .isEmpty()
 * .clear()
 * .keySet()
 * 
 * 
 * HashMap vs IdentityHashMap
 * HashMap IdentityHashMap
 * Uses equals()- Uses ==
 * Uses hashCode() -Uses System.identityHashCode() internally
 * Equal objects are treated as one key- Different object references are
 * different keys
 * Most commonly used- Used in special cases
 * 
 * 
 * 18.WEAK HASHMAP?
 * WeakHashMap is a class in Java that stores
 * keys using weak references. If a key has no strong
 * references outside the map, the garbage collector can remove
 * that key-value pair automatically.
 * 
 * 19.Set interface ?
 * * A set stores unique element.does not allow duplicates.and does not support
 * indexing
 * 
 * 20.Queue interface ?
 * A Qeueue is mainly used to processing element in order. Most queue follow
 * FIFO(first in first out)
 * 
 * 21.12.what is hashSet ?
 * HashSet is a class in java that implements the set interface.It is used to
 * store
 * unique elements,meaning it does not allow duplicate values.Internally.it uses
 * a HashMap,which provides fast insertion,deletion,and searching.the
 * average time complexity for these operation is O(1)
 * 
 * 22.Why do we need HashSet?
 * Java introduced HashSet because many applications need only unique data.
 * Unique usernames
 * Unique email addresses
 * Unique employee IDs
 * Unique Aadhaar numbers
 * Unique roll numbers
 * 
 * 23.Diferent between arraylist and linkedList
 * Dynamic arry -----Doubly linkedList
 * fast access ------slow acess
 * slow insertion----fast insertion
 * less momory ------more memory
 * 
 * 24.what is hasshing ?
 * hashing convert an object hashcode into the bukcket index
 * wher the object store.
 * 
 * 25.what is collision ?
 * Collisonn occure when two different key generated the same bucket index
 * handled by linkedlist
 * Balanced tree
 * 
 * 26. difference between comparable and comparator
 * Natural sorting ------custom sorting
 * comapateTo() -----comapare()
 * insisde class-----separate class or lambda
 * 
 * 27.Iterator vs lisiterator
 * forward only ------forward and backward
 * All collection-----list only
 * no add() ------support add() and set()
 * 
 * 28. why would you choose arrayList over linkedList ?
 * I use arraylist when my apllication perfrom frequent reading ,because it
 * provide fast random
 * access element ,if we perform insertion and deletion in the beggining or
 * middle we prfer linkedlist
 * 
 * 
 */

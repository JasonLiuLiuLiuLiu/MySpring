# Java中常用集合类型

最近在学习Java的基础知识,我们知道无论学习哪一门语言,了解其中的基本数据类型肯定是无法跨越的一个环节,而在那些基础的数据类型中,集合类型肯定是热门考点, 深入了解各个集合类型的数据结构以及工作原理才能让我们在从众多集合类型中挑选出一个符合我们业务场景的集合类型.  

该篇文章中,我对Java中常见的集合类型分别从线程性,数据结构,读取操作的时间复杂度等方面进行深入分析,相信看完这篇文章,以后每次用到集合时,应该会更得心应手了.  

在分析这些集合类型时,我根据各个集合的父类继承把这些类型分为Collection和Map, 为什么这么分呢?

## Collection

### List

元素可重复,遍历出来的顺序是插入顺序.

#### ArrayList

要了解ArrayList的工作原理,

``` java

    transient Object[] elementData; // non-private to simplify nested class access
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }

```

可以看到,往ArrayList中添加元素其实是给Object[]数组赋值,而赋值之前,数组的长度是否足够,如果不够了,会对数组进行扩容.

``` java
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
```

#### Vector

Vector是线程安全的,通过观察源码,发现基本所有操作方法上都加上了synchronized,表示同步方法,同时仅允许一个线程进行操作.

``` java
    protected transient int modCount = 0;
    protected Object[] elementData;

    public synchronized boolean add(E e) {
        modCount++;
        ensureCapacityHelper(elementCount + 1);
        elementData[elementCount++] = e;
        return true;
    }
```

同时,每次Vector的被修改modCount都会+1, 这是为了使遍历更安全,在遍历该对象时,如果发现modCount与开始遍历时的值不一致了,就会抛出异常,这样做有什么好处呢?

先假设不抛异常的情况下:

Vector中开始遍历时有 0,1,2,3,4 五个元素, 一波操作后,遍历到了3这里,对应的索引也是3, 可于此同时,Vector中插入了一条数据,变成0,5,1,2,3,4 上一次遍历,我们用的索引时3,那么下一次,我们要读取的时索引为4的数据,然而,修改后,索引4上的数据仍然是3,这个元素就被重复读取了.

所以,遍历时,默认时不允许增删集合元素的.

#### LinkedList

``` java
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    /**
     * Links e as last element.
     */
    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }
```

可以看到,LinkedList插入数据时,并不是给数组赋值,而是给最后的一个节点的下级节点赋值,这种链表存储数据的好处是当插入数据或者删除数据对其他元素没有影响,同时,也不会像ArryList和Vector中存储数据的数组扩容是要把自己的的所有元素赋值给新的数组,所以LinkedList插入删除数据效率更高.

### Set

元素不可重复,遍历顺序不一定是插入顺序.

#### HashSet

``` java

    private transient HashMap<E,Object> map=HashMap<E,Object>();
    // Dummy value to associate with an Object in the backing Map
    private static final Object PRESENT = new Object();
    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
```

在HashSet中插入数据,实际上就是把插入的数据作为Key插入HashMap中,而无论Key为多少,这些Key在HashMap中对应的Value永远为同一个Object对象.

#### LinkedHashSet

``` java
public class LinkedHashSet<E> extends HashSet<E> implements Set<E>, Cloneable, java.io.Serializable {

        private transient HashMap<E,Object> map=map = new LinkedHashMap<>();
        // Dummy value to associate with an Object in the backing Map
        private static final Object PRESENT = new Object();

        public boolean add(E e) {
            return map.put(e, PRESENT)==null;
        }
    }
```

与HashSet同理,LinkedHashSet中插入数据是把待插入的数据作为Key插入到LinkedHashMap中.所有Key对应的Value亦是同一个Object

#### TreeSet

用TreeMap进行存储数据.

``` java

    private transient HashMap<E,Object> map=new TreeMap<E,Object>();

    // Dummy value to associate with an Object in the backing Map
    private static final Object PRESENT = new Object();
    public boolean add(E e) {
        return m.put(e, PRESENT)==null;
    }
```

## Map

存储的是键值对,键不可重复,通过键取值时间复杂度为O(1).

### HashMap

利用Hash表进行数据存储

``` java

    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }

```

``` java
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
```

### HashTable

线程安全

``` java

    public synchronized V put(K key, V value) {

        // Make sure the value is not null
        if (value == null) {
            throw new NullPointerException();
        }

        // Makes sure the key is not already in the hashtable.
        Entry<?,?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K,V> entry = (Entry<K,V>)tab[index];
        for(; entry != null ; entry = entry.next) {
            if ((entry.hash == hash) && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }

        addEntry(hash, key, value, index);
        return null;
    }

    private void addEntry(int hash, K key, V value, int index) {
        modCount++;

        Entry<?,?> tab[] = table;
        if (count >= threshold) {
            // Rehash the table if the threshold is exceeded
            rehash();

            tab = table;
            hash = key.hashCode();
            index = (hash & 0x7FFFFFFF) % tab.length;
        }

        // Creates the new entry.
        @SuppressWarnings("unchecked")
        Entry<K,V> e = (Entry<K,V>) tab[index];
        tab[index] = new Entry<>(hash, key, value, e);
        count++;
    }
```

### TreeMap

二叉树+Hash

``` java
    public V put(K key, V value) {
        Entry<K,V> t = root;
        if (t == null) {
            compare(key, key); // type (and possibly null) check

            root = new Entry<>(key, value, null);
            size = 1;
            modCount++;
            return null;
        }
        int cmp;
        Entry<K,V> parent;
        // split comparator and comparable paths
        Comparator<? super K> cpr = comparator;
        if (cpr != null) {
            do {
                parent = t;
                cmp = cpr.compare(key, t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }
        else {
            if (key == null)
                throw new NullPointerException();
            @SuppressWarnings("unchecked")
                Comparable<? super K> k = (Comparable<? super K>) key;
            do {
                parent = t;
                cmp = k.compareTo(t.key);
                if (cmp < 0)
                    t = t.left;
                else if (cmp > 0)
                    t = t.right;
                else
                    return t.setValue(value);
            } while (t != null);
        }
        Entry<K,V> e = new Entry<>(key, value, parent);
        if (cmp < 0)
            parent.left = e;
        else
            parent.right = e;
        fixAfterInsertion(e);
        size++;
        modCount++;
        return null;
    }
```

### LinkedHashMap

链表+hash

``` java
    static class Entry<K,V> extends HashMap.Node<K,V> {
        Entry<K,V> before, after;
        Entry(int hash, K key, V value, Node<K,V> next) {
            super(hash, key, value, next);
        }
    }
```

``` java
    Node<K,V> newNode(int hash, K key, V value, Node<K,V> e) {
        LinkedHashMap.Entry<K,V> p =
            new LinkedHashMap.Entry<K,V>(hash, key, value, e);
        linkNodeLast(p);
        return p;
    }
```

### Properties

``` java

public
class Properties extends Hashtable<Object,Object> {
    public synchronized Object setProperty(String key, String value) {
        return put(key, value); // 调用HashTable的put方法
    }

}

```

## 线程安全

操作方法上加了  

Vector->(在ArryList的基础上加了synchronized)
Properties->HashTable->(在HashMap基础上加了synchronized)

## 有序性

### 遍历顺序和插入顺序一致

说明存储是基于数组或者链表的

ArrayList,Vector,LinkedList,LinkedHashSet,LinkedHashMap

### 数据的大小保持有序

说明存储是基于二叉树的

TreeSet,TreeMap

## 可以通过索引访问

ArrayList,Vector  O(1) --- 数组
LinkedList  O(N)  --- 链表

## 基于数组

ArrayList,Vector

## 基于链表

LinkedList,LinkedHashSet,LinkedHashMap

## 基于Hash

说明通过key查找时间复杂度为O(1)

HashSet,LinkedHashSet,TreeSet,HashMap,HashTable,TreeMap,LinkedHashMap

## 基于二叉树

说明可以有序遍历
TreeSet,TreeMap
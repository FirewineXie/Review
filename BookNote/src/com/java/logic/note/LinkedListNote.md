# LinkedList 
1. 对于LinkedList 与 ArrayList 的特点是相反的

```java
public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
```
2. 对于 LinkedList  他继承了 List ,Queue 列表和队列
3. 相对于其他队列，LinkedList 的队列是没有**限制**的


## 1. Deque
1. 这个接口，可以当做队列，栈，双端队列
2. 在java中还有stack 栈 的类
    1. 这两个不同的是 stack 是 有线程同步安全的

## 实现原理
### 1. 内部组成
1. LinkedList 是链表，他的内部就是 ==双向链表==
    ```java
       Node<E> node(int index) {
               // assert isElementIndex(index);
       
               if (index < (size >> 1)) {
                   Node<E> x = first;
                   for (int i = 0; i < index; i++)
                       x = x.next;
                   return x;
               } else {
                   Node<E> x = last;
                   for (int i = size - 1; i > index; i--)
                       x = x.prev;
                   return x;
               }
           }
    ```
2. 对于add 添加数据的代码,就是调用这个方法
    ```java
       public void add(int index, E element) {
            checkPositionIndex(index);
    
            if (index == size)
                linkLast(element);
            else
                linkBefore(element, node(index));
        }
     ```
     ```
            void linkLast(E e) {
                  final Node<E> l = last;
                   // 1. 首先创建一个新的节点，而1 和 last 指向原来的尾结点，如果原链表为空，则为null
                  final Node<E> newNode = new Node<>(l, e, null);
               //    2. 修改 尾结点last ，指向 新的最后尾结点
                  last = newNode;
               // 3. 修改前节点的后向连接，如果原来链表为空，则让头结点指向新节点，否则让前一个结点的next指向新节点
                  if (l == null)
                      first = newNode;
                  else
                      l.next = newNode;
                  size++;
                  modCount++;
              }
    ```
    ```java
           void linkBefore(E e, Node<E> succ) {
               // assert succ != null;
               final Node<E> pred = succ.prev;
               final Node<E> newNode = new Node<>(pred, e, succ);
               succ.prev = newNode;
               if (pred == null)
                   first = newNode;
               else
                   pred.next = newNode;
               size++;
               modCount++;
           }    
    ```
3. 根据内容查找元素indexof
    ```java
       public int indexOf(Object o) {
               int index = 0;
               if (o == null) {
                   for (Node<E> x = first; x != null; x = x.next) {
                       if (x.item == null)
                           return index;
                       index++;
                   }
               } else {
                   for (Node<E> x = first; x != null; x = x.next) {
                       if (o.equals(x.item))
                           return index;
                       index++;
                   }
               }
               return -1;
           }
    ```
4. 根据索引来查找值
    ```java
           public E get(int index) {
               //检查索引位置的有效性
               checkElementIndex(index);
               return node(index).item;
           }
    ```
5. 删除元素 remove
    ```java
        public boolean remove(Object o) {
               if (o == null) {
                   for (Node<E> x = first; x != null; x = x.next) {
                       if (x.item == null) {
                           unlink(x);
                           return true;
                       }
                   }
               } else {
                   for (Node<E> x = first; x != null; x = x.next) {
                       if (o.equals(x.item)) {
                           unlink(x);
                           return true;
                       }
                   }
               }
               return false;
           }
    ```
    ```java
        E unlink(Node<E> x) {
               // assert x != null;
               final E element = x.item;
               final Node<E> next = x.next;
               final Node<E> prev = x.prev;
       
               if (prev == null) {
                   first = next;
               } else {
                   prev.next = next;
                   x.prev = null;
               }
       
               if (next == null) {
                   last = prev;
               } else {
                   next.prev = prev;
                   x.next = null;
               }
       
               x.item = null;
               size--;
               modCount++;
               return element;
           }

    ```
   
### 2. LinkedLish 特点分析
1. 按需分配空间，不需要预先分配空间
2. 不可以随机访问，按照索引效率低，，因为只能通过遍历O(n/2)
3. 不管是否已经排序，只要按照内容排序，效率也是比较低，必须要逐个比较O(n)
4. 在两端添加，删除元素的效率很高(1)
4. 在中间插入，删除元素，要先定位，效率比较低O(n)，， 但是修改本身的效率很高O(1)
   
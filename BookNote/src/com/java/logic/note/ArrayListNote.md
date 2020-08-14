# 用java实现栈 和队列，，并查看java源码 
## 动态数组容器ArrayList(泛型容器)


### 1. 对于主要方法，不在这赘述
### 2. 基本原理

1. 对于基本原理类似于 动态数组DynamicArray
```java
public class DynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;
    public DynamicArray(){
        this.elementData = new Object[DEFAULT_CAPACITY];
    }
    
    /**
    *  首先确保，空间是满足的
    * @param minCapacity
    */
    private void ensureCapacity(int minCapacity){
        int oldCapacity = elementData.length;
        if (oldCapacity >= minCapacity){
            return;
        }
        int newCapacity = oldCapacity * 2;
        if (newCapacity < minCapacity){
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData,newCapacity);
    }
    public void  add(E e){
        ensureCapacity(size +1);
        elementData[size++] = e;
    }
    public E get(int index){
        return (E)elementData[index];
    }
    public int size(){
        return size;
    }
    public E set(int index,E element){
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }
}

```
### 3. 在ArrayList 的接口 实现 了迭代的接口(Iterable)
1. 实现了迭代就可以使用更加的简化的foreach 语法，
2. **iterable 和 iterator  是不一样的，**
    1. Iterable  表示 对象可以被迭代，他有一个方法iterator 返回iterator对象，实际是对iterator接口的方法进行遍历
    2. 如果对象实现了iterable，就可以创建foreach语法
    3. 类可以不实现iterable ，也可以创建iterator 对象
3. 迭代的陷进
    1. 就是 不能在迭代的过程中调用容器的删除方法
        ```java
       public void remove(ArrayList<Integer> list){
           for(Integer a :list){
            if(a <= 100){
             list.remove(a);
             }
            }
       }
        ```
   2. 但是如果改成 这样 ，就不会报错
        ```java
               public void remove(ArrayList<Integer> list){
                   for(Integer a :list){
                    if(a <= 100){
                     list.remove();
                     }
                    }
               }
        ```
   3. ArrayList 的迭代原理 
      ```JAVA
          public ListIterator<E> listIterator(int index) {
              if (index < 0 || index > size)
                  throw new IndexOutOfBoundsException("Index: "+index);
              return new ListItr(index);
          }

      ```
   4. 使用迭代器 表示的是一种关注点分离的思想，将数据的实际组织方式与数据的迭代遍历相分离，这是一种常见的设计模式
### 4. ArrayList实现的接口
1. ==三个主要的接口： collection， List， RandomAccess==
#### 1. collection
1. 表示一个数据集合，数据间没有位置和顺序的概念
2. 主要的方法 可以通过点击查看源码，更加有深刻的认识
#### 2. List
1. 表示有顺序或位置的数据集合，它更是扩展了Collection
#### 3. RandomAccess
1. 这个定义是空的
    ```java
       public iterface RandomAccess{
    
       }
    ```
2. **这种没有任何代码的接口在java 中被称为==标记接口==，用于声明类的一种属性**
3. 这里实现，接口表示，可以随机访问，可随机访问就是具备类似数组那样的特性

### 5. 总结ArrayList
1. 对于ArrayList 他的特点就是内部采用动态随机数组实现，
    1. 可以随机访问，按照索引位置进行访问效率高，O(1)
    2. 除非数组已经排序，不然按照内容排序，效率低O(n)
    3. 添加N个元素的效率为O(n)
    4. 插入和删除元素的效率比较低，因为要移动元素O(n)
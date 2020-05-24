####数组,链表，跳表
数组:  
    内存地址连续的一个空间  
复杂度分析:  
插入、删除:O(n)  
查询:O(1)  
操作分析:  
插入/删除：找到位置后，移动之后的k个元素
查询:根据下标查询
  


链表:  
    节点与节点之间引用来构建，Java中的LinkedList也实现了Queue的接口  
复杂度分析:  
插入、删除:O(1)  
查询:O(n)
操作分析:  
插入：头插法和尾插法，下标插入  
删除：
```
    //单向链表，找到删除节点的前一个节点node
    node.next = node.next.next
    //双向链表，找到删除的节点
    node.next.prev = node.prev
    node.prev.next = node.next
```
查询:根据下标查询

跳表：  
    简单理解就是添加了多级索引的链表，且只能用于元素有序的情况  
复杂度分析:  
插入、删除:O(1)  
查询:O(logn)  
工程中应用：Redis，LRU算法

####栈，队列，优先队列
栈：  
先进后出  
复杂度分析：
添加、删除：O(1)  
查询：O(n)  
队列：  
先进先出  
复杂度分析：  
添加、删除：O(1)，仅从队列接口的性质来看，添加删除是O(1)的，但是由于不同的队列实现，其操作复杂度，不一定为O(1)  
查询：O(n) 
优先队列  
先进先出,具有优先级，优先级高低决定出队顺序，java中默认实现为二叉堆  
复杂度分析：  
添加、删除：O(1)，群里讨论不一定为O(1),还需要再讨论研究下  
查询：O(logn)

Queue源码分析：  
Queue在java中是一个接口描述了Queue应有的特性  
```java
public interface Queue<E> extends Collection<E> { 
    //插入在队列尾部，如果超过容量会抛出异常
    boolean add(E e);
    //插入在队列头部，特定实现会自动扩容，否则超过容量会抛出异常
    boolean offer(E e);
    //删除头部元素，队列为空时抛出异常
    E remove();
    //取出元素，但不删除从队列中删除，队列为空时，返回null
    E poll();
    //取出元素，但不删除从队列中删除，队列为空时，抛出异常
    E element();
    //取出元素，并从队列中删除，队列为空时，返回null
    E peek();
}
```

改写Deque
```java
class Test{
    public static void main(String[] args){
        testQueue();
    }

    private void testQueue() {
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addLast("b");
        deque.addFirst("c");
        System.out.println(deque);
        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pollLast());
        }
        System.out.println(deque);

    }
}

```

阶段自我总结：  
自己前期时间分配不均，导致练习次数不够，整体课程还要再次看一遍。晚上每天需要再抽一两个小时出来  
过一下视频，做1~2道算法题，然后周末才会有充足的时间来复习和预习。


  

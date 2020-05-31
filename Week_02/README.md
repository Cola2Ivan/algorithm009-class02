####哈希表、映射、集合
学习总结：  
Set：不存在重复的值
HashMap：不存在重复的Key，Key-Value映射
针对Set和Map仅仅是有简单的认识，在面对leetcode上的相关题目时，  
发现自己对简单集合的操作局限于会用，对简单集合对实际问题的解决，  
没有达到举一反三的效果。
####树、二叉树、二叉搜索树
知识点：二叉树高度为logN，可以看到许多要求logN的算法问题，均  
可以先想到用二叉树解决。  
遍历：  

```java
    
    class Test{
        //递归前序遍历: 
        public void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }  
        //中序遍历
        public void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);
        }    
    }   
   
``` 
根据前序和中序可以推断出后序遍历
####堆，二叉堆，图
堆：大顶堆、小顶堆  
曾经面试一家公司，问题是如何找到钱1000名的玩家，当时完全没想法，现在看来  
就是一个基于积分点构建大顶堆的问题，也就是常见的top k问题。java中使用  
PriorityQueue很简单就可以实现。  
图：  
图的数据描述，可以使用顶点和边来进行描述。具体可以使用矩阵和链表两种实现方  
式。  
顶点矩阵：KxK的矩阵，其中K代表顶点个数，矩阵中的值，则代表边的信息，如果  
有权重则为权重值，没有则为1。  
链表：描述了顶点的边的信息，使用额外的值来存储权重信息。  



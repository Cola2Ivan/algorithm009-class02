学习笔记  
位运算:   
左移：<<  
右移：>>  
或：|  
与：&  
按位取反：~  
按位异或：^  
```
    //位运算交换两个数
    c=a^b
    a^c=b,b^c=a
    //结合法
    a^b^c=a^(b^c)=(a^b)^c

    //指定位置的位运算
    1、将x最右边的n位清零：x&(~0<<n)
    2、获取x的第n位值（0或1）：(x>>n)&1
    3、获取x的第n位的幂值：x&(1<<n)
    4、仅将第n位置为1：x|(1<<n)
    5、仅将第n位置为0：x&(~(1<<n))
    6、将x最高位至第n位（含)清零：x&((1<<n)-1)

    实战类要点：
    判断奇偶：
        x%2==1=>(x&1)==1 
        x%2==1=>(x&1)==1
    x>>1->x/2
    x=x&(x-1) 清零位中最后出现的1
    x&-x=>得到最低位的1所代表的值，例如00110通过操作得到的是2
    x&~x=0
```
注:位运算不会改变原始的值，位运算会返回结果。
布隆过滤器和LRUCache  
Bloom Filter：  
   常与哈希表进行对比。  
   布隆过滤器指用于判断元素是否在集合中，不需要把数据保存在集合中。  
   一个很长的二进制向量和一系列的随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中.  
   优点是空间效率和查询时间远远超过一般的算法。  
   缺点是有一定的误识别率和删除困难。  
   
   二进制向量位置都为1，不能确定是否存在，如果有一个为0，把那么必然元素不存在。  
   布隆过滤器可以作为检测不存在的缓存层。存在的话直接去查数据库。 
```java
//布隆过滤器实现实例
``` 
LRUCache算法(最新最少使用)  
大小、替换策略

实现:哈希表和双向链表

O(1)查询
O(1)修改、更新

替换策略:LFU最少频率 LRU最近使用

排序算法
比较类排序
通过比较决定元素相关顺序。由于其时间复杂度不能突破O(nlogn)
,因此也称为非线性时间比较类排序。
非比较类排序
不通过比较来决定元素顺序，可以突破基于比较排序时的时间下界，
也称为线性时间非比较类排序。一般用于整型数据类型。

初级排序 - O(n^2)
冒泡排序
```java
class BubbleSort{
    public void bubbleSort(int [] nums){
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = 1; j < nums.length; j++) {
                if(nums[i]>nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}

```
插入排序
```java
class InsertSort{
    public void insertSort(int[] nums){
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[cur];
            int pos = cur -1;
            while(pos>=0 && nums[pos] > cur ){
                 nums[pos+1] = nums[pos];
                 pos = pos -1;
            }
            nums[pos] = cur;
        }
    }
}
```
选择排序
```java
class SelectedSort{
    public void selectSort(int []nums){
        for(int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for(int j = i; j < nums.length; j++) {
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            if(min == i){
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }   
    }
}
```


希尔排序

高级排序
堆排序
```java
class HeapSort{
    public void heapSort(int[] array){
        if(array.length == 0){
            return;
        }
        int length = array.length;
        for(int i = length/2 -1; i >= 0; i--) {
            heapify(array,length,i);
        }
        for(int i = length -1; i >= 0 ; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array,i,0);
        }
    }
    public void heapify(int[] array,int length,int i){
        int left = 2 * i +1;
        int right = 2 * i  +2;
        int largest = i;
        if(left < length && array[left] > array[largest]){
            largest = left;
        }

        if(right < length && array[right] > array[largest]){
            largest = right;
        }
        if(largest != i){
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array,length,largest);
        }

    }

}
```
快速排序
```java
class QuickSort{
    public void quickSort(int[] array,int begin,int end){
        if(end<= begin){
            return;
        }
        int pivot = partition(array,begin,end);
        quickSort(array, begin, pivot -1);
        quickSort(array, pivot + 1, end);
    }
        
    public int partition(int[] a,int begin,int end){
        int pivot = end,counter = begin;
        for(int i = begin; i < end; i++) {
            if(a[i] < a[pivot]){
                int temp = a[counter];
                a[counter] = a[i];
                a[i] = temp;
                counter++;
            }
        }
        int temp = a[pivot];
        a[pivot] = a[counter];
        a[counter] = temp;
        return counter;
    }
}
```
归并排序 
```java
class MergeSort(){
    public void mergeSort(int[] array,int left,int right){
        if(right <= left){
            return;
        }
        int mid = (left+right)>>1;
        mergeSort(array,left,mid);
        mergeSort(array,mid+1,right);
        merge(array,left,mid,right);
    }
    private void merge(int[] arr,int left,int mid,int right){
        int[] temp = new int[right - left + 1];//中间数组
        int i= left;
        int j = mid +1;
        int k = 0;
    
        while(i <= mid&& j <= right){
            temp[k++] = arr[i] <= arr[j]?arr[i++]:arr[j++];
        }
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        while(j <= right){
            temp[k++] = arr[j++];
        }
        for(int p = 0; p < temp.length; p++) {
            arr[left+p] = temp[p];
        }
    }   
    
}
```

特殊排序
计数排序
桶排序
基数排序
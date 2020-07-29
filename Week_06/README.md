学习笔记
####动态规划
动态规划一般是解决在递归或分治的基础上加上求最优子结构的问题  
1、人肉递归低效  
2、找到最近最简方法，将其拆解成可重复解决的问题  
3、数学归纳法的思维  
递归模板
```java
class Recurit{
    public void recur(int level,int param) {
        //递归终止条件
        if (level > MAX_LEVEL) {
            //处理结果值
            return;
        }
        //处理当前层结果数据
        process(level,param);
        //到下一个层级进行递归
        recur(level + 1,param);
        
        //重置当前的状态(非必须)
    }   
}
```
分治模板：
```java
class dividerConquer {
    public <T> int dividerConquer(List<T> problem,int params) {
        //递归终止，问题解决
        if(problem == null) {
            //处理结果
            return result;
        }
        
        //分解子问题，求解子问题
        List<List<T>> subProblems = splitPro(problem,params);
        int result1 = dividerConquer(subProblems[0],params);
        int result2 = dividerConquer(subProblems[1],params);
        int result3 = dividerConquer(subProblems[2],params);
        //... 

        //merge合并问题结果
        result = merge(result1,result2,result3);

        //重置当前层状态

        return result;
    }
}
```

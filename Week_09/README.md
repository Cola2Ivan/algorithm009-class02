学习笔记
####高级动态规划
1.递归  
模板
```java
class Recruit{
    
    public void recur(int level,int param){
        //终止条件
        if(level > MAX_LEVEL){
            //处理结果
            return;
        }
        //处理当前逻辑
        process(level,param);
        
        //下沉逻辑到下一层递归
        recur(level+1, param);

        //处理中间状态
    }
    
}
```
2.分治
模板
```java
public class Divider{
    public void divider(int level,int param,int[] problem){
        //终止条件
        if(level > MAX_LEVEL){
            //处理结果
            return;
        }
        
        //数据准备拆分问题
        int data = process(param);
        int[][] subproblems = splitProblem(problem,param);
        int[] subResult = new int[subproblems.length];

        //处理子问题
        for(int i = 0; i < subproblems.length; i++) {
            int[] subproblem = subproblems[i];
            subResult[i] = divider(level, param, subproblem);
        }
        
        //合并结果,根据子问题确定最终结果
        mergeResult = processResult(subResult);
        
        //中间状态重置
    }
}
```
```
   总结：
   1.人肉递归很低效
   2。递归要找到最近最简方法，将其拆解为可重复解决的问题
   3.数学归纳法的思维
```

动态规划：  
复杂问题分解为简单的子问题  
使用分治和最优子结构的方式   
顺推形式:动态的递推(从斐波那契数列理解这个思路)  

模板与难点：
```java
class DynamicProblem{
    public void dp(){
        //难点一：如何抽象问题状态`
        int[][] dp = new int[M][N];
        
        for(int i = 0; i < M; i++) {
            for(int j = 0; i < N; i++) {
                //难点二：确定动态规划状态转移方程
                //从已知状态找到当前状态的最优值问题
                dp[i][j] = dpFunction();              
            }
        }
        //最终结果
        System.out.println(dp[M][N]);
    }   

}
```  
高级动态规划  
增加了状态的维度和动态方程选择的难度，一般考察的是数学思维和逻辑思维  
####字符串算法

package com.cola.algorithm09;

public class NumDecodings {

    /**
     * 题号91 解码方法
     * @see {https://leetcode-cn.com/problems/decode-ways/}
     * input: "226" "101"
     * output: 3 1
     * @see {https://leetcode-cn.com/problems/decode-ways/solution/dong-tai-gui-hua-java-python-by-liweiwei1419/}
     * 需要理解题解中的分步计数乘法原理和分类计数加法原理
     * 针对这个题目：s[i]结尾的子串，当s[i] != '0'时，可以解码，s[i-1]结尾的子串有dp[i-1]中方法，由于相互独立，所以使用的是分步乘法原理
     * 而针对两个数字的解码则需要使用分类加法，
     * 1、dp[i-2] * 1 + dp[i],其中dp[i-2] 是两个字符编码
     * 2、dp[i] 是前一个单字符可以编码情况下的编码值也可以写作dp[i-1]，不可以编码的情况下，则为dp[i] = 0;
     * */
    public static int numDecodings(String s){
        int len = s.length();
        if(len == 0){
            return 0;
        }

        if(len== 1){
            return 1;
        }
        //状态定义
        //第i个字符的解码结果最多有几个
        int[] dp = new int[len];
        dp[0] = 1;

        //状态方程定义
        for (int i = 1; i < len; i++) {
            int top = s.charAt(i-1) -'0';
            int sec = s.charAt(i) - '0';
            int nums = top * 10 + sec;
            if(nums == 0){
                return 0;
            }
            if(sec != 0){
                dp[i] = dp[i - 1] * 1;
            }
            //两位数
            if(nums >= 10 && nums <=26){
                if(i == 1){
                    dp[i] = dp[i] + 1;
                } else {
                    //由于前边已经做了sec != 0时的处理 所以这里可以直接写为dp[i] = dp[i] +dp[i-2]的形式
//                    if(sec == 0){
//                        dp[i] = dp[i-2];
//                    }else {
//                        dp[i] = dp[i -1] + dp[i-2];
//                    }
                    dp[i] = dp[i] + dp[i-2];
                }
            }
        }
        return dp[len -1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}

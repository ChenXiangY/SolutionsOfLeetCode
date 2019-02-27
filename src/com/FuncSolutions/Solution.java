package com.FuncSolutions;

import src.com.SharedClass.ListNode;
import src.com.SharedClass.TreeNode;

import java.util.*;

/**
 * 目前进度:50道简单题,暂时搁置.
 * 不会的题目或者写的比较差的题目:108,136(空间换时间),141(空间换时间),172,189(只实现了丑陋的双重循环算法)..
 * @author Chen Xiangyu
 * @version 1.0
 * @classname Test1
 * @date 2019/1/29
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }


    /**
     * 191题,位1的个数,比较简单,和上一道简单题差不多的思路.
     * @author Chen Xiangyu
     * @date 2019/2/27 13:46
     * @param n
     * @return int
     */
    public int hammingWeight(int n) {
//        方法1:位运算
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n&1) == 1){
                count++;
            }
            n >>=1;
        }
        return count;
//        方法2:字符串运算.
        /**
         *
         *     public int hammingWeight(int n) {
         *         String a = Integer.toBinaryString(n);
         *         int count = 0;
         *         for (int i = 0; i < a.length(); i++) {
         *             if (a.charAt(i)=='1'){
         *                 count++;
         *             }
         *         }
         *         return count;
         *     }
         */
    }

    /**
     * 190题,颠倒二进制位,这个题不知道咋回事,输入的数字不知道是什么,如果是那么长一串数字连跑都跑不通.如果是n是十进制数的话就能跑通代码,
     * 本质就是进制的转换问题.在这里使用了比较笨的方法.
     * @author Chen Xiangyu
     * @date 2019/2/26 23:30
     * @param n
     * @return int
     */
    public int reverseBits(int n) {
        int count = 0;
        int result=0;
        while (count<32) {
            result = ((result<<1) + (n&1));
            n = n >>> 1;
            count++;
        }
        return result;
        /**
         * 这个是从网上摘下来的方法,直接使用位运算,更加简洁方便.负数的那部分左移31位不太理解,其他的是常规操作.
         *     public int reverseBits(int n) {
         *         int temp = n;
         *         if(n>0){
         *             n |= (1<<31);
         *         }
         *         int result = 0;
         *         while(n!=0){
         *            result = ((result<<1)+(n & 1));
         *            n >>>= 1;
         *         }
         *         return temp>0?result-1:result;
         *     }
         */

    }

    /**
     * 189题,旋转数组.
     * 官网说尝试用更多方法.
     *
     * @param nums
     * @param
     * @return void
     * @author Chen Xiangyu
     * @date 2019/2/26 16:42
     */
    public void rotate(int[] nums, int k) {
//        方法1:每次只移动1位,移动k次.但是这样似乎空间复杂度很高?即使调用的是System.arraycopy方法.
//        int temp;
//        for (int i = 0; i < k; i++) {
//            temp = nums[nums.length - 1];
//            System.arraycopy(nums, 0, nums, 1, nums.length - 1);
//            nums[0] = temp;
//        }
//        方法2:每次循环都移动k个元素,如果到达尾,则赋值给头.
//        for (int i = 0; i < k; i++) {
//            Integer temp = null;
//            Integer temp1 = null;
//            int j = i;
////            应该是先把当前位置的数字提取出来,然后把上一次的结果赋值给现在的位置.
//            while (true){
//                if (j + k > nums.length - 1) {
//                    nums[j+k-nums.length] = nums[j];
//                    break;
//                }else if(temp == null){
//                    temp = nums[j];
//                }else{
//                    temp1 = nums[j];
//                    nums[j] = temp;
//                    temp = temp1;
//                }
//                j += k;
//            }
//        }
//        方法3: 一直循环直到i = 0;比如例子{1,2,3,4,5,6,7},1>4 4>7 7>3 3>6,6>2...5>1 索引为0,结束.

    }

    /**
     * 172题,阶乘后的零.这题没做出来,看的别人的答案.
     *
     * @param n
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/26 11:11
     */
    public int trailingZeroes(int n) {
        int sum = 0;
        long t = 5;
        while (t <= n) {
            sum += n / t;
            t *= 5;
        }
        return sum;
    }

    /**
     * 171题,Excel表列序号,其实就是168题反过来而已.
     *
     * @param s
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/24 23:30
     */
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            int temp = s.charAt(i) - 'A' + 1;
            result += temp * Math.pow(26, s.length() - 1 - i);
        }
        return result;
    }

    /**
     * 169题,求众数
     *
     * @param nums
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/22 23:43
     */
    public int majorityElement(int[] nums) {
//        空间换时间,hashmap记录次数.
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        int i;
        for (i = 0; i < nums.length; i++) {
            Integer current = counts.get(nums[i]);
            if (current == null) {
                counts.put(nums[i], 1);
            } else {
                counts.put(nums[i], current + 1);
            }
            current = counts.get(nums[i]);
            if (current > nums.length / 2) {
                break;
            }
        }
        return nums[i];
    }

    /**
     * 168题,Excel表列名称
     *
     * @param n
     * @return java.lang.String
     * @author Chen Xiangyu
     * @date 2019/2/22 10:13
     */
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
//        begin用于计算. 其实就是26进制...
        char begin = 'A' - 1;
        char temp;
        while (n > 0) {
            int a = n % 26;
            if (a == 0) {
                a = 26;
            }
            temp = (char) (begin + a);
            result.insert(0, temp);
            n = (n - a) / 26;
        }
        return result.toString();
    }


    /**
     * 167,两数之和,输入有序数组.
     *
     * @param numbers
     * @param target
     * @return int[]
     * @author Chen Xiangyu
     * @date 2019/2/21 23:33
     */
    public int[] twoSum2(int[] numbers, int target) {
//      用二分查找碰见负数直接完蛋.思考双指针法.
        int i = 0;
        int j = numbers.length - 1;
        int sum;
        int[] result = new int[2];
        while (i <= j) {
            sum = numbers[i] + numbers[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }
        }
        return result;
    }


    /**
     * 160题,相交链表
     * 不会写,先空着,不想看答案.
     *
     * @param headA
     * @param headB
     * @return src.com.SharedClass.ListNode
     * @author Chen Xiangyu
     * @date 2019/2/21 22:31
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return new ListNode(1);
    }

    /**
     * 125题,验证回文串
     *
     * @param s
     * @return boolean
     * @author Chen Xiangyu
     * @date 2019/2/19 11:34
     */
    public boolean isPalindrome(String s) {
        return false;
    }

    /**
     * 122题,买卖股票的最佳时机2,题目1的变种,可以多次买卖.我觉得可以在1的基础上多加条件或者循环就可以了.
     *
     * @param prices
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/19 9:25
     */
    public int maxProfit2(int[] prices) {
        int buy = 0;
        int profit = 0;
        int total = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0 || prices[i] - buy < profit) {
//                当天就卖出
                buy = prices[i];
                total += profit;
                profit = 0;
            } else {
                profit = Math.max(profit, prices[i] - buy);
            }
            if (i == prices.length - 1) {
                total += profit;
            }
        }
        return total;
    }

    /**
     * 121题,买卖股票的最佳时机,涉及动态规划
     *
     * @param prices
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/19 8:03
     */
    public int maxProfit(int[] prices) {
//        如果利润小于0,则算当天为买入的,利润清0,知道max(前面的利润,当天卖掉)的利润为止.要处理的是第一天和结尾的时候.
        int buy = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0 || (prices[i] - buy) < 0) {
                buy = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - buy);
            }
        }
        return profit;
    }

    /**
     * 119题,杨辉三角2,其实和118题根本不差啥..
     *
     * @param rowIndex
     * @return java.util.List<java.lang.Integer>
     * @author Chen Xiangyu
     * @date 2019/2/19 7:55
     */
    public List<Integer> getRow(int rowIndex) {
        ArrayList<List<Integer>> result = (ArrayList<List<Integer>>) new Solution().generate(rowIndex + 1);
        return result.get(rowIndex);
    }

    /**
     * 118 杨辉三角
     *
     * @param numRows
     * @return java.util.List<java.util.List                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               <                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               java.lang.Integer>>
     * @author Chen Xiangyu
     * @date 2019/2/18 23:43
     */
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<>(numRows);
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            temp.clear();
            for (int j = 0; j < i + 1; j++) {
                int a = j == 0 || j == i ? 1 : result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                temp.add(a);
            }
            result.add((List<Integer>) temp.clone());
        }
        return result;
    }

    /**
     * 112题,路径总和,还是递归.
     *
     * @param root
     * @param sum
     * @return boolean
     * @author Chen Xiangyu
     * @date 2019/2/18 23:12
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum = sum - root.val;
        if (sum == 0) {
            return true;
        }
        boolean a = hasPathSum(root.left, sum);
        boolean b = hasPathSum(root.right, sum);
        return a || b;
    }

    /**
     * 111题,二叉树的最小深度.感觉和最大深度其实差不多.
     *
     * @param root
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/18 19:09
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else if (root.left == null || root.right == null) {
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    /**
     * 110题,查看一棵树是否是平衡二叉树
     *
     * @param root
     * @return boolean
     * @author Chen Xiangyu
     * @date 2019/2/17 23:37
     */
    public boolean isBalanced(TreeNode root) {
//         递归比较当前节点的左数与右树的差值是否大于1;
        if (root == null) {
            return true;
        }
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }


    /**
     * 108题,这题不会写,抄的.
     *
     * @param nums
     * @return TreeNode
     * @author Chen Xiangyu
     * @date 2019/2/19 12:05
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return new TreeNode(nums[l]);
        }
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, l, mid - 1);
        root.right = buildTree(nums, mid + 1, r);
        return root;
    }

    /**
     * 107题,二叉树的层次遍历2
     *
     * @param root
     * @return java.util.List<java.util.List                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               <                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               java.lang.Integer>>
     * @author Chen Xiangyu
     * @date 2019/2/19 12:04
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //每次循环都push进去一次就行了
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        // 一个栈结构用来存放临时节点.
        if (root == null) {
            return result;
        }
        ArrayList<TreeNode> stack = new ArrayList<>();
        ArrayList<TreeNode> stack1 = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            for (TreeNode node :
                    stack) {
                temp.add(node.val);
                if (node.left != null) {
                    stack1.add(node.left);
                }
                if (node.right != null) {
                    stack1.add(node.right);
                }
            }
            stack.clear();
            stack.addAll(0, stack1);
            stack1.clear();
            result.add(0, (List<Integer>) temp.clone());
            temp.clear();
        }
        return result;
    }

    /**
     * 104,树的最大深度
     *
     * @param root
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/19 12:03
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 101题,对称二叉树,利用100题的结果,把第100题里面相比较的两个left还是right交换一下即可.
     *
     * @param root
     * @return boolean
     * @author Chen Xiangyu
     * @date 2019/2/16 21:46
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        } else {
            return isSameTree(root.left, root.right);
        }
    }

    /**
     * 100题,给定两个二叉树,看是否相同.
     * 有了点思路,可以有一个表用来存储,不过太占用内存了.
     *
     * @param p
     * @param q
     * @return boolean
     * @author Chen Xiangyu
     * @date 2019/2/12 9:47
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
//        递归调用这个函数,先查看当前点的值时候相同,如果当前点的值相同再看左右是否相同,
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        }
        if (Integer.compare(p.val, q.val) != 0) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 还是第88题,使用原始的归并排序占用空间比较大,重新写一个.
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return void
     * @author Chen Xiangyu
     * @date 2019/2/16 16:29
     */
    public void merge(int[] nums1, int m, int[] nums2, int n, boolean flag) {
        int j1 = m - 1;
        int j2 = n - 1;
        for (int i = m + n - 1; i > -1; i--) {
//            都是非负整数,直接将nums1的某个位置置为0就可以了.
            if (j1 < 0) {
                nums1[i] = nums2[j2];
                j2--;
            } else if (j2 < 0) {
                continue;
            } else if (nums1[j1] > nums2[j2]) {
                nums1[i] = nums1[j1];
                j1--;
            } else {
                nums1[i] = nums2[j2];
                j2--;
            }
        }
    }

    /**
     * 88题 合并两个有序数组.nums1空间足够.其实是个查找的问题.二分查找不想再用了.
     * 评论区里说从后往前排.
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return void
     * @author Chen Xiangyu
     * @date 2019/2/11 14:46
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j2 = n - 1;
        int j1 = m - 1;
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);
        for (int i = m + n - 1; i > -1; i--) {
//            查找出最大的值.
            if (j2 < 0) {
                nums1[i] = temp[j1];
                j1--;
            } else if (j1 < 0) {
                nums1[i] = nums2[j2];
                j2--;
            } else if (temp[j1] > nums2[j2]) {
                nums1[i] = temp[j1];
                j1--;
            } else {
                nums1[i] = nums2[j2];
                j2--;
            }
        }
    }

    /**
     * 83题,链表相关的题目,总感觉以前做过啊?
     *
     * @param head
     * @return ListNode
     * @author Chen Xiangyu
     * @date 2019/2/11 11:08
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        int currentVal = head.val;
        while (temp != null) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.val == currentVal) {
                if (temp.next.next != null) {
                    temp.next = temp.next.next;
                } else {
                    temp.next = null;
                    break;
                }
            } else {
                temp = temp.next;
                currentVal = temp.val;
            }

        }
        return head;
    }

    /**
     * 70题,爬楼梯
     * 爬楼梯,好像是比较经典的动态规划问题.
     *
     * @param n
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/10 22:17
     */
    public int climbStairs(int n) {
//        存放的是每步台阶共有多少种方法.
        ArrayList<Integer> step = new ArrayList<Integer>();
        int nth = 0;
//        初始化0,1台阶
        int sum = 0;
        step.add(0, 0);
        step.add(1, 1);
        step.add(2, 2);
        for (int i = 3; i <= n; i++) {
            sum = step.get(i - 1) + step.get(i - 2);
            System.out.println("i=" + i + "\t" + sum);
            step.add(i, sum);
        }
        return step.get(n);
    }

    /**
     * 69题,x的方根,使用二分查找进行查找,遇到了循环的时候平方会溢出的问题.
     *
     * @param x
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/10 21:23
     */
    public int mySqrt(int x) {
//         使用二分查找的话,那就是在0-x里面找,
        int lo = 0;
//        hi为根号下int.max的最大值.
        int hi = 46340;
        int find = 0;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
//            这里遇到了问题,当值过大的时候会溢出.
            find = mid * mid;
            if (find > x || find < 0) {
                hi = mid - 1;
            } else if (find < x) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
//                 向下取一位
        return lo - 1;
    }

    /**
     * 67题: 二进制加减,感觉和66题是一样的思路,无非是对应位相加,直接使用字符串来操作.
     *
     * @param a
     * @param b
     * @return java.lang.String
     * @author Chen Xiangyu
     * @date 2019/2/10 11:19
     */
    public String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
//        对应位相加减.
        String tempMax = a.length() >= b.length() ? a : b;
        String tempMin = a.length() < b.length() ? a : b;
        int ai = tempMax.length() - 1;
        int bi = tempMin.length() - 1;
        int c = 0;
        int sum;
        char temp = '0';
        while (ai > -1) {
            if (bi > -1) {
                sum = Character.getNumericValue(tempMax.charAt(ai)) + Character.getNumericValue(tempMin.charAt(bi)) + c;
            } else {
                sum = Character.getNumericValue(tempMax.charAt(ai)) + c;
            }
            c = sum / 2;
            sum = sum % 2;
            stringBuilder.insert(0, sum);
            ai--;
            bi--;
        }
        if (c > 0) {
            stringBuilder.insert(0, c);
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    /**
     * 66题
     * 使得数组加1;
     *
     * @param digits
     * @return int[]
     * @author Chen Xiangyu
     * @date 2019/2/10 11:06
     */
    public int[] plusOne(int[] digits) {
//        核心在于有进位.进位怎么结算.
//        进位标志位.
        int c = 1;
        int[] temp;
        for (int i = digits.length - 1; i > -1; i--) {
//            从后往前推,每次加进位.
            digits[i] += c;
            if (digits[i] == 10) {
                digits[i] = 0;
                c = 1;
            } else {
                c = 0;
            }
//            如果说溢出了.
            if (i == 0 && c == 1) {
                temp = new int[digits.length + 1];
                temp[0] = c;
                System.arraycopy(digits, 0, temp, 1, digits.length);
                digits = temp;
            }
        }

        for (int i = 0; i < digits.length; i++) {
            System.out.println(digits[i]);
        }
        return digits;
    }

    /**
     * 58题,最后一个单词的长度.
     * 碰见空格就重新开始计
     *
     * @param s
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/10 8:31
     */
    public int lengthOfLastWord(String s) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (flag) {
                    count = 0;
                }
                count++;
            } else {
                flag = true;
            }
        }
        return count;
    }

    /**
     * 53题,最大子序和,没写出来,抄袭的评论区代码.
     *
     * @param nums
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/9 15:44
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
//                只要前面的和<0,那么当前数字加和肯定比自身小.重新求和.
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    /**
     * 38题,报数
     *
     * @param n
     * @return java.lang.String
     * @author Chen Xiangyu
     * @date 2019/2/19 11:59
     */
    public String countAndSay(int n) {
//        两个数字分别记录当前的是什么字符.查看后边字符是否一样,有几个一样,
        StringBuilder result = new StringBuilder("1");
        char current;
        char after;
        int count = 0;
        for (int i = 1; i < n; i++) {
            String temp = result.toString();
            result = new StringBuilder();
            for (int j = 0; j < temp.length(); ) {
                current = temp.charAt(j);
//                如果后边还有字符,查看字符是否相同,不同则退出,否则记录出现的次数.
                count = 1;
                for (int k = j + 1; k < temp.length(); k++) {
                    if (temp.charAt(k) != current) {
                        break;
                    } else {
                        count++;
                    }
                }
                j += count;
                result.append(String.valueOf(count) + current);
            }
        }
        return result.toString();
    }

    /**
     * 35题,搜索插入位置.学习了二分查找.
     *
     * @param nums
     * @param target
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/19 11:59
     */
    public int searchInsert(int[] nums, int target) {
//         使用二分查找.
        return this.rank(nums, target);
    }

    public int rank(int[] nums, int a) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > a) {
                hi = mid - 1;
            } else if (nums[mid] < a) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    /**
     * 28题,实现strStr
     * 使用KMP算法实现indexOf的效果.
     *
     * @param haystack
     * @param needle
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/9 11:49
     */
    public int strStr(String haystack, String needle) {
        int[] next = this.getNext(needle);
        int i = 0;
//        匹配的索引
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                i = i - j;
                j = next[j];
            }
            i++;
        }
        return j == -1 || j != needle.length() ? -1 : i - j;
    }

    /**
     * KMP算法的得到next数组的方法.
     * 唯一不理解的地方在于 j=next[j],解析说的意思是为了更快得到j长度下已经匹配到的索引.
     *
     * @param a
     * @return int[]
     * @author Chen Xiangyu
     * @date 2019/2/9 9:17
     */
    public int[] getNext(String a) {
        int[] next = new int[a.length()];
        int j = -1;
        next[0] = -1;
        for (int i = 0; i < a.length() - 1; ) {
            if (j == -1 || a.charAt(i) == a.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }

        }
        return next;
    }


    /**
     * 27题,移除元素.
     *
     * @param nums
     * @param val
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/19 11:58
     */
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    /**
     * 26题,删除排序数组中的重复项
     *
     * @param nums
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/19 11:57
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    /**
     * 21题,合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return ListNode
     * @author Chen Xiangyu
     * @date 2019/2/19 11:57
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        先判断一次选出第一个. 这个是根节点,再选择一个作为当前节点.
        ListNode listNode = null;
        ListNode currentNode = null;


        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }


        if (l1.val > l2.val) {
            listNode = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            listNode = new ListNode(l1.val);
            l1 = l1.next;
        }
        currentNode = listNode;
//        循环判断.哪个小push哪一个并移动.
        while (l1 != null && l2 != null) {
//            如果哪个是null,就只能在另一个上面排.
            if (l1.val > l2.val) {
                currentNode.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                currentNode.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            currentNode = currentNode.next;
        }
//      如果某一个到结尾了,就得拿这个和末尾进行比较排序.
        if (l1 == null) {
            while (l2 != null) {
                if (l2.val > currentNode.val) {
                    currentNode.next = new ListNode(l2.val);
                } else {
                    currentNode.next = new ListNode(currentNode.val);
                    currentNode.val = l2.val;
                }
                l2 = l2.next;
                currentNode = currentNode.next;
            }
        } else {
            while (l1 != null) {
                if (l1.val > currentNode.val) {
                    currentNode.next = new ListNode(l1.val);
                } else {
                    currentNode.next = new ListNode(currentNode.val);
                    currentNode.val = l1.val;
                }
                l1 = l1.next;
                currentNode = currentNode.next;
            }
        }

        return listNode;
    }

    /**
     * 20题,有效的括号.
     *
     * @param s
     * @return boolean
     * @author Chen Xiangyu
     * @date 2019/2/19 11:55
     */
    public boolean isValid(String s) {
        // 使用ArrayList就行了.
        ArrayList<Character> arrayList = new ArrayList<Character>();
        char c1;
        for (int i = 0; i < s.length(); i++) {
//            如果是左括号
            c1 = s.charAt(i);
            if ('{' == c1 || '[' == c1 || '(' == c1) {
                arrayList.add(s.charAt(i));
//            如果是右括号.弹出一个看是否匹配
            } else {
                if (arrayList.size() <= 0) {
                    return false;
                }
                char c = arrayList.get(arrayList.size() - 1);
                switch (s.charAt(i)) {
                    case '}':
                        if (c == '{') {
//                            弹出并继续下一次循环.
                            arrayList.remove(arrayList.size() - 1);
                        } else {
                            return false;
                        }
                        break;
                    case ']':
                        if (c == '[') {
                            arrayList.remove(arrayList.size() - 1);
                        } else {
                            return false;
                        }
                        break;
                    case ')':
                        if (c == '(') {
                            arrayList.remove(arrayList.size() - 1);
                        } else {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
        }
        return arrayList.size() == 0;
    }


    /**
     * 14题,最长公共前缀.以下三个方法.
     *
     * @param strs
     * @return java.lang.String
     * @author Chen Xiangyu
     * @date 2019/2/19 11:55
     */
    public String longestCommonPrefix(String[] strs) {
        //        先循环一遍得到长度最短的串.顺道排下序.
        if (strs.length == 0) {
            return "";
        }
        try {
            this.selectSort(strs);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        双层循环?
        String c;
        for (int i = strs[0].length(); i >= 0; i--) {
            c = strs[0].substring(0, i);
            for (int j = 0; j < strs.length; j++) {
//              查看是否包含这个字符串,并且其索引为0?
                if (strs[j].indexOf(c) != 0) {
                    break;
                } else if (j == strs.length - 1) {
                    return c;
                }
//                如果循环完毕
            }
        }
        return "";
    }

    public void selectSort(String[] strs) throws Exception {
        int min;
        // 当前需要填的位
        for (int i = 0; i < strs.length - 1; i++) {
//            在当前位之后查找最小值
            min = i;
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[j].length() < strs[min].length()) {
                    min = j;
                }
            }
//           交换
            exchange(strs, min, i);
        }

    }

    /**
     * 将arr数组中的a,b位置的元素交换一下.
     *
     * @param arr 要交换元素的数组
     * @param a   交换元素的索引
     * @param b   交换元素的索引
     * @return void
     * @author Chen Xiangyu
     * @date 2019/2/3 12:22
     */
    public void exchange(Object[] arr, int a, int b) throws Exception {
        if (a > arr.length | b > arr.length | a < 0 | b < 0) {
            throw new Exception("传入参数的索引不正确.");
        }
        Object temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    /**
     * 第13题,罗马数字转整数
     *
     * @param s
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/19 11:50
     */
    public int romanToInt(String s) {
        int result = 0;
        int temp;
        // 从头开始,从上往下写.
        for (int i = 0; i < s.length(); ) {
            switch (s.charAt(i)) {
                case 'I':
                    // 查看后一位是否有5或者10,最后一位可能没有值.
                    if (i == s.length() - 1) {
                        temp = 1;
                        i++;
                    } else {
                        switch (s.charAt(i + 1)) {
                            case 'V':
                                temp = 4;
                                i += 2;
                                break;
                            case 'X':
                                temp = 9;
                                i += 2;
                                break;
                            default:
                                temp = 1;
                                i++;
                        }
                    }
                    break;
                case 'X':
                    if (i == s.length() - 1) {
                        temp = 10;
                        i++;
                    } else {
                        switch (s.charAt(i + 1)) {
                            case 'L':
                                temp = 40;
                                i += 2;
                                break;
                            case 'C':
                                temp = 90;
                                i += 2;
                                break;
                            default:
                                temp = 10;
                                i++;
                        }
                    }
                    break;
                case 'C':
                    if (i == s.length() - 1) {
                        temp = 100;
                        i++;
                    } else {
                        switch (s.charAt(i + 1)) {
                            case 'D':
                                temp = 400;
                                i += 2;
                                break;
                            case 'M':
                                temp = 900;
                                i += 2;
                                break;
                            default:
                                temp = 100;
                                i++;
                        }
                    }
                    break;
                case 'V':
                    temp = 5;
                    i++;
                    break;
                case 'L':
                    temp = 50;
                    i++;
                    break;
                case 'D':
                    temp = 500;
                    i++;
                    break;
                case 'M':
                    temp = 1000;
                    i++;
                    break;
                default:
                    temp = 0;
                    i++;
                    break;
            }
            result += temp;
        }
        return result;
    }

    /**
     * 第9题,回文数
     *
     * @param x
     * @return boolean
     * @author Chen Xiangyu
     * @date 2019/2/19 11:49
     */
    public boolean isPalindrome(int x) {
        /* 题目不让转换成String或者是Array的话.
         * 我自己没写出来,看了一下别人的代码,思路是从个位数开始一个一个往外导出原来的数字.
         * 代码:
         * while(x!=0)
         * temp = x % 10; // 得到个位数字
         * x = x/10; // 将个位数字除去.
         * new = new  * 10 + temp; // 构建新的.
         * 不得不说牛逼啊..
         */
        char[] x1 = String.valueOf(x).toCharArray();
        int size1 = x1.length;
        for (int i = 0; i < size1 / 2 + 1; i++) {
            if (x1[i] != (x1[size1 - i - 1])) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }

    /**
     * 第7题,整数反转
     *
     * @param x
     * @return int
     * @author Chen Xiangyu
     * @date 2019/2/19 11:48
     */
    public int reverse(int x) {
        int result = 0;
        int temp;
        while (x != 0) {
            temp = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && temp < -8)) {
                return 0;
            }
            result = result * 10 + temp;
        }
        return result;
    }

    /**
     * 第1题,两数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int one, two;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * LeetCode的辅助方法,可以将字符串转换为Tree;
     *
     * @param input
     * @return TreeNode
     * @author Chen Xiangyu
     * @date 2019/2/18 23:37
     */
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

}

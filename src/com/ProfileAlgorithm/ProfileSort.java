package src.com.ProfileAlgorithm;

/**
 * @author Chen Xiangyu
 * @version 1.0
 * @classname ProfileSort
 * @date 2019/2/7
 */
public class ProfileSort {

    /*
    选择排序,从已经排序之后的元素里面挑选出最小的元素放置到已经排序好的元素的后面
    * @author Chen Xiangyu
    * @date  2019/2/3 12:05
    * @param [strs]
    * @return void
    */
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


    /*
     * @author Chen Xiangyu
     * @date  2019/2/9 9:35
     * @param arr
     * @param a
     * @param b
     * @return void
     */
    public void exchange(Object[] arr, int a, int b) throws Exception {
        if (a > arr.length | b > arr.length | a < 0 | b < 0) {
            throw new Exception("传入参数的索引不正确.");
        }
        Object temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}

package com.changzhi.commonStructAndAlgorithm;

/**
 * @author ChangZhi
 * @date 2024/12/27
 */
public class SparseArrayUtil {
    /**
     * 数组转稀疏数组
     *      1、遍历原数组，得到有效元素数量sum
     *      2、初始化稀疏数组 spaceArr[sum + 1][3]
     *      3、将有效元素存入稀疏数组。
     * 效率分析：
     *      1、空间复杂度：O(1)
     *      2、时间复杂度：O(mn)，m、n分别为二维数组的行、列数。若为方阵时间复杂度即为O(n2)
     *          需要对二维数组进行两次遍历操作。第一次遍历获取有效元素总数 sum，用于初始化压缩数组 sparseArray[sum+1][3];
     *          第二次遍历用于给稀疏数组赋值。因此总的时间复杂度为 O(mn) + O(mn) = O(mn)
     */
    public static int[][] toSpaceArr(int[][] originArr) {
        int validElements = 0;
        for (int i = 0; i < originArr.length; i++) {
            for (int j = 0; j < originArr[0].length; j++) {
                if (originArr[i][j]!= 0) {
                    validElements++;
                }
            }
        }
        int[][] spaceArr = new int[validElements + 1][3];
        spaceArr[0][0] = originArr.length;
        spaceArr[0][1] = originArr[0].length;
        spaceArr[0][2] = validElements;

        int index = 1;
        for (int i = 0; i < originArr.length; i++) {
            for (int j = 0; j < originArr[0].length; j++) {
                if (originArr[i][j]!= 0) {
                    spaceArr[index][0] = i;
                    spaceArr[index][1] = j;
                    spaceArr[index][2] = originArr[i][j];
                    index++;
                }
            }
        }
        return spaceArr;
    }

    /**
     * 稀疏数组还原到原数组
     *      1、读取稀疏数组第一行，得到原数组行列数，初始化原数组 origin[row][col]
     *      2、遍历稀疏数组，给原数组有效元素赋值。
     * 效率分析：
     *      1、空间复杂度：O(mn)，即还原的二维数组所需空间大小。
     *      2、时间复杂度：O(mn)，m、n分别为稀疏数组的行、列数。
     */
    public static int[][] recoverSpaceArr(int[][] spaceArr) {
        int[][] originalArr = new int[spaceArr[0][0]][spaceArr[0][1]];
        for (int i = 1; i < spaceArr.length; i++) {
            originalArr[spaceArr[i][0]][spaceArr[i][1]] = spaceArr[i][2];
        }
        return originalArr;
    }
}

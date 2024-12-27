package com.changzhi.commonStructAndAlgorithm;

/**
 * @author ChangZhi
 * @date 2024/12/27
 */
public class SparseArrayTest {
    public static void main(String[] args) {
        int[][] originalArray = new int[10][10];
        originalArray[1][2] = 1;
        originalArray[2][3] = 2;
        originalArray[9][9] = 2;

        System.out.println("原数组为：");
        print(originalArray);

        System.out.println("压缩为稀疏数组：");
        int[][] spaceArr = SparseArrayUtil.toSpaceArr(originalArray);
        print(spaceArr);

        System.out.println("稀疏数组恢复到原数组：");
        int[][] originArr = SparseArrayUtil.recoverSpaceArr(spaceArr);
        print(originArr);
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j=0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

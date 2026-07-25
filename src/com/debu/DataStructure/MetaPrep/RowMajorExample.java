package com.debu.DataStructure.MetaPrep;

public class RowMajorExample {
    public int[] template(int[][] matrix)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int index = 0;
        int[] result = new int[rows*cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                result[index++] = matrix[i][j];
            }
        }
        return result;
    }
}

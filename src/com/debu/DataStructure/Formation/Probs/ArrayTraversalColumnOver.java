package com.debu.DataStructure.Formation.Probs;

public class ArrayTraversalColumnOver {
    public int findAvgOfMinColumns(int[][] matrix)
    {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] minInColumns = new int[cols];
        int avg = 0;
        int sum = 0;
        //Store the first row values in the array
        for(int j=0;j<cols;j++)
        {
            minInColumns[j] = matrix[0][j];
        }

        //Compare with each remaining row
        for(int i=1;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(matrix[i][j] < minInColumns[j])
                {
                    minInColumns[j] = matrix[i][j];
                }
            }
        }

        for(int i=0;i<minInColumns.length;i++)
        {
            sum += minInColumns[i];
        }
        avg = sum / minInColumns.length;
        return avg;
    }

    public static void main(String[] args)
    {
        int[][] matrix = {
                {1, 5, 3},
                {4, 2, 6},
        };
        ArrayTraversalColumnOver solution = new ArrayTraversalColumnOver();
        int avg = solution.findAvgOfMinColumns(matrix);
        System.out.println("avg-->"+avg);

    }
}

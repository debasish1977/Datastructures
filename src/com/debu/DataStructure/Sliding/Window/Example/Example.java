package com.debu.DataStructure.Sliding.Window.Example;

public class Example {
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int k =3;
        int sum = 0;
        int n = arr.length;
        for(int i=0;i<k;i++)
        {
            sum += arr[i];
        }
        System.out.println(sum);
        for(int i=1;i<n-k;i++)
        {
            sum = arr[i-1] + arr[i+k-1];
            System.out.println(sum);
        }

    }
}

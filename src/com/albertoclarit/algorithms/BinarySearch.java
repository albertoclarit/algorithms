package com.albertoclarit.algorithms;

public class BinarySearch {

    public static void main(String []args){
        // sorted array
        int []data = {1,4,67,123,434,5643,55675};

        System.out.println("BinSearch : " + binarySearch(data,123));
    }

    // returns -1 if not found else return the value

    public static int binarySearch(int []data,int find){

        int lowerBound = 0;
        int upperBound = data.length;

        while(true){
            int mid = (lowerBound + upperBound) /2;
             if(data[mid] == find)
                 return  data[mid];

             if(lowerBound > upperBound)
                 return  -1;

             if(data[mid] < find)
                 lowerBound = mid + 1;
              else
                 upperBound = mid - 1;
        }

    }
}

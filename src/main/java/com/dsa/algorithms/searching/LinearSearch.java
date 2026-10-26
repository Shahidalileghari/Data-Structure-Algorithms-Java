package com.dsa.algorithms.searching;
/** Linear search for integer arrays. */
public final class LinearSearch {private LinearSearch(){} /** O(n) time, O(1) extra space. */ public static int indexOf(int[] values,int target){for(int i=0;i<values.length;i++)if(values[i]==target)return i;return -1;}}

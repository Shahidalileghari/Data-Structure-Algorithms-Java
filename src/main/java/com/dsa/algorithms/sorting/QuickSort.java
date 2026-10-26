package com.dsa.algorithms.sorting;
/** In-place quicksort for integer arrays; average O(n log n), worst O(n^2). */
public final class QuickSort { private QuickSort(){} public static void sort(int[] a){sort(a,0,a.length-1);} private static void sort(int[] a,int lo,int hi){if(lo>=hi)return;int p=partition(a,lo,hi);sort(a,lo,p-1);sort(a,p+1,hi);} private static int partition(int[] a,int lo,int hi){int pivot=a[hi],i=lo;for(int j=lo;j<hi;j++)if(a[j]<=pivot){int t=a[i];a[i++]=a[j];a[j]=t;}int t=a[i];a[i]=a[hi];a[hi]=t;return i;} }

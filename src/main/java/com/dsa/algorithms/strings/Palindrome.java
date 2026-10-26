package com.dsa.algorithms.strings;
import java.util.Objects;
/** String palindrome checks. */
public final class Palindrome {private Palindrome(){} /** Checks exact character equality in O(n) time and O(1) extra space. */ public static boolean isPalindrome(String value){Objects.requireNonNull(value,"value");int left=0,right=value.length()-1;while(left<right)if(value.charAt(left++)!=value.charAt(right--))return false;return true;}}

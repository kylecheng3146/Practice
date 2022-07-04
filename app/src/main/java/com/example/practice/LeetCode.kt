package com.example.practice

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap


/**
 * Created by Kyle on 2/4/21.
 */

class LeetCode {

    fun runningSum(nums: IntArray): IntArray {
        var tempNum = 0
        var result = IntArray(nums.size)
        nums.forEachIndexed { index, i ->
            result[index] = i + tempNum
            tempNum = result[index]
        }
        return result
    }

    fun defangIPaddr(address: String): String {
        val tempAddr = StringBuffer()
        address.split(".").forEach {
            tempAddr.append(it).append("[.]")
        }
        return tempAddr.substring(0,tempAddr.length-3)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun simplifyPath(path: String): String {
        val dirs = path.split("/")
        val stack: Deque<String> = ArrayDeque()
        for (s in dirs) {
            if (s == "") continue
            if (s == ".") continue
            if (s == "..") stack.pollLast() else stack.add(s)
        }
        val result = "/" + java.lang.String.join("/", stack)
        return result
    }

    /*
    * 1672. Richest Customer Wealth
    * */
    fun maximumWealth(accounts: ArrayList<IntArray>): Int {
        var result = 0
        accounts.forEach {
            var tempResult = 0
            it.forEach {
                tempResult += it
            }
            if(tempResult > result){
                result = tempResult
            }
        }
        return result
    }

    /*
    * 1678. Goal Parser Interpretation
    * */
    fun interpret(command: String): String {
        val tempResult = StringBuilder()
        command.toCharArray().forEachIndexed { index, c ->
            if(c == 'G'){
                tempResult.append(c)
            }

            if(c == '(' && command[index+1] == 'a'){
                tempResult.append("al")
            }

            if(c == '(' && command[index+1] == ')'){
                tempResult.append("o")
            }
        }
        return tempResult.toString()
    }

    /**
     * 1512. Number of Good Pairs
     * */
    fun numIdenticalPairs(nums: IntArray): Int {
        var result = 0
        var index = 0
        var tempIndex = 0
        while (tempIndex < nums.size){
            val tempNum = nums[tempIndex]
            while (index < nums.size){
                val num = nums[index]
                if(num == tempNum && index > tempIndex){
                    result ++
                }
                index++
            }
            tempIndex++
            index = tempIndex
        }
        return result
    }

    /**
     * 1365. How Many Numbers Are Smaller Than the Current Number
     * */
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        var result = IntArray(nums.size)
        var tempResult = 0
        var i = 0
        var j = 0;
        while (i < nums.size){
           while (j < nums.size){
               if(nums[i] > nums[j]){
                   tempResult ++
               }
               j++
           }
            result[i] = tempResult
            tempResult = 0
            j = 0
            i++
        }
        return  result
    }

    /**
     * 242. Valid Anagram
     * */
    fun isAnagram(s: String, t: String): Boolean {
        if(s == "" && t == "")
            return true

        if(s.length != t.length)
            return false

        val sa = s.toCharArray()
        val ta = t.toCharArray()
        Arrays.sort(sa)
        Arrays.sort(ta)
        sa.forEachIndexed { index, c ->
            if(c != ta[index])
                return false
        }
        return true
    }

    /*
    * 20. Valid Parentheses
    * */
    fun isValid(s: String): Boolean {
        val stack:Deque<String> = ArrayDeque()
        s.toCharArray().forEach {
            when {
                it == '(' ->
                    stack.add(")")
                it == '[' ->
                    stack.add("]")
                it == '{' ->
                    stack.add("}")
                else -> {
                    val temp = stack.pollLast()
                    if (temp != it.toString()){
                        return  false
                    }
                }
            }
        }
        return stack.size == 0
    }

    /**
     * 1732. Find the Highest Altitude
     * gain = [-5,1,5,0,-7]
     * */
    fun largestAltitude(gain: IntArray): Int {
        var largest = 0
        var tempLargest = 0
        gain.forEach {
            tempLargest = tempLargest + it
            if(tempLargest > largest) {
                largest = tempLargest
            }
        }
        return largest
    }

    /**
     * 1748. Sum of Unique Elements
     * */
    fun sumOfUnique(nums: IntArray): Int {
        var result = 0
        val hashMap = HashMap<Int,Int>()
        nums.forEach {
            if(hashMap.get(it) == null){
                hashMap.put(it, 1)
            }else{
                var value = hashMap.get(it)
                if (value != null) {
                    hashMap.put(it, value+1)
                }
            }
        }
        hashMap.forEach {
            if(it.value == 1){
                result += it.key
            }
        }
        return result
    }

    /**
     * 1688. Count of Matches in Tournament
     * */
    fun numberOfMatches(n: Int): Int {
        var result = 0
        var totalMatch = n
        var tempMatch = 0
        while(totalMatch != 1) {
            if(totalMatch % 2 != 0) {
                tempMatch = (totalMatch - 1) / 2
            }else{
                tempMatch = totalMatch / 2
            }
            totalMatch -= tempMatch
            result += tempMatch
        }
        return result
    }

    /**
     * 1450. Number of Students Doing Homework at a Given Time
     * */
    fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
        var result = 0
        var i = 0
        while (i < startTime.size){
            if(queryTime in startTime[i] .. endTime[i])
                result++

            i++
        }
        return result
    }

    /**
     * 240. Search a 2D Matrix II
     * */
    open fun searchMatrix(matrix: ArrayList<IntArray>, target: Int): Boolean {
        var row = 0
        var column = matrix[0].size - 1
        while (row < matrix.size && column >= 0) {
            val current = matrix[row][column]
            if (target == current) {
                return true
            } else if (target < current) {
                --column
            } else {
                ++row
            }
        }
        return false
    }

    fun shuffleTheArray(nums: IntArray, n: Int): IntArray {
        var result = IntArray(nums.size)
        var first = 0
        var target = n
        var index = 0

        while (first < n) {
            result.set(index, nums[first])
            index += 1
            first += 1
            result.set(index, nums[target])
            target += 1
            index += 1
        }

        return result
    }

    /**
     * 1. Two Sum
     * */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashMap:HashMap<Int,Int> = HashMap()
        nums.forEachIndexed { index, i ->
            val targetMap = target - i
            if (hashMap.containsKey(targetMap)) {//比對Map
                return intArrayOf(hashMap[targetMap]!!, index) //如果比對成功表示相加等同Target
            }
            hashMap.put(nums[index],index)
        }
        return intArrayOf(0, 0)
    }

    /**
     * 9. Palindrome Number
     * */
    fun isPalindrome(x: Int): Boolean {
        val arrays = x.toString().toCharArray()
        var first = 0
        var last = arrays.size - 1

        for(i in first .. last) {
            if(arrays[first] != arrays[last])
                return false

            if(first == last)
                return true

            first++
            last --
        }
        return true
    }
    /**
     * 26. Remove Duplicates from Sorted Array
     * */
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var lastIndex = 1
        var curVal = nums[0]
        nums.forEachIndexed{ index, i ->
            if(nums[index] > curVal) {
                curVal = nums[index]
                nums[lastIndex] = curVal

                lastIndex++
            }
        }
        return lastIndex
    }

    /**
     * 27. Remove Element
     * */
    fun removeElement(nums: IntArray, removeValue: Int): Int {
        if(nums.isEmpty()) return 0
        var result = 0
        nums.forEachIndexed { i, _ ->
            if(nums[i] != removeValue){
                nums[result++] = nums[i]
            }
        }
        return result
    }

    /**
     * 169. Majority Element
     * */
    fun majorityElement(nums: IntArray): Int {

        val majority = nums.size / 2
        val hashMap = mutableMapOf<Int,Int>()
        nums.forEachIndexed { index, i ->
            if(hashMap.containsKey(i)){
                hashMap.put(i, hashMap.get(i)!!+1)
                return@forEachIndexed
            }

            hashMap.put(i, 1)
        }

        for ((key, value) in hashMap) {
            if (value > majority) return key
        }

        return 0
    }

    /**
     * 28. Implement strStr()
     * */
    fun strStr(haystack: String, needle: String): Int {
        if(haystack.length == 0 && needle.length > 0) return -1
        if(haystack.length == 0) return 0
        var firstC = 0
        var result = 0
        haystack.forEachIndexed { index, c ->
            if(c == needle.get(firstC)){
                if(result == 0)
                    result = index

                firstC ++
            }else{
                firstC = 0
            }

            if(firstC == needle.length)
                return result
        }
        return -1
    }

    /**
     * 344. Reverse String
     * Write a function that reverses a string. The input string is given as an array of characters s.
       You must do this by modifying the input array in-place with O(1) extra memory.
     * Input: s = ["h","e","l","l","o"]
       Output: ["o","l","l","e","h"]
     * */
    fun reverseString(s: CharArray): CharArray {
        val result = CharArray(s.size)
        var index = s.size - 1
        s.forEachIndexed { i, c ->
            result[index] = c
            index--
        }
        return result
    }

    /**
     * 35. Search Insert Position
     *Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.

    Example 1:

    Input: nums = [1,3,5,6], target = 5
    Output: 2
    Example 2:

    Input: nums = [1,3,5,6], target = 2
    Output: 1
    Example 3:

    Input: nums = [1,3,5,6], target = 7
    Output: 4
     * */
    fun searchInsert(nums: IntArray, target: Int): Int {
        var result = 0
        nums.forEachIndexed { index, i ->
            if (target > i) {
                result = index + 1
            }
        }
        return result
    }
}

/**
 * 284. Peeking Iterator
 * */
class PeekingIterator(iterator:Iterator<Int>):Iterator<Int> {
    val arr = iterator
    var peek = false
    var result = 0
    fun peek(): Int {
        if (arr.hasNext() && !peek){
            result = arr.next()
        }
        peek = true
        return result
    }

    override fun next(): Int {
        if(peek){
            peek = false
            return result
        }else {
            result = arr.next()
        }
        return result
    }

    override fun hasNext(): Boolean {
        val result = arr.hasNext()
        return result
    }
}

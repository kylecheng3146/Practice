package com.example.practice

import android.os.Build
import androidx.annotation.RequiresApi
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList


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

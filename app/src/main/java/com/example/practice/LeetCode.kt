package com.example.practice

import android.os.Build
import androidx.annotation.RequiresApi
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
}

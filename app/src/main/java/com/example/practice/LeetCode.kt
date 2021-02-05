package com.example.practice

import java.lang.StringBuilder

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
}

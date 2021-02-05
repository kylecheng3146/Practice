package com.example.practice

import org.junit.Test

/**
 * Created by Kyle on 2/4/21.
 */
class LeetCodeTest {

    @Test
    fun testRunningSum() {
        val nums: IntArray = intArrayOf(1,2,3,4)
        val leetCode = LeetCode()
        leetCode.runningSum(nums)
    }


    @Test
    fun defangIPaddr() {
        val leetCode = LeetCode()
        leetCode.defangIPaddr("1.1.1.1")
    }
}

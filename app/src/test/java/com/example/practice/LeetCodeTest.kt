package com.example.practice

import org.junit.Test

/**
 * Created by Kyle on 2/4/21.
 */
class LeetCodeTest {

    val leetCode = LeetCode()

    @Test
    fun testRunningSum() {
        val nums: IntArray = intArrayOf(1,2,3,4)
        leetCode.runningSum(nums)
    }


    @Test
    fun defangIPaddr() {
        leetCode.defangIPaddr("1.1.1.1")
    }

    @Test
    fun simplifyPath() {
        leetCode.simplifyPath("/a/./b/../../c/")
//        leetCode.simplifyPath("/home/")
//        leetCode.simplifyPath("/../")
//        leetCode.simplifyPath("/home//foo/")
    }

    @Test
    fun maximumWealth(){
        val accounts = arrayListOf<IntArray>()
        accounts.add(intArrayOf(2,8,7))
        accounts.add(intArrayOf(7,1,3))
        accounts.add(intArrayOf(1,9,5))
        leetCode.maximumWealth(accounts)
    }

    @Test
    fun interpret(){
        leetCode.interpret("(al)G(al)()()G")
    }

    @Test
    fun numIdenticalPairs(){
//        leetCode.numIdenticalPairs(intArrayOf(1,2,3,1,1,3))
//        leetCode.numIdenticalPairs(intArrayOf(1,1,1,1))
        leetCode.numIdenticalPairs(intArrayOf(1,2,3))
    }
}

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

    @Test
    fun test() {
        var obj = PeekingIterator(listOf(1,2,3,4).iterator())
        obj.hasNext()

        obj.next()
        obj.peek()
        obj.next()
        obj.hasNext()
    }

    @Test
    fun smallerNumbersThanCurrent() {
        leetCode.smallerNumbersThanCurrent(intArrayOf(8,1,2,2,3))
    }

    @Test
    fun isAnagram() {
//        leetCode.isAnagram("rat","car")
//        leetCode.isAnagram("anagram","nagaram")
//        leetCode.isAnagram("ac","ba")
        leetCode.isAnagram("a","ab")
    }

    @Test
    fun isValid() {
//        leetCode.isValid("()[]{}")
//        leetCode.isValid("([)]")
        leetCode.isValid("()")
    }

    @Test
    fun largestAltitude() {
//        leetCode.largestAltitude(intArrayOf(-5,1,5,0,-7))
        leetCode.largestAltitude(intArrayOf(-4,-3,-2,-1,4,3,2))
    }
    @Test
    fun sumOfUnique() {
//        leetCode.largestAltitude(intArrayOf(-5,1,5,0,-7))
        leetCode.sumOfUnique(intArrayOf(10,6,9,6,9,6,8,7))
    }

    @Test
    fun numberOfMatches() {
//        leetCode.largestAltitude(intArrayOf(-5,1,5,0,-7))
        leetCode.numberOfMatches(14)
    }

    @Test
    fun busyStudent() {
        leetCode.busyStudent(intArrayOf(9,8,7,6,5,4,3,2,1),intArrayOf(10,10,10,10,10,10,10,10,10),5)
//        leetCode.busyStudent(intArrayOf(4),intArrayOf(4),5)
//        leetCode.busyStudent(intArrayOf(16),intArrayOf(60),58)
    }
}

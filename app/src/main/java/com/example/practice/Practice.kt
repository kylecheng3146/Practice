package com.example.practice

import android.os.HandlerThread
import android.util.Log
import kotlinx.android.synthetic.*
import kotlinx.coroutines.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.logging.Handler

/**
 * Created by Kevin on 2020/10/11.
 */

class Practice {
    fun exampleLaunchCoroutineScope() = runBlocking {
        println("one - from thread ${Thread.currentThread().name}")

        val customDispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()



        var q = 0
        for(i in 1..3){
            launch(customDispatcher) {
                delay(2000)
                print("q number is ${q}")
                q = calculateHardThings(q)
            }
        }

        println("three - from thread ${Thread.currentThread().name}")


    }

    suspend fun calculateHardThings(startNum: Int): Int {
        return startNum +1
    }
}

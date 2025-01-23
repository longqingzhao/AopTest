package com.example.dynamicfeature

import android.util.Log
import com.qianqi.basedi.init.AopGlobalInit

class Test {

    companion object {
        private const val TAG = "Test"
    }

    @AopGlobalInit
    fun testInit() {
        Log.i(TAG, "testInit")
    }

}
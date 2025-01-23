package com.qianqi.base2.init

import android.util.Log
import com.qianqi.basedi.init.AopGlobalInit

class TestBase2 {

    companion object {
        private const val TAG = "TestBase2"
    }

    @AopGlobalInit
    fun testInit() {
        Log.i(TAG, "testInit")
    }

}
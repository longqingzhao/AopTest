package com.example.aoptest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aoptest.ui.theme.AopTestTheme
import com.qianqi.base2.init.TestBase2
//import com.qianqi.basedi.init.AopGlobalInit
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.functions

class MainActivity : ComponentActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        val clazz = Class.forName("com.example.dynamicfeature.Test").kotlin
//        val data = clazz.createInstance()
//        val fun0 = clazz.functions.find { it.name == "testInit" }
//        fun0?.call(data)
//        testMain()
        TestBase2().testInit()
        setContent {
            AopTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

//    @AopGlobalInit
//    fun testMain() {
//        Log.i(TAG, "testMain")
//    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AopTestTheme {
        Greeting("Android")
    }
}
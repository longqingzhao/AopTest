package com.qianqi.basedi.init

import android.util.Log
import com.flyjingfish.android_aop_annotation.ProceedJoinPoint
import com.flyjingfish.android_aop_annotation.base.BasePointCut

class AopGlobalInitCut : BasePointCut<AopGlobalInit> {

    companion object {
        private const val TAG = "AopGlobalInitCut"
    }


    override fun invoke(joinPoint: ProceedJoinPoint, anno: AopGlobalInit): Any? {
        Log.i(TAG, "invoke")
        return joinPoint.proceed()
    }
}
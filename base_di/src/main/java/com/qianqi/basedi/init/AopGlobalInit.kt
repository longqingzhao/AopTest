package com.qianqi.basedi.init

import com.flyjingfish.android_aop_annotation.anno.AndroidAopPointCut

@AndroidAopPointCut(AopGlobalInitCut::class)
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
annotation class AopGlobalInit
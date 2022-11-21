package com.mufe.mvvm.library.dl


import com.mufe.mvvm.library.util.DpUtil
import com.mufe.mvvm.library.util.KeyboardUtil
import org.koin.dsl.module

val commonModule = module {
    factory { KeyboardUtil() }
    factory { DpUtil() }
}

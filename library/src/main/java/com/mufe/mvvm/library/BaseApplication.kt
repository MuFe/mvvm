package com.mufe.mvvm.library

import android.app.Application

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApplication)
            modules(
                commonModule,
            )
        }


        ImageLoader.getDefault().diskCacheOptions()
                .setDiskCacheDirPath(getExternalFilesDir("Cache")?.path ?: filesDir.path)
                .setDiskCacheFolderName("Image")
                .setDiskCacheSize(2 * 1024 * 1024) // 设置磁盘缓存2G
                .setBitmapPoolSize(2.0f)
                .setMemoryCacheSize(1.5f)
                .build()


    }


}
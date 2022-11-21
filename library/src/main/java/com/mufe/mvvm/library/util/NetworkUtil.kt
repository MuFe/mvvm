package com.mufe.mvvm.library.util


import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import com.mufe.mvvm.library.base.BaseModel
import com.mufe.mvvm.library.network.ApiService
import com.mufe.mvvm.library.network.Resource
import kotlinx.coroutines.CoroutineScope



open class NetworkUtil() {
    var viewModelScope: CoroutineScope? = null
    var viewModel: BaseModel? = null

}

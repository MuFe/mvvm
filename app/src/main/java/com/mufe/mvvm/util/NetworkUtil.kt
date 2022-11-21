package com.mufe.mvvm.util


import android.text.TextUtils
import android.util.Log
import com.google.gson.Gson
import com.mufe.mvvm.base.BaseModel
import com.mufe.mvvm.network.ApiService
import com.mufe.mvvm.network.Resource
import kotlinx.coroutines.CoroutineScope



class NetworkUtil(val service: ApiService) {
    var viewModelScope: CoroutineScope? = null
    var viewModel: BaseModel? = null

}

package com.mufe.mvvm.library.base


import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mufe.mvvm.library.misc.SingleLiveEvent
import com.mufe.mvvm.library.network.Resource
import com.mufe.mvvm.library.network.Status
import com.mufe.mvvm.library.util.NetworkUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseModel(var networkUtil: NetworkUtil?=null)  : ViewModel(){
    protected val mBaseEvent = SingleLiveEvent<BaseViewModelEvent>()
    val baseEvent: LiveData<BaseViewModelEvent> = mBaseEvent
    sealed class BaseViewModelEvent {
        data class NetworkEvent(val resource:Resource<Any>):BaseViewModelEvent()
        object NavigateUpEvent:BaseViewModelEvent()
        object LogoutEvent:BaseViewModelEvent()
        data class NavigateEvent(val id:Int,val bundle:Bundle?):BaseViewModelEvent()
        data class ToastStrEvent(val str:String):BaseViewModelEvent()
        data class ToastIntEvent(val id:Int):BaseViewModelEvent()
    }


    open fun load() {

    }


    init {
        networkUtil?.viewModelScope=viewModelScope
        networkUtil?.viewModel=this
    }


    fun goBack(){
        mBaseEvent.postValue(BaseViewModelEvent.NavigateUpEvent)
    }

    fun loadData(listener: (v: CoroutineScope,result:(data:Resource<Any>)->Unit) -> Unit){
        mBaseEvent.postValue(BaseViewModelEvent.NetworkEvent(Resource.loading("")))
        viewModelScope.launch(Dispatchers.IO){
            listener(this){
                if(it.status==Status.ERROR){
                    mBaseEvent.postValue(BaseViewModelEvent.NetworkEvent(it))
                }
            }
        }
    }

    fun loadDataBlock(block: suspend CoroutineScope.() -> Unit){
        mBaseEvent.postValue(BaseViewModelEvent.NetworkEvent(Resource.loading("")))
        viewModelScope.launch(Dispatchers.IO){
            block.invoke(this)
        }
    }
    fun onError(data:Resource<Any>){
        if(data.code==202){
            mBaseEvent.postValue(BaseViewModelEvent.LogoutEvent)
        } else {
            mBaseEvent.postValue(BaseViewModelEvent.NetworkEvent(data))
        }
    }

    fun onSu(data:Resource<Any>){
        mBaseEvent.postValue(BaseViewModelEvent.NetworkEvent(data))
    }

}
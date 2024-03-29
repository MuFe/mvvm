package com.mufe.mvvm.library.network

class Resource<out T>(val status:Status,val data:T?,val message:String?,val code:Int) {
    companion object{
        fun <T> success(data:T?)=Resource(Status.SUCCESS,data,null,200)
        fun <T> error(msg:String?,data:T?,code:Int)=Resource(Status.ERROR,data,msg,code)
        fun <T> loading(data:T?)=Resource(Status.LOADING,null,null,200)
        fun <T> finish(data:T?)=Resource(Status.FINISHING,null,null,200)
    }
}
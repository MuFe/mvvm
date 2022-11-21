package com.mufe.mvvm.library.base




interface BaseOwner {
    fun getBaseModel():BaseModel?
    fun navigateUp()
    fun navigate(id:Int)
}

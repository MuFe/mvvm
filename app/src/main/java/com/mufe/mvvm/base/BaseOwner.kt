package com.mufe.mvvm.base




interface BaseOwner {
    fun getBaseModel():BaseModel?
    fun navigateUp()
    fun navigate(id:Int)
}

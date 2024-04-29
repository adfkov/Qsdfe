package com.example.week07.example3

import androidx.lifecycle.ViewModel

class NavViewModel : ViewModel(){
    val userid = "greenjoa"
    val userpasswd = "1234"

    var userID:String? = null
    var userPasswd:String? = null

    fun checkInfo(id:String, passwd:String):Boolean{
        return userid == id && userpasswd == passwd
    } // 같은 지 여부

    fun setUserInfo(id:String, passwd:String){
        userID = id
        userPasswd = passwd
    }
}

package com.example.hollys_clone_week2

data class UserInfo(
    var userID: String,
    var userPW: String,
    var userName: String,
)

val UserInfoList = mutableListOf<UserInfo>(
    UserInfo(
        userID = "jay1111",
        userPW = "1111",
        userName = "제이1",
    ),
    UserInfo(
        userID = "jay2222",
        userPW = "2222",
        userName = "제이2",
    ),
    UserInfo(
        userID = "jay3333",
        userPW = "3333",
        userName = "제이3",
    ),
)

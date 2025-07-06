package com.musaecer.customerregistration.presentation.component

sealed class Screen(val route: String) {
    object Main: Screen("main_screen")
    object UserList: Screen("user_list")
    object UserDetail: Screen("user_detail/{customerId}")
    object CustomerAdd: Screen("customer_add")
}
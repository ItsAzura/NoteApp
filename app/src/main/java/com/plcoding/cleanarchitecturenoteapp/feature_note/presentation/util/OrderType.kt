package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.util

//dùng để biểu diễn loại sắp xếp (thứ tự) của dữ liệu
sealed class OrderType {
    object  Ascending: OrderType() //1 đối tượng singleton để đại diện cho việc sắp xếp tăng dần
    object Descending: OrderType() //1 đối tượng singleton để đại diện cho việc sắp xếp giảm dần
}
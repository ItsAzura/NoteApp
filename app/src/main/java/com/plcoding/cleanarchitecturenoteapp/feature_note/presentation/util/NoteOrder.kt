package com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.util

//định nghĩa các lớp con để đại diện cho các phương thức sắp xếp khác nhau
sealed class NoteOrder(val orderType: OrderType)  {
    //sắp xếp theo Title
    class Title(orderType: OrderType): NoteOrder(orderType)
    //sắp xếp theo Date
    class Date(orderType: OrderType): NoteOrder(orderType)
    //sắp xếp theo Color
    class Color(orderType: OrderType): NoteOrder(orderType)
}
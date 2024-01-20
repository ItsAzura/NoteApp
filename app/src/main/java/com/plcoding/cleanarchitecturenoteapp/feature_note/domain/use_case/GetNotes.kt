package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.util.NoteOrder
import com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//Định nghĩa 1 use case để lấy danh sách các note từ repository theo thứ tự củ thể
class GetNotes(
    private val repository: NoteRepository
) //là 1 class chịu trách nhiệm cho việc lấy danh sách từ các note từ repository
{
    operator fun invoke( //gọi 1 đối tượng như là 1 hàm
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending) //Tham số mặc định
    ): Flow<List<Note>>  //trả về 1 flow phát ra danh sách các đồi tượng note
    {
        return repository.getNotes().map {notes ->
            //trả về 1 danh sách các đối tượng note từ repository và sau đó sử dụng map để ánh xạ và xử lý logic
            when(noteOrder.orderType){ //khi có sắp xếp
                is OrderType.Ascending -> { //khi sắp xếp tăng dần
                    when(noteOrder){ //Sắp xếp theo từng loại
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }//sắp xếp tăng dần theo title
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }//sắp xếp tăng dần theo date
                        is NoteOrder.Color -> notes.sortedBy { it.color  }//sắp xếp tăng dần theo color
                    }
                }
                is OrderType.Descending -> { //khi sắp xếp giảm dần
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }//sắp xếp giảm dần theo title
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }//sắp xếp giảm dần theo date
                        is NoteOrder.Color -> notes.sortedByDescending { it.color  }//sắp xếp giảm dần theo color
                    }
                }
            }
        }
    }
}
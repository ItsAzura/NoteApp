package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

//Định nghĩa các phương thức chung của NoteRepository
interface NoteRepository {
    fun getNotes(): Flow<List<Note>> //trả về 1 danh sách các đối tượng Note
    suspend fun getNoteById(id: Int): Note? //trả về 1 đối tượng Note củ thế dựa vào id or null
    suspend fun insertNote(note: Note) //chèn 1 đối tượng Note or cập nhật 1 note đã tồn tạo vào database
    suspend fun deleteNote(note: Note) //xoá 1 đối tượng note khỏi database
}
package com.plcoding.cleanarchitecturenoteapp.feature_note.data.repository

import com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDao
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow


class NoteRepositoryImpl( // => truy cập vào các phương thức DAO để tương tác với Room Database
    private val dao: NoteDao //Nhận NoteDao làm tham số
) : NoteRepository{ //Implement interface "NoteRepository"
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes() //lấy 1 danh sách các note từ database và trả về 1 Flow để cho phép theo dõi sự thay đổi danh sách
    }
    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id) //trả về 1 node dựa trên id or null
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note) //chèn hoặc cập nhật 1 node vào database
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note) //xoá 1 note từ database
    }
}
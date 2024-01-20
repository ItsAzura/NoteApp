package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case

//1 data class để đóng gói các use case liên quan đến quản lý các note
data class NotesUseCase(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote
)

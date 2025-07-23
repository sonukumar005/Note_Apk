package com.example.note_apk.feature_note.presentation.notes

import com.example.note_apk.feature_note.domain.modal.Note
import com.example.note_apk.feature_note.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()  // why data class or object?
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
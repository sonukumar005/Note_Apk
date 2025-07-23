package com.example.note_apk.feature_note.presentation.notes

import com.example.note_apk.feature_note.domain.modal.Note
import com.example.note_apk.feature_note.domain.util.NoteOrder
import com.example.note_apk.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
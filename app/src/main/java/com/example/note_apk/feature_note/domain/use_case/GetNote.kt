package com.example.note_apk.feature_note.domain.use_case

import com.example.note_apk.feature_note.domain.modal.Note
import com.example.note_apk.feature_note.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}
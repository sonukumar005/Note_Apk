package com.example.note_apk.feature_note.domain.modal

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.note_apk.ui.theme.BabyBlue
import com.example.note_apk.ui.theme.LightGreen
import com.example.note_apk.ui.theme.RedOrange
import com.example.note_apk.ui.theme.RedPink
import com.example.note_apk.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)
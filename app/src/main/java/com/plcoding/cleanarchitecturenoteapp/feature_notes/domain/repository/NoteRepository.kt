package com.plcoding.cleanarchitecturenoteapp.feature_notes.domain.repository

import com.plcoding.cleanarchitecturenoteapp.feature_notes.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNote(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}
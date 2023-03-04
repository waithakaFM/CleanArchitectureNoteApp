package com.plcoding.cleanarchitecturenoteapp.feature_notes.domain.use_case

/**
 * Wrap the use cases of a single feature into one class to inject that single class that contains
 * all of our usescases for that feature into the VM
 */
data class NoteUseCases(
    val getNotes: GetNotesUseCase,
    val deleteNote: DeleteNoteUseCase,
    val addNote: AddNoteUseCase,
    val getNote: GetNoteUseCase
)
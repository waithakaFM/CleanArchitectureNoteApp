package com.plcoding.cleanarchitecturenoteapp.feature_notes.domain.use_case

import com.plcoding.cleanarchitecturenoteapp.feature_notes.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_notes.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.feature_notes.domain.util.NoteOrder
import com.plcoding.cleanarchitecturenoteapp.feature_notes.domain.util.OrderType
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow

class GetNotesUseCase(
    private val repository: NoteRepository
) {

    /** to make an instance of a class callable like a function.
     * So that we can call this usecase class  as a function
     */
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getNote().map { notes ->
            when(noteOrder.orderType){
                is OrderType.Ascending -> {
                    when (noteOrder){
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase()}
                        is NoteOrder.Date -> notes.sortedBy {it.timestamp}
                        is NoteOrder.Color -> notes.sortedBy {it.color}
                    }

                }
                is OrderType.Descending ->{

                    when (noteOrder){
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase()}
                        is NoteOrder.Date -> notes.sortedByDescending {it.timestamp}
                        is NoteOrder.Color -> notes.sortedByDescending {it.color}
                    }

                }
            }
        }
    }
}
package test_task.dto

import test_task.data.domain.Note

class NoteDto extends BaseDto{

    String message

    static NoteDto fromDomain(Note note){
        return new NoteDto(
                id: note.id,
                createDate: note.createDate,
                message: note.message
        )
    }
}

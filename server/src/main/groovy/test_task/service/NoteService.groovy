package test_task.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import test_task.data.domain.Note
import test_task.data.service.NoteDataService
import test_task.dto.NoteDto

@Service
class NoteService {

    @Autowired private NoteDataService noteDataService

    List<NoteDto> findAllNotes(){

        ArrayList<NoteDto> noteDtos = noteDataService.findAllByOrderByCreateDateDesc().collect {it -> NoteDto.fromDomain(it)}

        return noteDtos
    }

    NoteDto create(NoteDto noteDto){
        Note note = noteDataService.create(noteDto)

        return NoteDto.fromDomain(note)
    }

    void update(NoteDto noteDto){
        noteDataService.update(noteDto)
    }

    void delete(String id){
        noteDataService.delete(id)
    }
}

package test_task.data.service

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import test_task.data.domain.Note
import test_task.data.repository.NoteRepository
import test_task.dto.NoteDto

@Slf4j
@Service
class NoteDataService {

    @Autowired private NoteRepository noteRepository

    List<Note> findAll(){
        log.debug('Find all notes')

        List<Note> notes = noteRepository.findAll()

        if(!notes){
            log.debug('Notes not found')
            return []
        }

        log.debug('Found all notes')

        return notes
    }

    List<Note> findAllByOrderByCreateDateDesc(){
        log.debug('Find all notes')

        List<Note> notes = noteRepository.findAllByOrderByCreateDateDesc()

        if(!notes){
            log.debug('Notes not found')
            return []
        }

        log.debug('Found all notes')

        return notes
    }

    Note findById(String id){
        log.debug("Find note by id ${id}")

        Note note = noteRepository.findById(id).orElseThrow({ -> new Exception("Note with id ${id} not found") })

        log.debug("Found note by id ${id}")

        return note
    }

    Note create(NoteDto noteDto) {
        log.debug("Create note")

        Note note = new Note(
                message: noteDto.message
        )

        note = noteRepository.save(note)

        log.debug("Create note")

        return note
    }

    void update(NoteDto noteDto){
        log.debug("Update note ID [${noteDto.id}]")

        Note note = this.findById(noteDto.id)

        note.message = noteDto.message

        noteRepository.save(note)

        log.debug("Updated note ID [${noteDto.id}]")
    }

    void delete(String id) {
        log.debug("Delete note ID [${id}]")

        noteRepository.deleteById(id)

        log.debug("Note ID [${id}] deleted")
    }
}

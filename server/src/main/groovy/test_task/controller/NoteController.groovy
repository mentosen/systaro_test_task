package test_task.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import test_task.dto.NoteDto
import test_task.service.NoteService

@RestController
@RequestMapping("/note")
class NoteController {

    @Autowired private NoteService noteService

    @GetMapping
    List<NoteDto> findAll(){
        return noteService.findAllNotes()
    }

    @PostMapping
    NoteDto create(@RequestBody NoteDto noteDto){
        return noteService.create(noteDto)
    }

    @PutMapping
    void update(@RequestBody NoteDto noteDto){
        noteService.update(noteDto)
    }

    @DeleteMapping
    void delete(@RequestParam("id") String id){
        noteService.delete(id)
    }
}

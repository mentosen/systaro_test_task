package test_task.data.repository

import org.springframework.data.mongodb.repository.MongoRepository
import test_task.data.domain.Note

interface NoteRepository extends MongoRepository<Note, String>{
    List<Note> findAllByOrderByCreateDateDesc()
}
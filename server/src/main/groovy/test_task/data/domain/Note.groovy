package test_task.data.domain

import groovy.transform.ToString
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = 'notes')
@ToString(includeFields = true, includeNames = true, includePackage = false)
class Note extends BaseDomain {

    String message
}

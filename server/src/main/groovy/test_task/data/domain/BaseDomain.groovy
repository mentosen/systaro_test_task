package test_task.data.domain

import groovy.transform.ToString
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate

@ToString(includeFields = true, includeNames = true, includePackage = false)
class BaseDomain {

    @Id
    String id

    @CreatedDate
    Date createDate

    @LastModifiedDate
    Date lastModifiedDate
}

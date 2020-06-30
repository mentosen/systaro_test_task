package test_task.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import test_task.dto.SumDto
import test_task.service.SumService

@RestController
@RequestMapping("/api")
class SumController {

    @Autowired SumService sumService

    @CrossOrigin
    @PostMapping("/sum")
    SumDto sumOfDigits(@RequestBody SumDto sumDto){
        return sumService.sumOfDigits(sumDto)
    }
}

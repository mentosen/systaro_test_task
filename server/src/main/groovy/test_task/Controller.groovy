package test_task

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class Controller {

    @Autowired SumService sumService

    @CrossOrigin
    @PostMapping("/sum")
    SumDto sumOfDigits(@RequestBody SumDto sumDto){
        return sumService.sumOfDigits(sumDto)
    }
}

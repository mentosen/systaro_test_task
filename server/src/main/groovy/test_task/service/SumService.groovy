package test_task.service

import org.springframework.stereotype.Service
import test_task.dto.SumDto

@Service
class SumService {

    SumDto sumOfDigits(SumDto sumDto){

        SumDto result = new SumDto()
        int number = sumDto.inputNumber

        while (number > 0) {
            result.result = result.result + number % 10;
            number = number / 10;
        }

        return result
    }
}

package test_task

import org.springframework.stereotype.Service

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

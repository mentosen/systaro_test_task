<template>
    <div class="container">
        <task-button-component/>

        <label class="container__item" for="inputNumber">Input number</label>
        <input class="container__item" id="inputNumber"
               type="number"
               v-model="number"
        />
        <button class="container__item" @click="sum">Count</button>
        <span class="container__item">Result: {{result}}</span>
    </div>
</template>

<script>
    import {sumDigits} from "@/api/sumApi";
    import TaskButtonComponent from "@/components/common/TaskButtonComponent";

    export default {
        name: "SumOfDigit",
        components: {TaskButtonComponent},
        data(){
            return {
                number: 0,
                result: 0
            }
        },
        methods: {
            sum(){
                let that = this;
                let params = {
                    input_number: that.number
                };

                sumDigits(params).then(response => {
                    that.result = response.data.result;
                })
            }
        }
    }
</script>

<style scoped>

</style>
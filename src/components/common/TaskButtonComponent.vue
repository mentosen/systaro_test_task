<template>
    <div>
        <button class="btn btn_margin-right" @click="pushByRoute('/')">Task 1</button>
        <button class="btn btn_margin-right" @click="pushByRoute('/task/2')">Task 2</button>
        <button class="btn" @click="pushByRoute('/task/3')">Task 3</button>
    </div>
</template>

<script>
    export default {
        name: "TaskButtonComponent",
        methods: {
            pushByRoute(path){
                this.$router.push(path);
            }
        }
    }
</script>

<style scoped>

</style>
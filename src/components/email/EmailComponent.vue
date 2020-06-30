<template>
    <div class="container">
        <label class="container__item" for="inputNumber">Input email</label>
        <div>
            <input class="container__item container_margin-right" id="inputNumber"
                   type="email"
                   v-model="email"
                   @input="checkEmail"
            />
            <ion-icon v-if="isChecked" name="checkbox-outline" class="success"></ion-icon>
        </div>
        <span class="container__item">The entire email address: {{email}}</span>
        <span class="container__item">First part (before the @) of the email address: {{emailFirstPart}}</span>
        <span class="container__item">The second part of the email address : {{emailSecondPart}}</span>
        <a v-if="mailto.length > 0" class="container__item" :href="mailto">That was an easy Task, Systaro!</a>
    </div>
</template>

<script>
    export default {
        name: "Email",
        data(){
            return {
                email: "",
                emailFirstPart: "",
                emailSecondPart: "",
                mailto: "",
                isChecked: false
            }
        },
        methods:{
            checkEmail(){
                let that = this;
                const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                if(re.test(that.email)){
                    that.isChecked = true;
                    that.createEmailStrings()
                } else {
                    that.isChecked = false;
                    that.emailFirstPart = "";
                    that.emailSecondPart = "";
                    that.mailto = ""
                }
            },
            createEmailStrings(){
                let that = this;
                that.emailFirstPart = that.email.substring(0, that.email.indexOf('@'));
                that.emailSecondPart = that.email.substring(that.email.indexOf('@'), that.email.length);
                that.mailto = 'mailto:' + that.email + '?subject=That was an easy Task, Systaro!'
            }
        }
    }
</script>

<style lang="scss" scoped>
    .success {
        color: green;
    }
</style>
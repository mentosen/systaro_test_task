<template>
    <div class="comment">
        <button class="btn" @click="showComment">comments</button>
        <template v-if="isShowComments">
            <div v-for="comment in comments" :key="comment.id" class="comment comment_padding">
                <span class="comment__email">{{comment.email}}</span>
                <span class="comment__name">{{comment.name}}</span>
                <span class="comment__body">{{comment.body}}</span>
            </div>
        </template>
    </div>
</template>

<script>
    import {getComments} from "@/api/jsonPlaceHolderApi";

    export default {
        name: "Comment",
        props:{
            postId:{
                type: Number,
                required: true
            }
        },
        data(){
            return {
                comments: [],
                isShowComments: false,
            }
        },
        methods:{
            showComment(){
                let that = this;
                that.isShowComments = !that.isShowComments;

                if(that.isShowComments){
                    that.getComments();
                }
            },
            getComments(){
                let that = this;

                getComments(that.postId).then(response => {
                    that.comments = response.data;
                })
            },
        }
    }
</script>

<style scoped>

</style>
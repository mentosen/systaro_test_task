<template>
    <div class="mainContainer">
        <h1>Posts:</h1>
        <div v-for="post in postsPerPage" :key="post.id" class="postContainer postContainer_padding">
            <span class="postContainer__title">{{post.title}}</span>
            <span class="postContainer__body">{{post.body}}</span>
            <comment :postId="post.id"/>
        </div>

        <paginate
                v-model="page"
                :page-count="pagination.total_pages"
                :margin-pages="2"
                :click-handler="getPostsPerPage"
                :containerClass="'pagination'"
                :active-class="'pagination--active'"
                :disabled-class="'pagination--disable'"
                :prev-text="'Prev'"
                :next-text="'Next'"/>
    </div>
</template>

<script>
    import {getPosts, getComments} from "@/api/mainApi";
    import Comment from "@/components/CommentComponent";

    export default {
        name: "PostsPage",
        components: {Comment},
        data(){
            return {
                posts: [],
                postsPerPage: [],
                comments: [],
                perPageCount: 20,
                page: 1,
                pagination: {
                    total: 0,
                    total_pages: 0
                }
            }
        },
        mounted() {
            this.getPosts();
        },
        methods:{
            getPosts(){
                let that = this;

                getPosts().then(response => {
                    that.posts = response.data;
                    that.postsPerPage = response.data;
                    that.pagination.total = that.posts.length;
                    that.pagination.total_pages = Math.ceil(that.posts.length / that.perPageCount);
                })
            },
            getPostsPerPage(){
                let that = this;
                that.postsPerPage = that.posts.slice(that.perPageCount * (that.page - 1), that.perPageCount * that.page);
            },
        }
    }
</script>

<style scoped>

</style>
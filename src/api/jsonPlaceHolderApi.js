import axios from 'axios'

const service = axios.create({
    baseURL: 'https://jsonplaceholder.typicode.com',
});

export function getPosts() {
    return service.get("/posts")
}

export function getComments(postId) {
    return service.get("/posts/" + postId + "/comments")
}
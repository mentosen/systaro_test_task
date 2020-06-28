import axios from 'axios'

const service = axios.create({
    baseURL: 'http://localhost:8081/api',
});

export function sumDigits(params) {
    return service.post("/sum", params)
}
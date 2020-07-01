import request from './request';

export function sumDigits(params) {
    return request.post('/sum', params)
}
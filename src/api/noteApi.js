import request from './request';

export function getAll() {
    return request.get('/note')
}

export function create(data) {
    return request.post('/note', data)
}

export function update(data) {
    return request.put('/note', data)
}

export function deleteNote(id) {
    return request({
        url: '/note',
        method: 'delete',
        params: {id:id}
    })
}
import Axios from 'axios'

const createUrl = (url) => {
    const payload = {
        url
    }
    return Axios.post('http://localhost:8080/rest/url', payload)
} 

const removeUrl = (id) => {
    return Axios.delete(`http://localhost:8080/rest/url/${id}`)
} 

const getAllUrls = () => {
    return Axios.get('http://localhost:8080/rest/url')
} 

export {createUrl, removeUrl, getAllUrls}
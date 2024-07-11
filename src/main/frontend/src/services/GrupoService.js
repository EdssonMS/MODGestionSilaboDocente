import axios from "axios";

const GRUPO_BASE_REST_API_URL = "http://localhost:8080";

class GrupoService {
    
    getAllGrupos() {
        return axios.get(`${GRUPO_BASE_REST_API_URL}/grupo/json`);
    }

    createGrupo(json) {
        return axios.post(`${GRUPO_BASE_REST_API_URL}/grupo/json`, json, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
    }

    getGrupoById(id) {
        return axios.get(`${GRUPO_BASE_REST_API_URL}/grupo/json/${id}`);
    }

    updateGrupo(id, json) {
        return axios.put(`${GRUPO_BASE_REST_API_URL}/grupo/json/${id}`, json, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
    }

    deleteGrupo(id) {
        return axios.delete(`${GRUPO_BASE_REST_API_URL}/grupo/json/${id}`);
    }
}

export default new GrupoService();
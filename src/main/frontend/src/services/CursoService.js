import axios from "axios";

const CURSO_BASE_REST_API_URL = "http://localhost:8080/curso";

class CursoService {

    getAllCursos() {
        return axios.get(CURSO_BASE_REST_API_URL);
    }

    getCursoById(cursoId) {
        return axios.get(CURSO_BASE_REST_API_URL + '/' + cursoId);
    }
}

export default new CursoService();
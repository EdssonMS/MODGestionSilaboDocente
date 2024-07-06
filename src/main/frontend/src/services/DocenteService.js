import axios from "axios";

const DOCENTE_BASE_REST_API_URL = "http://localhost:8080/docente";

class DocenteService {

    getAllDocentes() {
        return axios.get(DOCENTE_BASE_REST_API_URL);
    }

    getDocenteById(docenteId){
        return axios.get(DOCENTE_BASE_REST_API_URL + '/' + docenteId);
    }
}

export default new DocenteService();
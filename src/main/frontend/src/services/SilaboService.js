import axios from "axios";

const SILABO_BASE_REST_API_URL = 'http://localhost:8080'

class SilaboService {

    getAllSilabos() {
        return axios.get(`${SILABO_BASE_REST_API_URL}/silabo/json`);
    }

    deleteSilabo(id) {
        return axios.delete(`${SILABO_BASE_REST_API_URL}/silabo/json/${id}`);
    }
}

export default new SilaboService();
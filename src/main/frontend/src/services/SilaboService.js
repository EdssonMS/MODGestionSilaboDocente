import axios from "axios";

const SILABO_BASE_REST_API_URL = 'http://localhost:8080'

class SilaboService {

    getAllSilabos() {
        return axios.get(`${SILABO_BASE_REST_API_URL}/silabo/json`);
    }

    deleteSilabo(id) {
        return axios.delete(`${SILABO_BASE_REST_API_URL}/silabo/json/${id}`);
    }

    generatePdf(json) {
        return axios.post(`${SILABO_BASE_REST_API_URL}/generar-pdf`, json, {
            headers: {
                'Content-Type': 'application/json',
            },
            responseType: 'blob'  // Para manejar la respuesta como un Blob
        });
    }
}

export default new SilaboService();
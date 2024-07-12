import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import SilaboService from '../services/SilaboService';

export const DownloadSilaboComponent = () => {
    const { id } = useParams();
    const [pdfUrl, setPdfUrl] = useState(null);

    useEffect(() => {
        const fetchSilabo = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/silabo/json/${id}`);
                
                // Verificar el contenido de la respuesta
                const jsonData = response.data;
                
                console.log('JSON del sílabo:', jsonData);
                
                // Generar el PDF
                const pdfResponse = await SilaboService.generatePdf(jsonData);
                
                // Crear una URL para el Blob del PDF
                const pdfBlob = new Blob([pdfResponse.data], { type: 'application/pdf' });
                const pdfUrl = URL.createObjectURL(pdfBlob);
                
                setPdfUrl(pdfUrl);
            } catch (error) {
                console.error('Error al obtener el sílabo:', error);
            }
        };
        fetchSilabo();
    }, [id]);

    return (
        <section id='info-content-cont' className='container'>
            <h2 id='list-header' className='text-center'>Descargar documento</h2>
            {pdfUrl ? (
                <iframe
                    src={pdfUrl}
                    title="Previsualización del PDF"
                    width="100%"
                    height="600px"
                />
            ) : (
                <p>Cargando datos del sílabo...</p>
            )}
        </section>
    );
};

export default DownloadSilaboComponent;

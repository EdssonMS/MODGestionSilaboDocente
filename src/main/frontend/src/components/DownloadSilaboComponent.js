import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import SilaboService from '../services/SilaboService';

export const DownloadSilaboComponent = () => {
    const { id } = useParams();
    const [silaboData, setSilaboData] = useState(null);
    const [pdfUrl, setPdfUrl] = useState(null);

    useEffect(() => {
        const fetchSilabo = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/silabo/json/${id}`);
                
                // Verificar el contenido de la respuesta
                const jsonData = response.data;
                
                console.log('JSON del sílabo:', jsonData);
                
                setSilaboData(jsonData);
                
                // Generar el PDF
                const pdfResponse = await SilaboService.generatePdf(JSON.stringify(jsonData));
                
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
        
        <section id='info-content-cont' className='container' style={{ display: 'flex', gap: '20px' }}>
            
            <div style={{ flex: 1 }}>
                {silaboData ? (
                    <div style={{marginTop:'120px',marginLeft:'20px'}}>
                        <h2>Datos del Sílabo</h2>
                        <br/>
                        <p><strong>Asignatura:</strong> {silaboData.codigoCurso} - {silaboData.nombreCurso}</p>
                        <p><strong>Docente:</strong> {silaboData.codigoDocente} - {silaboData.apellidoDocente}, {silaboData.nombreDocente}</p>
                        <p><strong>Semestre Académico:</strong> {silaboData.semestreAcademico}</p>
                        <p><strong>Tipo de Asignatura:</strong> {silaboData.tipoAsignatura}</p>
                        <p><strong>Número de Semanas:</strong> {silaboData.numeroSemanas}</p>                        <p><strong>Ciclo:</strong> {silaboData.ciclo}</p>
                        <p><strong>Créditos:</strong> {silaboData.creditos}</p>
                        <p><strong>Modalidad:</strong> {silaboData.modalidad}</p>
                      
                    </div>
                ) : (
                    <p>Cargando datos del sílabo...</p>
                )}
            </div>
            <div style={{ flex: 1 }}>
                {pdfUrl ? (
                    <iframe
                        src={pdfUrl}
                        title="Previsualización del PDF"
                        width="100%"
                        height="600px"
                    />
                ) : (
                    <p>Cargando previsualización del PDF...</p>
                )}
            </div>
        </section>
    );
};

export default DownloadSilaboComponent;

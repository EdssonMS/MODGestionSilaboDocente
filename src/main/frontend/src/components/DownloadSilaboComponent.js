import React, { useState, useEffect } from 'react'
import axios from 'axios'
import { useParams } from 'react-router-dom'

export const DownloadSilaboComponent = () => {

    const {id} = useParams();
    const[silabo, setSilabo] = useState(null);

    useEffect(() => {
        const fetchSilabo = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/silabo/json/${id}`);
                
                let data = response.data;
                
                // Si `datos` es una cadena, intentar parsearla a un objeto
                if (typeof data === 'string') {
                    data = JSON.parse(data);
                }
                
                setSilabo(data);
            } catch (error) {
                console.error('Error al obtener el sílabo:', error);
            }
        };
        fetchSilabo();
    }, [id]);

  return (

    <section id='info-content-cont' className='container'>
        <header>
            <h1 id='info-header'>
                Descargar documento
            </h1>
        </header>
        {silabo ? (
                <div>
                    <h2>Datos del sílabo</h2>
                    <br/>
                    <p><strong>Asignatura:</strong> {silabo.codigoCurso} - {silabo.nombreCurso}</p>
                    <p><strong>Docente:</strong> {silabo.apellidoDocente}, {silabo.nombreDocente} - ({silabo.codigoDocente})</p>
                    <p><strong>Correo del Docente:</strong> {silabo.correoDocente}</p>
                    <p><strong>Número de Semanas:</strong> {silabo.numeroSemanas}</p>
                    <p><strong>Ciclo:</strong> {silabo.ciclo}</p>
                    <p><strong>Créditos:</strong> {silabo.creditos}</p>
                    <p><strong>Modalidad:</strong> {silabo.modalidad}</p>
                </div>
            ) : (
                <p>Cargando datos del sílabo...</p>
            )}

        
    </section>

  )
}

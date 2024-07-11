import React, { useState } from 'react'
import useAddSilaboFormContext from '../hooks/useAddSilaboFormContext'
import GrupoService from '../services/GrupoService';

export const AddSilaboPage4 = () => {
  
  const {
    page,
    setPage,
    silabo,
    setSilabo,
    title,
    canSubmit,
    disablePrev,
    prevHide,
    nextHide,
    submitHide,
    handleChange } = useAddSilaboFormContext()


    const handleBuscar = () => {
        const id = silabo.codigoGrupoUnidad;

        GrupoService.getGrupoById(id)
            .then(response => {
                let grupoData;
                if (typeof response.data === 'string') {
                    grupoData = JSON.parse(response.data);
                } else {
                    grupoData = response.data;
                }
                
                setSilabo(prevSilabo => ({
                    ...prevSilabo,
                    unidadesAprendizaje: grupoData.unidadesAprendizaje || []
                }));
            })
            .catch(error => {
                console.error('Error fetching group data', error);
            });
    };

    const renderUnidades = () => {
        if (!silabo.unidadesAprendizaje || silabo.unidadesAprendizaje.length === 0) {
            return <p>No hay unidades de aprendizaje disponibles.</p>;
        }

        return silabo.unidadesAprendizaje.map((unidad, unidadIndex) => (
            <table key={unidadIndex} className="table">
                <tbody>
                    <tr>
                        <td colSpan="5"><strong>Nombre de la Unidad: </strong>{unidad.nombreUnidad}</td>
                    </tr>
                    <tr>
                        <td colSpan="5"><strong>Logro de la Unidad: </strong>{unidad.logroUnidad}</td>
                    </tr>
                    <tr>
                        <th>Semana</th>
                        <th>Contenido</th>
                        <th>Actividades</th>
                        <th>Recursos</th>
                        <th>Estrategias</th>
                    </tr>
                    {unidad.semanas.map((semana, semanaIndex) => (
                        <tr key={semanaIndex}>
                            <td>{semana.semana}</td>
                            <td>{semana.contenido}</td>
                            <td>{semana.actividades}</td>
                            <td>{semana.recursos}</td>
                            <td>{semana.estrategias}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        ));
    };

    const content = (
        <div className='add-silabo-form4'>
            <div>
                <h2 style={{marginBottom:'0'}} className='section-title'>
                    Unidades de aprendizaje
                </h2>
                <hr className='border-bottom border-3 border-dark' style={{marginTop:'2px'}}/>
            </div>
            <div className='info-input-cont'>
                <label htmlFor='codigoGrupoUnidad' className='info-label codigo-grupo'>
                    Código GRUPO unidad aprendizaje
                </label>
                <div id='info-subject-search'>
                    <input 
                        tabIndex={0}
                        id='codigoGrupoUnidad'
                        name='codigoGrupoUnidad'
                        className='info-input codigo-grupo'
                        type='text'
                        value={silabo.codigoGrupoUnidad}
                        onChange={handleChange}
                    />
                    <button style={{marginLeft:'10px'}} type="button" className="btn btn-primary mb-3" onClick={handleBuscar}>Buscar</button>
                </div>
            </div>
            {renderUnidades()}
        </div>
  )

  return content
}

export default AddSilaboPage4

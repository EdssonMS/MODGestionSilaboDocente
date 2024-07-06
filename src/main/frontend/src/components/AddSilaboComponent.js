import useAddSilaboFormContext from '../hooks/useAddSilaboFormContext';
import React, { useState } from 'react';
import CursoService from '../services/CursoService';
import DocenteService from '../services/DocenteService';

export const AddSilaboComponent = () => {

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

    const llenarCurso = (id) => {
        console.log('Llamando a llenarCurso con id:', id);
        CursoService.getCursoById(id).then((response) => {
            console.log('Respuesta recibida:', response.data);

            setSilabo(prevState => ({
                ...prevState,
                nombreCurso: response.data.nombreAsignatura,
                areaEstudios: response.data.areaEstudios,
                horasSemanales: response.data.horasSemanales,
                creditos: response.data.creditos,
                tipoAsignatura: response.data.tipoAsignatura,
                numeroSemanas: response.data.numeroSemanas,
                ciclo: response.data.ciclo,
                prerequisitos: response.data.prerequisitos,
                semestreAcademico: response.data.semestreAcademico,
                modalidad: response.data.modalidad,
                sumilla: response.data.sumilla,
                evaluacionAprendizaje: response.data.evaluacionAprendizaje
            }))
        }).catch(error => {
            console.error('Error al obtener el curso:', error);
        })
    }

    const llenarDocente = (id) => {
        console.log('Llamando a llenarDocente con id:', id);
        DocenteService.getDocenteById(id).then((response) => {
            console.log('Respuesta recibida:', response.data);

            setSilabo(prevState => ({
                ...prevState,
                apellidoDocente: response.data.apellido,
                nombreDocente: response.data.nombre,
                correoDocente: response.data.correo
            }))
        })
    }

    const content = (
        <div className='add-silabo-form1'>
                {/*Titulo*/}
                <div>
                    <h2 style={{marginBottom:'0'}} className='section-title'>
                        Datos generales de la asignatura
                    </h2>
                    <hr className='border-bottom border-3 border-dark' style={{marginTop:'2px'}}/>
                </div>
                <div className='info-input-cont'>
                    <label for='codigoCurso' className='info-label'>
                        Código de la asignatura
                    </label>
                    <div id='info-subject-search'>
                    <input 
                        tabIndex={0}
                        id='codigoCurso'
                        name='codigoCurso'
                        className='info-input codigo-curso'
                        type='text'
                        value={silabo.codigoCurso}
                        onChange={handleChange}
                        //onBlur={handleBlur}
                        />
                    <button style={{marginLeft:'10px'}} type="button" class="btn btn-primary mb-3" onClick={() => llenarCurso(silabo.codigoCurso)}>Buscar</button>
                    </div>
                </div>

                <div className='silabo-grid'>
                    <div className='silabo-grid-wrapper'>
                        {/*Nombre curso*/}
                        <div className='info-input-cont'>
                            <label 
                                for='infoNombreAsignatura'
                                className='info-label'
                            >
                                Nombre de la asignatura
                            </label>
                            <input 
                                id='nombreCurso'
                                name='nombreCurso'
                                className='info-input nombre-curso'
                                type='text'
                                value={silabo.nombreCurso}
                                /*onChange={handleChange}*/
                                //onBlur={handleBlur}
                                disabled
                            />
                        </div>
                        {/*Area*/}
                        <div className='info-input-cont'>
                            <label 
                                for='infoAreaEstudios'
                                className='info-label'
                            >
                                Área de estudios
                            </label>
                            <input 
                                id='areaEstudios'
                                name='areaEstudios'
                                className='info-input area-estudios'
                                type='text'
                                value={silabo.areaEstudios}
                                //onChange={handleChange}
                                //onBlur={handleBlur}
                                disabled
                            />
                        </div>
                        {/*Numero horas*/}
                        <div className='info-input-cont'>
                            <label 
                                for='infoHoras'
                                className='info-label'
                            >
                                Horas semanales
                            </label>
                            <input 
                                id='horasSemanales'
                                name='horasSemanales'
                                className='info-input horas-semanales'
                                type='number'
                                value={silabo.horasSemanales}
                                //onChange={handleChange}
                                //onBlur={handleBlur}
                                disabled
                            />
                        </div>
                        {/*Creditos*/}
                        <div className='info-input-cont'>
                            <label 
                                for='infoCreditos'
                                className='info-label'
                            >
                                Créditos
                            </label>
                            <input 
                                id='creditos'
                                name='creditos'
                                className='info-input creditos'
                                type='number'
                                value={silabo.creditos}
                                //onChange={handleChange}
                                //onBlur={handleBlur}
                                disabled
                            />
                        </div>
                        
                    </div>
                    <div className='silabo-grid-wrapper'>
                        {/*Tipo curso*/}
                        <div className='info-input-cont'>
                            <label 
                                for='tipoAsignatura'
                                className='info-label'
                            >
                                Tipo de asignatura
                            </label>
                            <input 
                                id='tipoAsignatura'
                                name='tipoAsignatura'
                                className='info-input'
                                type='text'
                                value={silabo.tipoAsignatura}
                                //onChange={handleChange}
                                //onBlur={handleBlur}
                                disabled
                            />
                        </div>
                        {/*Numero semanas*/}
                        <div className='info-input-cont'>
                            <label 
                                for='numeroSemanas'
                                className='info-label'
                            >
                                Número de semanas
                            </label>
                            <input 
                                id='numeroSemanas'
                                name='numeroSemanas'
                                className='info-input'
                                type='number'
                                value={silabo.numeroSemanas}
                                //onChange={handleChange}
                                //onBlur={handleBlur}
                                disabled
                            />
                        </div>
                        {/*Ciclo*/}
                        <div className='info-input-cont'>
                            <label 
                                for='ciclo'
                                className='info-label'
                            >
                                Ciclo
                            </label>
                            <input 
                                id='ciclo'
                                name='ciclo'
                                className='info-input'
                                type='text'
                                value={silabo.ciclo}
                                //onChange={handleChange}
                                //onBlur={handleBlur}
                                disabled
                            />
                        </div>
                        {/*Prerequisitos*/}
                        <div className='info-input-cont'>
                            <label 
                                for='prerequisitos'
                                className='info-label'
                            >
                                Prerequisitos
                            </label>
                            <input 
                                id='prerequisitos'
                                name='prerequisitos'
                                className='info-input'
                                type='text'
                                value={silabo.prerequisitos}
                                //onChange={handleChange}
                                //onBlur={handleBlur}
                                disabled
                            />
                        </div>
                    </div>
                </div>
                <div>
                    <h2 style={{marginBottom:'0'}} className='section-title'>
                        Datos específicos de la asignatura
                    </h2>
                    <hr className='border-bottom border-3 border-dark' style={{marginTop:'2px'}}/>
                </div>
                <div className='silabo-grid'>
                    <div className='silabo-grid-wrapper'>
                        {/*Semestre*/}
                        <div style={{marginTop:'2px'}} className='info-input-cont'>
                            <label 
                                for='semestreAcademico'
                                className='info-label'
                            >
                                Semestre
                            </label>
                            <input 
                                id='semestreAcademico'
                                name='semestreAcademico'
                                className='info-input semestre'
                                type='text'
                                value={silabo.semestreAcademico}
                                onChange={handleChange}
                                //onBlur={handleBlur}
                            />
                        </div>
                    </div>
                    <div className='silabo-grid-wrapper'>
                        {/*Modalidad*/}
                        <div style={{marginTop:'2px'}} className='info-input-cont'>
                            <label 
                                for='modalidad'
                                className='info-label'
                            >
                                Modalidad
                            </label>
                            <select 
                                id='modalidad'
                                name='modalidad'
                                className='info-input modalidad'
                                value={silabo.modalidad}
                                //onChange={handleChange}
                                /*onBlur={handleBlur}*/>
                                    <option selected>Seleccionar...</option>
                                    <option>Presencial</option>
                                    <option>Semipresencial</option>
                                    <option>Virtual</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div>
                    <h2 style={{marginBottom:'0'}} className='section-title'>
                        Datos del docente
                    </h2>
                    <hr className='border-bottom border-3 border-dark' style={{marginTop:'2px'}}/>
                </div>
                <div className='info-input-cont'>
                    {/*Docente*/}
                    <div style={{marginTop:'2px'}} className='info-input-cont'>
                        <label 
                            for='codigoDocente'
                            className='info-label'
                            >
                                Código del docente
                        </label>
                    </div>
                    <div className='info-docente-search'>
                            
                            <input 
                                id='codigoDocente'
                                name='codigoDocente'
                                className='info-input codigo-docente'
                                type='text'
                                value={silabo.codigoDocente}
                                onChange={handleChange}
                                //onBlur={handleBlur}
                            />
                            <button style={{marginLeft:'10px'}} type="button" class="btn btn-primary mb-3" onClick={() => llenarDocente(silabo.codigoDocente)}>Buscar</button>
                    </div>
                </div>
                <div className='silabo-grid'>
                    <div className='silabo-grid-wrapper'>
                        {/*Apellido*/}
                        <div className='info-input-cont'>
                            <label 
                                for='apellidoDocente'
                                className='info-label'
                            >
                                Apellido
                            </label>
                            <input 
                                id='apellidoDocente'
                                name='apellidoDocente'
                                className='info-input apellido'
                                type='text'
                                value={silabo.apellidoDocente}
                                onChange={handleChange}
                                //onBlur={handleBlur}
                                disabled
                            />
                        </div>
                        {/*Correo*/}
                        <div className='info-input-cont'>
                            <label 
                                for='correoDocente'
                                className='info-label'
                            >
                                Correo
                            </label>
                            <input 
                                id='correoDocente'
                                name='correoDocente'
                                className='info-input correo'
                                type='text'
                                value={silabo.correoDocente}
                                onChange={handleChange}
                                //onBlur={handleBlur}
                                disabled
                            />
                        </div>
                    </div>
                    <div className='silabo-grid-wrapper'>
                        {/*Nombre*/}
                        <div className='info-input-cont'>
                            <label 
                                for='nombreDocente'
                                className='info-label'
                            >
                                Nombre
                            </label>
                            <input 
                                id='nombreDocente'
                                name='nombreDocente'
                                className='info-input nombre'
                                type='text'
                                value={silabo.nombreDocente}
                                onChange={handleChange}
                                //onBlur={handleBlur}
                                disabled
                            />
                        </div>
                    </div>
                </div>
                
        </div>
    )

    return content
}

export default AddSilaboComponent;
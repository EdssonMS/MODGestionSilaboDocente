import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import GrupoService from '../services/GrupoService';

const CrearGrupoComponent = () => {
    const { id } = useParams();
    const isEditing = Boolean(id);

    
    const [grupo, setGrupo] = useState({
        nombre: '',
        descripcion: '',
        unidadesAprendizaje: []
    });

    useEffect(() => {
        if (isEditing) {
            GrupoService.getGrupoById(id)
            .then(response => {
                // Verifica si response.data ya es un objeto
                let grupoData;
                if (typeof response.data === 'string') {
                    grupoData = JSON.parse(response.data);
                } else {
                    grupoData = response.data;
                }
                setGrupo(grupoData);
            })
            .catch(error => {
                console.error('Error fetching group data', error);
            });
        }
    }, [isEditing, id]);

    const addUnidad = () => {
        setGrupo(prevState => ({
            ...prevState,
            unidadesAprendizaje: [...prevState.unidadesAprendizaje, { nombreUnidad: '', logroUnidad: '', semanas: [] }]
        }));
    };

    const removeUnidad = (unidadIndex) => {
        setGrupo(prevState => ({
            ...prevState,
            unidadesAprendizaje: prevState.unidadesAprendizaje.filter((_, index) => index !== unidadIndex)
        }));
    };

    const addSemana = (unidadIndex) => {
        const nuevasUnidades = [...grupo.unidadesAprendizaje];
        nuevasUnidades[unidadIndex].semanas.push({ semana: '', contenido: '', actividades: '', recursos: '', estrategias: '' });
        setGrupo(prevState => ({ ...prevState, unidadesAprendizaje: nuevasUnidades }));
    };

    const removeSemana = (unidadIndex, semanaIndex) => {
        const nuevasUnidades = [...grupo.unidadesAprendizaje];
        nuevasUnidades[unidadIndex].semanas = nuevasUnidades[unidadIndex].semanas.filter((_, index) => index !== semanaIndex);
        setGrupo(prevState => ({ ...prevState, unidadesAprendizaje: nuevasUnidades }));
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        const grupoJson = JSON.stringify(grupo);

        if (isEditing) {
            GrupoService.updateGrupo(id, grupoJson).then(response => {
                console.log('Grupo actualizado', response.data);
                // Redirigir o mostrar mensaje de éxito
            }).catch(error => {
                console.error('Error actualizando grupo', error);
            });
        } else {
            GrupoService.createGrupo(grupoJson).then(response => {
                console.log('Grupo creado', response.data);
                // Redirigir o mostrar mensaje de éxito
            }).catch(error => {
                console.error('Error creando grupo', error);
            });
        }
    };

    return (

        <section id='info-content-cont' className='container'>
            <form className='group-form' onSubmit={handleSubmit}>
                <header>
                    <h1 id='info-header'>
                        {isEditing ? 'Editar Grupo' : 'Programación de contenidos'}
                    </h1>
                </header>
                <div className='group-input-cont'> 
                    <label style={{marginRight:'10px'}} className='group-label'>Nombre del Grupo: </label>
                    <input
                        className='group-input'
                        type="text"
                        value={grupo.nombre}
                        onChange={(e) => setGrupo({ ...grupo, nombre: e.target.value })}
                    />
                </div>
                <div className='group-input-cont'>
                    <label style={{marginRight:'54px'}} className='group-label'>Descripción: </label>
                    <input
                        className='group-input'
                        type="text"
                        value={grupo.descripcion}
                        onChange={(e) => setGrupo({ ...grupo, descripcion: e.target.value })}
                    />
                </div>
                {grupo.unidadesAprendizaje.map((unidad, unidadIndex) => (
                    <div key={unidadIndex} style={{marginBottom:'40px'}}>
                        <br/>
                        <div style={{display:'flex'}}>
                        <h3 style={{marginRight:'15px'}}>Unidad {unidadIndex + 1}</h3>
                        <button className='btn btn-danger' type="button" onClick={() => removeUnidad(unidadIndex)}>Eliminar</button>
                        </div>
                        <div className='group-input-cont'>
                            <label style={{marginRight:'10px'}}>Nombre de la Unidad: </label>
                            <input
                                className='group-input'
                                type="text"
                                value={unidad.nombreUnidad}
                                onChange={(e) => {
                                    const nuevasUnidades = [...grupo.unidadesAprendizaje];
                                    nuevasUnidades[unidadIndex].nombreUnidad = e.target.value;
                                    setGrupo(prevState => ({ ...prevState, unidadesAprendizaje: nuevasUnidades }));
                                }}
                            />
                        </div>
                        <div className='group-input-cont'>
                            <label style={{marginRight:'22px'}}>Logro de la Unidad: </label>
                            <input
                                className='group-input'
                                type="text"
                                value={unidad.logroUnidad}
                                onChange={(e) => {
                                    const nuevasUnidades = [...grupo.unidadesAprendizaje];
                                    nuevasUnidades[unidadIndex].logroUnidad = e.target.value;
                                    setGrupo(prevState => ({ ...prevState, unidadesAprendizaje: nuevasUnidades }));
                                }}
                            />
                        </div>
                        <br/>
                        

                        {unidad.semanas.map((semana, semanaIndex) => (
                            <div id='input-semanas' key={semanaIndex} style={{marginTop:'5px', marginBottom:'5px'}}>
                                {/*<br/>
                                <h4>Semana {semanaIndex + 1}</h4>*/}
                                <div className='group-input-cont' style={{float:'left', marginRight:'5px', marginBottom:'5px', marginTop:'5px'}}>
                                    <label style={{marginRight:'0px'}}>Semana: </label>
                                    <textarea
                                        className='group-input'
                                        type="text"
                                        style={{width:'60px', height:'200px'}}
                                        value={semana.semana}
                                        onChange={(e) => {
                                            const nuevasUnidades = [...grupo.unidadesAprendizaje];
                                            nuevasUnidades[unidadIndex].semanas[semanaIndex].semana = e.target.value;
                                            setGrupo(prevState => ({ ...prevState, unidadesAprendizaje: nuevasUnidades }));
                                        }}
                                    />
                                </div>
                                <div className='group-input-cont' style={{float:'left', marginRight:'5px', marginBottom:'5px', marginTop:'5px'}}>
                                    <label style={{marginRight:'76px'}}>Contenido: </label>
                                    <textarea
                                        className='group-input'
                                        type="text"
                                        style={{width:'300px', height:'200px', fontSize:'12.5px'}}
                                        value={semana.contenido}
                                        onChange={(e) => {
                                            const nuevasUnidades = [...grupo.unidadesAprendizaje];
                                            nuevasUnidades[unidadIndex].semanas[semanaIndex].contenido = e.target.value;
                                            setGrupo(prevState => ({ ...prevState, unidadesAprendizaje: nuevasUnidades }));
                                        }}
                                    />
                                </div>
                                <div className='group-input-cont' style={{float:'left', marginRight:'5px', marginBottom:'5px', marginTop:'5px'}}>
                                    <label style={{marginRight:'66px'}}>Actividades: </label>
                                    <textarea
                                        className='group-input'
                                        type="text"
                                        style={{width:'250px', height:'200px', fontSize:'12.5px'}}
                                        value={semana.actividades}
                                        onChange={(e) => {
                                            const nuevasUnidades = [...grupo.unidadesAprendizaje];
                                            nuevasUnidades[unidadIndex].semanas[semanaIndex].actividades = e.target.value;
                                            setGrupo(prevState => ({ ...prevState, unidadesAprendizaje: nuevasUnidades }));
                                        }}
                                    />
                                </div>
                                <div className='group-input-cont' style={{float:'left', marginRight:'5px', marginBottom:'5px', marginTop:'5px'}}>
                                    <label style={{marginRight:'77px'}}>Recursos: </label>
                                    <textarea
                                        className='group-input'
                                        type="text"
                                        style={{width:'180px', height:'200px', fontSize:'12.5px'}}
                                        value={semana.recursos}
                                        onChange={(e) => {
                                            const nuevasUnidades = [...grupo.unidadesAprendizaje];
                                            nuevasUnidades[unidadIndex].semanas[semanaIndex].recursos = e.target.value;
                                            setGrupo(prevState => ({ ...prevState, unidadesAprendizaje: nuevasUnidades }));
                                        }}
                                    />
                                </div>
                                <div className='group-input-cont' style={{float:'left', marginBottom:'5px', marginTop:'5px'}}>
                                    <label style={{marginRight:'58px'}}>Estrategias: </label>
                                    <textarea
                                        className='group-input'
                                        type="text"
                                        style={{width:'180px', height:'200px', fontSize:'12.5px'}}
                                        value={semana.estrategias}
                                        onChange={(e) => {
                                            const nuevasUnidades = [...grupo.unidadesAprendizaje];
                                            nuevasUnidades[unidadIndex].semanas[semanaIndex].estrategias = e.target.value;
                                            setGrupo(prevState => ({ ...prevState, unidadesAprendizaje: nuevasUnidades }));
                                        }}
                                    />
                                </div>
                                <br style={{clear:'both'}}/>
                                <button style={{width:'142px'}} className='btn btn-danger' type="button" onClick={() => removeSemana(unidadIndex, semanaIndex)}>Borrar Semana</button>
                            </div>
                        ))}
                        <button style={{marginBottom:'30px'}} className='btn-primary' type="button" onClick={() => addSemana(unidadIndex)}>Agregar Semana</button>
                    </div>
                ))}
                <button style={{marginTop:'20px'}} className='btn-primary' type="button" onClick={addUnidad}>Agregar Unidad</button>
                <div className='form-group'>
                    <br/>
                    <button type='submit' className='btn btn-success'>Guardar</button>
                </div>
            </form>
        </section>
    );
};

export default CrearGrupoComponent;
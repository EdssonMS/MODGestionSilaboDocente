import React from 'react'
import useAddSilaboFormContext from '../hooks/useAddSilaboFormContext'

export const AddSilaboPage3 = () => {
  
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

    const renderLogros = () => {
      if (!silabo.unidadesAprendizaje || silabo.unidadesAprendizaje.length === 0) {
          return <p>No hay unidades de aprendizaje disponibles.</p>;
      }

      return silabo.unidadesAprendizaje.map((unidad, unidadIndex) => (
          <table key={unidadIndex} className="table">
              <tbody>
                  <tr>
                      <td colSpan="5"><strong>Unidad {unidadIndex+1}: </strong>{unidad.logroUnidad}</td>
                  </tr>
              </tbody>
          </table>
      ));
  };

  const content = (
    <div className='add-silabo-form3'>
          {/*Logros aprendizaje*/}
          <div>
            <h2 style={{marginBottom:'0'}} className='section-title'>
              Logros de aprendizaje
            </h2>
            <hr className='border-bottom border-3 border-dark' style={{marginTop:'2px'}}/>
          </div>
          <div className='info-input-cont'>
            <label for='logrosAprendizaje' className='info-label logros'>
              Competencias de la asignatura
            </label>
            <textarea className='info-input logross' id='logrosAprendizaje' name='logrosAprendizaje' type='text' value={silabo.logrosAprendizaje} onChange={handleChange} rows={9}></textarea>
          </div>
          {/*Capacidades*/}
          <div>
            <h2 style={{marginBottom:'0'}} className='section-title'>
              Capacidades
            </h2>
            <hr className='border-bottom border-3 border-dark' style={{marginTop:'2px'}}/>
          </div>
          <div className='info-input-cont'>
            <label for='logrosAprendizaje' className='info-label logros'>
              Logros por unidad
            </label>
            {renderLogros()}
          </div>
    </div>
  )

  return content
}

export default AddSilaboPage3

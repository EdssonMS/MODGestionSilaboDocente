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
            
          </div>
    </div>
  )

  return content
}

export default AddSilaboPage3

import React from 'react'
import useAddSilaboFormContext from '../hooks/useAddSilaboFormContext'

export const AddSilaboPage5 = () => {
  
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
    <div className='add-silabo-form5'>
          {/*Estrategia didáctica*/}
          <div>
            <h2 style={{marginBottom:'0'}} className='section-title'>
              Estrategia didáctica
            </h2>
            <hr className='border-bottom border-3 border-dark' style={{marginTop:'2px'}}/>
          </div>
          <div className='info-input-cont'>
            <label for='estrategiaDidactica' className='info-label estrategia'>
              Estrategia
            </label>
            <textarea className='info-input estrategia' id='estrategiaDidactica' name='estrategiaDidactica' type='text' value={silabo.estrategiaDidactica} onChange={handleChange} rows={9}></textarea>
          </div>
          {/*Evaluación del aprendizaje*/}
          <div>
            <h2 style={{marginBottom:'0'}} className='section-title'>
              Evaluación del aprendizaje
            </h2>
            <hr className='border-bottom border-3 border-dark' style={{marginTop:'2px'}}/>
          </div>
          <div className='info-input-cont'>
            <label for='evaluacionAprendizaje' className='info-label'>
              Metodología de evaluación
            </label>
            <textarea className='info-input evaluacion' id='evaluacionAprendizaje' name='evaluacionAprendizaje' type='text' value={silabo.evaluacionAprendizaje} onChange={handleChange} rows={9}></textarea>
          </div>
          
        </div>
  )

  return content
}

export default AddSilaboPage5

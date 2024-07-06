import React from 'react'
import useAddSilaboFormContext from '../hooks/useAddSilaboFormContext'

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

  const content = (
    <div className='add-silabo-form4'>
                {/*Programación de contenidos*/}
                <div>
                    <h2 style={{marginBottom:'0'}} className='section-title'>
                        Unidades de aprendizaje
                    </h2>
                    <hr className='border-bottom border-3 border-dark' style={{marginTop:'2px'}}/>
                </div>
                <div className='info-input-cont'>
                    <label for='codigoGrupoUnidad' className='info-label codigo-grupo'>
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
                        //onBlur={handleBlur}
                        />
                    <button style={{marginLeft:'10px'}} type="button" class="btn btn-primary mb-3">Buscar</button>
                    </div>
                </div>
      </div>
  )

  return content
}

export default AddSilaboPage4

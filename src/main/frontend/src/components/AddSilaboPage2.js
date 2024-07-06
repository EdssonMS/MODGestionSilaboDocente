import React, { useEffect, useState } from 'react'
import useAddSilaboFormContext from '../hooks/useAddSilaboFormContext'

export const AddSilaboPage2 = () => {
  
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

    const {competencias, setCompetencias} = useState([]);

    useEffect(() => {
      listarCompetencias();
    },[])

    const listarCompetencias = () => {
      //Por implementar
    }

    const content = (
        <div className='add-silabo-form2'>
          {/*Sumilla*/}
          <div>
            <h2 style={{marginBottom:'0'}} className='section-title'>
              Sumilla
            </h2>
            <hr className='border-bottom border-3 border-dark' style={{marginTop:'2px'}}/>
          </div>
          <div className='info-input-cont'>
            <label for='sumilla' className='info-label'>
              Descripción de la asignatura
            </label>
            <textarea className='info-input sumilla' id='sumilla' name='sumilla' type='text' value={silabo.sumilla} onChange={handleChange} rows={9}></textarea>
          </div>
          {/*Competencias*/}
          <div>
            <h2 style={{marginBottom:'0'}} className='section-title'>
              Competencias
            </h2>
            <hr className='border-bottom border-3 border-dark' style={{marginTop:'2px'}}/>
          </div>
          <div className='info-input-cont'>
            <label for='competencias' className='info-label'>
              Competencias del perfil de egreso a las que contribuye la asignatura
            </label>
            
            <table class="table table-bordered table-hover">
              <thead>
                <th>Código</th>
                <th>Descripción</th>
                <th>Tipo</th>
                <th>Nivel</th>
              </thead>
              <tbody>
                {
                  competencias?.map(
                    competencia =>
                      <tr key={competencia.codigo}>
                        <td>{competencia.codigo}</td>
                        <td>{competencia.descripcion}</td>
                        <td>{competencia.tipo}</td>
                        <td>{competencia.nivel}</td>
                      </tr>
                  )
                }
              </tbody>
            </table>
          </div>
        </div>
    )

    return content
}

export default AddSilaboPage2

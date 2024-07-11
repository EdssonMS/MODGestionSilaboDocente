import React from 'react'
import useAddSilaboFormContext from '../hooks/useAddSilaboFormContext'

export const AddSilaboPage6 = () => {
  
  const {silabo, handleChange} = useAddSilaboFormContext()

  return (
    <div className='add-silabo-form6'>
          {/*Bibliografia*/}
          <div>
            <h2 style={{marginBottom:'0'}} className='section-title'>
              Referencias bibliográficas
            </h2>
            <hr className='border-bottom border-3 border-dark' style={{marginTop:'2px'}}/>
          </div>
          <div className='info-input-cont'>
            <label for='bibliografia' className='info-label bibliografia'>
              Bibliografia
            </label>
            <textarea className='info-input bibliografia' id='bibliografia' name='bibliografia' type='text' value={silabo.bibliografia} onChange={handleChange} rows={9}></textarea>
          </div>
    </div>
  )
}

export default AddSilaboPage6

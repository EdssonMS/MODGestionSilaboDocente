/*Componente para mostrar el historial de sílabos creados*/

import React, { useEffect, useState } from 'react'

export const ListSilabosComponent = () => {

  const [silabos, setSilabos] = useState([]);

  useEffect(() => {
    listarSilabos();
  },[])

  /*Pendiente hasta crear el servicio de silabos (SilaboService.js) y sus métodos para la conexión con la BD*/

  const listarSilabos = () => {
    /*SilaboService.getAllSilabos().then(reponse => {
        setSilabos(response.data);
        console.log(response.data);
    }).catch(error => {
        console.log(error);
    }) */
  }

  const deleteSilabo = (silaboId) => {
    /*SilaboService.deleteSilabo(silaboId).then((response) => {
        listarSilabos();
    }).catch(error => {
        console.log(error);
    }) */
  }

  return (
    <div className='container'>
        <h2 className='text-center'>Historial de sílabos</h2>
        <table className='table table-bordered table-striped'>
            <thead>
                <th>Código</th>
                <th>Asignatura</th>
                <th>Últ. actualización</th>
                <th>Editar</th>
                <th>Formato</th>
                <th>Eliminar</th>
            </thead>
            <tbody>
                {
                    silabos.map(
                        silabo =>
                            <tr key={silabo.id}>
                                <td>{silabo.codigo}</td>
                                <td>{silabo.curso}</td>
                                <td>{silabo.ultActualizacion}</td>
                                <td>
                                    {/*Botón que redirija al componente de registro de silabo*/}
                                </td>
                                <td>
                                    {/*Botón para generar el PDF del sílabo*/}
                                </td>
                                <td>
                                    <button style={{marginLeft:"10px"}} className='btn btn-danger' onClick={() => deleteSilabo(silabo.id)}>Eliminar</button>
                                </td>
                            </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListSilabosComponent;
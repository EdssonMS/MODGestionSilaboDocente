/*Componente para mostrar el historial de sílabos creados*/

import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';
import DataTable from 'react-data-table-component'

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

  const customStyles = {
    headRow: {
        style: {
            backgroundColor: '#424c6f',
            color: 'white'
        }
    },
    headCells: {
        style: {
            fontSize: '16px',
            fontWeight: '600',
            
        }
    },
    cells: {
        style: {
            fontSize: '15px'
        }
    }
  }

  const paginationComponentOptions = {
    rowsPerPageText: 'Filas por página:', 
    rangeSeparatorText: 'de', 
    noRowsPerPage: false, 
    selectAllRowsItem: false, 
    selectAllRowsItemText: 'Todo'
  }

  const column = [
    {
        name: "Código",
        selector: row => row.codigo
    },
    {
        name: "Asignatura",
        selector: row => row.asignatura
    },
    {
        name: "Últ. Actualización",
        selector: row => row.lastUpdate
    },
    {
        name: "Acciones",
        width: "350px",
        button: true,
		cell: () => 
        <div id='list-actions'>
            <button style={{marginRight:'10px'}} className='btn btn-primary'>Editar</button>
            <button style={{marginRight:'10px'}} className='btn btn-warning'>Descargar</button>
            <button style={{fontFamily: 'Roboto Serif', fontSize: '0.875rem', paddingLeft: '10px', paddingRight: '10px', borderRadius: '5px'}} className='btn btn-danger'>Eliminar</button>
        </div>},
  ];

  const data = [
    {
      codigo: 1,
      asignatura: '20W0603 - DISEÑO DE SOFTWARE',
      lastUpdate: '2024/07/03',
      acciones: ''
  },
  {
    codigo: 2,
    asignatura: '20W0603 - DISEÑO DE SOFTWARE',
    lastUpdate: '2024/07/03',
    acciones: ''
  },
];

  return (
    
    
    <section id='list-content-cont' className='container'>
        <h2 id='list-header' className='text-center'>Historial de sílabos</h2>
        <div id='list-welcome'>
            <h6>Bienvenido(a): USUARIO DOCENTE</h6>
            <Link id='btn-list-create' to={'/add-silabo'}>
                <button className='btn-primary'>Crear sílabo</button>
            </Link>
            <button id='btn-list-return' className='btn-primary'>Volver</button>
        </div>
        <div style={{padding: "50px 0.5%", borderRadius:"10px"}}>
        <DataTable
                columns = {column}
                data = {data}
                persistTableHead = {true}
                noDataComponent = {'No hay registros para mostrar'}
                highlightOnHover = {true}
                pagination = {true}
                paginationComponentOptions = {paginationComponentOptions}
                customStyles={customStyles}
            />
        </div>
    </section>
        /*<table className='table table-striped'>
            <thead className='thead-dark'>
                <th scope="col">Código</th>
                <th scope="col">Asignatura</th>
                <th scope="col">Últ. actualización</th>
                <th scope="col">Editar</th>
                <th scope="col">Formato</th>
                <th scope="col">Eliminar</th>
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
                                    Botón que redirija al componente de registro de silabo
                                </td>
                                <td>
                                    Botón para generar el PDF del sílabo
                                </td>
                                <td>
                                    <button style={{marginLeft:"10px"}} className='btn btn-danger' onClick={() => deleteSilabo(silabo.id)}>Eliminar</button>
                                </td>
                            </tr>
                    )
                }
            </tbody>
        </table>
    </section>*/
  )
}

export default ListSilabosComponent;
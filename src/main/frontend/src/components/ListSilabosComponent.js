/*Componente para mostrar el historial de sílabos creados*/

import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import DataTable from 'react-data-table-component'
import SilaboService from '../services/SilaboService';
import { Modal, Button } from 'react-bootstrap';
import useAddSilaboFormContext from '../hooks/useAddSilaboFormContext';

export const ListSilabosComponent = () => {

  const [silabos, setSilabos] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const [deleteId, setDeleteId] = useState(null);
  const navigate = useNavigate();
  const { loadSilabo } = useAddSilaboFormContext();

  useEffect(() => {
    SilaboService.getAllSilabos()
      .then((response) => {
        const data = response.data.map((silabo) => {
          const datos = JSON.parse(silabo.datos); 
          return {
            id: silabo.id,
            nombreCurso: datos.nombreCurso,
            codigoCurso: datos.codigoCurso,
            tipoAsignatura: datos.tipoAsignatura,
          };
        });
        setSilabos(data);
      })
      .catch((error) => {
        console.error('Error al obtener los sílabos:', error);
      });
  }, []);

  const handleEdit = (row) => {
    // Lógica para editar el silabo
    navigate(`/edit-silabo/${row.id}`);
  };
  
  const handleDownload = (row) => {
    // Lógica para descargar el silabo
    navigate(`/download-silabo/${row.id}`);
  };
  
  const handleDelete = (id) => {
    // Lógica para eliminar el silabo
    setDeleteId(id);
    setShowModal(true);
  };

  const confirmDelete = () => {
    SilaboService.deleteSilabo(deleteId)
    .then(() => {
      setSilabos(silabos.filter(silabo => silabo.id !== deleteId));
      setShowModal(false);
    })
    .catch((error) => {
      console.error('Error al eliminar el silabo:', error);
      setShowModal(false);
    });
  };

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
        name: "ID",
        selector: row => row.id,
        sortable: true,
    },
    {
        name: "Asignatura",
        selector: row => row.nombreCurso,
        sortable: true,
    },
    {
        name: "Código Asignatura",
        selector: row => row.codigoCurso,
        sortable: true,
    },
    {
        name: 'Tipo de Asignatura',
        selector: row => row.tipoAsignatura,
        sortable: true,
    },
    {
        name: "Acciones",
        width: "350px",
        button: true,
		cell: row => 
        <div id='list-actions'>
            <button style={{marginRight:'10px'}} className='btn btn-primary' onClick={() => handleEdit(row)}>Editar</button>
            <button style={{marginRight:'10px'}} className='btn btn-warning' onClick={() => handleDownload(row)}>Descargar</button>
            <button style={{fontFamily: 'Roboto Serif', fontSize: '0.875rem', paddingLeft: '10px', paddingRight: '10px', borderRadius: '5px'}} className='btn btn-danger' onClick={() => handleDelete(row.id)}>Eliminar</button>
        </div>},
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
                data = {silabos}
                persistTableHead = {true}
                noDataComponent = {'No hay registros para mostrar'}
                highlightOnHover = {true}
                pagination = {true}
                paginationComponentOptions = {paginationComponentOptions}
                customStyles={customStyles}
                paginationPerPage = {5}
                paginationRowsPerPageOptions = {[5, 10, 15, 20, 25, 30]}
            />
        </div>
        <Modal show={showModal} onHide={() => setShowModal(false)} centered>
                    <Modal.Header className='custom-modal-title'>
                        <Modal.Title className="custom-modal-title">Confirmación</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>¿Estás seguro de que deseas eliminar este sílabo?</Modal.Body>
                    <Modal.Footer>
                        <Button variant="danger" onClick={() => setShowModal(false)}>
                            Cancelar
                        </Button>
                        <Button variant="success" onClick={confirmDelete}>
                            Confirmar
                        </Button>
                    </Modal.Footer>
                </Modal>
    </section>
  )
}

export default ListSilabosComponent;
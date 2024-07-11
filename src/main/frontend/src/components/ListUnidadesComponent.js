import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import DataTable from 'react-data-table-component'
import GrupoService from '../services/GrupoService';
import { Modal, Button } from 'react-bootstrap';

export const ListUnidadesComponent = () => {
  
    const [unidades, setUnidades] = useState([]);
    const [showModal, setShowModal] = useState(false);
    const [deleteId, setDeleteId] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        GrupoService.getAllGrupos()
        .then((response) => {
            const data = response.data.map((grupo) => {
                const datos = JSON.parse(grupo.datos);
                return {
                    id: grupo.id,
                    nombre: datos.nombre,
                    descripcion: datos.descripcion
                };
            });
            setUnidades(data);
        })
        .catch((error) => {
            console.error('Error al obtener los grupos:', error);
        });
    },[])

    const listarUnidades = () => {

    }

    const handleEdit = (row) => {
        //Navergar al form en modo edición
        navigate(`/edit-grupo/${row.id}`);
    }

    const handleDelete = (id) => {
        // Mostrar el Modal de confirmación
        setDeleteId(id);
        setShowModal(true);
    };

    const confirmDelete = () => {
        // Lógica para eliminar el grupo
        GrupoService.deleteGrupo(deleteId)
            .then(() => {
                setUnidades(unidades.filter(unidad => unidad.id !== deleteId));
                setShowModal(false);
            })
            .catch((error) => {
                console.error('Error al eliminar el grupo:', error);
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
            selector: row => row.id
        },
        {
            name: "Nombre",
            selector: row => row.nombre
        },
        {
            name: "Descripción",
            selector: row => row.descripcion
        },
        {
            name: "Acciones",
            width: "350px",
            button: true,
            cell: row => 
            <div id='list-actions'>
                <button style={{marginRight:'10px'}} className='btn btn-primary' onClick={() => handleEdit(row)}>Editar</button>
                <button style={{fontFamily: 'Roboto Serif', fontSize: '0.875rem', paddingLeft: '10px', paddingRight: '10px', borderRadius: '5px'}} className='btn btn-danger' onClick={() => handleDelete(row.id)}>Eliminar</button>
            </div>},
    ];

    return (
        <main>
        <section id='list-content-cont' className='container'>
        <h2 id='list-header' className='text-center'>Unidades de aprendizaje</h2>
        <div id='list-welcome'>
            <h6>Bienvenido(a): USUARIO DOCENTE</h6>
            <Link id='btn-list-create' to={'/add-grupo'}>
                <button className='btn-primary'>Crear programación</button>
            </Link>
            <button id='btn-list-return' className='btn-primary'>Volver</button>
        </div>
        <div style={{padding: "50px 0.5%", borderRadius:"10px"}}>
        <DataTable
                columns = {column}
                data = {unidades}
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
                    <Modal.Body>¿Estás seguro de que deseas eliminar esta programación?</Modal.Body>
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
</main>
  )
}

export default ListUnidadesComponent;

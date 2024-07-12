import axios from "axios";
import AddSilaboFormInputs from "../components/AddSilaboFormInputs"
import useAddSilaboFormContext from "../hooks/useAddSilaboFormContext";
import { useParams, useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { Modal, Button} from "react-bootstrap";

const Form = () => {
    
    const {
        page,
        setPage,
        silabo,
        title,
        canSubmit,
        disablePrev,
        prevHide,
        nextHide,
        submitHide,
        loadSilabo
    } = useAddSilaboFormContext()

    const { id } = useParams();
    const navigate = useNavigate();

    const [showModal, setShowModal] = useState(false);

    useEffect(() => {
        let isMounted = true; // Bandera para verificar si el componente está montado
      
        if (id && isMounted) {
          // Cargar datos del sílabo para edición solo si hay un ID y el componente está montado
          axios
            .get(`http://localhost:8080/silabo/json/${id}`)
            .then((response) => {
              if (isMounted) {
                // Verificar si el componente está montado antes de actualizar el estado
                if (response.data) {
                  loadSilabo(response.data); // Actualiza el estado del sílabo con los datos recibidos
                } else {
                  console.error("No se encontraron datos en la respuesta:", response.data);
                }
              }
            })
            .catch((error) => {
              console.error("Error al cargar el sílabo para edición:", error);
            });
        }
      
        return () => {
          isMounted = false; // Actualizar la bandera cuando el componente se desmonte
        };
      }, [id]); // Solo se ejecutará cuando id cambie

    const handlePrev = () => setPage(prev => prev - 1)

    const handleNext = () => setPage(prev => prev + 1)

    const handleSubmit = async () => {
        //e.preventDefault();
        //console.log(JSON.stringify(silabo));
    console.log('Silabo antes de enviar:', silabo);

        try {
            if (id) {
                // Editar sílabo existente
                const response = await axios.put(`http://localhost:8080/silabo/json/${id}`, silabo, {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                });
                console.log('Respuesta del servidor:', response.data);
            } else {
                // Crear nuevo sílabo
                const response = await axios.post('http://localhost:8080/silabo/json', silabo, {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                });
                console.log('Respuesta del servidor:', response.data);
            }
        } catch(error) {
            console.error('Error al enviar el sílabo', error);
        }

        navigate('/silabos');
    }

    const handleShowModal = () => setShowModal(true);
    const handleCloseModal = () => setShowModal(false);
    
    const handleConfirmSubmit = () => {
        handleCloseModal();
        handleSubmit();
    }

    const content = (
        <main id='info-cont'>
            
        <section id='info-content-cont' className='container'>
            
            <form id='info-form' tabIndex={0} onSubmit={handleSubmit}> 
                <header>
                    <h1 id='info-header'>
                        {title[page]}
                    </h1>
                </header>
                
                <AddSilaboFormInputs />
                
                <br />
                <div className='fixed-buttons'>
                    <button 
                        type="button"
                        className={`btn-primary ${prevHide}`}
                        onClick={handlePrev}
                        disabled={disablePrev}
                    >
                        Anterior 
                    </button>
                    &nbsp;
                    <button 
                        type="button"
                        className={`btn-primary ${nextHide}`}
                        onClick={handleNext}

                    >
                        Siguiente
                    </button>
                    &nbsp;
                    <button 
                        type="button"
                        className={`btn-primary ${submitHide}`}
                        onClick={handleShowModal}
                        //disabled={!canSubmit}
                    >
                        Guardar
                    </button>
                </div>
            </form>
        </section>
        <Modal show={showModal} onHide={handleCloseModal} centered>
                <Modal.Header className="custom-modal-title">
                    <Modal.Title className="custom-modal-title">Confirmación</Modal.Title>
                </Modal.Header>
                <Modal.Body>¿Estás seguro de que deseas guardar este sílabo?</Modal.Body>
                <Modal.Footer>
                    <Button variant="danger" onClick={handleCloseModal}>
                        Cancelar
                    </Button>
                    <Button variant="success" onClick={handleConfirmSubmit}>
                        Confirmar
                    </Button>
                </Modal.Footer>
            </Modal>
      </main>
    )

    return content
}

export default Form
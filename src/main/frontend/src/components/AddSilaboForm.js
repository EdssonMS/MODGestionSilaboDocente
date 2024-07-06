import axios from "axios";
import AddSilaboFormInputs from "../components/AddSilaboFormInputs"
import useAddSilaboFormContext from "../hooks/useAddSilaboFormContext";

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
        nombreDocente,
        setNombreDocente,
        apellidoDocente,
        setApellidoDocente,
        correoDocente,
        setCorreoDocente
    } = useAddSilaboFormContext()

    const handlePrev = () => setPage(prev => prev - 1)

    const handleNext = () => setPage(prev => prev + 1)

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log(JSON.stringify(silabo));

        try {
            const response = await axios.post('http://localhost:8080/silabo/json', silabo, {
                headers: {
                    'Content-Type': 'application/json',
                },
            });

            console.log('Respuesta del servidor:', response.data);
        } catch(error) {
            console.error('Error al enviar el silabo', error);
        }
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
                <div className='silabo-form-btn'>
                    <button 
                        type="button"
                        className={`btn-primary ${prevHide}`}
                        onClick={handlePrev}
                        disabled={disablePrev}
                    >
                        Anterior sección
                    </button>
                    <button 
                        type="button"
                        className={`btn-primary ${nextHide}`}
                        onClick={handleNext}

                    >
                        Siguiente sección
                    </button>
                    <button 
                        type="submit"
                        className={`btn-primary ${submitHide}`}
                        disabled={!canSubmit}
                    >
                        Guardar
                    </button>
                </div>
            </form>
        </section>
      </main>
    )

    return content
}

export default Form
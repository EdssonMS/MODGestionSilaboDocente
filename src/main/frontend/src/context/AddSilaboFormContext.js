import { createContext, useState, useEffect } from "react";

const AddSilaboFormContext = createContext({})

export const AddSilaboFormProvider = ({children}) => {

    const title = {
        0: 'Sección 1: Información general del sílabo',
        1: 'Sección 2: Sumilla y competencias',
        2: 'Sección 3: Logros de aprendizaje y capacidades',
        3: 'Sección 4: Programación de contenidos',
        4: 'Sección 5: Estrategia didáctica y evaluación',
        5: 'Sección 6: Referencias bibliográficas'
    }

    const [page, setPage] = useState(0)

    const [silabo, setSilabo] = useState({
        codigoCurso: "",
        nombreCurso: "",
        tipoAsignatura: "",
        areaEstudios: "",
        numeroSemanas: "",
        horasSemanales: "",
        semestreAcademico: "",
        ciclo: "",
        creditos: "",
        modalidad: "",
        prerequisitos: "",
        codigoDocente: "",
        apellidoDocente: "",
        nombreDocente: "",
        correoDocente: "",
        sumilla: "",
        logrosAprendizaje: "",
        codigoGrupoUnidad: "",
        estrategiaDidactica: "",
        evaluacionAprendizaje: "",
        bibliografia: "",
        competencias: [],
        unidadesAprendizaje: []
    })
    

    useEffect(() => {

    })

    const handleChange = e => {
        const type = e.target.type

        const name = e.target.name

        const value= type === "checkbox"
            ? e.target.checked
            : e.target.value

        setSilabo(prevSilabo => ({ 
            ...prevSilabo, 
            [name]:value
        }))
    }

    const {bibliografia, ...requiredInputs} = silabo

    const canSubmit = [...Object.values(requiredInputs)].
    every(Boolean) && page === Object.keys(title).length - 1

    const canNextPage1 = Object.keys(silabo)
        .filter(key => key.startsWith('info') && key !== 'infoModalidad')
        .map(key => silabo[key])
        .every(Boolean)

    const canNextPage = Object.keys(silabo)
        .map(key => silabo[key])
        .every(Boolean)

    const disablePrev = page === 0

    const prevHide = page === 0 && "remove-button"

    const nextHide = page === Object.keys(title).length - 1 && "remove-button"

    const submitHide = page !== Object.keys(title).length - 1 && "remove-button"

    const loadSilabo = (silaboData) => {
        setSilabo(silaboData)
    }

    return (
        <AddSilaboFormContext.Provider value={{title, page, setPage, silabo, setSilabo, 
             canSubmit, handleChange, disablePrev, 
             prevHide, nextHide, submitHide, loadSilabo}}>
            {children}
        </AddSilaboFormContext.Provider>
    )
}

export default AddSilaboFormContext
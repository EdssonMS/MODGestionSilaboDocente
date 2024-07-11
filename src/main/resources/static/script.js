function buscarCurso() {
    var cursoId = document.getElementById("cursoId").value;
    fetch("/cursos/" + cursoId)
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        })
        .then(curso => {
            mostrarResultado(curso);
        })
        .catch(error => {
            console.error("Error:", error);
            mostrarError("Error al buscar el curso.");
        });
}

function mostrarResultado(curso) {
    var resultadoDiv = document.getElementById("resultado");
    resultadoDiv.innerHTML = `
        <h2>Resultado:</h2>
        <p>ID: ${curso.id}</p>
        <p>Nombre: ${curso.nombreAsignatura}</p>
        <p>Tipo: ${curso.tipoAsignatura}</p>
        <p>Área de Estudios: ${curso.areaEstudios}</p>
        <p>Número de Semanas: ${curso.numeroSemanas}</p>
        <p>Horas Semanales: ${curso.horasSemanales}</p>
        <p>Semestre Académico: ${curso.semestreAcademico}</p>
        <p>Ciclo: ${curso.ciclo}</p>
        <p>Créditos: ${curso.creditos}</p>
        <p>Modalidad: ${curso.modalidad}</p>
        <p>Prerrequisitos: ${curso.prerequisitos}</p>
    `;
}

function mostrarError(mensaje) {
    var resultadoDiv = document.getElementById("resultado");
    resultadoDiv.innerHTML = `<p style="color: red;">${mensaje}</p>`;
}
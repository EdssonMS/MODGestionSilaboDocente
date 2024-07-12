package com.grupo.MODGestionSilaboDocente;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PDFGenerator {

    public static ByteArrayInputStream generatePdfFromJson(String json) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        // Convert JSON string to JsonNode
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        //Colores:
        Color headerColor = new DeviceRgb(0, 0, 0);
        Color textColor = new DeviceRgb(33, 33, 33);
        Color tableHeaderColor = new DeviceRgb(227, 227, 227);

        // Recorrer el JSON y agregar los elementos al documento:
        /*=======================================ENCABEZADO==========================================*/
        String imagePath = "src/main/java/com/grupo/MODGestionSilaboDocente/Images/UNMSM-logo.png"; // Ruta a la imagen
        Image image = new Image(ImageDataFactory.create(imagePath));
        image.setWidth(80); // Ajusta el tamaño de la imagen según sea necesario
        image.setHorizontalAlignment(com.itextpdf.layout.property.HorizontalAlignment.CENTER); // Centrar la imagen
        document.add(image);
        Paragraph paragraph = new Paragraph()
                .add("UNIVERSIDAD NACIONAL MAYOR DE SAN MARCOS\n")
                .add("(Universidad del Perú, DECANA DE AMÉRICA)\n")
                .add("\nFACULTAD DE INGENIERIA DE SISTEMAS E INFORMATICA\n")
                .add("ESCUELA PROFESIONAL DE INGENIERÍA DE SOFTWARE\n")
                .add("\nSÍLABO\n")
                .setFontSize(10).setBold().setFontColor(textColor).setTextAlignment(com.itextpdf.layout.property.TextAlignment.CENTER);
        document.add(paragraph);
        /*=======================================INFORMACION GENERAL==========================================*/
        String nombreCurso = rootNode.get("nombreCurso").asText();
        String codigoCurso = rootNode.get("codigoCurso").asText();
        String tipoAsignatura = rootNode.get("tipoAsignatura").asText();
        String areaEstudios = rootNode.get("areaEstudios").asText();
        String numeroSemanas = rootNode.get("numeroSemanas").asText();
        String horasSemanales = rootNode.get("horasSemanales").asText();
        String semestreAcademico = rootNode.get("semestreAcademico").asText();
        String ciclo = rootNode.get("ciclo").asText();
        String creditos = rootNode.get("creditos").asText();
        String modalidad = rootNode.get("modalidad").asText();
        String prerequisitos = rootNode.get("prerequisitos").asText();
        String nombreDocente = rootNode.get("nombreDocente").asText();
        String apellidoDocente = rootNode.get("apellidoDocente").asText();
        String correoDocente = rootNode.get("correoDocente").asText();
        document.add(new Paragraph("1. INFORMACIÓN GENERAL").setFontSize(10).setBold().setFontColor(headerColor));
        // Crear lista numerada para la informacion general
        com.itextpdf.layout.element.List list = new com.itextpdf.layout.element.List().setSymbolIndent(12).setListSymbol("").setFontSize(10).setFontColor(textColor);
        list.add(new ListItem("1.1 Nombre de la asignatura: " + nombreCurso));
        list.add(new ListItem("1.2 Codigo de asignatura: " + codigoCurso));
        list.add(new ListItem("1.3 Tipo de asignatura: " + tipoAsignatura));
        list.add(new ListItem("1.4 Área de estudio: " + areaEstudios));
        list.add(new ListItem("1.5 Número de semanas: " + numeroSemanas));
        list.add(new ListItem("1.6 Horas semanales: " + horasSemanales));
        list.add(new ListItem("1.7 Semestre Académico: " + semestreAcademico));
        list.add(new ListItem("1.8 Ciclo: " + ciclo));
        list.add(new ListItem("1.9 Créditos: " + creditos));
        list.add(new ListItem("1.10 Modalidad: " + modalidad));
        list.add(new ListItem("1.11 Pre-requisitos: " + prerequisitos));
        list.add(new ListItem("1.12 Docente: " + apellidoDocente + " " + nombreDocente + " " + correoDocente));
        document.add(list);

        /*=======================================SUMILLA==========================================*/
        String sumilla = rootNode.get("sumilla").asText();
        document.add(new Paragraph("2. SUMILLA").setFontSize(10).setBold().setFontColor(headerColor));
        document.add(new Paragraph(sumilla).setFontSize(9).setFontColor(textColor).setMarginLeft(20).setMarginRight(20));

        /*=======================================COMPETENCIAS==========================================*/
        document.add(new Paragraph("3. COMPETENCIAS DEL PERFIL DE EGRESO A LA QUE CONTRIBUYE LA ASIGNATURA").setFontSize(10).setBold().setFontColor(headerColor));
        // Obtener la lista de competencias del JSON
        JsonNode competenciasNode = rootNode.get("competencias");
        float[] competenciasColumnWidths = {2, 4, 2, 2}; // Ancho de las columnas
        Table competenciasTable = new Table(competenciasColumnWidths);
        competenciasTable.setFontSize(9);
        competenciasTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
        competenciasTable.setWidth(UnitValue.createPercentValue(90));
        //HEAD TALBLE
        competenciasTable.addHeaderCell("Código").setFontColor(headerColor).setBold();
        competenciasTable.addHeaderCell("Descripción").setFontColor(headerColor).setBold();
        competenciasTable.addHeaderCell("Tipo").setFontColor(headerColor).setBold();
        competenciasTable.addHeaderCell("Nivel").setFontColor(headerColor).setBold();
        // RECORRE COOMPETTENCIAS Y AÑADE LAS FILAS A LA TABLA BODY
        for (JsonNode competencia : competenciasNode) {
            competenciasTable.addCell(competencia.get("codigo").asText()).setFontColor(textColor);
            competenciasTable.addCell(competencia.get("descripcion").asText()).setFontColor(textColor);
            competenciasTable.addCell(competencia.get("tipo").asText()).setFontColor(textColor);
            competenciasTable.addCell(competencia.get("nivel").asText()).setFontColor(textColor);
        }
        document.add(competenciasTable);

        /*=======================================LOGROS DE APRENDIZAJE==========================================*/
        String logrosAprendizaje = rootNode.get("logrosAprendizaje").asText();
        document.add(new Paragraph("4. LOGROS DE APRENDIZAJE (Competencias de la asignatura)").setFontSize(10).setBold().setFontColor(headerColor));
        document.add(new Paragraph(logrosAprendizaje).setFontSize(9).setFontColor(textColor).setMarginLeft(20));

        /*=======================================CAPACIDADES==========================================*/
        document.add(new Paragraph("5. CAPACIDADES (Logros por unidad)").setFontSize(10).setBold().setFontColor(headerColor));
        JsonNode unidadesNode0 = rootNode.get("unidadesAprendizaje");
        for (int i = 0; i < unidadesNode0.size(); i++) {
            JsonNode unidad = unidadesNode0.get(i);
            String logroUnidad = unidad.get("logroUnidad").asText();
            String unidadTitle = "Unidad " + (i + 1) + ":";
            Paragraph unidadParagraph = new Paragraph();
            unidadParagraph.setFontSize(10).setFontColor(textColor);
            unidadParagraph.add(new Text(unidadTitle).setFontColor(headerColor).setUnderline()).setMarginLeft(20).setMarginRight(20);
            unidadParagraph.add(" " + logroUnidad);
            document.add(unidadParagraph);
        }


        /*=======================================PROGRAMACION DE CONTENIDOS==========================================*/
        document.add(new Paragraph("6. PROGRAMACIÓN DE CONTENIDOS").setFontSize(10).setBold().setFontColor(headerColor));
        // Obtener la lista de unidades de aprendizaje del JSON
        JsonNode unidadesNode = rootNode.get("unidadesAprendizaje");
        // Recorrer cada unidad de aprendizaje
        for (int i = 0; i < unidadesNode.size(); i++) {
            JsonNode unidad = unidadesNode.get(i);
            String nombreUnidad = unidad.get("nombreUnidad").asText();
            String logroUnidad = unidad.get("logroUnidad").asText();
            JsonNode semanasNode = unidad.get("semanas");
            // Crear la tabla para la unidad de aprendizaje
            float[] unitColumnWidths = {2, 2, 2, 2, 2}; // Ancho de las columnas
            Table unidadTable = new Table(unitColumnWidths);
            unidadTable.setFontSize(9);
            unidadTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
            unidadTable.setWidth(UnitValue.createPercentValue(90));
            // Añadir las filas estáticas de la tabla
            unidadTable.addCell(new Cell(1, 5).add(new Paragraph("Unidad " + (i + 1) + ": " + nombreUnidad).setBold().setFontColor(headerColor)).setBold());
            Paragraph logrosTitle = new Paragraph("Logros por unidad:").setFontColor(textColor).setUnderline().setBold();
            Paragraph logrosContent = new Paragraph("• " + logroUnidad).setFontColor(textColor).setMarginLeft(20);
            Cell logrosCell = new Cell(1, 5);
            logrosCell.add(logrosTitle);
            logrosCell.add(logrosContent);
            unidadTable.addCell(logrosCell);
            unidadTable.addCell("Semana").setBold();
            unidadTable.addCell("Contenido").setBold();
            unidadTable.addCell("Actividades").setBold();
            unidadTable.addCell("Recursos").setBold();
            unidadTable.addCell("Estrategias").setBold();
            // Recorrer las semanas de la unidad de aprendizaje y añadirlas a la tabla
            for (JsonNode semana : semanasNode) {
                unidadTable.addCell(semana.get("semana").asText()).setFontColor(textColor).setHorizontalAlignment(HorizontalAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE);
                unidadTable.addCell(semana.get("contenido").asText()).setFontColor(textColor);
                unidadTable.addCell(semana.get("actividades").asText()).setFontColor(textColor);
                unidadTable.addCell(semana.get("recursos").asText()).setFontColor(textColor);
                unidadTable.addCell(semana.get("estrategias").asText()).setFontColor(textColor);
            }
            document.add(unidadTable);
            document.add(new Paragraph("\n"));
        }

        /*=======================================ESTRATEGIA DIDACTICA==========================================*/
        String estrategiaDidactica = rootNode.get("estrategiaDidactica").asText();
        document.add(new Paragraph("7. ESTRATEGIA DIDACTICA").setFontSize(10).setBold().setFontColor(headerColor));
        document.add(new Paragraph(estrategiaDidactica).setFontSize(9).setFontColor(textColor).setMarginLeft(20));

        /*=======================================EVALUACION DE APRENDIZAJE==========================================*/
        String evaluacionAprendizaje = rootNode.get("evaluacionAprendizaje").asText();
        document.add(new Paragraph("8. EVALUACION DEL APRENDIZAJE").setFontSize(10).setBold().setFontColor(headerColor));
        document.add(new Paragraph(evaluacionAprendizaje).setFontSize(9).setFontColor(textColor).setMarginLeft(20).setMarginRight(20));
        float[] columnWidths = {2, 2, 2, 2, 2, 2};
        Table table = new Table(columnWidths);
        table.setFontSize(9);
        table.setHorizontalAlignment(HorizontalAlignment.CENTER);
        table.setWidth(UnitValue.createPercentValue(90));
        // HEAD TABLE
        table.addCell(new Cell(2, 1).add(new Paragraph("Unidad de aprendizaje")).setBold().setFontColor(headerColor).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE).setBackgroundColor(tableHeaderColor));
        table.addCell(new Cell(2, 1).add(new Paragraph("Criterios y logros de aprendizaje")).setBold().setFontColor(headerColor).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE).setBackgroundColor(tableHeaderColor));
        table.addCell(new Cell(2, 1).add(new Paragraph("Procedimientos (Productos)")).setBold().setFontColor(headerColor).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE).setBackgroundColor(tableHeaderColor));
        table.addCell(new Cell(2, 1).add(new Paragraph("Instrumentos de evaluación")).setBold().setFontColor(headerColor).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE).setBackgroundColor(tableHeaderColor));
        table.addCell(new Cell(1, 2).add(new Paragraph("Pesos en porcentajes")).setBold().setFontColor(headerColor).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE).setBackgroundColor(tableHeaderColor));
        table.addCell(new Cell().add(new Paragraph("Sesiones")).setBold().setFontColor(headerColor).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE).setBackgroundColor(tableHeaderColor));
        table.addCell(new Cell().add(new Paragraph("Notas SUM")).setBold().setFontColor(headerColor).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE).setBackgroundColor(tableHeaderColor));
        // BODY TABLE
        table.addCell(new Cell().add(new Paragraph("1, 2")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("Exposición parcial del proyecto del curso")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("Presentación y exposición")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("Proyecto del curso")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("100%")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell(2, 1).add(new Paragraph("N1")).setBold().setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell(1, 4).add(new Paragraph("Total Nota 1")).setBold().setTextAlignment(TextAlignment.RIGHT).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("100%")).setBold().setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell(2, 1).add(new Paragraph("1, 2, 3")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("Realiza trabajos prácticos")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("Trabajos prácticos resueltos")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("Rubrica")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("75%")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell(3, 1).add(new Paragraph("N2")).setBold().setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("Participación en clase")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("Intervenciones en clase")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("Evaluación oral")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("25%")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell(1, 4).add(new Paragraph("Total Nota 2")).setBold().setTextAlignment(TextAlignment.RIGHT).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("100%")).setBold().setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("3")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("Exposición final del proyecto del curso")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("Presentación, exposición")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("Proyecto del curso")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("100%")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell(2, 1).add(new Paragraph("N3")).setBold().setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell(1, 4).add(new Paragraph("Total Nota 3")).setBold().setTextAlignment(TextAlignment.RIGHT).setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell().add(new Paragraph("100%")).setTextAlignment(TextAlignment.CENTER).setBold().setVerticalAlignment(VerticalAlignment.MIDDLE));
        table.addCell(new Cell(1, 6).add(new Paragraph("Promedio final = 0.3 * N1 + 0.4 * N2 + 0.3 * N3")).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE));
        document.add(table);

        /*=======================================REFERENCIAS BIBLIOGRAFICAS==========================================*/
        String bibliografia = rootNode.get("bibliografia").asText();
        document.add(new Paragraph("9. REFERENCIAS BIBLIOGRAFIAS").setFontSize(10).setBold().setFontColor(headerColor));
        document.add(new Paragraph(bibliografia).setFontSize(9).setFontColor(textColor).setMarginLeft(20));


        document.close();
        return new ByteArrayInputStream(out.toByteArray());
    }

}

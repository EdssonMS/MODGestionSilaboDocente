package com.grupo.MODGestionSilaboDocente;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;

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
        document.add(new Paragraph(sumilla).setFontSize(9).setFontColor(textColor).setMarginLeft(20));

        /*=======================================COMPETENCIAS==========================================*/
        document.add(new Paragraph("3. COMPETENCIAS DEL PERFIL DE EGRESO A LA QUE CONTRIBUYE LA ASIGNATURA").setFontSize(10).setBold().setFontColor(headerColor));

        /*=======================================LOGROS DE APRENDIZAJE==========================================*/
        String logrosAprendizaje = rootNode.get("logrosAprendizaje").asText();
        document.add(new Paragraph("4. LOGROS DE APRENDIZAJE (Competencias de la asignatura)").setFontSize(10).setBold().setFontColor(headerColor));
        document.add(new Paragraph(logrosAprendizaje).setFontSize(9).setFontColor(textColor).setMarginLeft(20));

        /*=======================================CAPACIDADES==========================================*/
        document.add(new Paragraph("5. CAPACIDADES (Logros por unidad)").setFontSize(10).setBold().setFontColor(headerColor));
        String log = rootNode.get("logrosAprendizaje").asText();
        document.add(new Paragraph("4. LOGROS DE APRENDIZAJE (Competencias de la asignatura)").setFontSize(10).setBold().setFontColor(headerColor));
        document.add(new Paragraph(logrosAprendizaje).setFontSize(9).setFontColor(textColor).setMarginLeft(20));

        /*=======================================PROGRAMACION DE CONTENIDOS==========================================*/
        document.add(new Paragraph("6. PROGRAMACIÓN DE CONTENIDOS").setFontSize(10).setBold().setFontColor(headerColor));


        /*=======================================ESTRATEGIA DIDACTICA==========================================*/
        document.add(new Paragraph("7. ESTRATEGIA DIDACTICA").setFontSize(10).setBold().setFontColor(headerColor));


        /*=======================================EVALUACION DE APRENDIZAJE==========================================*/
        document.add(new Paragraph("8. EVALUACION DEL APRENDIZAJE").setFontSize(10).setBold().setFontColor(headerColor));


        /*=======================================REFERENCIAS BIBLIOGRAFICAS==========================================*/
        document.add(new Paragraph("9. REFERENCIAS BIBLIOGRAFIAS").setFontSize(10).setBold().setFontColor(headerColor));






        document.close();
        return new ByteArrayInputStream(out.toByteArray());
    }
}

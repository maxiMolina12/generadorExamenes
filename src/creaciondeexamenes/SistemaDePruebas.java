/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creaciondeexamenes;

/**
 *
 * @author maxi
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaDePruebas {

    private static LectorDeArchivos lector = new LectorDeArchivos();
    
public static void crearPrueba() {
    List<String> archivosSeleccionados = new ArrayList<>(); // lista para almacenar los archivos seleccionados
    int maxPreguntas = 10; // maximo de preguntas permitidas

    // la carpetas para diferentes tipos de preguntas
    String[] carpetasPreguntas = {"preguntas_multiples", "preguntas_verdadero_falso", "preguntas_cortas"};
    //mientras el array no alcance el maximo de preguntas este se seguira iterando
    while (archivosSeleccionados.size() < maxPreguntas) { 
        //iterara por cada carpeta de preguntas por el numero de carpetas que hay hasta
        for (String carpeta : carpetasPreguntas) {
            if (archivosSeleccionados.size() >= maxPreguntas) {
                break; // salir del bucle si se alcanza el maximo de preguntas
            }

            System.out.println("Selecciona preguntas de la carpeta: " + carpeta);
            String rutaArchivoPregunta = lector.mostrarArchivosYSeleccionar(carpeta);
            
            if (rutaArchivoPregunta != null) {
                archivosSeleccionados.add(rutaArchivoPregunta); // agregar el archivo seleccionado al array
                System.out.println("total de preguntas seleccionadas: " + archivosSeleccionados.size() + "/" + maxPreguntas);
            } else {
                System.out.println("no se selecciono ninguna pregunta de " + carpeta);
            }
        }
    }

    // guardar la prueba personalizada
    if (!archivosSeleccionados.isEmpty()) {
        System.out.println("creando prueba...");
        guardarPrueba(archivosSeleccionados);
    } else {
        System.out.println("no se seleccionaron preguntas para la prueba.");
    }
}
//metodo para guardar las preguntas que se selecionaron en una archivo 
public static void guardarPrueba(List<String> archivosSeleccionados) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("ingresa el nombre para la prueba:");
    String nombrePrueba = scanner.nextLine();
    
    // crear la carpeta de destino
    String rutaCarpetaPrueba = lector.getDesktopPath() + "\\pruebas_java\\" + nombrePrueba;
    lector.crearCarpetaDestino(rutaCarpetaPrueba); //crea la carpeta de destino

    // copiar cada archivo seleccionado a la carpeta de prueba
    for (String archivo : archivosSeleccionados) {
        String nombreArchivo = new File(archivo).getName(); // obtener solo el nombre del archivo
        String destino = rutaCarpetaPrueba + "\\" + nombreArchivo; // definir la ruta de destino
        try {
            Files.copy(Paths.get(archivo), Paths.get(destino), StandardCopyOption.REPLACE_EXISTING); // copiar el archivo
        } catch (IOException e) {
            System.out.println("error al guardar el archivo: " + e.getMessage());
        }
    }

    System.out.println("prueba guardada en: " + rutaCarpetaPrueba);
}

    
        // metodo para abrir una prueba guardada
 public static void abrirPrueba() {
    
    // mostrar las carpetas de las pruebas guardadas
    String carpetaSeleccionada = lector.mostrarArchivosYSeleccionar("pruebas_java");

    if (carpetaSeleccionada != null) {
        try {
            // obtener los nombres de los archivos de preguntas usando el nuevo metodo
            List<String> archivosDePreguntas = lector.listarArchivos(carpetaSeleccionada);
            
            if (!archivosDePreguntas.isEmpty()) {
                // realizar la prueba con los nombres de archivos
                realizarPrueba(archivosDePreguntas);
            } else {
                System.out.println("no se encontraron preguntas en la carpeta seleccionada.");
            }
        } catch (Exception e) {
            System.out.println("error al cargar las preguntas: " + e.getMessage());
        }
    } else {
        System.out.println("no se selecciono ninguna carpeta de prueba.");
    }
}

    
// metodo para realizar la prueba
public static void realizarPrueba(List<String> archivosDePreguntas) throws IOException {
    int puntajeTotalPrueba = 0;
    int puntajeTotalObtenido = 0;
    Scanner scanner = new Scanner(System.in);
    
    // iterar sobre los archivos de preguntas
    for (String rutaArchivo : archivosDePreguntas) {
        // leer el contenido del archivo y crear una instancia de Pregunta
        Pregunta pregunta = lector.cargarPreguntaDesdeArchivo(rutaArchivo); // metodo para leer una pregunta
        // mostrar la pregunta y las opciones 
        System.out.println(pregunta.getEnunciadoPregunta());
        pregunta.mostrarAlternativas(new PrintWriter(System.out, true));
        // capturar la respuesta
        puntajeTotalPrueba += pregunta.getPuntaje();
        String respuestaUsuario = scanner.nextLine();
        // verificar la respuesta y sumar el puntaje
        if (pregunta.respuestaCorrecto(respuestaUsuario)) {
            puntajeTotalObtenido += pregunta.getPuntaje();
            System.out.println("¡Respuesta correcta!");
        } else {
            System.out.println("respuesta incorrecta. La respuesta correcta es: " + pregunta.getRespuestaCorrecta());
        }
        
    }

    // mostrar el puntaje total al finalizar la prueba
    System.out.println("puntaje total: " + puntajeTotalObtenido+"/"+puntajeTotalPrueba);
}

    
    
}



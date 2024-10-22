/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creaciondeexamenes;

/**
 *
 * @author maxi
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LectorDeArchivos {
    private final String desktopPath;

    //  inicializa una al escritorio
    public LectorDeArchivos() {
        this.desktopPath = System.getProperty("user.home") + "/Desktop";
    }

    public String getDesktopPath() {
        return desktopPath;
    }

    // metodo para listar los archivos en una carpeta en el escritorio y elegir uno para copiar
    public String mostrarArchivosYSeleccionar(String nombreCarpeta) {
        String folderPath = desktopPath + "/" + nombreCarpeta;
        File carpeta = new File(folderPath);

        // verificar si la carpeta existe
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] elementos = carpeta.listFiles(); // lista archivos y carpetas de la carpeta

            if (elementos != null && elementos.length > 0) {
                System.out.println("elementos disponibles en la carpeta '" + nombreCarpeta + "':");

                // mostrar los archivos y carpetas con indices numericos
                for (int i = 0; i < elementos.length; i++) {
                    if (elementos[i].isFile()) {
                        System.out.println(i + ". [Archivo] " + elementos[i].getName());
                    } else if (elementos[i].isDirectory()) {
                        System.out.println(i + ". [Carpeta] " + elementos[i].getName());
                    }
                }

                // pedir que se seleccione una archivo o una carpeta
                Scanner scanner = new Scanner(System.in);
                System.out.println("ingresa el numero del archivo o carpeta que quiera seleccionar:");
                int opcion = scanner.nextInt();

                // verificar que la opción sea valida
                if (opcion >= 0 && opcion < elementos.length) {
                    // Devolver la ruta del elemento seleccionado
                    return elementos[opcion].getAbsolutePath();
                } else {
                    System.out.println("opcion no valida.");
                }
            } else {
                System.out.println("la carpeta esta vacia o no contiene elementos.");
            }
        } else {
            System.out.println("la carpeta no existe.");
        }

        return null; // si no se selecciona un archivo o carpeta valida
    }
        public List<String> listarArchivos(String rutaCarpeta) {
        File carpeta = new File(rutaCarpeta);
        List<String> archivos = new ArrayList<>();

        // verificar si la carpeta existe 
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] elementos = carpeta.listFiles(); // listar archivos y carpetas en la carpeta

            if (elementos != null) {
                for (File elemento : elementos) {
                    if (elemento.isFile()) {
                        archivos.add(elemento.getAbsolutePath()); // agregar la ruta del archivo a la lista
                    }
                }
            }
        } else {
            System.out.println("la carpeta no existe.");
        }

        return archivos; // retornar la lista de rutas de archivos
    }

    
    // Metodo para crear la carpeta de destino
    public void crearCarpetaDestino(String rutaCarpetaDestino) {
    File carpetaDestino = new File(rutaCarpetaDestino);
    if (!carpetaDestino.exists()) {
        if (carpetaDestino.mkdirs()) {
            System.out.println("Carpeta creada: " + rutaCarpetaDestino);
        } else {
            System.out.println("No se pudo crear la carpeta: " + rutaCarpetaDestino);
        }
    }
}
    
// Metodo para copiar un archivo a la carpeta de destino
    public void copiarArchivoCarpeta(String origenArchivo, String carpetaDestino) {
        File archivoOrigen = new File(origenArchivo);
    File archivoDestino = new File(carpetaDestino + "/" + archivoOrigen.getName());

    try {
        // copiar el archivo al destino especificado
        Files.copy(archivoOrigen.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("archivo copiado exitosamente a: " + archivoDestino.getAbsolutePath());
    } catch (IOException e) {
        System.out.println("error al copiar el archivo: " + e.getMessage());
        e.printStackTrace();
    }
}
    //metodo para cargar el tipo de preguta de una archivo de texto plano siguindo el formato definido
    public Pregunta cargarPreguntaDesdeArchivo(String rutaArchivo) throws IOException{
    BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
    String tipoPregunta = lector.readLine().trim();
    String enunciado = lector.readLine().trim();
    String puntajeLinea = lector.readLine().trim();
    int puntaje = Integer.parseInt(puntajeLinea.split(":")[1].trim());

    if (tipoPregunta.equalsIgnoreCase("seleccion_multiple")) {
        List<String> opciones = new ArrayList<>();
        String opcion;
        while (!(opcion = lector.readLine()).startsWith("respuesta:")) {
            opciones.add(opcion.trim());
        }
        String respuestaCorrecta = opcion.split(":")[1].trim();
        return new PreguntaSeleccionMultiple(opciones.toArray(new String[0]), respuestaCorrecta, enunciado, puntaje);
        
    } else if (tipoPregunta.equalsIgnoreCase("verdadero_falso")) {
        String respuestaCorrecta = lector.readLine().split(":")[1].trim();
        boolean esVerdadera = respuestaCorrecta.equalsIgnoreCase("V");
        return new PreguntaVerdaderoFalso(esVerdadera, enunciado, puntaje);
        
    } else if (tipoPregunta.equalsIgnoreCase("respuesta_corta")) {
        String respuestaCorrecta = lector.readLine().split(":")[1].trim();
        return new RespuestasCortas(respuestaCorrecta, enunciado, puntaje);
    }

    return null;  
    }
    



}



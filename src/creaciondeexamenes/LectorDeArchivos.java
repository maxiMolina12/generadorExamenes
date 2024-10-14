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
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LectorDeArchivos {
    private String desktopPath;

    // Constructor: Inicializa la ruta al escritorio del usuario
    public LectorDeArchivos() {
        this.desktopPath = System.getProperty("user.home") + "/Desktop";
    }

    // Método para listar los archivos en una carpeta en el escritorio y elegir uno para leer
    public void mostrarArchivosYLeer(String nombreCarpeta) {
        String folderPath = desktopPath + "/" + nombreCarpeta;
        File carpeta = new File(folderPath);

        // Verificar si la carpeta existe y es un directorio
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles(); // Listar archivos en la carpeta

            if (archivos != null && archivos.length > 0) {
                System.out.println("Archivos disponibles en la carpeta '" + nombreCarpeta + "':");
                
                // Mostrar los archivos con índices numéricos
                for (int i = 0; i < archivos.length; i++) {
                    if (archivos[i].isFile()) {
                        System.out.println(i + ". " + archivos[i].getName());
                    }
                }

                // Pedir al usuario que elija un archivo
                Scanner scanner = new Scanner(System.in);
                System.out.println("Ingresa el número del archivo que deseas leer:");
                int opcion = scanner.nextInt();

                // Verificar que la opción sea válida
                if (opcion >= 0 && opcion < archivos.length && archivos[opcion].isFile()) {
                    // Leer el archivo seleccionado
                    leerArchivo(archivos[opcion].getAbsolutePath());
                } else {
                    System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("La carpeta está vacía o no contiene archivos.");
            }
        } else {
            System.out.println("La carpeta no existe.");
        }
    }

    // Método privado que realiza la lectura del archivo
    private void leerArchivo(String filePath) {
        try {
            File archivo = new File(filePath);
            Scanner lector = new Scanner(archivo);

            // Leer e imprimir cada línea del archivo
            System.out.println("Leyendo archivo: " + archivo.getName());
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                System.out.println(linea);
            }

            // Cerrar el lector
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado: " + filePath);
            e.printStackTrace();
        }
    }
}



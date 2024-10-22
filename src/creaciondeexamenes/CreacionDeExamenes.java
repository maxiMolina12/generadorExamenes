/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package creaciondeexamenes;

import java.util.Scanner;

/**
 *
 * @author maxi
 */
public class CreacionDeExamenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            
            System.out.println("IMPORTARTE: al momento de responder las preguntas cualquier entrada de datos que no sea la respuesta correcta sera tomada como respuesta equivocada");
            System.out.println("¡NO RALLE LA PRUEBA!");
            
            System.out.println("Sistema de Gestion de Pruebas");
            System.out.println("1. Crear prueba");
            System.out.println("2. Abrir prueba");
            System.out.println("3. Salir");
            System.out.print("selecciona una opcion: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  //  
            
            switch (opcion) {
                case 1:
                    SistemaDePruebas.crearPrueba();
                    break;
                case 2:
                    SistemaDePruebas.abrirPrueba();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida. intenta de nuevo.");
            }
        }
        
        System.out.println("¡SUERTE!");
        scanner.close(); // Cerrar el escaner al final
    }
    
}

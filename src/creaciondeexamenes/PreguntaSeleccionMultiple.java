/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creaciondeexamenes;

/**
 *
 * @author maxi
 */
public class PreguntaSeleccionMultiple extends Pregunta{
    private String [] opciones;
    private String respuestaCorrecta;

    public PreguntaSeleccionMultiple(String[] opciones, String respuestaCorrecta, String enunciadoPregunta, int puntaje) {
        super(enunciadoPregunta, puntaje);
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    @Override
    public boolean respuestaCorrecto(String respuesta) {
        return respuestaCorrecta.equalsIgnoreCase(respuesta);
        
        
    }

    @Override
    public void mostrarAlternativas() {
        System.out.println("Opciones:");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
    }
    
    
}

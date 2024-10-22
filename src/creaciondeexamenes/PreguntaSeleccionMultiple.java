/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creaciondeexamenes;

import java.io.PrintWriter;

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
    String letra[] = {"a","b","c","d"};
    int i = 0;
    @Override
    public void mostrarAlternativas(PrintWriter writer) {
        writer.println("Opciones:");
        for (String opcion : opciones) {
            writer.println( letra[i] +") "+opcion); // Guarda cada opcion en el archivo
            i++;
        }
    }

    @Override
    public String getTipoPregunta() {
        return "seleccion_multiple";
        
    }

    @Override
    public String getRespuestaCorrecta() {
        return respuestaCorrecta; 
    }

    
}

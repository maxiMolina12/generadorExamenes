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
public class PreguntaVerdaderoFalso extends Pregunta {
    private boolean respuestaCorrecta;

    public PreguntaVerdaderoFalso(boolean respuestaCorrecta, String enunciadoPregunta, int puntaje) {
        super(enunciadoPregunta, puntaje);
        this.respuestaCorrecta = respuestaCorrecta;
    }
    
    

    @Override
    public boolean respuestaCorrecto(String respuesta) {
        //  si la respuesta del es "V" o "F" (en cualquier caso)
        if (respuesta.equalsIgnoreCase("V")) {
            return respuestaCorrecta == true;
        } else if (respuesta.equalsIgnoreCase("F")) {
            return respuestaCorrecta == false;
        }
        // Si se ingresa algo distinto a "V" o "F", se considera incorrecto
        return false;
    }

    

    @Override
    public void mostrarAlternativas(PrintWriter writer) {
        writer.println("1. V");
        writer.println("2. F");
    }

    @Override
    public String getTipoPregunta() {
        return "verdadero_falso";
    }

    @Override
    public String getRespuestaCorrecta() {
        return respuestaCorrecta ? "V" : "F"; // devuelve la respuesta correcta 
    }
    
}

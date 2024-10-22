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
public class RespuestasCortas extends Pregunta{
    private String respuestaCorrecta;

    public RespuestasCortas(String respuestaCorrecta, String enunciadoPregunta, int puntaje) {
        super(enunciadoPregunta, puntaje);
        this.respuestaCorrecta = respuestaCorrecta;
    }
    

    @Override
    public boolean respuestaCorrecto(String respuesta) {
        return respuestaCorrecta.equalsIgnoreCase(respuesta.trim());

    }

    @Override
    public void mostrarAlternativas(PrintWriter writer) {
        
        writer.println("escribe una respuesta corta:");
    }

    @Override
    public String getTipoPregunta() {
        
        return "respuesta_corta";
    }
    
    @Override
    public String getRespuestaCorrecta() {
        return respuestaCorrecta; // metodo para obtener la respuesta correcta
    }


    
    
    
}

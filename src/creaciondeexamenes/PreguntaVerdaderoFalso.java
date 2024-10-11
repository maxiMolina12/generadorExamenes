/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creaciondeexamenes;

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
        // Verificamos si la respuesta del usuario es "V" o "F" (en cualquier caso)
        if (respuesta.equalsIgnoreCase("V")) {
            return respuestaCorrecta == true;
        } else if (respuesta.equalsIgnoreCase("F")) {
            return respuestaCorrecta == false;
        }
        // Si el usuario ingresa algo distinto a "V" o "F", se considera incorrecto
        return false;
    }

    @Override
    public void mostrarAlternativas() {
        System.out.println("1. verdadero");
        System.out.println("2. falso");
    }
    
}

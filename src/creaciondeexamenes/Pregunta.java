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
public abstract class Pregunta {
    protected String enunciadoPregunta;
    protected int puntaje;
    
    public Pregunta(String enunciadoPregunta, int puntaje) {
        this.enunciadoPregunta = enunciadoPregunta;
        this.puntaje = puntaje;
    }
    //get para el enunciado de la preugunta
    public String getEnunciadoPregunta() {
        return enunciadoPregunta;
    }
    //el set para el pun
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPuntaje() {
        return puntaje;
    }
    
    
    public abstract boolean respuestaCorrecto(String respuesta);//metodo para verificar si la respuesta es correcta
    public abstract void mostrarAlternativas(PrintWriter writer);//mueestra las alternativas para los distintos tipos de preguntas
    public abstract String getTipoPregunta();//devuelve el tipo de preguta
    public abstract String getRespuestaCorrecta();//devuelve la respuesta correcta
    
    
    
}

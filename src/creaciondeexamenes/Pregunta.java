/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creaciondeexamenes;

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
    
    public abstract boolean respuestaCorrecto(String respuesta);
    public abstract void mostrarAlternativas();
    
    
    
}

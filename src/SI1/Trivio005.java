package SI1;

import processing.core.PApplet;

public class Trivio005 extends PApplet {

    // Interfície Gràfica (Pantalles i components)
    GUI gui;

    public static void main(String[] args) {
        PApplet.main("SI1.Trivio005", args);
    }

    public void settings(){
        fullScreen();                       // Pantalla completa
        smooth(10);
    }

    public void setup(){
        noStroke();                         // Sense bordes
        textAlign(CENTER); textSize(18);   // Alineació i mida del text
        gui = new GUI(this);                   // Constructor de la GUI
    }

    public void draw(){

        // Dibuixa la pantalla corresponent
        switch(gui.pantallaActual){

            case INICIO:     gui.dibuixaPantallaInicio(this);
                break;

            case FUTURASLECTURAS:     gui.dibuixaPantallaFuturasLecturas(this);
                break;

            case LECTURASCOMPLETADAS:     gui.dibuixaPantallaLecturasCompletadas(this);
                break;

            case QUEQUIERESLEER:     gui.dibuixaPantallaQueQuieresLeer(this);
                break;

            case ESTADÍSTICAS:     gui.dibuixaPantallaEstadísticas(this);
                break;

            case LIBRONOLEIDO:     gui.dibuixaPantallaLibroNoLeido(this);
                break;

            case LIBROLEIDO:     gui.dibuixaPantallaLibroLeido(this);
                break;
        }

        updateCursor(this);

    }

    public void updateCursor(PApplet p5){
        if(gui.b1.updateHandCursor(p5) || gui.b2.updateHandCursor(p5) || gui.b3.updateHandCursor(p5)|| gui.b4.updateHandCursor(p5)|| gui.b5.updateHandCursor(p5)){
            cursor(HAND);
        }
        else {
            cursor(ARROW);
        }
    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        if(key=='1'){
            gui.pantallaActual = GUI.PANTALLA.INICIO;
        }
        else if(key=='2'){
            gui.pantallaActual = GUI.PANTALLA.FUTURASLECTURAS;
        }
        else if(key=='3'){
            gui.pantallaActual = GUI.PANTALLA.LECTURASCOMPLETADAS;
        }
        else if(key=='4'){
            gui.pantallaActual = GUI.PANTALLA.QUEQUIERESLEER;
        }
        else if(key=='5'){
            gui.pantallaActual = GUI.PANTALLA.ESTADÍSTICAS;
        }
        else if(key=='6'){
            gui.pantallaActual = GUI.PANTALLA.LIBRONOLEIDO;
        }
        else if(key=='7'){
            gui.pantallaActual = GUI.PANTALLA.LIBROLEIDO;
        }

    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        if(gui.b1.mouseOverButton(this)){
            gui.pantallaActual = GUI.PANTALLA.INICIO;
        }
        else if(gui.b2.mouseOverButton(this)){
            gui.pantallaActual = GUI.PANTALLA.FUTURASLECTURAS;
        }
        else if(gui.b3.mouseOverButton(this)){
            gui.pantallaActual = GUI.PANTALLA.LECTURASCOMPLETADAS;
        }
        else if(gui.b4.mouseOverButton(this)){
            gui.pantallaActual = GUI.PANTALLA.QUEQUIERESLEER;
        }
        else if(gui.b5.mouseOverButton(this)){
            gui.pantallaActual = GUI.PANTALLA.ESTADÍSTICAS;
        }
    }


    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}

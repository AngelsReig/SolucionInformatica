package SI1;

import processing.core.PApplet;

public class Trivio005 extends PApplet {

    // Interfície Gràfica (Pantalles i components)
    GUI gui;

    DataBase db;

    public static void main(String[] args) {
        PApplet.main("SI1.Trivio005", args);
    }

    public void settings(){
        fullScreen();                       // Pantalla completa
        smooth(10);
    }

    public void setup(){
        db= new DataBase("admin","12345","libros");
        db.connect();
        db.getInfo("nombre", "usuario", "prova1", "nombre");
        String[] ColumnInfo = db.getInfo("usuario", "nombre");
        printArray(ColumnInfo);

        String[][] tableInfo = db.getInfo();
        println("TAULA: ");
        for(int i=0; i<tableInfo.length; i++){
            print(i+": ");
            for(int j=0; j<tableInfo[i].length; j++){
                System.out.print(tableInfo[i][j]+"\t");
            }
            println();
        }

        String[][] infoQuerry = db.getUsuarioContrasena();
        println("TAULA: ");
        for(int i=0; i<infoQuerry.length; i++){
            print(i+": ");
            for(int j=0; j<infoQuerry[i].length; j++){
                System.out.print(infoQuerry[i][j]+"\t");
            }
            println();
        }


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

            case LIBRO:     gui.dibuixaPantallaLibro(this);
                break;

            case USUARIO:     gui.dibuixaPantallaUsuario(this);
                break;

            case DATOS:     gui.dibuixaPantallaDatos(this);
                break;
        }

        updateCursor(this);

    }

    public void updateCursor(PApplet p5){
        if(gui.pantallaActual == GUI.PANTALLA.INICIO || gui.pantallaActual == GUI.PANTALLA.FUTURASLECTURAS || gui.pantallaActual == GUI.PANTALLA.LECTURASCOMPLETADAS || gui.pantallaActual == GUI.PANTALLA.QUEQUIERESLEER || gui.pantallaActual == GUI.PANTALLA.ESTADÍSTICAS|| gui.pantallaActual == GUI.PANTALLA.LIBRO|| gui.pantallaActual == GUI.PANTALLA.DATOS ){
            if(gui.b1.updateHandCursor(p5) || gui.b2.updateHandCursor(p5) || gui.b3.updateHandCursor(p5)|| gui.b4.updateHandCursor(p5)|| gui.b5.updateHandCursor(p5)  ){
                cursor(HAND);
            }
            else if(gui.pantallaActual == GUI.PANTALLA.QUEQUIERESLEER ){
                if(gui.b6.updateHandCursor(p5)){
                    cursor(HAND);
                }
                else {
                    cursor(ARROW);
                }
            }
            else if(gui.pantallaActual == GUI.PANTALLA.LIBRO ){
                if(gui.b9.updateHandCursor(p5)|| gui.b10.updateHandCursor(p5)){
                    cursor(HAND);
                }
                else {
                    cursor(ARROW);
                }
            }
            else if(gui.pantallaActual == GUI.PANTALLA.DATOS ){
                if(gui.b11.updateHandCursor(p5)){
                    cursor(HAND);
                }
                else {
                    cursor(ARROW);
                }
            }
            else {
                cursor(ARROW);
            }
        }

        else if(gui.pantallaActual == GUI.PANTALLA.USUARIO ){
            if(gui.b7.updateHandCursor(p5) || gui.b8.updateHandCursor(p5)){
                cursor(HAND);
            }
            else {
                cursor(ARROW);
            }

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
            gui.pantallaActual = GUI.PANTALLA.LIBRO;
        }
        else if(key=='7'){
            gui.pantallaActual = GUI.PANTALLA.USUARIO;
        }

        // Comprova i actualitza l'escriptura dins els TextFields
        gui.tf1.keyPressed(key, keyCode);
        gui.tf2.keyPressed(key, keyCode);
        gui.tf3.keyPressed(key, keyCode);

        if(keyCode==LEFT){
            gui.c.prevMonth();
            println("PREV MONTH");
        }
        // Anar un mes endavant
        else if(keyCode==RIGHT){
            gui.c.nextMonth();
            println("PREV MONTH");
        }

        gui.areaText.keyPressed(key, (int)keyCode);

    }

    // ******************* MOUSE interaction ***************************** //

    public void mousePressed(){
        if(gui.pantallaActual == GUI.PANTALLA.INICIO || gui.pantallaActual == GUI.PANTALLA.FUTURASLECTURAS || gui.pantallaActual == GUI.PANTALLA.LECTURASCOMPLETADAS || gui.pantallaActual == GUI.PANTALLA.QUEQUIERESLEER || gui.pantallaActual == GUI.PANTALLA.ESTADÍSTICAS|| gui.pantallaActual == GUI.PANTALLA.LIBRO|| gui.pantallaActual == GUI.PANTALLA.DATOS ){
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
            else if (gui.pantallaActual == GUI.PANTALLA.QUEQUIERESLEER && gui.b6.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.QUEQUIERESLEER;
            }
            else if(gui.rb1.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.LIBRO;
            }
            else if(gui.pantallaActual == GUI.PANTALLA.LIBRO && gui.b9.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.FUTURASLECTURAS;
            }

            else if(gui.pantallaActual == GUI.PANTALLA.LIBRO && gui.b10.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.DATOS;
            }

            else if(gui.pantallaActual == GUI.PANTALLA.DATOS && gui.b11.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.LECTURASCOMPLETADAS;
            }

            else if (gui.pantallaActual == GUI.PANTALLA.DATOS){
                gui.c.checkButtons(this);
                gui.buttons.checkMousePressed(this);
                gui.areaText.isPressed(this);
            }
        }

        else if (gui.pantallaActual == GUI.PANTALLA.USUARIO){
            if(gui.b7.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.INICIO;
            }
            else if(gui.b8.mouseOverButton(this)){
                gui.pantallaActual = GUI.PANTALLA.INICIO;
            }
        }



        // Comprova si pitjam amb el mouse sobre els TextFields
        gui.tf1.isPressed(this);
        gui.tf2.isPressed(this);
        gui.tf3.isPressed(this);
    }



    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}

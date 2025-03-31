package SI1;

import processing.core.PApplet;

import static SI1.Mides.*;
import static SI1.Layout.*;
import SI1.BarsDiagram;
import processing.core.PFont;
import processing.core.PImage;

public class GUI extends PApplet{

    // Enumerat de les Pantalles de l'App
    public enum PANTALLA {USUARIO, INICIO, FUTURASLECTURAS, LECTURASCOMPLETADAS, QUEQUIERESLEER, ESTADÍSTICAS, LIBRO};
    // Pantalla Actual
    public PANTALLA pantallaActual;

    // Colors i Fonts de l'APP
    Colors appColors;
    Fonts fontsApp;


    String[] textos = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    float[] values = {400, 600, 100, 300, 200, 800, 100, 50, 300, 700, 400, 200};

    String[] texts = {"Género de misterio", "Género romántico", "Género de fantasia", "Género histórico"};
    float[] value = {400f, 600f, 100f, 300f};
    int[] colors = {color(27, 40, 69), color(39, 64, 96), color(51, 92, 129), color(88, 153, 226)};



    // Botons
    Button b1, b2, b3, b4 ,b5, b6;  // 2a passa : declarar els components

    RoundButton rb1;
    PImage portada1;
    RoundButton rb2;
    PImage portada2;

    BarsDiagram BD;
    SectorDiagram s;



    // Dimensions del Confirm
    float compW = 800;
    float compH = 340;

    // Textos del Confirm
    String title = "Canvia de Color!";
    String message = "Tria el nou color de fons";

    // Color de fons
    int bgColor;

    // Elements de la Interfície Gràfica (TextFields)
    TextField tf1, tf2;



    // Constructor de la GUI
    public GUI(PApplet p5){
        pantallaActual = PANTALLA.INICIO;
        appColors = new Colors(p5);   // Constructor dels colors de l'App
        fontsApp = new Fonts(p5);     // Constructor de les fonts de l'App

        createButtons(p5);
        BD = new BarsDiagram(500,-750,1370,1200);

        BD.setTexts(textos);
        BD.setValues(values);

        // Creació del Diagrama de Sectors
        s = new SectorDiagram(1400, 850, 200);

        // Configuració de Dades (textos, valors, colors)
        s.setTexts(texts);
        s.setValues(value);
        s.setColors(colors);


        // Color de fons
        bgColor = color(255);

        tf1 = new TextField(p5, 570, 500, 1200, 150);
        tf2 = new TextField(p5, 200, 400, 400, 40);


        portada1 = p5.loadImage("data/agggtm.png");
        rb1 = new RoundButton(p5, portada1, 600, 190, 80);
        portada2 = p5.loadImage("data/aoe.PNG");
        rb2 = new RoundButton(p5, portada2, 800, 190, 80);


    }

    public void createButtons(PApplet p5){
        b1 = new Button(p5, "Inicio", 30, 80, 370, 110);
        b2 = new Button(p5, "Futuras lecturas", 30, 220, 370, 110);
        b3 = new Button(p5, "Lecturas completadas", 30, 360, 370, 110);
        b4 = new Button(p5, "¿Qué quieres leer?", 30, 500, 370, 110);
        b5 = new Button(p5, "Estadísticas", 30, 640, 370, 110);
        b6 = new Button(p5, "Enter", 1600, 670, 150, 70);
    }


    // PANTALLES DE LA GUI

    public void dibuixaPantallaUsuario(PApplet p5){

        p5.background(197, 212, 232);
    }

    public void dibuixaPantallaInicio(PApplet p5){

        p5.background(197, 212, 232);
        dibuixaSideBar(p5);

        rb1.display(p5);
        rb2.display(p5);
        //Afegir files

        p5.textFont(fontsApp.getSecondFont());
        b2.display(p5);
        b3.display(p5);
        b4.display(p5);
        b5.display(p5);

        p5.fill(255); p5.textFont(fontsApp.getFirstFont()); p5.textSize(60);
        p5.text("Inicio", 30,120,370,110);

        p5.fill(0); p5.textFont(fontsApp.getSecondFont()); p5.textSize(45);
        p5.text("Recomendación libros del género de misterio", 900,100);
        p5.text("Recomendación libros del género romántico", 878,330);
        p5.text("Recomendación libros del género de fantasia", 900,560);
        p5.text("Recomendación libros del género histórico", 875,790);
    }

    public void dibuixaPantallaFuturasLecturas(PApplet p5){

        p5.background(197, 212, 232);
        dibuixaSideBar(p5);
        //Afegir files

        p5.textFont(fontsApp.getSecondFont());
        b1.display(p5);
        b3.display(p5);
        b4.display(p5);
        b5.display(p5);

        p5.fill(255); p5.textFont(fontsApp.getFirstFont()); p5.textSize(60);
        p5.text("Futuras", 220, 260);
        p5.text("lecturas", 220, 315);

        p5.fill(0); p5.textFont(fontsApp.getSecondFont()); p5.textSize(30);
        p5.text("Género de misterio", 600,100);
        p5.text("Género romántico", 580,330);
        p5.text("Género de fantasia", 600,560);
        p5.text("Género histórico", 578,790);
    }

    public void dibuixaPantallaLecturasCompletadas(PApplet p5){

        p5.background(197, 212, 232);
        dibuixaSideBar(p5);
        //Afegir files

        p5.textFont(fontsApp.getSecondFont());
        b1.display(p5);
        b2.display(p5);
        b4.display(p5);
        b5.display(p5);

        p5.fill(255); p5.textFont(fontsApp.getFirstFont()); p5.textSize(60);
        p5.text("Lecturas", 220, 400);
        p5.text("completadas", 220, 455);

        p5.fill(0); p5.textFont(fontsApp.getSecondFont()); p5.textSize(30);
        p5.text("dd/mm/aaa", 550,100);
        p5.text("dd/mm/aaa", 550,330);
        p5.text("dd/mm/aaa", 550,560);
        p5.text("dd/mm/aaa", 550,790);
    }

    public void dibuixaPantallaQueQuieresLeer(PApplet p5){

        p5.background(197, 212, 232);
        dibuixaSideBar(p5);


        p5.textFont(fontsApp.getSecondFont());
        b1.display(p5);
        b2.display(p5);
        b3.display(p5);
        b5.display(p5);


        p5.fill(255); p5.textFont(fontsApp.getFirstFont()); p5.textSize(60);
        p5.text("¿Qué quieres", 220, 540);
        p5.text("leer?", 220, 595);
        b6.display(p5);

        p5.fill(0); p5.textFont(fontsApp.getFirstFont()); p5.textSize(100);
        p5.text("¿Qué quieres leer?", 1150, 250);


        tf1.display(p5);
    }

    public void dibuixaPantallaEstadísticas(PApplet p5){

        p5.background(197, 212, 232);
        dibuixaSideBar(p5);

        p5.textFont(fontsApp.getSecondFont());
        b1.display(p5);
        b2.display(p5);
        b3.display(p5);
        b4.display(p5);

        p5.fill(255); p5.textFont(fontsApp.getFirstFont()); p5.textSize(60);
        p5.text("Estadísticas", 220, 695);

        p5.fill(0); p5.textFont(fontsApp.getSecondFont()); p5.textSize(50);
        p5.text("Páginas leidas el último año", 800, 100);
        p5.text("Géneros más leidos", 800, 800);

        BD.display(p5);
        s.display(p5);
    }


    public void dibuixaPantallaLibro(PApplet p5){

        p5.background(197, 212, 232);
        dibuixaSideBar(p5);

        p5.textFont(fontsApp.getSecondFont());
        b1.display(p5);
        b2.display(p5);
        b3.display(p5);
        b4.display(p5);
        b5.display(p5);
    }


    // ZONES DE LA GUI



    public void dibuixaSideBar(PApplet p5){
        // Zona Sidebar ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(appColors.getFirstColor());
        p5.rect(marginH, marginV, sidebarWidth, sidebarHeight);
        p5.fill(255); p5.textFont(fontsApp.getFirstFont()); p5.textSize(midaTitol);
        p5.text("TUS LECTURAS", marginH + sidebarWidth/2, 30+marginV + logoHeight + sidebarHeight/2);
    }


    public void dibuixaBanner(PApplet p5){
        p5.fill(appColors.getColorAt(4));
        p5.rect(2*marginH + logoWidth, marginV, bannerWidth, bannerHeight);
        p5.fill(0); p5.textFont(fontsApp.getSecondFont()); p5.textSize(midaTitol);
        p5.text("PANTALLA " +  pantallaActual + "("+pantallaActual.ordinal() +")", marginH + logoWidth + bannerWidth/2, marginV + bannerHeight/2);
    }

    public void dibuixaColumna1(PApplet p5){
        // Zona Columnes 1, 2 i 3 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(appColors.getThirdColor());
        p5.rect(2*marginH + sidebarWidth, 2*marginV + bannerHeight, 3*columnWidth + 2*marginH, columnHeight);
        p5.fill(0); p5.textFont(fontsApp.getThirdFont()); p5.textSize(midaParagraf);
        p5.text("COLUMN 1", 2*marginH + sidebarWidth + 3*columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);
    }

    public void dibuixaColumnes12(PApplet p5){
        // Zona Columnes 1, 2 i 3 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(appColors.getThirdColor());
        p5.rect(2*marginH + sidebarWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0); p5.textFont(fontsApp.getThirdFont()); p5.textSize(midaParagraf);
        p5.text("COLUMN 1", 2*marginH + sidebarWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        p5.fill(appColors.getThirdColor());
        p5.rect(3*marginH + sidebarWidth + columnWidth, 2*marginV + bannerHeight, 2*columnWidth + marginH, columnHeight);
        p5.fill(0); p5.textFont(fontsApp.getThirdFont()); p5.textSize(midaParagraf);
        p5.text("COLUMN 2", 3*marginH + sidebarWidth + 2*columnWidth, 2*marginV + bannerHeight + columnHeight/2);
    }

    public void dibuixaColumnes123(PApplet p5){
        // Zona Columnes 1, 2 i 3 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(appColors.getThirdColor());
        p5.rect(2*marginH + sidebarWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0); p5.textFont(fontsApp.getThirdFont()); p5.textSize(midaParagraf);
        p5.text("COLUMN 1", 2*marginH + sidebarWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        p5.fill(appColors.getThirdColor());
        p5.rect(3*marginH + sidebarWidth + columnWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0); p5.textFont(fontsApp.getThirdFont()); p5.textSize(midaParagraf);
        p5.text("COLUMN 2", 3*marginH + sidebarWidth + columnWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        p5.fill(appColors.getThirdColor());
        p5.rect(4*marginH + sidebarWidth + 2*columnWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0); p5.textFont(fontsApp.getThirdFont()); p5.textSize(midaParagraf);
        p5.text("COLUMN 3", 4*marginH + sidebarWidth + 2*columnWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);
    }
}

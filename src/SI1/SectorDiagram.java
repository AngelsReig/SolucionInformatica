package SI1;

import processing.core.PApplet;

import static processing.core.PApplet.cos;
import static processing.core.PApplet.sin;
import static processing.core.PConstants.TWO_PI;

public class SectorDiagram {

    // Dimensions del Diagrama de Sectors
    float x, y, r;

    // Informació del diagrama (textos, valors i colors)
    String[] texts;
    float[] value;
    float[] percentages;
    int[] colors;

    // Suma total dels valors
    float total;

    // Constructor

    public SectorDiagram(float x, float y, float r){
        this.x = x; this.y = y; this.r = r;
    }

    // Setters

    public void setTexts(String[] t){
        this.texts = t;
    }

    public void setValues(float[] v){
        this.value = v;
        this.total = 0;
        for(int i=0; i<value.length; i++){
            this.total += this.value[i];
        }

        this.percentages = new float[value.length];
        for(int i=0; i<percentages.length; i++){
            this.percentages[i] = (this.value[i] / this.total)*100f;
        }
    }

    public void setColors(int[] c){
        this.colors = c;
    }

    // Dibuixa el Diagrama de Sectors

    public void display(PApplet p5){

        //p5.pushStyle();

        float angStart = 0;
        for(int i=0; i<this.value.length; i++){

            float sectorValue = (this.value[i] / this.total)*TWO_PI;
            float angEnd = angStart + sectorValue;

            p5.fill(colors[i]); p5.stroke(0); p5.strokeWeight(5);
            p5.arc(this.x, this.y, 2*this.r, 2*this.r, angStart, angEnd);

            float textX = this.x + (this.r + 70)*cos((angStart+angEnd)/2f);
            float textY = this.y + (this.r + 70)*sin((angStart+angEnd)/2f);
            p5.fill(0); p5.textAlign(p5.CENTER); p5.textSize(24);
            p5.text(this.texts[i], textX, textY);

            float percX = this.x + (this.r/2)*cos((angStart+angEnd)/2f);
            float percY = this.y + (this.r/2)*sin((angStart+angEnd)/2f);
            String percentage = p5.nf(this.percentages[i], 2, 2);
            p5.fill(255); p5.textAlign(p5.CENTER); p5.textSize(18);
            p5.text(percentage+"%", percX, percY);

            angStart = angEnd;
        }
        //p5.popStyle();
    }

}


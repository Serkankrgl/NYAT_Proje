package Main;

import java.util.Random;

public class Thermometer{
    private int Tempeture;
    private Random rdm = new Random();

    public Thermometer(){
        this.Tempeture = rdm.nextInt(15);
    }

    public int currentTempeture(){
        return Tempeture;
    }

    public void setTempeture(int tempeture){
        Tempeture = tempeture;
    }
}

package Main;

import Interfaces.IAirConditioner;
import Observer.Observable;

import java.util.Scanner;

public class AirConditioner extends Observable implements IAirConditioner {
    Thermometer thermometer = new Thermometer();
    Scanner scanner= new Scanner(System.in);
    boolean status;
    @Override
    public boolean GetStatus()
    {
        if(status) {
            HaberVer("Klima Açık\n Anlık Sıcaklık : ");
        }
        else{
            HaberVer("Klima Kapalı\n Anlık Sıcaklık : ");
        }
        return status;
    }

    @Override
    public void OpenAirConditioner() {
        String msg1 = "Klima Çalışıyor Anlık Sıcaklık : ";
        HaberVer("Şuanki Sıcaklık : ");
        System.out.println("Hedef Sıcaklığı giriniz");
        int target =  scanner.nextInt();
        if(target <=thermometer.currentTempeture()){
            for (int i =thermometer.currentTempeture(); i>=target;i--){
                thermometer.setTempeture(i);
                HaberVer(msg1);
            }
        }
        if(target > thermometer.currentTempeture()){
            for (int i =thermometer.currentTempeture(); i<=target;i++){
                thermometer.setTempeture(i);
                HaberVer(msg1);
            }
        }
        HaberVer("Sıcaklık "+ target +" Dereceye Sabitlendi.\nKlima Çalışıyor Anlık Sıcaklık : ");
        this.status = true;
    }



    @Override
    public void CloseAirConditioner() {
        String msg = "Klima Kapatılıyor\n Son Sıcaklık : ";
        HaberVer(msg);
        this.status = false;
    }

    @Override
    public int GetTempeture() {
        return thermometer.currentTempeture();
    }



}

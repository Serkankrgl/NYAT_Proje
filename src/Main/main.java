package Main;

import DataBase.DbContext;
import Main.Menü;

public class main {


    public static void main(String[] args) {
        DbContext.Connect();
        Menü menü = new Menü();
        menü.PrintMenü();
        DbContext.Disconnect();
    }
}

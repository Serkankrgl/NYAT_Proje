package Main;

import DataBase.DbContext;
import Main.AirConditioner;
import Main.User;

import java.util.Scanner;

public class Menü {

    private static final int OPEN = 1;
    private static final int CLOSE = 2;
    private static final int STATU = 3;
    private static final int EXIT = 4;

    public  void PrintMenü(){
        Scanner scanner= new Scanner(System.in);
        User currentUser = new User();
        AirConditioner airConditioner = new AirConditioner();
        // Authentication
        boolean isLogedIn = false;
        boolean isSignIn = false;
        while(!isLogedIn) {
            System.out.println(" --->  Klima Kontrol Sistemine Hoş Geldiniz  <---  ");
            System.out.println(" --->  1.) Giriş Yap");
            System.out.println(" --->  2.) Kayıt Ol  ");
            int switchKey;
            switchKey = Integer.parseInt(scanner.nextLine());
            if (switchKey == 1){
                while (!isSignIn){
                    System.out.println("Kullanıcı Adınızı Giriniz...");
                    String UserName = scanner.nextLine();
                    System.out.println("Şifrenizi Giriniz...");
                    String Password = scanner.nextLine();
                    currentUser = DbContext.CheckUser(UserName,Password);
                    if(currentUser.getProductNumber()!=0){
                        isSignIn = true;
                    }
                }
                isLogedIn = isSignIn;
            }
            if (switchKey == 2){
                System.out.println("Kullanıcı Adınızı Giriniz...");
                String UserName = scanner.nextLine();
                System.out.println("Şifrenizi Giriniz...");
                String Password = scanner.nextLine();
                System.out.println("Adınızı Giriniz...");
                String Name = scanner.nextLine();
                System.out.println("Soyadınızı Giriniz...");
                String Surname = scanner.nextLine();
                System.out.println("Konum Bilgisi Giriniz...");
                String Location = scanner.nextLine();
                User newUser = new User.Builder()
                        .UserName(UserName)
                        .Password(Password)
                        .Name(Name)
                        .Surname(Surname)
                        .Location(Location)
                        .isLocked(false)
                        .build();

                DbContext.CreateUser(newUser);
            }
        }
        airConditioner.ekle(currentUser);
        if(isLogedIn) {
            int secim = 0;
            do {
                System.out.println("\n\n --->  Klima Kontrol Sistemine Hoş Geldiniz  <---  ");
                System.out.println(" --->  1.) Klima Aç");
                System.out.println(" --->  2.) Klima Kapat ");
                System.out.println(" --->  3.) Anlık Durum");
                System.out.println(" --->  4.) Çıkış Yap");
                secim = Integer.parseInt(scanner.nextLine());
                switch (secim) {
                    case OPEN:
                        airConditioner.OpenAirConditioner();
                        break;
                    case CLOSE:
                        airConditioner.CloseAirConditioner();
                        break;
                    case STATU:
                        airConditioner.GetStatus();
                        break;

                    case EXIT:
                        System.out.println("Çıkış Yapılıyor");
                        break;
                    default:
                        System.out.println("1-4 arasında bir sayı girmelisiniz");
                }
            } while (secim != 4);
        }

    }
}

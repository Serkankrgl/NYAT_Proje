package Main;

import Observer.Observer;
import Observer.Observable;

public class User implements Observer {
    private String UserName;
    private String Password;
    private int ProductNumber;
    private String Location;
    private String Name;
    private String Surname;
    private boolean isLocked;

    public User(){}
    public User(Builder builder){
    this.UserName = builder.UserName;
    this.Password = builder.Password;
    this.ProductNumber = builder.ProductNumber;
    this.Location = builder.Location;
    this.Name = builder.Name;
    this.Surname = builder.Surname;
    this.isLocked = builder.isLocked;
    }

    public int getProductNumber() {
        return ProductNumber;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getLocation() {
        return Location;
    }

    public boolean getIsLocked() {
        return isLocked;
    }

    @Override
    public void Update(Observable observable, String msg) {
        AirConditioner airConditioner = (AirConditioner) observable;

        System.out.println(msg + ((AirConditioner) observable).GetTempeture());
    }

    public static class Builder {
        private String UserName,Password,Location,Name,Surname;
        private int ProductNumber;
        private boolean isLocked;

        public Builder(){}

        public Builder UserName(String UserName){
            this.UserName = UserName;
            return this;
        }

        public Builder Password(String Password){
            this.Password = Password;
            return this;
        }
        public Builder Location(String Location){
            this.Location = Location;
            return this;
        }
        public Builder Name(String Name){
            this.Name = Name;
            return this;
        }
        public Builder Surname(String Surname){
            this.Surname = Surname;
            return this;
        }
        public Builder ProductNumber(int ProductNumber){
            this.ProductNumber = ProductNumber;
            return this;
        }
        public Builder isLocked(boolean isLocked){
            this.isLocked = isLocked;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }
}

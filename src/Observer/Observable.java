package Observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private List<Observer> observerList;

    public Observable(){
        observerList = new ArrayList<>();
    }

    public void ekle(Observer observer){
        observerList.add(observer);
    }

    public void cıkar(Observer observer){
        observerList.remove(observer);
    }
    public void HaberVer(String msg){
        for (Observer observer:observerList){
            observer.Update(this, msg);
        }
    }
}

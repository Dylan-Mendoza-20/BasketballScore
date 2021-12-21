package com.example.basketballscore;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public final MutableLiveData<Integer> localPoints = new MutableLiveData<>();
    public final MutableLiveData<Integer> visitorPoints = new MutableLiveData<>();

    public MainViewModel() {
        reset();
    }

    public LiveData<Integer> getLocalPoints() {
        return localPoints;
    }

    public LiveData<Integer> getVisitorPoints() {
        return visitorPoints;
    }


    public void local(int opc){
        switch (opc){
            case 0:
                if (localPoints.getValue()>0){
                    localPoints.setValue(localPoints.getValue() - 1);
                }
                break;
            case 1:
                localPoints.setValue(localPoints.getValue() + 1);
                break;
            case 2:
                localPoints.setValue(localPoints.getValue() +2);
                break;
        }
    }

    public void visitor(int opc){
        switch (opc){
            case 0:
                if (visitorPoints.getValue()>0){
                    visitorPoints.setValue(visitorPoints.getValue() -1);
                }
                break;
            case 1:
                visitorPoints.setValue(visitorPoints.getValue() +1);
                break;
            case 2:
                visitorPoints.setValue(visitorPoints.getValue() +2);
                break;
        }
    }

    public void reset(){
        localPoints.setValue(0);
        visitorPoints.setValue(0);
    }
}

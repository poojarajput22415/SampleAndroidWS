package com.example.samplemvvm;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class CommonViewModel extends ViewModel implements LifecycleObserver {


    private DataRepository dataRepository = new DataRepositoryImpl();


    LiveData<List<String>> getListOfData(){
        return dataRepository.getUpdatedData();
    }

    void addDataInList(String data){
        dataRepository.addDataInList(data);
    }


    private void listenLifeCycleObserverOnResume(){



    }

}

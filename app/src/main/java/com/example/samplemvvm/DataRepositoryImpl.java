package com.example.samplemvvm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class DataRepositoryImpl implements DataRepository {

    private MutableLiveData<List<String>> liveData = new MutableLiveData();

    private List<String> dataList = new ArrayList<>();

    @Override
    public void setData() {
    }

    @Override
    public void addDataInList(String value) {

        dataList.add(value);
        liveData.postValue(dataList);
    }

    @Override
    public void removeDataFromList(int index) {

        dataList.remove(index);
        liveData.postValue(dataList);
    }

    @Override
    public LiveData<List<String>> getUpdatedData() {
        return liveData;
    }

    @Override
    public void updatedDataInList(int index,String value) {

        dataList.add(index,value);
    }
}

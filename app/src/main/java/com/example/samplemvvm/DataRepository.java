package com.example.samplemvvm;

import androidx.lifecycle.LiveData;

import java.util.List;

interface DataRepository {
    void setData();
    void addDataInList(String value);
    void removeDataFromList(int index);
    LiveData<List<String>> getUpdatedData();
    void updatedDataInList(int index,String value);



}

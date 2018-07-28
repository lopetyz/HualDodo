package com.lopetyz.hualdodo.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.lopetyz.hualdodo.BR;

public class User extends BaseObservable {

    private String name;

    private int age;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

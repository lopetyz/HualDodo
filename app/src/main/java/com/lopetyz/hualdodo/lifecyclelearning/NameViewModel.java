package com.lopetyz.hualdodo.lifecyclelearning;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class NameViewModel extends ViewModel {

    private MutableLiveData<String> mCurrentName;

    public MutableLiveData<String> getCurrentName() {
        if (mCurrentName == null) {
            mCurrentName = new MutableLiveData<>();
        }
        return mCurrentName;
    }

}

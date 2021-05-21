package com.example.ecommerceandroidapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ecommerceandroidapp.model.Image;
import com.example.ecommerceandroidapp.repository.UserImageRepository;

public class UserImageViewModel extends AndroidViewModel {

    private UserImageRepository userImageRepository;

    public UserImageViewModel(@NonNull Application application) {
        super(application);
        userImageRepository = new UserImageRepository(application);
    }

    public LiveData<Image> getUserImage(int userId) {
        return userImageRepository.getUserImage(userId);
    }
}

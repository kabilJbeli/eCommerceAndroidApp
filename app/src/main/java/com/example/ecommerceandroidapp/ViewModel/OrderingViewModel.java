package com.example.ecommerceandroidapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ecommerceandroidapp.model.Ordering;
import com.example.ecommerceandroidapp.repository.OrderingRepository;

import okhttp3.ResponseBody;

public class OrderingViewModel extends AndroidViewModel {

    private OrderingRepository orderingRepository;

    public OrderingViewModel(@NonNull Application application) {
        super(application);
        orderingRepository = new OrderingRepository(application);
    }

    public LiveData<ResponseBody> orderProduct(Ordering ordering) {
        return orderingRepository.orderProduct(ordering);
    }

}

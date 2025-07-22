package com.example.messenger;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class UserViewModel extends ViewModel {

    private FirebaseAuth auth;
    private FirebaseDatabase database;

    //livedata para mostrar si el usuario esta autorizado o no
    private MutableLiveData<FirebaseUser> user = new MutableLiveData<>();

    public UserViewModel(){
        auth = FirebaseAuth.getInstance();
        auth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                //if(firebaseAuth.getCurrentUser() == null){
                    user.setValue(firebaseAuth.getCurrentUser());
                //}
            }
        });
        database  = FirebaseDatabase.getInstance();
    }


    public LiveData<FirebaseUser> getUser() {
        return user;
    }

    public void logout(){
        auth.signOut();
    }
}

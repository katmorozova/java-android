package com.example.messenger;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {

    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference userReference;

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
        database = FirebaseDatabase.getInstance();
        userReference = database.getReference("Users");
        userReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    List<User> usersFromDb = new ArrayList<>();
                    User user = dataSnapshot.getValue(User.class);
                    usersFromDb.add(user);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    public LiveData<FirebaseUser> getUser() {
        return user;
    }

    public void logout(){
        auth.signOut();
    }
}

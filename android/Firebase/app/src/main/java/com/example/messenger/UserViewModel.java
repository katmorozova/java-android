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
    private DatabaseReference usersReference;

    //livedata para mostrar si el usuario esta autorizado o no
    private MutableLiveData<FirebaseUser> user = new MutableLiveData<>();
    private MutableLiveData<List<User>> users = new MutableLiveData<>();

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
        usersReference = database.getReference("Users");
        usersReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                FirebaseUser currentUser = auth.getCurrentUser();
                if (currentUser == null){
                    return;
                }

                List<User> usersFromDb = new ArrayList<>();
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    User user = dataSnapshot.getValue(User.class);
                    if(user == null){
                        return;
                    }
                    if (!user.getId().equals(currentUser.getUid())){
                        usersFromDb.add(user);
                    }
                }
                users.setValue(usersFromDb);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void setUserOnline(boolean isOnline){
        FirebaseUser firebaseUser = auth.getCurrentUser();
        if(firebaseUser == null){
            return;
        }
        usersReference
                .child(firebaseUser.getUid())
                .child("online").setValue(isOnline);
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public LiveData<FirebaseUser> getUser() {
        return user;
    }

    public void logout(){
        setUserOnline(false);
        auth.signOut();
    }
}

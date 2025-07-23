package com.example.messenger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private static final String EXTRA_CURRENT_USER_ID = "current_id";
    private static final String EXTRA_OTHER_USER_ID = "other_id";

    private TextView textViewTitle;
    private View onlineStatus;
    private RecyclerView recyclerViewMessage;
    private ImageView imageViewSendMessage;

    private MessagesAdapter messagesAdapter;

    private String currentUserId;
    private String otherUserId;

    private ChatViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        viewModel = new ViewModelProvider(this).get(ChatViewModel.class);
        currentUserId = getIntent().getStringExtra(EXTRA_CURRENT_USER_ID);
        otherUserId = getIntent().getStringExtra(EXTRA_OTHER_USER_ID);
        messagesAdapter = new MessagesAdapter(currentUserId);
        recyclerViewMessage.setAdapter(messagesAdapter);
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Message message = new Message(
                    "Text"+i,
                    currentUserId,
                    otherUserId
            );
            messages.add(message);
        }
        for (int i = 0; i < 10; i++){
            Message message = new Message(
                    "Text"+i,
                    otherUserId,
                    currentUserId
            );
            messages.add(message);
        }
        messagesAdapter.setMessages(messages);

    }



    private void initViews(){
        textViewTitle = findViewById(R.id.textViewTitle);
        onlineStatus = findViewById(R.id.onlineStatus);
        recyclerViewMessage = findViewById(R.id.recyclerViewMessages);
        imageViewSendMessage = findViewById(R.id.imageViewSendMessage);
    }

    public static Intent newIntent(Context context, String currentUserId, String otherUserId){
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra(EXTRA_CURRENT_USER_ID, currentUserId);
        intent.putExtra(EXTRA_OTHER_USER_ID, otherUserId);
        return intent;
    }

}
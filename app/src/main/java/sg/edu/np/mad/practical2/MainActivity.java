package sg.edu.np.mad.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    TextView userId;
    TextView userDesc;
    User u;
    Button followButton;
    Button messageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int pos = getIntent().getIntExtra("position", 0);

        Intent receivingEnd = getIntent();

        userId = findViewById(R.id.idTxt);
        userDesc = findViewById(R.id.txtDesc);
        followButton = findViewById(R.id.followButton);
        messageButton = findViewById(R.id.messageButton);

        Integer getid = receivingEnd.getIntExtra("id",1);
        String s = String.format("MAD %d", getid);
        userId.setText(s);

        User u = SetDetails();
        followButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (u.followed == false){
                    u.followed = true;
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();

                } else {
                    u.followed = false;
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
                follow(u, followButton);
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, MessageGroup.class));
            }
        });
    }

    public User SetDetails() {
        User u = new User("MAD", "Week 2 practical", 1, false);
        return u;
    }

    public void follow(User u, Button btn){
        TextView txt = btn;
        if(u.followed == false){
            txt.setText("Follow");

        }else {
            txt.setText("Unfollow");
        }
    }
}


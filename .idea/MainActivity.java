package sg.edu.np.mad.practical4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final String TITLE = "Main Activity";
    Integer RecvInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TITLE, "Start!");
    }
    @Override
    protected void onResume(){
        super.onResume();

        // Receive Intent
        Intent myRecvIntent = getIntent();
        RecvInt = myRecvIntent.getIntExtra("Integer", 0);

        // Getting User Objects
        User myUser = new User("Hello World!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua", 1, false);

        TextView tv1 = findViewById(R.id.textView);
        TextView tv2 = findViewById(R.id.textView2);
        tv1.setText(myUser.getUserName() + " " + RecvInt);
        tv2.setText(myUser.getUserDescription());

        // Follow Button Control (Toggling)
        Button buttonFollow = findViewById(R.id.button);
        buttonFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myUser.isUserFollowed() == false) {
                    buttonFollow.setText("UNFOLLOW");
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                    myUser.setUserFollowed(true); // Changing the bool accordingly
                    Log.v(TITLE, "Follow button clicked!");
                } else {
                    buttonFollow.setText("FOLLOW");
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                    myUser.setUserFollowed(false);
                    Log.v(TITLE, "Unfollow button clicked!");
                }
            }
        });
    }
}
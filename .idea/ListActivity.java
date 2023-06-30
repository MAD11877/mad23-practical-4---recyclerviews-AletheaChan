package sg.edu.np.mad.practical4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    String title = "Main Activity 2";
    ArrayList<myObject> myList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
    @Override
    protected void onResume() {
        super.onResume();

        // List User objects
        for (int i = 0; i<21; i++) {
            myObject myData = new myObject();
            Log.v("Scroll Value", String.valueOf(i));
            myData.setMyImageID(R.id.imageView2);
            myData.setMyText(randomName());
            myData.setMyText(randomDesc());
            myList.add(myData);
        }
        // Recycler View
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        CustomAdapter custAdapter = new CustomAdapter(myList);
        LinearLayoutManager mylayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mylayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(custAdapter);
    };

    private void queryProfile() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("MADness").setCancelable(false);
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v(title, "User Accepts");
                Intent myIntent = new Intent(ListActivity.this, MainActivity.class);
                myIntent.putExtra("Integer", randomInt());
                startActivity(myIntent);
            }
        });
        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.v(title, "User Declines");
                finish();
            }
        });
        AlertDialog alert = builder.create();
        alert.setTitle("Profile");
        alert.show();
    }
    private int randomInt() {
        Random ran = new Random();
        int myRandomNumber = ran.nextInt(100000);
        return myRandomNumber;
    }
    private String randomName() {
        Random ran = new Random();
        int myRandomNumber = ran.nextInt(10000000);
        String randName = Integer.toString(myRandomNumber);
        return ("Name " + randName);
    }
    private String randomDesc() {
        Random ran = new Random();
        int myRandomNumber = ran.nextInt(10000000);
        String randDesc = Integer.toString(myRandomNumber);
        return ("Description " + randDesc);
    }
}
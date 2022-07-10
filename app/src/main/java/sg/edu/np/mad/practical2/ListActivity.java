package sg.edu.np.mad.practical2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView img = findViewById(R.id.icon);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ListActivity.this);
                alertDialogBuilder.setTitle("Profile");
                alertDialogBuilder.setMessage("MADness");
                alertDialogBuilder.setCancelable(true);
                alertDialogBuilder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        int getid = Math.abs(new Random().nextInt());
                        Intent listact = new Intent(ListActivity.this, MainActivity.class);
                        listact.putExtra("id", getid);
                        startActivity(listact);
                    }
                });

                alertDialogBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alert = alertDialogBuilder.create();
                alertDialogBuilder.show();
            }
        });
    }
}
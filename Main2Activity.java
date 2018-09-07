package com.depeloper.jhe.bajumanula;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "Main2Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Token: " + token);


    }

    public void hubungikeluarga(View view) {
        String posted_by = "0895391413247";
        String uri = "tel:" + posted_by.trim() ;
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

    public void hubungirs(View view) {


        Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:089668908842"));
        try {

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(in);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "Could not find an activity to place the call.", Toast.LENGTH_SHORT).show();
        }
    }
}

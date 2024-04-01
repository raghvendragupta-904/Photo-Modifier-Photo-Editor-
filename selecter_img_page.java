 package com.example.photomodifier;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

//import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import com.example.photomodifier.databinding.ActivityMainBinding;
import com.github.dhaval2404.imagepicker.ImagePicker;

 public class selecter_img_page extends AppCompatActivity {
     ActivityMainBinding binding;
     public static Uri imgUri;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecter_img_page);
        binding=ActivityMainBinding.inflate(getLayoutInflater());

        //setContentView(binding.getRoot());

         Button btn = findViewById(R.id.Start);

         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {


                 ImagePicker.Companion.with(selecter_img_page.this)
                         .crop()	    			//Crop image(Optional), Check Customization for more option
                      //   .compress(1024)			//Final image size will be less than 1 MB(Optional)
                       //  .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                         .start();


             }
         });
    }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
         super.onActivityResult(requestCode, resultCode, data);


         if (data.getResultCode()
                 ==Activity.RESULT_OK) {
             Intent intent = data.getData();
             // do your operation from here....
             if (intent != null && intent.getData() != null) {
                 Uri selectedimageUri = data.getData();
                 Intent intent1 = new Intent(this, FinalActivity.class);
                 intent1.putExtra("IMG_URI", selectedimageUri);
                 startActivity(intent1);
             }
         }
//         try {
//             imgUri = data.getData();
//             if (!imgUri.equals(""));
//             startActivity(new Intent(selecter_img_page.this, FinalActivity.class));
//         }
//         catch (Exception e){
//
//         }

     }
 }
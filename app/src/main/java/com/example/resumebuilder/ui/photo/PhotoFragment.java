package com.example.resumebuilder.ui.photo;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.resumebuilder.R;

import com.example.resumebuilder.data.Interests;
import com.example.resumebuilder.databinding.FragmentPersonalBinding;
import com.example.resumebuilder.databinding.FragmentPhotoBinding;
import com.example.resumebuilder.db.RealmManager;
import com.example.resumebuilder.ui.personalInfo.PersonalInfoViewModel;

import java.io.InputStream;

import io.realm.RealmResults;

public class PhotoFragment extends Fragment {
    private FragmentPhotoBinding binding;
    private PhotoViewModel photoViewModel;
    private final int Pick_image = 1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        photoViewModel =
                new ViewModelProvider(this).get(PhotoViewModel.class);

        binding = FragmentPhotoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        Button button_save = binding.buttonSave8;
        ImageView photo = binding.photo;
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, Pick_image);
            }
        });

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*RealmResults<Interests> interests = RealmManager.getInstance().getRealmCollectionInterests();
                Interests buba = interests.get(0);
                String firstName = buba.getInterests();
                binding.h.setText(firstName);*/
                Bitmap bitmap = ((BitmapDrawable)photo.getDrawable()).getBitmap();
                saveReceivedImage(bitmap, "some_name");

            }
        });

    }
   @Override
   public void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent){
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode){
            case Pick_image:
                if(resultCode == RESULT_OK){
                    try{
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContext().getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        binding.photo.setImageBitmap(selectedImage);
                    } catch(FileNotFoundException e){
                        e.printStackTrace();
                    }
                }
        }
   }
    private void saveReceivedImage(Bitmap image, String imageName){
        try {
            File path = new File(getContext().getFilesDir(), "MyAppName" + File.separator + "Images");
            if(!path.exists()){
                path.mkdirs();
            }
            File outFile = new File(path, imageName + ".jpeg");
            FileOutputStream outputStream = new FileOutputStream(outFile);
            image.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.close();
        } catch (FileNotFoundException e) {
            Log.e(TAG, "Saving received message failed with", e);
        } catch (IOException e) {
            Log.e(TAG, "Saving received message failed with", e);
        }
    }
    @Override
    public void onPause() {
        super.onPause();

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}



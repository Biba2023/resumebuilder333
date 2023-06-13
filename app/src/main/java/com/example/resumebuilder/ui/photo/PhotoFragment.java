package com.example.resumebuilder.ui.photo;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
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

import com.example.resumebuilder.App;
import com.example.resumebuilder.R;

import com.example.resumebuilder.data.Interests;
import com.example.resumebuilder.data.PersonalInfo;
import com.example.resumebuilder.data.Photo;
import com.example.resumebuilder.databinding.FragmentPersonalBinding;
import com.example.resumebuilder.databinding.FragmentPhotoBinding;
import com.example.resumebuilder.db.RealmManager;
import com.example.resumebuilder.ui.personalInfo.PersonalInfoViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.io.InputStream;

import io.realm.RealmResults;

public class PhotoFragment extends Fragment {
    private FragmentPhotoBinding binding;
    private PhotoViewModel photoViewModel;
    private final int Pick_image = 1;
    SharedPreferences prefs;
    private final int GALLERY_REQ_CODE = 1000;
    private static final String PREF_BITMAP_KEY = "PREF_BITMAP_KEY";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        photoViewModel =
                new ViewModelProvider(this).get(PhotoViewModel.class);

        binding = FragmentPhotoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.setViewModel(photoViewModel);
        binding.setLifecycleOwner(this);

        binding.photo.setImageBitmap(readBitmap(getImageFile("image.png")));

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

                Intent iGallery = new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery, GALLERY_REQ_CODE);

            }
        });
        
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bitmap bitmap = ((BitmapDrawable)binding.photo.getDrawable()).getBitmap();
                writeBitmap(bitmap, getImageFile("image.png"));
                App.photoResume = readBitmap(getImageFile("image.png"));

            }
        });
        binding.buttonDelete8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon_user);
                writeBitmap(bitmap, getImageFile("image.png"));
                App.photoResume = readBitmap(getImageFile("image.png"));
                binding.photo.setImageBitmap(readBitmap(getImageFile("image.png")));
            }
        });

    }
    String picturePath;
    Uri selectedImageUri;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==GALLERY_REQ_CODE){
                binding.photo.setImageURI(data.getData());
                selectedImageUri = data.getData();


            }
        }
    }
    private boolean writeBitmap(Bitmap bitmap, File imageFile){
        FileOutputStream out = null;
        boolean success = false;

        try {
            out = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    private Bitmap readBitmap(File imageFile){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath(), options);
        return bitmap;
    }


    private File getImageFile(String filename){
        return new File(getContext().getFilesDir().getPath()
                + "/"
                + filename);
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



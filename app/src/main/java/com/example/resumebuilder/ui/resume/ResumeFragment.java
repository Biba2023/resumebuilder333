package com.example.resumebuilder.ui.resume;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.resumebuilder.App;

import com.example.resumebuilder.MainActivity;
import com.example.resumebuilder.PermissionUtils;
import com.example.resumebuilder.databinding.FragmentResumeBinding;
import com.google.android.material.snackbar.Snackbar;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResumeFragment extends Fragment {
    private LinearLayout linearLayout;
    private Bitmap bitmap;
    private Context context;
    private FragmentResumeBinding binding;
    private ResumeViewModel resumeViewModel;
    private static final int PERMISSION_STORAGE = 101;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        resumeViewModel =
                new ViewModelProvider(this).get(ResumeViewModel.class);

        binding = FragmentResumeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.setViewModel(resumeViewModel);
        binding.setLifecycleOwner(this);
        binding.nameResume.setText(App.nameResume);
        binding.addressResume.setText(App.addressResume);
        binding.emailAndPhoneAndDoB.setText(App.emailResume + " | " + App.telephoneResume + " | " + "Дата рождения:" + App.dateofBirthResume);
        binding.experienceResume.setText(App.experienceResume);
        binding.nameOfCompanyResume.setText(App.nameOfCompanyResume);
        binding.jobResume.setText(App.jobResume);
        binding.introductionResume.setText(App.introductionResume);
        binding.detailsOfJobResume.setText("•" + App.detailsOfJobResume);
        binding.dateOfJob.setText(App.startDateJobResume + " - " + App.endDateJobResume);
        binding.nameOfUniversityResume.setText(App.universityResume);
        binding.qualificationAndGradeResume.setText(App.qualificationResume + " - " + App.gradeResume);
        binding.dateOfEducation.setText(App.startDateOfEduResume + " - " + App.endDateOfEduResume);
        binding.detailsOfEducationResume.setText("•" + App.detailsOfEduResume);
        binding.nameOfProjectResume.setText(App.projectResume);
        binding.detailsOfProjectResume.setText(App.detailsOfProjectResume);
        binding.dateOfProject.setText(App.startDateOfProjectResume + " - " + App.endDateOfProjectResume);
        binding.skillsResume.setText("•" + App.keySkillsResume);
        binding.interestsResume.setText("•" + App.interestsResume);
        return root;

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = this.getActivity();
        linearLayout = binding.resume;
        binding.buttonDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PermissionUtils.hasPermissions(getContext())) {
                    layoutToImage(linearLayout);
                    try {
                        imageToPDF();
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    PermissionUtils.requestPermissions(getActivity(), PERMISSION_STORAGE);
                }


            }
        });

    }
    @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                                     @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Snackbar.make(getView(), "Разрешение получено", Snackbar.LENGTH_SHORT).show();
            } else {
                Snackbar.make(getView(), "Разрешение откланено", Snackbar.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == PERMISSION_STORAGE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (PermissionUtils.hasPermissions(getContext())) {
                    Snackbar.make(getView(), "Разрешение получено", Snackbar.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(getView(), "Разрешение откланено", Snackbar.LENGTH_SHORT).show();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    String dirpath;
    View relativeLayout;
    public void layoutToImage(View view) {
        // get view group using reference
        relativeLayout = view;
        // convert view group to bitmap
        relativeLayout.setDrawingCacheEnabled(true);
        relativeLayout.buildDrawingCache();
        Bitmap bm = relativeLayout.getDrawingCache();
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/jpeg");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

        File f = new File(Environment.getExternalStorageDirectory() + File.separator + "image.jpg");
        try {
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            Snackbar.make(view, "Изображение успешно сохранено во внутреннюю память", Snackbar.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Snackbar.make(view, "Что-то пошло не так..." + e.toString(), Snackbar.LENGTH_SHORT).show();
        }

    }
    public void imageToPDF() throws FileNotFoundException {
        try {
            Document document = new Document();
            dirpath = android.os.Environment.getExternalStorageDirectory().toString();
            PdfWriter.getInstance(document, new FileOutputStream(dirpath + "/NewPDF.pdf")); //  Change pdf's name.
            document.open();
            Image img = Image.getInstance(Environment.getExternalStorageDirectory() + File.separator + "image.jpg");
            float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
                    - document.rightMargin() - 0) / img.getWidth()) * 100;
            img.scalePercent(scaler);
            img.setAlignment(Image.ALIGN_CENTER | Image.ALIGN_TOP);
            document.add(img);
            document.close();
            Snackbar.make(getView(), "Документ успешно сохранен во внутренней памяти", Snackbar.LENGTH_SHORT).show();

        } catch (Exception e) {

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
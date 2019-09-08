package com.lionel.mvvm_lifedata_navigation_realmp.features.main;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.databinding.ViewDataBinding;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.lionel.mvvm_lifedata_navigation_realmp.BuildConfig;
import com.lionel.mvvm_lifedata_navigation_realmp.R;
import com.lionel.mvvm_lifedata_navigation_realmp.base.BaseFragment;
import com.lionel.mvvm_lifedata_navigation_realmp.databinding.FragmentFeature3Binding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;


public class Feature3Fragment extends BaseFragment {

    private static final int REQUEST_CODE_TAKE_PHOTO = 1;
    private static final int REQUEST_CODE_PICK_PHOTO = 2;
    private static final int REQUEST_CODE_FOR_CROP_AVATAR = 3;


    private FragmentFeature3Binding dataBinding;
    private Button btnGo;
    private ImageView imgAvatar;
    private Uri photoUri;
    private Uri photoTakingUri;
    private File fileAvatarCrop;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_feature3;
    }

    @Override
    protected boolean getIsEnableBack() {
        return true;
    }

    @Override
    protected void initViewModel() {

    }

    @Override
    protected void initView(ViewDataBinding baseDataBinding) {
        dataBinding = (FragmentFeature3Binding) baseDataBinding;
        btnGo = dataBinding.btnGo;
        imgAvatar = dataBinding.imgAvatar;
    }

    @Override
    protected void initListener() {
        btnGo.setOnClickListener(v -> navController.navigate(R.id.action_feature3Fragment_to_feature3_1Fragment));
        imgAvatar.setOnClickListener(v -> takePhoto());
    }

    private void takePhoto() {
        File imagePhoto = new File(getActivity().getCacheDir(), "avatar_simple.png");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        photoTakingUri = FileProvider.getUriForFile(getActivity(), BuildConfig.APPLICATION_ID + ".provider", imagePhoto);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoTakingUri);
        startActivityForResult(intent, REQUEST_CODE_TAKE_PHOTO);
    }

    private void cropPhoto() {
        Intent cropIntent = new Intent("com.android.camera.action.CROP");
        cropIntent.setDataAndType(photoTakingUri, "image/*");
        cropIntent.putExtra("crop", "true");
        cropIntent.putExtra("aspectX", 1);
        cropIntent.putExtra("aspectY", 1);
        cropIntent.putExtra("outputX", 300);
        cropIntent.putExtra("outputY", 300);
        cropIntent.putExtra("scale", "true");
        cropIntent.putExtra("outputFormat", Bitmap.CompressFormat.PNG.toString());
        cropIntent.putExtra("return-data", false);
        cropIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivityForResult(cropIntent, REQUEST_CODE_FOR_CROP_AVATAR);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_TAKE_PHOTO:
                    cropPhoto();
                    break;

                case REQUEST_CODE_FOR_CROP_AVATAR:
                    if (data != null && data.getData() != null) {
                        handleCropResult(data);
                    }
                    break;
            }
        }
    }

    private void handleCropResult(Intent data) {
        try {
            fileAvatarCrop = new File(getActivity().getCacheDir(), "avatar_crop.png");
            InputStream inputStream = getActivity().getContentResolver().openInputStream(data.getData());
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            FileOutputStream fileOutputStream = new FileOutputStream(fileAvatarCrop);
            fileOutputStream.write(buffer);

            inputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Glide.with(this)
                .load(fileAvatarCrop)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(imgAvatar);
    }

    @Override
    protected void initObserve() {

    }
}

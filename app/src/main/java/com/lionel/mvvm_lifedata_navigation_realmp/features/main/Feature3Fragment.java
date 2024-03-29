package com.lionel.mvvm_lifedata_navigation_realmp.features.main;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
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
import java.util.List;

import static android.app.Activity.RESULT_OK;


public class Feature3Fragment extends BaseFragment {

    private static final int REQUEST_CODE_TAKE_PHOTO = 1;
    private static final int REQUEST_CODE_PICK_PHOTO = 2;
    private static final int REQUEST_CODE_FOR_CROP_AVATAR = 3;


    private FragmentFeature3Binding dataBinding;
    private Button btnGo;
    private ImageView imgAvatar;
    private Uri uriAvatarOrigin;
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
        imgAvatar.setOnClickListener(v -> pickPhoto());
    }

    private void pickPhoto() {
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        getIntent.setType("image/*");
        pickIntent.setType("image/*");
        Intent chooserIntent = Intent.createChooser(getIntent, "Select photo");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});
        startActivityForResult(chooserIntent, REQUEST_CODE_PICK_PHOTO);
    }

    private void takePhoto() {
        File imagePhoto = new File(getActivity().getCacheDir(), "avatar_origin.png");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        uriAvatarOrigin = FileProvider.getUriForFile(getActivity(), BuildConfig.APPLICATION_ID + ".provider", imagePhoto);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriAvatarOrigin);
        startActivityForResult(intent, REQUEST_CODE_TAKE_PHOTO);
    }

    private void cropPhoto() {
        //產生圖片存的file位置
        fileAvatarCrop = new File(getActivity().getCacheDir(), "avatar_crop.png");

        //只要和外部應用程式溝通, 就最好用FileProvider將 file:// 轉成 content://  (for android 7.0 above)
        Uri photoCropUri = FileProvider.getUriForFile(getActivity(), BuildConfig.APPLICATION_ID + ".provider", fileAvatarCrop);

        Intent cropIntent = new Intent("com.android.camera.action.CROP");
        cropIntent.setDataAndType(uriAvatarOrigin, "image/*");
        cropIntent.putExtra("crop", "true");
        cropIntent.putExtra("aspectX", 1);
        cropIntent.putExtra("aspectY", 1);
        cropIntent.putExtra("outputX", 300);
        cropIntent.putExtra("outputY", 300);
        cropIntent.putExtra("scale", "true");
        cropIntent.putExtra("outputFormat", Bitmap.CompressFormat.PNG.toString());
        cropIntent.putExtra("return-data", false);
        cropIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoCropUri);

        // 似乎只要和fileProvider扯上關係, 就要宣告臨時權限
        List<ResolveInfo> resInfoList = getActivity().getPackageManager().queryIntentActivities(cropIntent, PackageManager.MATCH_DEFAULT_ONLY);
        for (ResolveInfo resolveInfo : resInfoList) {
            String packageName = resolveInfo.activityInfo.packageName;
            getActivity().grantUriPermission(packageName, uriAvatarOrigin, Intent.FLAG_GRANT_READ_URI_PERMISSION);
            getActivity().grantUriPermission(packageName, photoCropUri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        }

        startActivityForResult(cropIntent, REQUEST_CODE_FOR_CROP_AVATAR);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_PICK_PHOTO:
                    uriAvatarOrigin = data.getData();
                    cropPhoto();
                    break;

                case REQUEST_CODE_TAKE_PHOTO:
                    cropPhoto();
                    break;

                case REQUEST_CODE_FOR_CROP_AVATAR:
                    handleCropResult();
                    break;
            }
        }
    }

    private void handleCropResult() {
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

package com.ypx.imagepickerdemo.style.custom;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

import car.wuba.saas.media.imagepicker.utils.PStatusBarUtil;
import car.wuba.saas.media.imagepicker.views.base.SingleCropControllerView;
import car.wuba.saas.media.imagepicker.widget.cropimage.CropImageView;
import com.ypx.imagepickerdemo.R;

public class CustomCropControllerView extends SingleCropControllerView {
    private ImageView mCloseImg;
    private ImageView mOkImg;

    public CustomCropControllerView(Context context) {
        super(context);
    }

    /**
     * @return item布局id
     */
    @Override
    protected int getLayoutId() {
        return R.layout.layout_custom_crop;
    }

    /**
     * @param view 初始化view
     */
    @Override
    protected void initView(View view) {
        mCloseImg = view.findViewById(R.id.mCloseImg);
        mOkImg = view.findViewById(R.id.mOkImg);
        mCloseImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void setStatusBar() {
        PStatusBarUtil.fullScreenWithCheckNotch((Activity) getContext(), Color.BLACK);
    }

    @Override
    public View getCompleteView() {
        return mOkImg;
    }

    @Override
    public void setCropViewParams(CropImageView cropImageView, MarginLayoutParams params) {
        params.bottomMargin = dp(60);
    }

}

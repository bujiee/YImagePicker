package car.wuba.saas.media.imagepicker.data;

import androidx.annotation.Nullable;

import car.wuba.saas.media.imagepicker.bean.ImageItem;

public interface ICameraExecutor {

    void takePhoto();

    void takeVideo();

    void onTakePhotoResult(@Nullable ImageItem imageItem);
}

package car.wuba.saas.media.imagepicker.widget.cropimage;

import android.view.MotionEvent;

/**
 * Description: 旋转手势
 * <p>
 * Author: peixing.yang
 * Date: 2019/2/21
 */
public class RotateGestureDetector {

    private static final int MAX_DEGREES_STEP = 120;

    private OnRotateListener mListener;

    private float mPrevSlope;
    private float mCurrSlope;

    private float x1;
    private float y1;
    private float x2;
    private float y2;

    public RotateGestureDetector(OnRotateListener l) {
        mListener = l;
    }

    public void onTouchEvent(MotionEvent event) {

        final int Action = event.getActionMasked();

        switch (Action) {
            case MotionEvent.ACTION_POINTER_DOWN:
            case MotionEvent.ACTION_POINTER_UP:
                if (event.getPointerCount() == 2) mPrevSlope = caculateSlope(event);
                break;
            case MotionEvent.ACTION_MOVE:
                if (event.getPointerCount() > 1) {
                    mCurrSlope = caculateSlope(event);

                    double currDegrees = Math.toDegrees(Math.atan(mCurrSlope));
                    double prevDegrees = Math.toDegrees(Math.atan(mPrevSlope));

                    double deltaSlope = currDegrees - prevDegrees;

                    if (Math.abs(deltaSlope) <= MAX_DEGREES_STEP) {
                        mListener.onRotate((float) deltaSlope, (x2 + x1) / 2, (y2 + y1) / 2);
                    }
                    mPrevSlope = mCurrSlope;
                }
                break;
            default:
                break;
        }
    }

    private float caculateSlope(MotionEvent event) {
        x1 = event.getX(0);
        y1 = event.getY(0);
        x2 = event.getX(1);
        y2 = event.getY(1);
        return (y2 - y1) / (x2 - x1);
    }

    public  interface OnRotateListener {
        void onRotate(float degrees, float focusX, float focusY);
    }
}


package toolgamecorporation.worldcupschedule.presentations.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import java.util.Locale;

import toolgamecorporation.worldcupschedule.R;

/**
 * Created by Dell on 3/29/2018.
 */

public class CompatTextView extends AppCompatTextView {
    public CompatTextView(Context context) {
        super(context);
        init(null);
    }

    public CompatTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CompatTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {
        if (attrs != null) {
            Context context = getContext();
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CompatTextView);

            // Grab the compat drawable resources from the XML
            int startDrawableRes = a.getResourceId(R.styleable.CompatTextView_drawableStart, 0);
            int topDrawableRes = a.getResourceId(R.styleable.CompatTextView_drawableTop, 0);
            int endDrawableRes = a.getResourceId(R.styleable.CompatTextView_drawableEnd, 0);
            int bottomDrawableRes = a.getResourceId(R.styleable.CompatTextView_drawableBottom, 0);

            setDrawables(startDrawableRes, topDrawableRes, endDrawableRes, bottomDrawableRes);

            a.recycle();
        }
    }

    public void setDrawables(int startDrawableRes, int topDrawableRes, int endDrawableRes, int bottomDrawableRes) {
        Context context = getContext();

        // Load the used drawables, falling back to whatever may be set in an "android:" namespace attribute
        Drawable[] currentDrawables = getCompoundDrawables();
        Drawable left = startDrawableRes != 0 ? ContextCompat.getDrawable(context, startDrawableRes) : currentDrawables[0];
        Drawable right = endDrawableRes != 0 ? ContextCompat.getDrawable(context, endDrawableRes) : currentDrawables[1];
        Drawable top = topDrawableRes != 0 ? ContextCompat.getDrawable(context, topDrawableRes) : currentDrawables[2];
        Drawable bottom = bottomDrawableRes != 0 ? ContextCompat.getDrawable(context, bottomDrawableRes) : currentDrawables[3];

        // Account for RTL and apply the compound Drawables
        Drawable start = isLayoutRtl() ? right : left;
        Drawable end = isLayoutRtl() ? left : right;
        setCompoundDrawablesWithIntrinsicBounds(start, top, end, bottom);
    }

    public boolean isLayoutRtl() {
        return isRTL();
    }

    public boolean isRTL() {
        return TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault())
                == android.support.v4.view.ViewCompat.LAYOUT_DIRECTION_RTL;
    }
}

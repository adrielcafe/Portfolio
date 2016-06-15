package cafe.adriel.myappportfolio.util;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.lang.reflect.Field;

public class Util {

    public static void setupToolbar(Context context, Toolbar toolbar){
        TextView titleView = null;
        try {
            Field f = toolbar.getClass().getDeclaredField("mTitleTextView");
            f.setAccessible(true);
            titleView = (TextView) f.get(toolbar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(titleView != null) {
            Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/Limelight.ttf");
            titleView.setTypeface(font);
            titleView.setTextSize(26);
        }
    }

}
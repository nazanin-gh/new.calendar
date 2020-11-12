import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;

public class vazir extends AppCompatTextView {
    public vazir (Context context){
        super(context);
    }
    public vazir (Context context, AttributeSet attrs){
        super(context, attrs);
        Typeface vazir = Typeface.createFromAsset(context.getAssets(), "Vazir-Light.ttf");
        this.setTypeface(vazir);
    }

}

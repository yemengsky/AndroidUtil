
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;

import com.umeng.analytics.MobclickAgent;

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }


    public void startActivityTrans(Intent intent, @Nullable Pair<View, String>... sharedElements) {
        if (sharedElements != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ActivityOptions options = null;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                options = ActivityOptions
                        .makeSceneTransitionAnimation(this, sharedElements);

            }
            if (options == null) {
                startActivity(intent);
            } else {
                startActivity(intent, options.toBundle());
            }

        } else {
            startActivity(intent);
        }
    }

    public void finishThis() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        } else {
            finish();
        }
    }
}

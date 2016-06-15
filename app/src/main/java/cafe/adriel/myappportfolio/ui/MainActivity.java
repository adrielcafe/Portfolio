package cafe.adriel.myappportfolio.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.andexert.library.RippleView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import cafe.adriel.myappportfolio.R;
import cafe.adriel.myappportfolio.util.Util;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindViews({R.id.app1, R.id.app2, R.id.app3, R.id.app4, R.id.app5, R.id.app6})
    List<View> appViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        Util.setupToolbar(this, toolbar);
        init();
    }

    @Override
    public void onClick(View v) {
        TextView appNameView = (TextView) ((RippleView) v).getChildAt(0);
        String message = String.format("Launch %s app", appNameView.getText());
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void init(){
        for(View appView : appViews) {
            appView.setOnClickListener(this);
        }
    }

}
package caduceuslabs.examrecord;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.app.Fragment;

public class ExamActivity extends AppCompatActivity {

    private RadioGroup navigation;
    private int checkedButton;
    private View fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_exam);
        navigation = (RadioGroup)findViewById(R.id.navigation_radio_group);
        final FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BasicInfoFragment basicInfoFragment = new BasicInfoFragment();
        fragmentTransaction.add(R.id.fragment_container,basicInfoFragment);
        fragmentTransaction.commit();
        navigation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d("test","check has changed");
                if (checkedId == R.id.radioButton2) {
                    Log.d("test","let's change that fragment");
                    HistoryFragment newFragment = new HistoryFragment();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.fragment_container, newFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
    }

}

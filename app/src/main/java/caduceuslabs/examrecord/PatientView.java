package caduceuslabs.examrecord;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PatientView extends AppCompatActivity {

    private ImageView patient_image;
    private TextView patient_name;
    private Button start_exam_button;
    private Button previous_records_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent parentIntent = getIntent();
        setContentView(R.layout.activity_patient_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        patient_image = (ImageView)findViewById(R.id.patient_image);
        // set patient's picture if applicable
        patient_name = (TextView)findViewById(R.id.patient_name);
        patient_name.setText(parentIntent.getStringExtra("patientName"));
        start_exam_button = (Button)findViewById(R.id.start_exam_button);
        start_exam_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ExamActivity.class);
                intent.putExtra("patientName","David Hagen");
                startActivity(intent);
            }
        });
        previous_records_button = (Button)findViewById(R.id.previous_records_button);
        previous_records_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fill in intent
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

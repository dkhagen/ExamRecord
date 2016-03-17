package caduceuslabs.examrecord;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainPage extends AppCompatActivity {

    private ListView todaysAppts;
    private String[][] testData = new String[][] {{"David Hagen","12:30"}, {"John Smith","1:30"}};
    //private Context mContext = getApplicationContext();
    private String TAG = "Testing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main_page);
        // DONE: create custom adapter from example online for formatting
        // http://www.vogella.com/tutorials/AndroidListView/article.html
        todaysAppts = (ListView)findViewById(R.id.todaysAppts);
        AppointmentAdapter appointmentAdapter = new AppointmentAdapter(this,testData);
        todaysAppts.setAdapter(appointmentAdapter);
        todaysAppts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,"on click");
                Intent intent = new Intent(getApplicationContext(),PatientView.class);
                intent.putExtra("patientName","David Hagen");
                startActivity(intent);
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

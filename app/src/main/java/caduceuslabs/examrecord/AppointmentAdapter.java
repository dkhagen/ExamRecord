package caduceuslabs.examrecord;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Alex on 3/13/2016.
 */
public class AppointmentAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[][] values;

    public AppointmentAdapter(Context context, String[][] values) {
        super(context, -1, values[0]);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.simple_list_item, parent, false);
        TextView textView1 = (TextView) rowView.findViewById(R.id.patient_appt_name);
        TextView textView2 = (TextView) rowView.findViewById(R.id.patient_appt_time);
        textView1.setText(values[position][0]);
        textView2.setText(values[position][1]);

        return rowView;
    }
}

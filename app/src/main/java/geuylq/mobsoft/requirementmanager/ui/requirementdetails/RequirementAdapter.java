package geuylq.mobsoft.requirementmanager.ui.requirementdetails;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import geuylq.mobsoft.requirementmanager.R;
import geuylq.mobsoft.requirementmanager.model.Requirement;

public class RequirementAdapter extends ArrayAdapter<Requirement> {
    public RequirementAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Requirement> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.activity_list_requirement, null);
        }

        Requirement f = getItem(position);

        if(f != null){
            TextView name = (TextView) v.findViewById(R.id.requirement_details);
            TextView details = (TextView) v.findViewById(R.id.requirement_date);

            //name.setText(f.getName());
            //details.setText(f.getDetails());
            //price.setText(f.getPrice() + " Ft");
        }

        return v;
    }
}

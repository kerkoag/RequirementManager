package geuylq.mobsoft.requirementmanager.ui.requirementlist;

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
            TextView title = (TextView) v.findViewById(R.id.requirement_title);
            TextView state = (TextView) v.findViewById(R.id.requirement_state);

            title.setText(f.getTitle());
            state.setText(f.getState());
        }

        return v;
    }
}

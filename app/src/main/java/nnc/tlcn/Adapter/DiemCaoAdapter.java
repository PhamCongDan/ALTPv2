package nnc.tlcn.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import nnc.tlcn.R;
import nnc.tlcn.model.DiemCao;

/**
 * Created by Dan Pham on 01/01/2018.
 */

public class DiemCaoAdapter  extends ArrayAdapter<DiemCao>{
    Activity context;
    int resource;
    List<DiemCao> objects;
    public DiemCaoAdapter(Activity context, int resource, List<DiemCao> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource,null);

        TextView txtTen= (TextView) row.findViewById(R.id.txtTen);
        TextView txtDiem= (TextView) row.findViewById(R.id.txtDiemCao);

        DiemCao dc=this.objects.get(position);
        txtTen.setText(dc.getTen());
        txtDiem.setText(dc.getDiem());
        return row;
    }
}

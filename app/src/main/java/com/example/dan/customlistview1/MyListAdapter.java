package com.example.dan.customlistview1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dan on 2/25/2016.
 */
public class MyListAdapter extends BaseAdapter {

    Integer[] images={R.drawable.brca1,R.drawable.brca2,R.drawable.cmyc,R.drawable.hers,R.drawable.mitocondrialdna,R.drawable.p27,R.drawable.p53,R.drawable.ras,R.drawable.skp2a};
    String[] name={"BRCA1","BRCA2","C-MYC","HER2","MITOCHONDRIAL DNA","P27","P53","RAS","SKP2"};
    String[] genefunction={ "tumor suppressor", "tumor suppressor","regulator","epidermal growth factor","various","enzyme inhibitor","tumor suppressor","signal transduction","enzyme"};
    String[] genelocation={ "chromosome 17", "chromosome 13","chromosome 8","chromosome 17","Mitochondria","chromosome 12","chromosome 17","chromosome 1","chromosome 21"};

    Context context;
    LayoutInflater layoutInflater;

    public MyListAdapter(Context context){
        this.context=context;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view=layoutInflater.inflate(R.layout.my_list_view,null);
        ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
        TextView tvName=(TextView)view.findViewById(R.id.textViewName);
        final TextView tvFunction=(TextView)view.findViewById(R.id.textViewFunction);
        TextView tvLocation=(TextView)view.findViewById(R.id.textViewLocation);

        imageView.setImageResource(images[position]);
        tvName.setText(name[position]);
        tvFunction.setText(genefunction[position]);
        tvLocation.setText(genelocation[position]);

        tvFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You picked out a: " + tvFunction.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}

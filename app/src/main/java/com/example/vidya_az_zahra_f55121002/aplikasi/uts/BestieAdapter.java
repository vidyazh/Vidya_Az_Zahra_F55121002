package com.example.vidya_az_zahra_f55121002.aplikasi.uts;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class BestieAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Bestie> besties;

    public void setBesties(ArrayList<Bestie> besties) {
        this.besties = besties;
    }

    public BestieAdapter(Context context) {
        this.context = context;
        besties = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return besties.size();
    }

    @Override
    public Object getItem(int i) {
        return besties.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_list_bestie, viewGroup, false);

        }

        BestieAdapter.ViewHolder viewHolder = new BestieAdapter.ViewHolder(view);
        Bestie bestie = (Bestie) getItem(i);
        viewHolder.bind(bestie);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Bestie bestie) {
            txtName.setText(bestie.getName());
            txtDescription.setText(bestie.getDescription());
            imgPhoto.setImageResource(bestie.getPhoto());
        }
    }
}

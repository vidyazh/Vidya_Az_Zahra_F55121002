package com.example.vidya_az_zahra_f55121002.aplikasi.uts;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private BestieAdapter adapter;
    ListView listView;
    private ArrayList<Bestie> besties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new BestieAdapter(this);
        listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long id){
                if (i==0){
                    startActivity(new Intent(MainActivity.this, VidyaActivity.class));
                }
                else if (i==1){
                    startActivity(new Intent(MainActivity.this, NydiaActivity.class));
                }
                else if (i==2){
                    startActivity(new Intent(MainActivity.this, NadiaActivity.class));
                }
                else if (i==3){ 
                    startActivity(new Intent(MainActivity.this, MayaActivity.class));
                }
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);

    }

    private void addItem() {
        besties = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Bestie bestie = new Bestie();
            bestie.setPhoto(dataPhoto.getResourceId(i, -1));
            bestie.setName(dataName[i]);
            bestie.setDescription(dataDescription[i]);
            besties.add(bestie);
        }
        adapter.setBesties(besties);
    }
}
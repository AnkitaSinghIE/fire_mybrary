package com.example.fire_mybrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
 RecyclerView recview;
 CardView cv;
 myadapter adapter;
 LinearLayout LL;
 ClipData.Item watch;
 ImageButton imageButton;
    @Override
     protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recview=(RecyclerView)findViewById(R.id.recview);
        LL=(LinearLayout)findViewById(R.id.button);
        imageButton=(ImageButton)findViewById(R.id.imageButton2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AnotherActivity.class);
             startActivity(intent);
            }
        });

        recview.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<model>options=
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Users"),model.class)
                        .build();
        adapter=new myadapter(options);
        recview.setAdapter(adapter);
    }
    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchmenu, menu);

        MenuItem item=menu.findItem(R.id.search);
       // MenuItem item=menu.findItem(R.menu.searchmenu,menu);
        SearchView searchView=(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearch(s);
                return false;
            }



            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    private void processsearch(String s)
    {
        FirebaseRecyclerOptions<model>options=
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Users").orderByChild("title").startAt(s).endAt(s+"\uf8ff"),model.class)
                        .build();
        adapter=new myadapter(options);
        adapter.startListening();
        recview.setAdapter(adapter);

    }


   @Override
   public boolean onOptionsItemSelected(MenuItem item){
        return super.onOptionsItemSelected(item);
   }



    }
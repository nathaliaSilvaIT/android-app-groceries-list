package ca.georgebrown.comp2074.a2_mobile;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends FragmentActivity
        implements ItemDetailsFragment.OnFragmentInteractionListener {

    private WordViewModel myWordViewModel;
    public final static int NEW_WORD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton myButton = findViewById(R.id.fab);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this, AddWordActivity.class);
                startActivityForResult(myIntent, NEW_WORD);

            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final WordListAdapter myWordAdapter = new WordListAdapter(this);

        recyclerView.setAdapter(myWordAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);

        myWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable List<Word> words) {
                myWordAdapter.setWords(words);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent thisIntent) {

        super.onActivityResult(requestCode, resultCode, thisIntent);

        if(requestCode == NEW_WORD && resultCode == RESULT_OK){

            assert thisIntent != null; /* avoiding null pointer error */
            Word myWord = new Word(thisIntent.getStringExtra(AddWordActivity.NEW_REPLY));
            myWordViewModel.insert(myWord);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.action_settings) { return true; }
        return super.onOptionsItemSelected(menuItem);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onFragmentInteraction(Word listItem) {


    }

}

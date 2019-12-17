package ca.georgebrown.comp2074.a2_mobile;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private Context myContext;


    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }



    private final LayoutInflater inflater;
    private List<Word> words;

    WordListAdapter(Context context){

        inflater = LayoutInflater.from(context);
        myContext = context;

    }

    void setWords(List<Word> myWords){
        this.words = myWords;
        notifyDataSetChanged();
    }

    @NonNull
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int pos){
        View itemView = inflater.inflate(R.layout.rec_item_layout, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int pos) {

        if (words != null) {

            final Word current = words.get(pos);
            holder.wordItemView.setText(current.getWord());
            holder.wordItemView.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {

                    Intent myIntent = new Intent(myContext, DetailsActivity.class);
                    myIntent.putExtra("item", current);
                    myContext.startActivity(myIntent);

                }
            });
        }

        else {
            holder.wordItemView.setText("---");
        }
    }


    @Override
    public int getItemCount() {

        if (words != null) {return words.size();}
        else { return 0; }

    }


    private String selectedItem = "";

    public void SetDataFragment(String listItem) {

        selectedItem = listItem;
    }

    public String GetDataFragment() {

        return selectedItem;
    }
}


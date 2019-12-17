package ca.georgebrown.comp2074.a2_mobile;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import android.os.Build;
import android.os.Bundle;
import java.util.Objects;


public class DetailsActivity extends FragmentActivity
        implements ItemDetailsFragment.OnFragmentInteractionListener {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        FragmentManager myFragManager = getSupportFragmentManager();
        ItemDetailsFragment itemDetailsFragment =
                (ItemDetailsFragment) myFragManager.findFragmentById(R.id.details_fragment);


        Word myItem = (Word) Objects.requireNonNull(getIntent().getExtras()).getSerializable("item");

        assert itemDetailsFragment != null;
        itemDetailsFragment.setItem(myItem);

    }


    @Override
    public void onFragmentInteraction(Word thisItem) {


        WordViewModel wordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        wordViewModel.delete(thisItem);
        finish();


    }
}

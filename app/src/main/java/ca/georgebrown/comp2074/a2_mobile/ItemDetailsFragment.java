package ca.georgebrown.comp2074.a2_mobile;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ItemDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class ItemDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public Word getItem() {

        return item;

    }

    void setItem(Word my_item) {

        this.item = my_item;
        Activity a = getActivity();

        /* ADDED TO AVOID EXCEPTIONS */
        assert a != null;
        TextView t = a.findViewById(R.id.lblItemText);
            if (t != null) {
               t.setText(my_item.getWord());
            }

    }

    private Word item;

    // TODO: Rename and change types of parameters

    private String myParam1;
    private String myParam2;
    private String itemList;
    private OnFragmentInteractionListener myFragListener;

    public ItemDetailsFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ItemDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ItemDetailsFragment newInstance(String param1, String param2) {

        ItemDetailsFragment my_fragment = new ItemDetailsFragment();

        Bundle my_args = new Bundle();
        my_args.putString(ARG_PARAM1, param1);
        my_args.putString(ARG_PARAM2, param2);
        my_fragment.setArguments(my_args);

        return my_fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            myParam1 = getArguments().getString(ARG_PARAM1);
            myParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_item_details, container, false);

        Button myButton = view.findViewById(R.id.delete_btn);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFragListener.onFragmentInteraction(item);
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            myFragListener = (OnFragmentInteractionListener) context;
        }

        else {
            throw new RuntimeException(context.toString()
                    + " there is not an OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myFragListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Word item);
    }
}

package android.example.com.leduccommonareatour;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClothingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClothingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ClothingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClothingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClothingFragment newInstance(String param1, String param2) {
        ClothingFragment fragment = new ClothingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.store_list, container, false);
        // Create a list of stores
        final ArrayList<StoreInfo> stores = new ArrayList<StoreInfo>();
        stores.add(new StoreInfo(R.string.clothing_ardene, R.string.store_hours_9am_to_9pm,122));
        stores.add(new StoreInfo(R.string.clothing_wearhouse_one, R.string.store_hours_9am_to_9pm,123));
        stores.add(new StoreInfo(R.string.clothing_reitmans, R.string.store_hours_9am_to_9pm,125));
        stores.add(new StoreInfo(R.string.clothing_marks_clothing, R.string.store_hours_9am_to_9pm,205));
        // Create an {@link StoreInfoAdapter}, whose data source is a list of {@link StoreInfo}s. The
        // adapter knows how to create list items for each item in the list.
        StoreInfoAdapter adapter = new StoreInfoAdapter(getActivity(), stores);
        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // store_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.storelist);
        // Make the {@link ListView} use the {@link StoreInfoAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link StoreInfo} in the list.
        listView.setAdapter(adapter);
        // Set a click listener to open a custom made map image when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //When Item is click, note store address and pass it onto the next intent
                int store = stores.get(position).getStoreAddress();
                Intent locationIntent = new Intent(getActivity(), PickedStoreLocationActivity.class);
                locationIntent.putExtra("Address",store);
                startActivity(locationIntent);
            }
        });
        return rootView;
    }
}
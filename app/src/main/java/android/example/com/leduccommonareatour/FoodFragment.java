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
 * Use the {@link FoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FoodFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodFragment newInstance(String param1, String param2) {
        FoodFragment fragment = new FoodFragment();
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
        // Create a list of words
        final ArrayList<StoreInfo> stores = new ArrayList<StoreInfo>();
        stores.add(new StoreInfo(R.string.food_dairy_queen, R.string.store_hours_10am_to_10pm,111));
        stores.add(new StoreInfo(R.string.food_tim_hortons, R.string.store_hours_6am_to_11pm,112));
        stores.add(new StoreInfo(R.string.food_subway, R.string.store_hours_6am_to_11pm,113));
        stores.add(new StoreInfo(R.string.food_m_and_m_food, R.string.store_hours_10am_to_6pm,115));
        stores.add(new StoreInfo(R.string.food_edo_japan, R.string.store_hours_11am_to_10pm,127));
        stores.add(new StoreInfo(R.string.food_mucho_baritos, R.string.store_hours_11am_to_10pm,130));
        stores.add(new StoreInfo(R.string.food_rickys_all_day_grill, R.string.store_hours_11am_to_10pm,131));
        stores.add(new StoreInfo(R.string.food_cobs_bread_bakery, R.string.store_hours_6am_to_8pm,133));
        stores.add(new StoreInfo(R.string.food_dominos_pizza, R.string.store_hours_10am_to_10pm,134));
        stores.add(new StoreInfo(R.string.food_booster_juice, R.string.store_hours_7am_to_9pm,135));
        stores.add(new StoreInfo(R.string.food_original_joes, R.string.store_hours_11am_to_2am,140));
        stores.add(new StoreInfo(R.string.food_the_chopped_leaf, R.string.store_hours_11am_to_9pm,142));
        stores.add(new StoreInfo(R.string.food_phoxpress, R.string.store_hours_11am_to_9pm,145));
        stores.add(new StoreInfo(R.string.food_ace_liquor, R.string.store_hours_11am_to_2am,203));
        stores.add(new StoreInfo(R.string.food_the_canadian_brewhouse, R.string.store_hours_11am_to_2am,207));
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
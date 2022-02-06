package android.example.com.leduccommonareatour;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.core.content.ContextCompat;

public class StoreInfoAdapter extends ArrayAdapter<android.example.com.leduccommonareatour.StoreInfo>{
    /**
     * Create a new {@link StoreInfoAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param stores is the list of {@link StoreInfo}s to be displayed.
     *
     */
    public StoreInfoAdapter(Context context, ArrayList<android.example.com.leduccommonareatour.StoreInfo> stores) {
        super(context, 0, stores);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link StoreInfo} object located at this position in the list
        android.example.com.leduccommonareatour.StoreInfo currentStore = getItem(position);
        // Find the TextView in the list_item.xml layout with the ID store_name_text_view.
        TextView storeNameTextView = (TextView) listItemView.findViewById(R.id.store_name_text_view);
        // Get the store name from the currentStore object and set this text on
        // the Store name TextView.
        storeNameTextView.setText(currentStore.getStoreName());
        // Find the TextView in the list_item.xml layout with the ID store_address_text_view.
        TextView storeAddressTextView = (TextView) listItemView.findViewById(R.id.store_address_text_view);
        // Create a new local string that gets the store address from the currentStore object, appends it with the street name
        // and set this text on the store address TextView.
        String longAddress = currentStore.getStoreAddress() + " " +
                getContext().getResources().getString(R.string.street_name_discover_way_leduc);
        storeAddressTextView.setText(longAddress);
        // Find the TextView in the list_item.xml layout with the ID store_hours_text_view.
        TextView storeHoursTextView = (TextView) listItemView.findViewById(R.id.store_hours_text_view);
        // Get the store hours from the currentStore object and set this text on
        // the store hours TextView.
        storeHoursTextView.setText(currentStore.getStoreHours());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.store_logo_image);
        // Check if an image is provided for this word or not
        if (currentStore.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentStore.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }
        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}

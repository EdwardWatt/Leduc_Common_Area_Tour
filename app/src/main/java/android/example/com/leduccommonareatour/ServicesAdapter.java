package android.example.com.leduccommonareatour;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
public class ServicesAdapter extends FragmentPagerAdapter{
    private Context mContext;
    public ServicesAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }
    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new DepartmentFragment();
        } else if (position == 1) {
            return new HealthFragment();
        } else if (position == 2) {
            return new ClothingFragment();
        } else if (position == 3) {
            return new FoodFragment();
        } else {
            return new SpecialtyFragment();
        }
    }
    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 5;
    }
    /**
     * Return Title of page.
     */
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.services_department);
        } else if (position == 1) {
            return mContext.getString(R.string.services_health);
        } else if (position == 2) {
            return mContext.getString(R.string.services_clothing);
        } else if (position == 3) {
            return mContext.getString(R.string.services_food);
        } else {
            return mContext.getString(R.string.services_specialty);
        }
    }
}

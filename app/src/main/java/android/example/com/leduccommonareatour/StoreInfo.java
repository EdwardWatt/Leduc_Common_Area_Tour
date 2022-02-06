package android.example.com.leduccommonareatour;

public class StoreInfo {
    /** String resource ID for the store name */
    private int mStoreName;
    /** String resource ID for the store hours */
    private int mStoreHours;
    /** String resource ID for the store address */
    private int mStoreAddress;
    /** Image resource ID for the word */
    private int mStoreImageResourceId = NO_IMAGE_PROVIDED;
    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;
    /**
     * Create a new StoreInfo object.
     *
     * @param StoreName is the string resource ID for the store name
     * @param StoreHours is the string resource Id for the store hours
     *
     */
    public StoreInfo(int StoreName, int StoreHours, int StoreAddress) {
        mStoreName = StoreName;
        mStoreHours = StoreHours;
        mStoreAddress = StoreAddress;
    }
    /**
     * Create a new Word object.
     *
     * @param StoreName is the string resource ID for the store name
     * @param StoreAddress is the string resource Id for the Store Address
     * @param storeImageResourceId is the drawable resource ID for the image associated with store listing
     */
    public StoreInfo(int StoreName, int StoreHours, int StoreAddress, int storeImageResourceId) {
        mStoreName = StoreName;
        mStoreHours = StoreHours;
        mStoreAddress = StoreAddress;
        mStoreImageResourceId = storeImageResourceId;
    }
    /**
     * Get the string resource ID for the store name.
     */
    public int getStoreName() {
        return mStoreName;
    }
    /**
     * Get the string resource ID for the store address.
     */
    public int getStoreAddress() {
        return mStoreAddress;
    }
    /**
     * Get the string resource ID for the store hours.
     */
    public int getStoreHours() {
        return mStoreHours;
    }
    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mStoreImageResourceId;
    }
    /**
     * Returns whether or not there is an image for this store.
     */
    public boolean hasImage() {
        return mStoreImageResourceId != NO_IMAGE_PROVIDED;
    }
}

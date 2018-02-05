package com.example.inventory.data.provider;

import android.net.Uri;

/**
 * Created by usuario on 5/02/18.
 */

public final class InventoryProviderContract {

    public static final String AUTHORITY = "com.example.inventory";
    public static final Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY);

}

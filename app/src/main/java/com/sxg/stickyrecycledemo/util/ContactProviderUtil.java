package com.sxg.stickyrecycledemo.util;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.sxg.stickyrecycledemo.entity.MobileContactEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：联系人提供者
 * Created by sxg on 2018/4/12.
 */

public class ContactProviderUtil {

    public static List<MobileContactEntity> queryContact(Context context) {
        ArrayList<MobileContactEntity> list = new ArrayList<>();

        Cursor cursor = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null, null, null, null);
        if (cursor == null) {
            return list;
        }
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            MobileContactEntity entity = new MobileContactEntity(name, number);
            list.add(entity);
        }
        cursor.close();
        return list;
    }
}

package com.example.mx.weddingplanner;

import android.database.MatrixCursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import java.util.LinkedList;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.*;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.*;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Build;
import android.widget.Button;
import android.support.v4.content.ContextCompat;
import android.widget.EditText;
import android.content.Intent;
import android.util.Log;
import android.Manifest;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.widget.Toast;
import android.net.Uri;
import android.view.View;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.zip.Inflater;
public class AddPeople extends AppCompatActivity {
    SimpleCursorAdapter mAdapter;
    LayoutInflater mInflater;
    MatrixCursor mMatrixCursor;RecyclerView mRecyclerView;
    private static final int PERMISSION_REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_people);
      //  Log.d("hakjf","hallo");
        mMatrixCursor = new MatrixCursor(new String[] { "_id", "name","details" });
        mAdapter = new SimpleCursorAdapter( getBaseContext(),R.layout.single_person,null,new String[]{ "name","details" }, new int[] { R.id.tv_name,R.id.tv_details }, 0);
        ListView lstContacts = (ListView) findViewById(R.id.lst_contacts);
        lstContacts.setAdapter(mAdapter);
        ListViewContactsLoader listViewContactsLoader = new ListViewContactsLoader();
        listViewContactsLoader.execute();
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkPermission()) {
                Log.e("permission", "Permission already granted.");
            } else {
                requestPermission();
            }
        }
    }
    public boolean checkPermission() {
        int CallPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE);
        return CallPermissionResult == PackageManager.PERMISSION_GRANTED;
    }
    private void requestPermission() {
        ActivityCompat.requestPermissions(AddPeople.this, new String[]
                { Manifest.permission.CALL_PHONE}, PERMISSION_REQUEST_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                CardView callButton = findViewById(R.id.card_view);
                if (grantResults.length > 0) {
                    boolean CallPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (CallPermission ) {
                        Toast.makeText(AddPeople.this,"Permission accepted", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(AddPeople.this,"Permission denied", Toast.LENGTH_LONG).show();
                        callButton.setEnabled(false);
                    }
                    break;
                }
        }
    }
    public void call(View view)
    {
        final TextView phoneNumber =  findViewById(R.id.tv_details);
        String phoneNum = phoneNumber.getText().toString();
        if(!TextUtils.isEmpty(phoneNum)) {
            String dial = "tel:" + phoneNum;
            startActivity(new Intent(Intent.ACTION_CALL,Uri.parse(dial)));
        }else {
            Toast.makeText(AddPeople.this, "Please enter a valid telephone number", Toast.LENGTH_SHORT).show();
        }
    }
    private class ListViewContactsLoader extends AsyncTask<Void, Void, Cursor> {
        @Override
        protected Cursor doInBackground(Void... params) {
            Uri contactsUri = ContactsContract.Contacts.CONTENT_URI;
            Cursor contactsCursor = getContentResolver().query(contactsUri,
                                    null, null, null,
                                    ContactsContract.Contacts.DISPLAY_NAME + " ASC ");
            if (contactsCursor.moveToFirst()) {
                do {
                    long contactId = contactsCursor.getLong(contactsCursor.getColumnIndex("_ID"));
                    Uri dataUri = ContactsContract.Data.CONTENT_URI;
                    Cursor dataCursor = getContentResolver().query(dataUri,null,
                                        ContactsContract.Data.CONTACT_ID + "=" + contactId,
                                        null, null);
                    String displayName = "";
                    String nickName = "";
                    String homePhone = "";
                    String mobilePhone = "";
                    String workPhone = "";
                    String photoPath = "" + R.drawable.ic_launcher_background;
                    byte[] photoByte = null;
                    String homeEmail = "";
                    String workEmail = "";
                    String companyName = "";
                    String title = "";
                    if (dataCursor.moveToFirst()) {
                        displayName = dataCursor
                                .getString(dataCursor
                                        .getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
                        do {
                            if (dataCursor
                                    .getString(dataCursor.getColumnIndex("mimetype"))
                                    .equals(ContactsContract.CommonDataKinds.Nickname.CONTENT_ITEM_TYPE))
                                nickName = dataCursor.getString(dataCursor
                                        .getColumnIndex("data1"));
                            if (dataCursor
                                    .getString(
                                            dataCursor
                                                    .getColumnIndex("mimetype"))
                                    .equals(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)) {
                                switch (dataCursor.getInt(dataCursor
                                        .getColumnIndex("data2"))) {
                                    case ContactsContract.CommonDataKinds.Phone.TYPE_HOME:
                                        homePhone = dataCursor.getString(dataCursor
                                                .getColumnIndex("data1"));
                                        break;
                                    case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
                                        mobilePhone = dataCursor
                                                .getString(dataCursor
                                                        .getColumnIndex("data1"));
                                        break;
                                    case ContactsContract.CommonDataKinds.Phone.TYPE_WORK:
                                        workPhone = dataCursor.getString(dataCursor
                                                .getColumnIndex("data1"));
                                        break;
                                }
                            }
                            if (dataCursor
                                    .getString(
                                            dataCursor
                                                    .getColumnIndex("mimetype"))
                                    .equals(ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)) {
                                switch (dataCursor.getInt(dataCursor
                                        .getColumnIndex("data2"))) {
                                    case ContactsContract.CommonDataKinds.Email.TYPE_HOME:
                                        homeEmail = dataCursor.getString(dataCursor
                                                .getColumnIndex("data1"));
                                        break;
                                    case ContactsContract.CommonDataKinds.Email.TYPE_WORK:
                                        workEmail = dataCursor.getString(dataCursor
                                                .getColumnIndex("data1"));
                                        break;
                                }
                            }
                        } while (dataCursor.moveToNext());
                        String details = "";
                        if (homePhone != null && !homePhone.equals(""))
                            details = "HomePhone : " + homePhone + "\n";
                        if (mobilePhone != null && !mobilePhone.equals(""))
                            details += "MobilePhone : " + mobilePhone + "\n";
                        if (workPhone != null && !workPhone.equals(""))
                            details += "WorkPhone : " + workPhone + "\n";
                        if (nickName != null && !nickName.equals(""))
                            details += "NickName : " + nickName + "\n";
                        if (homeEmail != null && !homeEmail.equals(""))
                            details += "HomeEmail : " + homeEmail + "\n";
                        if (workEmail != null && !workEmail.equals(""))
                            details += "WorkEmail : " + workEmail + "\n";
                        if (companyName != null && !companyName.equals(""))
                            details += "CompanyName : " + companyName + "\n";
                        if (title != null && !title.equals(""))
                            details += "Title : " + title + "\n";
                        mMatrixCursor.addRow(new Object[] {
                                Long.toString(contactId), displayName,  details });
                    }

                } while (contactsCursor.moveToNext());
            }
            return mMatrixCursor;
        }@Override
        protected void onPostExecute(Cursor result) {
            mAdapter.swapCursor(result);
        }
    }




}

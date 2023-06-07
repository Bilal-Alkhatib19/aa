package com.zeeshan.final_p;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import kotlin.collections.ArrayDeque;

public class DataBases extends SQLiteOpenHelper {

    public static final String NAMEDATABASE = "Prodact";
    private static final int VERSION = 7;

    public DataBases(Context context) {
        super(context, NAMEDATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ProdctItem (id Integer primary KEY autoincrement ," +
                " name TEXT , price TEXT , qun TEXT , dic TEXT ,image BLOB )");


        db.execSQL("CREATE TABLE Cart (id Integer primary KEY autoincrement ," +
                " name TEXT , price TEXT , quntity TEXT  ,image BLOB )");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop TABLE IF EXISTS ProdctItem ");
        onCreate(db);

    }

    public boolean insertItem(ProdctModel model) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", model.getName());
        values.put("price", model.getPrice());
        values.put("qun", model.getQun());
        values.put("dic", model.getDic());
        byte[] imgBytes = convertBitmapTpByteArray(model.getImage());
        values.put("image", imgBytes);
        Log.e("TAG", "insertItem: " + model);
        long re = database.insert("ProdctItem", null, values);
        return re != -1;
    }


    public boolean insertCart(Cart_Modle model) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", model.getName_cart());
        values.put("price", model.getPrice_cart());
        values.put("quntity", model.getQuntity_cart());
        byte[] imgBytes = convertBitmapTpByteArray(model.getImage_cart());
        values.put("image", imgBytes);
        long re = database.insert("Cart", null, values);
        return re != -1;
    }

    public ArrayList<ProdctModel> getItem() {
        SQLiteDatabase database = this.getReadableDatabase();
        ArrayList<ProdctModel> prodctModels = new ArrayList<>();
        boolean flag = false;
        Cursor cursor = database.rawQuery("Select * From ProdctItem ", null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
            String price = cursor.getString(cursor.getColumnIndexOrThrow("price"));
            String qun = cursor.getString(cursor.getColumnIndexOrThrow("qun"));
            String dic = cursor.getString(cursor.getColumnIndexOrThrow("dic"));
            byte[] img = cursor.getBlob(cursor.getColumnIndexOrThrow("image"));
            Bitmap imgBytes = convertByteArrayToBitmap(img);

            ProdctModel model = new ProdctModel(name, price, qun, dic, imgBytes);
            prodctModels.add(model);
            flag = true;
        }
        if (flag)
            return prodctModels;
        else
            return null;
    }

    //هذا لشاشة التعديل
    public boolean updateProduct(ProdctModel product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", product.getId());
        cv.put("name", product.getName());
        cv.put("price", product.getPrice());
        cv.put("dic", product.getDic());
        cv.put("qun", product.getQun());
        byte[] imgBytes = convertBitmapTpByteArray(product.getImage());
        cv.put("image", imgBytes);
        Log.e("TAG", "updateProduct: " + product.getId());
        int result = db.update("ProdctItem", cv, "id" + " = ? ", new String[]{String.valueOf(product.getId())});
        return result > 0;
    }

    public Cursor getCart() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("Select * From Cart ",null,null);
        return cursor;
    }

    public  byte[] convertBitmapTpByteArray(Bitmap bitmap){
        ByteArrayOutputStream outputStream =new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,0,outputStream);
        return outputStream.toByteArray();
    }
    public  Bitmap convertByteArrayToBitmap(byte[]bytes){
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length);
    }

}


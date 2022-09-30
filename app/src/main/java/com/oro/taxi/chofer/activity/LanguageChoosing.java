package com.oro.taxi.chofer.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.oro.taxi.chofer.R;
import com.oro.taxi.chofer.adapter.LanguageAdapter;
import com.oro.taxi.chofer.model.LanguagePojo;
import com.oro.taxi.chofer.onclick.ClickListener;
import com.oro.taxi.chofer.onclick.RecyclerTouchListener;
import com.oro.taxi.chofer.settings.LocaleManager;
import com.oro.taxi.chofer.settings.PrefManager;

import java.util.ArrayList;
import java.util.List;

public class LanguageChoosing extends BaseActivity {

    private RecyclerView recycler_view_language;
    private List<LanguagePojo> albumList_language;
    private LanguageAdapter adapter_language;
    private FloatingActionButton button_next;
    String lang = "";
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Checking for first time launch - before calling setContentView()
        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch1()) {
            launchHomeScreen();
            finish();
        }

        // Making notification bar transparent
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_language_choosing);

        albumList_language = new ArrayList<>();
        adapter_language = new LanguageAdapter(this, albumList_language, this);

        button_next = (FloatingActionButton) findViewById(R.id.button_next);
        recycler_view_language = (RecyclerView) findViewById(R.id.recycler_view_langue);
        @SuppressLint("WrongConstant") LinearLayoutManager horizontalLayoutManagerGarde = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler_view_language.setLayoutManager(horizontalLayoutManagerGarde);
        recycler_view_language.setItemAnimator(new DefaultItemAnimator());
        recycler_view_language.setAdapter(adapter_language);
        recycler_view_language.addOnItemTouchListener(new RecyclerTouchListener(this, recycler_view_language, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                LanguagePojo languagePojo = albumList_language.get(position);
                lang = languagePojo.getName();
            }

            @Override
            public void onLongClick(View view, int position) {
                LanguagePojo languagePojo = albumList_language.get(position);
                lang = languagePojo.getName();
            }
        }));

        setLanguage();
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!lang.equals("")){
                    switch (lang){
                        case "Français": setNewLocale(LanguageChoosing.this, LocaleManager.FRANCAIS); break;
                        case "中文": setNewLocale(LanguageChoosing.this, LocaleManager.CHINA); break;
                        case "日本人": setNewLocale(LanguageChoosing.this, LocaleManager.JAPAN); break;
                        case "عرب": setNewLocale(LanguageChoosing.this, LocaleManager.ARABIC); break;
                        case "भारतीय": setNewLocale(LanguageChoosing.this, LocaleManager.HINDI); break;
                        case "বাংলাদেশ": setNewLocale(LanguageChoosing.this, LocaleManager.BANGLADESH); break;
                        case "Deutschland": setNewLocale(LanguageChoosing.this, LocaleManager.GERMANY); break;
                        case "대한민국": setNewLocale(LanguageChoosing.this, LocaleManager.KOREA); break;
                        case "Portugal": setNewLocale(LanguageChoosing.this, LocaleManager.PORTUGAL); break;
                        case "Россия": setNewLocale(LanguageChoosing.this, LocaleManager.RUSSIA); break;
                        case "Español": setNewLocale(LanguageChoosing.this, LocaleManager.SPANISH); break;
                        default: setNewLocale(LanguageChoosing.this, LocaleManager.ENGLISH); break;
                    }
                    launchHomeScreen();
                    finish();
                }else{
                    Toast.makeText(LanguageChoosing.this, getResources().getString(R.string.please_select_a_language), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void launchHomeScreen() {
        prefManager.setFirstTimeLaunch1(false);
        startActivity(new Intent(LanguageChoosing.this, IntroActivity.class));
        finish();
    }

    private void setNewLocale(AppCompatActivity mContext, @LocaleManager.LocaleDef String language) {
        LocaleManager.setNewLocale(this, language);
        Intent intent = mContext.getIntent();
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
    }

    private void setLanguage(){
        lang = "Español";
        albumList_language.add(new LanguagePojo(1,"English", getResources().getDrawable(R.drawable.ic_uk), "no"));
        albumList_language.add(new LanguagePojo(2,"Français", getResources().getDrawable(R.drawable.ic_france), "no"));
        albumList_language.add(new LanguagePojo(3,"中文", getResources().getDrawable(R.drawable.ic_china), "no"));
        albumList_language.add(new LanguagePojo(4,"日本人", getResources().getDrawable(R.drawable.ic_japan), "no"));
        albumList_language.add(new LanguagePojo(5,"عرب", getResources().getDrawable(R.drawable.ic_saudi_arabia), "no"));
        albumList_language.add(new LanguagePojo(6,"भारतीय", getResources().getDrawable(R.drawable.ic_india), "no"));
        albumList_language.add(new LanguagePojo(7,"Español", getResources().getDrawable(R.drawable.ic_spain), "yes"));
        albumList_language.add(new LanguagePojo(8,"বাংলাদেশ", getResources().getDrawable(R.drawable.ic_bangladesh), "no"));
        albumList_language.add(new LanguagePojo(9,"Deutschland", getResources().getDrawable(R.drawable.ic_germany), "no"));
        albumList_language.add(new LanguagePojo(10,"대한민국", getResources().getDrawable(R.drawable.ic_north_korea), "no"));
        albumList_language.add(new LanguagePojo(11,"Portugal", getResources().getDrawable(R.drawable.ic_portugal), "no"));
        albumList_language.add(new LanguagePojo(12,"Россия", getResources().getDrawable(R.drawable.ic_russia), "no"));

        adapter_language.notifyDataSetChanged();
    }
}

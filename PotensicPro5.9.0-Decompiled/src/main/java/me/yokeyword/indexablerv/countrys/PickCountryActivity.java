package me.yokeyword.indexablerv.countrys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.github.promeg.pinyinhelper.Pinyin;
import com.github.promeg.tinypinyin.lexicons.android.cncity.CnCityDict;
import com.ipotensic.baselib.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;
import me.yokeyword.indexablerecyclerview.R;
import me.yokeyword.indexablerv.EntityWrapper;
import me.yokeyword.indexablerv.IndexableAdapter;
import me.yokeyword.indexablerv.IndexableLayout;

/* loaded from: classes4.dex */
public class PickCountryActivity extends BaseActivity {
    private CityAdapter adapter;
    private ArrayList<CityEntity> allCountries = new ArrayList<>();
    private ArrayList<CityEntity> emptyEntities = new ArrayList<>();
    private IndexableLayout indexableLayout;
    private List<CityEntity> mData;
    private SearchFragment mSearchFragment;
    private SearchView mSearchView;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_pick_country);
        setToolBar();
        initView();
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setHomeButtonEnabled(false);
        supportActionBar.setDisplayHomeAsUpEnabled(false);
        toolbar.findViewById(R.id.btn_return).setOnClickListener(new View.OnClickListener() { // from class: me.yokeyword.indexablerv.countrys.PickCountryActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PickCountryActivity.this.finish();
            }
        });
    }

    private void initView() {
        this.mSearchFragment = (SearchFragment) getSupportFragmentManager().findFragmentById(R.id.search_fragment);
        this.indexableLayout = (IndexableLayout) findViewById(R.id.indexableLayout);
        SearchView searchView = (SearchView) findViewById(R.id.searchview);
        this.mSearchView = searchView;
        searchView.findViewById(R.id.search_plate).setBackground(null);
        this.mSearchView.findViewById(R.id.submit_area).setBackground(null);
        ((TextView) this.mSearchView.findViewById(R.id.search_src_text)).setTextSize(2, 16.0f);
        this.indexableLayout.setLayoutManager(new LinearLayoutManager(this));
        Pinyin.init(Pinyin.newConfig().with(CnCityDict.getInstance(this)));
        this.indexableLayout.setCompareMode(0);
        CityAdapter cityAdapter = new CityAdapter(this);
        this.adapter = cityAdapter;
        this.indexableLayout.setAdapter(cityAdapter);
        List<CityEntity> initData = initData();
        this.mData = initData;
        this.adapter.setDatas(initData, new IndexableAdapter.IndexCallback<CityEntity>() { // from class: me.yokeyword.indexablerv.countrys.PickCountryActivity.2
            @Override // me.yokeyword.indexablerv.IndexableAdapter.IndexCallback
            public void onFinished(List<EntityWrapper<CityEntity>> list) {
                PickCountryActivity.this.mSearchFragment.bindDatas(PickCountryActivity.this.mData, PickCountryActivity.this);
            }
        });
        this.adapter.setOnItemContentClickListener(new IndexableAdapter.OnItemContentClickListener<CityEntity>() { // from class: me.yokeyword.indexablerv.countrys.PickCountryActivity.3
            @Override // me.yokeyword.indexablerv.IndexableAdapter.OnItemContentClickListener
            public void onItemClick(View view, int i, int i2, CityEntity cityEntity) {
                Intent intent = new Intent();
                intent.putExtra("country_code", cityEntity.getCode());
                intent.putExtra("country_name", cityEntity.getName());
                PickCountryActivity.this.setResult(-1, intent);
                PickCountryActivity.this.finish();
            }
        });
        this.indexableLayout.addHeaderAdapter(new BannerHeaderAdapter(this, "", getString(R.string.hot_country), initHotCityData()));
        initSearch();
    }

    private List<CityEntity> initData() {
        this.allCountries.clear();
        this.allCountries.addAll(CityEntity.getAll(this));
        return this.allCountries;
    }

    private List<CityEntity> initHotCityData() {
        this.emptyEntities.add(new CityEntity(0, ""));
        return this.emptyEntities;
    }

    private void initSearch() {
        getSupportFragmentManager().beginTransaction().hide(this.mSearchFragment).commit();
        this.mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: me.yokeyword.indexablerv.countrys.PickCountryActivity.4
            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextSubmit(String str) {
                return false;
            }

            @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
            public boolean onQueryTextChange(String str) {
                if (str.trim().length() > 0) {
                    if (PickCountryActivity.this.mSearchFragment.isHidden()) {
                        PickCountryActivity.this.getSupportFragmentManager().beginTransaction().show(PickCountryActivity.this.mSearchFragment).commit();
                    }
                } else if (!PickCountryActivity.this.mSearchFragment.isHidden()) {
                    PickCountryActivity.this.getSupportFragmentManager().beginTransaction().hide(PickCountryActivity.this.mSearchFragment).commit();
                }
                PickCountryActivity.this.mSearchFragment.bindQueryText(str);
                return false;
            }
        });
    }
}

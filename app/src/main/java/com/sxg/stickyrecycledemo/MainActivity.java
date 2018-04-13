package com.sxg.stickyrecycledemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sxg.stickyrecycledemo.adapter.ContactAdapter;
import com.sxg.stickyrecycledemo.entity.MobileContactEntity;
import com.sxg.stickyrecycledemo.util.ContactProviderUtil;
import com.sxg.stickyview.StickyItemDecoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CONTACT = 0;
    private RecyclerView mRecycleView;

    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = findViewById(R.id.recycle);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
//        RecycleAdapter adapter=new RecycleAdapter();
//        mRecycleView.setAdapter(adapter);
//        mRecycleView.addItemDecoration(new StickyItemDecoration(adapter));
//        adapter.setmList(getData());


        adapter = new ContactAdapter();
        mRecycleView.setAdapter(adapter);
        mRecycleView.addItemDecoration(new StickyItemDecoration(adapter));
        if (checkPermission()) {
            initContact();
        }

    }


    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CONTACT);
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    private void initContact() {
        List<MobileContactEntity> list = ContactProviderUtil.queryContact(this);
        //排序
        Collections.sort(list, new Comparator<MobileContactEntity>() {
            @Override
            public int compare(MobileContactEntity o1, MobileContactEntity o2) {
                try {
                    if (o1.latter.equals(o2.latter)) {
                        return o1.name.compareTo(o2.name);
                    } else {
                        if ("#".equals(o1.latter)) {
                            return 1;
                        } else if ("#".equals(o2.latter)) {
                            return -1;
                        }
                        return o1.latter.compareTo(o2.latter);
                    }
                } catch (Exception e) {
                    return -1;
                }

            }


        });


        adapter.setList(list);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CONTACT) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initContact();
            }
        }
    }

    private List<TextBean> getData() {
        List<TextBean> TextBeans = new ArrayList<>();

        TextBean TextBean = new TextBean("香港明星", 0);
        TextBeans.add(TextBean);

        TextBean ldh = new TextBean("刘德华", 10);
        TextBeans.add(ldh);
        TextBean zxy = new TextBean("张学友", 10);
        TextBeans.add(zxy);
        TextBean zrf = new TextBean("周润发", 10);
        TextBeans.add(zrf);
        TextBean lcw = new TextBean("梁朝伟", 10);
        TextBeans.add(lcw);
        TextBean wyj = new TextBean("吴毅将", 10);
        TextBeans.add(wyj);
        TextBean lm = new TextBean("黎明", 10);
        TextBeans.add(lm);
        TextBean cgx = new TextBean("陈冠希", 10);
        TextBeans.add(cgx);
        TextBean gfc = new TextBean("郭富城", 10);
        TextBeans.add(gfc);
        TextBean xtf = new TextBean("谢霆锋", 10);
        TextBeans.add(xtf);

        TextBean TextBeanTw = new TextBean("台湾明星：指的是中国台湾的一些有名气的电影，电视演员和歌手，他们具有很高的人气，成名时间早，成名时间久", 0);
        TextBeans.add(TextBeanTw);

        TextBean rxq = new TextBean("任贤齐", 10);
        TextBeans.add(rxq);
        TextBean mtw = new TextBean("孟庭苇", 10);
        TextBeans.add(mtw);
        TextBean ldy = new TextBean("罗大佑", 10);
        TextBeans.add(ldy);
        TextBean lzs = new TextBean("李宗盛", 10);
        TextBeans.add(lzs);
        TextBean xc = new TextBean("小虫", 10);
        TextBeans.add(xc);
        TextBean zhj = new TextBean("周华健", 10);
        TextBeans.add(zhj);
        TextBean zhl = new TextBean("周杰伦", 10);
        TextBeans.add(zhl);

        TextBean TextBeanNl = new TextBean("内陆明星", 0);
        TextBeans.add(TextBeanNl);
        TextBeans.add(TextBeanNl);

        TextBean lh = new TextBean("鹿晗", 10);
        TextBeans.add(lh);
        TextBean wzw = new TextBean("王志文", 10);
        TextBeans.add(wzw);
        TextBean yq = new TextBean("羽泉", 10);
        TextBeans.add(yq);
        TextBean lxl = new TextBean("李小璐", 10);
        TextBeans.add(lxl);
        TextBean hh = new TextBean("韩红", 10);
        TextBeans.add(hh);
        TextBean ny = new TextBean("那英", 10);
        TextBeans.add(ny);
        TextBean lhh = new TextBean("刘欢", 10);
        TextBeans.add(lhh);
        TextBean yk = new TextBean("杨坤", 10);
        TextBeans.add(yk);
        TextBean zj = new TextBean("周杰", 10);
        TextBeans.add(zj);

        TextBean TextBeanOm = new TextBean("美国明星", 0);
        TextBeans.add(TextBeanOm);
        TextBean mm = new TextBean("梅梅", 10);
        TextBeans.add(mm);
        TextBean ade = new TextBean("Gaga", 10);
        TextBeans.add(ade);
        TextBean hff = new TextBean("黑寡妇", 10);
        TextBeans.add(hff);
        TextBean xlz = new TextBean("小李子", 10);
        TextBeans.add(xlz);

        TextBean TextBeanNba = new TextBean("NBA明星", 0);
        TextBeans.add(TextBeanNba);
        TextBean xhd = new TextBean("小皇帝", 10);
        TextBeans.add(xhd);
        TextBean kb = new TextBean("科比", 10);
        TextBeans.add(kb);
        TextBean ym = new TextBean("姚明", 10);
        TextBeans.add(ym);
        TextBean md = new TextBean("麦迪", 10);
        TextBeans.add(md);
        TextBean dlt = new TextBean("杜兰特", 10);
        TextBeans.add(dlt);
        TextBean kl = new TextBean("库里", 10);
        TextBeans.add(kl);
        TextBean ouw = new TextBean("欧文", 10);
        TextBeans.add(ouw);
        TextBean qd = new TextBean("乔丹", 10);
        TextBeans.add(qd);
        TextBean alzw = new TextBean("奥拉朱旺", 10);
        TextBeans.add(alzw);
        TextBean pp = new TextBean("皮蓬", 10);
        TextBeans.add(pp);
        TextBean ldm = new TextBean("罗德曼", 10);
        TextBeans.add(ldm);
        TextBean ke = new TextBean("科尔", 10);
        TextBeans.add(ke);
        TextBean pesi = new TextBean("皮尔斯", 10);
        TextBeans.add(pesi);
        TextBean jnt = new TextBean("加内特", 10);
        TextBeans.add(jnt);
        TextBean lal = new TextBean("雷阿伦", 10);
        TextBeans.add(lal);
        TextBean zmg = new TextBean("字母哥", 10);
        TextBeans.add(zmg);
        TextBean adn = new TextBean("安东尼", 10);
        TextBeans.add(adn);

        TextBean TextBeanDy = new TextBean("导演", 0);
        TextBeans.add(TextBeanDy);
        TextBean jzk = new TextBean("贾樟柯", 10);
        TextBeans.add(jzk);
        TextBean ly = new TextBean("李杨", 10);
        TextBeans.add(ly);
        TextBean fxg = new TextBean("冯小刚", 10);
        TextBeans.add(fxg);
        TextBean lyy = new TextBean("娄烨", 10);
        TextBeans.add(lyy);
        TextBean zym = new TextBean("张艺谋", 10);
        TextBeans.add(zym);

        TextBean yjl = new TextBean("易建联", 0);
        TextBeans.add(yjl);

        TextBean wzz = new TextBean("王治郅", 0);
        TextBeans.add(wzz);


        return TextBeans;
    }
}

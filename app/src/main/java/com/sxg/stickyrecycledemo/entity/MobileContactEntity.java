package com.sxg.stickyrecycledemo.entity;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.TextView;

import com.github.promeg.pinyinhelper.Pinyin;

/**
 * 描述：手机联系人实体
 * Created by sxg on 2018/4/12.
 */

public class MobileContactEntity {
    /**
     * 名称
     */
    public String name;
    /**
     * 手机
     */
    public String mobile;
    /**
     * 首字母
     */
    public String latter;

    public MobileContactEntity(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
        if (!TextUtils.isEmpty(name)) {
            char first = name.charAt(0);
            if (Pinyin.isChinese(first)) {
                latter = Pinyin.toPinyin(first).substring(0,1);
            } else {
                latter = "#";
            }
        } else {
            //没有名称的时候用手机号当名称
            this.name = mobile;
            latter = "#";
        }
    }

}

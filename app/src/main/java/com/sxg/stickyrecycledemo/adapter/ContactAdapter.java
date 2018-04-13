package com.sxg.stickyrecycledemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sxg.stickyrecycledemo.R;
import com.sxg.stickyrecycledemo.entity.MobileContactEntity;
import com.sxg.stickyview.StickyView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：
 * Created by sxg on 2018/4/12.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.BaseHolder> implements StickyView {

    /**
     * 吸附View标签下标
     */
    private static final int STICKY_VIEW_TAG_INDEX = -1;
    /**
     * 第一次出现的View的布局
     */
    private static final int FIRST_TYPE = 1;
    private List<MobileContactEntity> list;

    /**
     * 存储第一个的下标
     */
    private Map<String,MobileContactEntity> map=new HashMap<>();

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewType == FIRST_TYPE ?
                new FirstVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_contact_first, parent, false)) :
                new NormalVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_contact_normal, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        MobileContactEntity entity=list.get(position);
        holder.onBind(entity);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    /**
     * 处理返回值
     */
    @Override
    public int getItemViewType(int position) {
        MobileContactEntity entity=list.get(position);
        MobileContactEntity first=map.get(entity.latter);
        if (entity.equals(first)) {
            return FIRST_TYPE;
        }
        return super.getItemViewType(position);
    }

    @Override
    public boolean isStickyView(View view) {
        return (boolean) view.getTag(STICKY_VIEW_TAG_INDEX);
    }

    @Override
    public int getStickViewType() {
        return FIRST_TYPE;
    }

    @Override
    public View getStickView(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof FirstVH) {
            return ((FirstVH) viewHolder).mTitle;
        }
        return null;
    }

    public void setList(List<MobileContactEntity> list) {
        for (MobileContactEntity entity : list) {
            if (!map.containsKey(entity.latter)) {
                map.put(entity.latter,entity);
            }
        }
        this.list = list;
        notifyDataSetChanged();
    }

    protected abstract class BaseHolder extends RecyclerView.ViewHolder {
        public BaseHolder(View itemView) {
            super(itemView);
            itemView.setTag(STICKY_VIEW_TAG_INDEX, isStickyView());
        }

        /**
         * 绑定数据
         */
        protected abstract void onBind(MobileContactEntity entity);

        /**
         * 是否是吸附View
         *
         * @return
         */
        public abstract boolean isStickyView();
    }

    /**
     * 第一次出现的VH
     */
    class FirstVH extends BaseHolder {
        private TextView mTitle;
        private TextView mContent;

        public FirstVH(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_title);
            mContent = itemView.findViewById(R.id.tv_content);
        }

        @Override
        protected void onBind(MobileContactEntity entity) {
            mTitle.setText(entity.latter);
            mContent.setText(entity.name);
        }

        @Override
        public boolean isStickyView() {
            return true;
        }
    }

    /**
     * 常规VH
     */
    class NormalVH extends BaseHolder {
        private TextView mContent;
        public NormalVH(View itemView) {
            super(itemView);
            mContent = itemView.findViewById(R.id.tv_content);
        }

        @Override
        protected void onBind(MobileContactEntity entity) {
            mContent.setText(entity.name);
        }

        @Override
        public boolean isStickyView() {
            return false;
        }
    }


}


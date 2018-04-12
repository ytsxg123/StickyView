package com.sxg.stickyrecycledemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sxg.stickyview.StickyView;

import java.util.List;

/**
 * 描述：
 * Created by sxg on 2018/3/27.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements StickyView {

    private List<TextBean> mList;

    /**
     * 吸附的ViewType
     */
    private final int STICK_TYPE = 0;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewType == STICK_TYPE ?
                new TitleVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_title, parent, false)) :
                new ContentVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_content, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TextBean bean = mList.get(position);
        if (holder instanceof ContentVH) {
            ((ContentVH) holder).bindData(bean);
        }
        if (holder instanceof TitleVH) {
            ((TitleVH) holder).bindData(bean);
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).type;
    }

    @Override
    public boolean isStickyView(View view) {
        return (boolean) view.getTag();
    }

    @Override
    public int getStickViewType() {
        return STICK_TYPE;
    }

    @Override
    public View getStickView(RecyclerView.ViewHolder vh) {
        if (vh instanceof TitleVH) {
            return ((TitleVH) vh).mTitle;
        }
        return null;
//        return vh.itemView;
    }

    public void setmList(List<TextBean> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    static class TitleVH extends RecyclerView.ViewHolder {

        //        private TextView mContent;
        private TextView mTitle;

        public TitleVH(View itemView) {
            super(itemView);
//            mContent = itemView.findViewById(R.id.tv_content);
            mTitle = itemView.findViewById(R.id.tv_title);
            itemView.setTag(true);
        }

        public void bindData(TextBean bean) {
//            mContent.setText(bean.name);
            mTitle.setText("标题" + bean.name);
        }

    }

    static class ContentVH extends RecyclerView.ViewHolder {

        private TextView mContent;

        public ContentVH(View itemView) {
            super(itemView);
            mContent = itemView.findViewById(R.id.tv_content);
            itemView.setTag(false);
        }

        public void bindData(TextBean performer) {
            mContent.setText(performer.name);
        }
    }
}


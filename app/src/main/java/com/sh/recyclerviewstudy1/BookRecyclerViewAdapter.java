package com.sh.recyclerviewstudy1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Author: SherlockShi
 * E-mail: sherlock_shi@163.com
 * Date:   2016-03-29 22:04
 * Description: 适配器
 */
public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookViewHolder> {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private String[] mBooks;

    public BookRecyclerViewAdapter(Context context, String[] mBooks) {
        this.mBooks = mBooks;
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 创建一个View
        View view = mLayoutInflater.inflate(R.layout.rv_item_book, parent, false);
        // 创建一个ViewHolder
        BookViewHolder bookViewHolder = new BookViewHolder(view);
        return bookViewHolder;
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        // 绑定数据到ViewHolder上
        holder.tvBook.setText(mBooks[position]);
    }

    @Override
    public int getItemCount() {
        // item数量
        return mBooks.length;
    }
}

package com.sh.recyclerviewstudy1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Author: SherlockShi
 * E-mail: sherlock_shi@163.com
 * Date:   2016-03-29 21:54
 * Description: ViewHolder
 */
public class BookViewHolder extends RecyclerView.ViewHolder {

    public TextView tvBook;

    public BookViewHolder(View view) {
        super(view);
        tvBook = (TextView) view.findViewById(R.id.tv_book);
    }
}

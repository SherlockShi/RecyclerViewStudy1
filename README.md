# 一、 前言
RecyclerView是谷歌V7包下新增的控件,用来替代ListView、GridView的使用.

#### 要点：
- LayoutManager：布局管理器,目前SDK中提供了三种自带的LayoutManager:
      LinearLayoutManager-----类似ListView
      GridLayoutManager-----类似GridView
      StaggeredGridLayoutManager-----瀑布流
- ItemDecoration：Item间的分割线样式
- ItemAnimator：Item增加、删除的动画
- 点击、长按事件：比较麻烦

# 二、开发环境
- IDE: Android Studio 2.0 Beta 6
- SDK: Android 23

# 三、使用
##### 配置：build.gradle
```java
dependencies {
    ...
    compile 'com.android.support:recyclerview-v7:23.1.1'
}
```

##### 主布局文件：activity_main.xml
```java
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
   xmlns:tools="http://schemas.android.com/tools"
   android:layout_width="match_parent"
   android:layout_height="match_parent"
   android:paddingBottom="@dimen/activity_vertical_margin"
   android:paddingLeft="@dimen/activity_horizontal_margin"
   android:paddingRight="@dimen/activity_horizontal_margin"
   android:paddingTop="@dimen/activity_vertical_margin"
   tools:context="com.sh.recyclerviewstudy1.MainActivity">
​
   <android.support.v7.widget.RecyclerView
       android:id="@+id/rv_book"
       android:layout_width="match_parent"
       android:layout_height="match_parent">
​
   </android.support.v7.widget.RecyclerView>
</RelativeLayout>
```

##### 子布局文件：rv_item_book.xml
```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
   android:layout_width="match_parent"
   android:layout_height="match_parent"
   android:padding="@dimen/activity_horizontal_margin"
   android:orientation="vertical">
​
   <TextView
       android:id="@+id/tv_book"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       android:textSize="16sp"/>
</LinearLayout>
```

##### ViewHolder文件：BookViewHolder
```java
public class BookViewHolder extends RecyclerView.ViewHolder {
​
   public TextView tvBook;
​
   public BookViewHolder(View view) {
       super(view);
       tvBook = (TextView) view.findViewById(R.id.tv_book);
   }
}
```
##### 适配器：BookRecyclerViewAdapter
```java
public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookViewHolder> {
​
   private LayoutInflater mLayoutInflater;
   private Context mContext;
   private String[] mBooks;
​
   public BookRecyclerViewAdapter(Context context, String[] mBooks) {
       this.mBooks = mBooks;
       this.mContext = context;
       mLayoutInflater = LayoutInflater.from(context);
   }
​
   @Override
   public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       // 创建一个View
       View view = mLayoutInflater.inflate(R.layout.rv_item_book, parent, false);
       // 创建一个ViewHolder
       BookViewHolder bookViewHolder = new BookViewHolder(view);
       return bookViewHolder;
   }
​
   @Override
   public void onBindViewHolder(BookViewHolder holder, int position) {
       // 绑定数据到ViewHolder上
       holder.tvBook.setText(mBooks[position]);
   }
​
   @Override
   public int getItemCount() {
       // item数量
       return mBooks.length;
   }
}
```
##### 主界面：MainActivity
```java
public class MainActivity extends AppCompatActivity {
    private RecyclerView rebook;
    private String[] mBooks = {"认知盈余", "和喜欢的一切在一起", "从0到1", "从你的全世界路过", "打工旅行", "番茄工作法图解"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        rvBook = (RecyclerView) findViewById(R.id.rv_book);

        // 1. 这里用线性显示,类似于ListView
        rvBook.setLayoutManager(new LinearLayoutManager(this));

        // 2. 这里用线性宫格显示,类似于GridView
//      rvBook.setLayoutManager(new GridLayoutManager(this, 2));

        // 3. 这里用线性宫格显示,类似于瀑布流
//      rvBook.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL));

        rvBook.setAdapter(new BookRecyclerViewAdapter(MainActivity.this, mBooks));
    }
}
```

# 四、总结
RecyclerView的另一个特点是标准化了 ViewHolder， 编写Adapter面向的是ViewHolder而不在是View了， 复用的逻辑被封装了， 写起来更加简单。

简书账号：SherlockShi
相应博文：http://www.jianshu.com/p/c3c6c81adfbc
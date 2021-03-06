package vn.needy.buyer.utils.binding;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.views.BannerSlider;
import vn.needy.buyer.database.sharedprf.SharedPrefsImpl;
import vn.needy.buyer.database.sharedprf.SharedPrefsKey;
import vn.needy.buyer.utils.ViewUtil;
import vn.needy.buyer.utils.image.CompressImage;

/**
 * Created by lion on 16/12/2017.
 */

public class BindingAdapters {

    private static final String TAG = BindingAdapters.class.getName();

    private BindingAdapters() {
        // No-op
    }

    /**
     * setAdapter For RecyclerView
     */
    @BindingAdapter({"recyclerAdapter"})
    public static void setAdapterForRecyclerView(RecyclerView recyclerView,
                                                 RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter("text")
    public static void setText(TextView view, int resId) {
        view.setText(resId);
    }

    @BindingAdapter("errorText")
    public static void setErrorText(EditText editText, String text) {
        editText.setError(text);
    }

    @BindingAdapter("htmlText")
    public static void setHtmlText(TextView textView, String text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY));
        } else {
            textView.setText(Html.fromHtml(text));
        }
    }

    @BindingAdapter("srcVector")
    public static void setSrcVector(ImageButton view, @DrawableRes int drawable) {
        view.setImageResource(drawable);
    }

    @BindingAdapter("srcDrawableRight")
    public static void setDrawableRightTextView(TextView view, int drawable) {
        view.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0);
    }

    @BindingAdapter("srcDrawableLeft")
    public static void setDrawableLeftTextView(TextView view, int drawable) {
        view.setCompoundDrawablesWithIntrinsicBounds(drawable, 0, 0, 0);
    }


    // for load image from path in device's storage
//    @BindingAdapter("srcPath")
//    public static void loadImagePath(final ImageView imageView, final String path) {
//        if (!TextUtils.isEmpty(path)) {
//            Bitmap bmp = BitmapFactory.decodeFile(path);
//            imageView.setImageBitmap(CompressImage.reduceSize(bmp,
//                    ViewUtil.dpToPx(imageView.getContext(), 100)));
//        }
//    }

    // for load image from Resource server (Python)
    @BindingAdapter("srcUri")
    public static void loadImageUri(ImageView imageView, String url) {
        // check image load from server
        if (url.contains("http")) {
            String token = SharedPrefsImpl.getInstance()
                    .get(SharedPrefsKey.ACCESS_TOKEN, String.class);

            GlideUrl gUri = new GlideUrl(url, new LazyHeaders.Builder()
                    .setHeader("Authorization", token).build());

            Glide.with(imageView.getContext())
                    .load(gUri).into(imageView);
        } else if (!TextUtils.isEmpty(url)) {
            // for image load from local
            Bitmap bmp = BitmapFactory.decodeFile(url);
            imageView.setImageBitmap(CompressImage.reduceSize(bmp,
                    ViewUtil.dpToPx(imageView.getContext(), 100)));
        }
    }

    @BindingAdapter("transformationMethod")
    public static void setTransformationMethod(EditText editText, TransformationMethod method) {
        editText.setTransformationMethod(method);
    }

    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView recyclerView,
                                        LayoutManagers.LayoutManagerFactory layoutManagerFactory) {
        recyclerView.setLayoutManager(layoutManagerFactory.create(recyclerView));
    }

    @BindingAdapter("bannersrc")
    public static void setBanners(BannerSlider bannerSlider, List<Banner> banners) {
        if (banners != null) {
            bannerSlider.setBanners(banners);
        }
    }

//    @BindingAdapter("inputType")
//    public static void setInputType(EditText editText, int inputType) {
//        if (inputType == DataType.NUMBER) {
//            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
//        } else {
//            editText.setInputType(InputType.TYPE_CLASS_TEXT);
//        }
//    }

    @BindingAdapter({"viewPagerAdater"})
    public static void setAdapterForViewPager(final ViewPager view, FragmentPagerAdapter pagerAdapter) {
       // final Wallet adapter = new MainActionsAdapter(view.getContext(), activity.getSupportFragmentManager());
        view.setAdapter(pagerAdapter);
    }

    @BindingAdapter("viewPager")
    public static void setViewPagerForTablayout(TabLayout tablayout , ViewPager viewPager){
        tablayout.setupWithViewPager(viewPager);
    }
}

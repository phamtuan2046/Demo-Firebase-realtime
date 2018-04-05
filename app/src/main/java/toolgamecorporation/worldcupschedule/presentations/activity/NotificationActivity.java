package toolgamecorporation.worldcupschedule.presentations.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.transition.Transition;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import org.jetbrains.annotations.Nullable;

import toolgamecorporation.worldcupschedule.R;

public class NotificationActivity extends BaseActivity {
    Context mContext = this;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_create_database);
        Button btn = (Button) findViewById(R.id.btnPush);
        img = (ImageView) findViewById(R.id.imgAvatar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNotificationMessage();
            }
        });
    }

    public void createNotification() {

    }

    public void showNotificationMessage() {
        String title = "tao la title";
        int icon = R.mipmap.ic_launcher;

        CharSequence boldTitle = Html.fromHtml("<b>" + title + "</b> ");
        String message = "tao la message";
        NotificationCompat.InboxStyle smallStyle = new NotificationCompat.InboxStyle();
        smallStyle.addLine(message);


        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.setSummaryText(message);
        bigPictureStyle.bigPicture(BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_launcher));


        Intent intent = new Intent("push_notification");
        PendingIntent resultPendingIntent =
                PendingIntent.getBroadcast(
                        mContext,
                        0,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        final NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        final int id = (int) System.currentTimeMillis();
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(
                mContext)
                .setContentTitle(boldTitle)
                .setContentIntent(resultPendingIntent)
                .setStyle(smallStyle)
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setOnlyAlertOnce(true)
                .setSmallIcon(R.mipmap.ic_launcher);
//                .setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_launcher));
        final Notification notification = builder.build();
        notificationManager.notify(id, notification);
        Glide.with(this)
                .load("https://cdn1.iconfinder.com/data/icons/freeline/32/bell_sound_notification_remind_reminder_ring_ringing_schedule-128.png")
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        notification.largeIcon = resource;
                        builder.setSound(null);
                        img.setImageBitmap(resource);
                        notificationManager.notify(id, notification);
                    }
                });


    }

}

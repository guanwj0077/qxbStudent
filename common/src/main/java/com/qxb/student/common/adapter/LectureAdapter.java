package com.qxb.student.common.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qxb.student.common.R;
import com.qxb.student.common.listener.MultiClickUtil;
import com.qxb.student.common.module.bean.LectureVideo;
import com.qxb.student.common.utils.GlideUtils;
import com.qxb.student.common.view.dialog.ToastUtils;

import java.util.List;

/**
 * @author: zjk9527
 * created on: 2018/8/1 17:50
 * description:
 */
public class LectureAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<LectureVideo> mList;
    private Context mContext;
    private static final int HEADER_VIEW_TYPE = 0;
    private static final int BODY_VIEW_TYPE = 1;
    private static final int FOOTER_VIEW_TYPE = 2;
    public static final int headerCount = 1;
    public static final int footerCount = 1;
    private OnItemClickListener mItemClickListener;
    private OnFooterClickListener mFooterClickListener;

    private int scan_num = 0;
    private HeaderViewHolder mHeaderViewHolder;
    private BodyViewHolder mBodyViewHolder;
    private FooterViewHolder mFooterViewHolder;

    public LectureAdapter(Context mContext, List<LectureVideo> list) {
        this.mContext = mContext;
        this.mList = list;
    }

    public interface OnItemClickListener {
        void onItemClick(int position, LectureVideo mLectureVideo);

        void onLongItemClick(View view, int position, LectureVideo mLectureVideo);
    }

    public interface OnFooterClickListener {
        void onFooterClick(View view, LectureVideo mLectureVideo);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setOnFooterClickListener(OnFooterClickListener mOnFooterClickListener) {
        this.mFooterClickListener = mOnFooterClickListener;
    }

    public void setScan_num(int scan_num) {
        this.scan_num = scan_num;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerView.ViewHolder viewHolder = null;
        switch (i) {
            case HEADER_VIEW_TYPE:
                viewHolder = new HeaderViewHolder(View.inflate(viewGroup.getContext(), R.layout.item_lecture_header_view, null));
                mHeaderViewHolder = (HeaderViewHolder) viewHolder;
                break;
            case BODY_VIEW_TYPE:
                viewHolder = new BodyViewHolder(View.inflate(viewGroup.getContext(), R.layout.item_lecture_body_view, null));
                mBodyViewHolder = (BodyViewHolder) viewHolder;
                break;
            case FOOTER_VIEW_TYPE:
                viewHolder = new FooterViewHolder(View.inflate(viewGroup.getContext(), R.layout.item_lecture_footer_view, null));
                mFooterViewHolder = (FooterViewHolder) viewHolder;
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        final LectureVideo mModel = mList.get(0);
        if (viewHolder instanceof HeaderViewHolder && i <= headerCount) {
            mHeaderViewHolder.tv_num.setText(mContext.getResources().getString(R.string.lecture_num_summary, "80", String.valueOf(scan_num)));
            mHeaderViewHolder.go_counsel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (MultiClickUtil.isFastClick()) {
                        try {
                            if (mModel.getStaffId() == 0) {
                                ToastUtils.toast(mContext, R.string.failed_to_init_chat);
                                return;
                            }
                            //聊天
                        } catch (Exception e) {
                            e.printStackTrace();
                            ToastUtils.toast(mContext, R.string.failed_to_init_chat);

                        }
                    }
                }
            });
        } else if (viewHolder instanceof FooterViewHolder && i >= mList.size() + footerCount) {
            GlideUtils.getInstance().LoadContextCircleBitmap(mContext, mModel.getPhoto(), mFooterViewHolder.iv_head);
            mFooterViewHolder.tv_pro_name.setText(mModel.getName());
            mFooterViewHolder.tv_pro_desc.setText(mModel.getProfile());
        } else {
            BodyViewHolder mBodyViewHolder = (BodyViewHolder) viewHolder;
            final LectureVideo lectureVideo = mList.get(i - headerCount);
            if (i == headerCount) {
                mBodyViewHolder.iv_is_playing.setVisibility(View.VISIBLE);
                mBodyViewHolder.tv_lecture_title.setTextColor(mContext.getResources().getColor(R.color.orange));
                mBodyViewHolder.rootView.setBackgroundColor(mContext.getResources().getColor(R.color.light_gray));
            } else {
                mBodyViewHolder.iv_is_playing.setVisibility(View.GONE);
                mBodyViewHolder.tv_lecture_title.setTextColor(mContext.getResources().getColor(R.color.black));
                mBodyViewHolder.rootView.setBackgroundColor(mContext.getResources().getColor(android.R.color.white));
            }
            mBodyViewHolder.iv_mianfei_tag.setVisibility(lectureVideo.isBuy() ? View.VISIBLE : View.GONE);
            mBodyViewHolder.tv_lecture_title.setText(lectureVideo.getTitle());
            mBodyViewHolder.iv_mianfei_tag.setVisibility("1001".equals(lectureVideo.getPower_code()) ? View.VISIBLE : View.GONE);

            if (mItemClickListener != null) {
                mBodyViewHolder.rootView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (MultiClickUtil.isFastClick()) {
                            mItemClickListener.onItemClick(i, lectureVideo);
                        }
                    }
                });
                mBodyViewHolder.rootView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        if (MultiClickUtil.isFastClick()) {
                            mItemClickListener.onLongItemClick(view, i, lectureVideo);
                        }
                        return false;
                    }
                });
            }
        }


    }

    @Override
    public int getItemCount() {
        return mList.size() + headerCount + footerCount;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (headerCount != 0 && position < headerCount) {
            return HEADER_VIEW_TYPE;
        } else if (footerCount != 0 && position >= (headerCount + mList.size())) {
            return FOOTER_VIEW_TYPE;
        } else {
            return BODY_VIEW_TYPE;
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        TextView tv_num;
        TextView go_counsel;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_num = itemView.findViewById(R.id.tv_num);
            go_counsel = itemView.findViewById(R.id.go_counsel);
        }
    }

    public class BodyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_is_playing;
        TextView tv_lecture_title;
        ImageView iv_mianfei_tag;
        RelativeLayout rootView;


        public BodyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_is_playing = itemView.findViewById(R.id.iv_is_playing);
            tv_lecture_title = itemView.findViewById(R.id.tv_lecture_title);
            iv_mianfei_tag = itemView.findViewById(R.id.iv_mianfei_tag);
            rootView = itemView.findViewById(R.id.rootView);
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        TextView tv_pro_name;
        TextView tv_pro_desc;
        ImageView iv_head;

        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_pro_name = itemView.findViewById(R.id.tv_pro_name);
            tv_pro_desc = itemView.findViewById(R.id.tv_pro_desc);
            iv_head = itemView.findViewById(R.id.iv_head);
            itemView.findViewById(R.id.tv_see_more).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (MultiClickUtil.isFastClick()) {
                        if (mFooterClickListener != null) {
                            mFooterClickListener.onFooterClick(view, mList.get(0));
                        }
                    }
                }
            });
        }
    }
}

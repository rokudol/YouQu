package rokudol.com.youqu.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import rokudol.com.youqu.R;
import rokudol.com.youqu.beans.ZhiHuBean;
import rokudol.com.youqu.utils.GlideUtil;

/**
 * Created by rokudo on 2017/4/14.
 */

public class ZhiHuCommentDetailsAdapter extends RecyclerView.Adapter<ZhiHuCommentDetailsAdapter.ZhiHuCommentDetailsHolder> {
	private Context mContext;
	private List<ZhiHuBean> list;


	public ZhiHuCommentDetailsAdapter(Context mContext, List<ZhiHuBean> list) {
		this.mContext = mContext;
		this.list = list;
	}

	@Override
	public ZhiHuCommentDetailsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(mContext).inflate(R.layout.zhihucomment_item, parent, false);
		ZhiHuCommentDetailsHolder holder = new ZhiHuCommentDetailsHolder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder(final ZhiHuCommentDetailsHolder holder, final int position) {
		holder.commentName.setText(list.get(0).getCommentlist().get(position).getAuthor());
		holder.commentContent.setText(list.get(0).getCommentlist().get(position).getContent());
		holder.commentTime.setText(list.get(0).getCommentlist().get(position).getTime());
		holder.commentLike.setText(list.get(0).getCommentlist().get(position).getLikes());
		GlideUtil.setImage(mContext, list.get(0).getCommentlist().get(position).getAvatar(),
				R.drawable.ic_load_fail, holder.img);
		/*
		* 若被回复的消息不为空则将被回复的消息加载出来
		* */
		if (list.get(0).getCommentlist().get(position).getReply_to() != null
				&& list.get(0).getCommentlist().get(position).getReply_to().getId() != 0 + "") {
			holder.commentReply.setVisibility(View.VISIBLE);
			SpannableString ss = new SpannableString("@" + list.get(0).getCommentlist().get(position).getReply_to().getAuthor() + ":"
					+ list.get(0).getCommentlist().get(position).getReply_to().getContent());
			ss.setSpan(new ForegroundColorSpan(ContextCompat.getColor(mContext, R.color.comment_at)), 0,
					list.get(0).getCommentlist().get(position).getReply_to().getAuthor().length() + 2,
					Spanned.SPAN_INCLUSIVE_INCLUSIVE);
			holder.commentReply.setText(ss);
		}
	}


	@Override
	public int getItemCount() {
		return list == null ? 0 : list.get(0).getCommentlist().size();
	}

	class ZhiHuCommentDetailsHolder extends RecyclerView.ViewHolder {
		@BindView(R.id.civ_comment_face)
		CircleImageView img;
		@BindView(R.id.tv_comment_name)
		TextView commentName;
		@BindView(R.id.tv_comment_content)
		TextView commentContent;
		@BindView(R.id.tv_comment_reply)
		TextView commentReply;
		@BindView(R.id.tv_comment_time)
		TextView commentTime;
		@BindView(R.id.tv_comment_like)
		TextView commentLike;

		public ZhiHuCommentDetailsHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}

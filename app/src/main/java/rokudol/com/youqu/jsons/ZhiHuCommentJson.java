package rokudol.com.youqu.jsons;

import java.util.List;

/**
 * Created by rokudo on 2017/4/14.
 */

public class ZhiHuCommentJson {
	/*
	* @param comments:评论列表
	*   @param author:评论作者
	*   @param content:评论的内容
	*   @param avatar:用户头像图片地址
	*   @param id:评论者的唯一标识
	*   @param likes:评论所获得赞的数量
	*   @param time:评论时间
	* @param reply_to:所回复的消息
	*   @param content:原消息的内容
	*   @param status:消息状态，0为正常，非0为已被删除
	*   @param id:被回复者的唯一标识
	*   @param author:被回复者
	*   @param err_msg:错误消息，仅当status为非0时出现
	* */
	private List<Comments> comments;

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public static class Comments {
		private String author;
		private String id;
		private String content;
		private String likes;
		private String avatar;
		private String time;
		private ReplyTo reply_to;

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public String getLikes() {
			return likes;
		}

		public void setLikes(String likes) {
			this.likes = likes;
		}

		public String getAvatar() {
			return avatar;
		}

		public void setAvatar(String avatar) {
			this.avatar = avatar;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public ReplyTo getReply_to() {
			return reply_to;
		}

		public void setReply_to(ReplyTo reply_to) {
			this.reply_to = reply_to;
		}

		public static class ReplyTo {
			private String content;
			private String status;
			private String id;
			private String author;
			private String err_msg;

			public String getContent() {
				return content;
			}

			public void setContent(String content) {
				this.content = content;
			}

			public String getStatus() {
				return status;
			}

			public void setStatus(String status) {
				this.status = status;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getAuthor() {
				return author;
			}

			public void setAuthor(String author) {
				this.author = author;
			}

			public String getErr_msg() {
				return err_msg;
			}

			public void setErr_msg(String err_msg) {
				this.err_msg = err_msg;
			}
		}
	}
}

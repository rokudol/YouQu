package rokudol.com.youqu.jsons;

import java.util.List;

/**
 * Created by rokudo on 2017/4/14.
 */

public class ZhiHuCommentJson {

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

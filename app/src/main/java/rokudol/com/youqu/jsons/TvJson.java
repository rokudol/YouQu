package rokudol.com.youqu.jsons;

import java.util.List;

/**
 * Created by rokudo on 2017/4/20.
 */

public class TvJson {
	/*
	* @param tvid:该电视台id
	* @param name:该电视台名称
	* @param parentid：该电视台的上一级电视台id
	* @param istv:
	* */
	private String status;
	private String msg;
	private List<Result> result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Result> getResult() {
		return result;
	}

	public void setResult(List<Result> result) {
		this.result = result;
	}

	public class Result {
		private String tvid;
		private String name;
		private String parentid;
		private String istv;

		public String getTvid() {
			return tvid;
		}

		public void setTvid(String tvid) {
			this.tvid = tvid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getParentid() {
			return parentid;
		}

		public void setParentid(String parentid) {
			this.parentid = parentid;
		}

		public String getIstv() {
			return istv;
		}

		public void setIstv(String istv) {
			this.istv = istv;
		}
	}
}

package rokudol.com.youqu.jsons;

import java.util.List;

/**
 * Created by rokudo on 2017/4/26.
 */

public class ExChangeJson {
	/*
	* @param from:源货币
	* @param to:目标货币
	* @param formname:源货币名称
	* @param toname:目标货币名称
	* @param updatetime:汇率更新时间
	* @param rate:汇率
	* @param camount:换算后所得结果
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
		private String from;
		private String to;
		private String fromname;
		private String toname;
		private String updatetime;
		private String rate;
		private String camount;

		public String getFrom() {
			return from;
		}

		public void setFrom(String from) {
			this.from = from;
		}

		public String getTo() {
			return to;
		}

		public void setTo(String to) {
			this.to = to;
		}

		public String getFromname() {
			return fromname;
		}

		public void setFromname(String fromname) {
			this.fromname = fromname;
		}

		public String getToname() {
			return toname;
		}

		public void setToname(String toname) {
			this.toname = toname;
		}

		public String getUpdatetime() {
			return updatetime;
		}

		public void setUpdatetime(String updatetime) {
			this.updatetime = updatetime;
		}

		public String getRate() {
			return rate;
		}

		public void setRate(String rate) {
			this.rate = rate;
		}

		public String getCamount() {
			return camount;
		}

		public void setCamount(String camount) {
			this.camount = camount;
		}
	}
}

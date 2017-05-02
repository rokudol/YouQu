package rokudol.com.youqu.jsons;


import java.util.List;

/**
 * Created by rokudo on 2017/4/25.
 */

public class AllCurrency {
	/*
	* @param currency:货币代码
	* @param name:货币名称
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
		private String currency;
		private String name;

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}

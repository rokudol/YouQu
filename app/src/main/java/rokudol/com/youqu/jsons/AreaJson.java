package rokudol.com.youqu.jsons;

import java.util.List;

/**
 * Created by rokudo on 2017/4/18.
 */

public class AreaJson {
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
		private int id;
		private String name;
		private int parentid;
		private String parentname;
		private String areacode;
		private String zipcode;
		private String depth;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getParentid() {
			return parentid;
		}

		public void setParentid(int parentid) {
			this.parentid = parentid;
		}

		public String getParentname() {
			return parentname;
		}

		public void setParentname(String parentname) {
			this.parentname = parentname;
		}

		public String getAreacode() {
			return areacode;
		}

		public void setAreacode(String areacode) {
			this.areacode = areacode;
		}

		public String getZipcode() {
			return zipcode;
		}

		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}

		public String getDepth() {
			return depth;
		}

		public void setDepth(String depth) {
			this.depth = depth;
		}
	}
}

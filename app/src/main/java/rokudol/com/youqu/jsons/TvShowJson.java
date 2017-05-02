package rokudol.com.youqu.jsons;

import java.util.List;

/**
 * Created by rokudo on 2017/4/20.
 */

public class TvShowJson {
	/*
	* @param tvid:该电视台id
	* @param name:该电视台名称
	* @param date:查询的时间
	* @param name:电视节目名称
	* @param starttime:该电视节目开始时间
	* */
	private String status;
	private String msg;
	private Result result;

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

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public class Result {
		private String tvid;
		private String name;
		private String date;
		private List<Program> program;

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

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public List<Program> getProgram() {
			return program;
		}

		public void setProgram(List<Program> program) {
			this.program = program;
		}

		public class Program {
			private String name;
			private String starttime;

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getStarttime() {
				return starttime;
			}

			public void setStarttime(String starttime) {
				this.starttime = starttime;
			}
		}
	}
}

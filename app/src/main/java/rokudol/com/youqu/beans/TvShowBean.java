package rokudol.com.youqu.beans;

import java.util.List;

import javax.inject.Inject;

import rokudol.com.youqu.jsons.TvJson;
import rokudol.com.youqu.jsons.TvShowJson;

/**
 * Created by rokudo on 2017/4/20.
 */

public class TvShowBean {
	private List<TvJson.Result> tvResults;
	private List<TvShowJson.Result.Program> tvShowList;
	private String tvName;

	public String getTvName() {
		return tvName;
	}

	public void setTvName(String tvName) {
		this.tvName = tvName;
	}

	public List<TvShowJson.Result.Program> getTvShowList() {
		return tvShowList;
	}

	public void setTvShowList(List<TvShowJson.Result.Program> tvShowList) {
		this.tvShowList = tvShowList;
	}

	@Inject
	public TvShowBean() {
	}

	public List<TvJson.Result> getTvResults() {
		return tvResults;
	}

	public void setTvResults(List<TvJson.Result> tvResults) {
		this.tvResults = tvResults;
	}

}

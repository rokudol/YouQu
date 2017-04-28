package rokudol.com.youqu.switcharea;

import java.util.List;

/**
 * Created by rokudo on 2017/4/18.
 */

public interface SwitchAreaView {
	//添加省数据
	void addProvince(List<String> provinceNameList, List<String> provinceIdList);

	//添加城数据
	void addCity(List<String> cityNameList, List<String> cityIdList);

	//添加区数据
	void addArea(List<String> areaNameList, List<String> areaIdList);

	//没有数据时
	void noMore(List<String> noMore);
}

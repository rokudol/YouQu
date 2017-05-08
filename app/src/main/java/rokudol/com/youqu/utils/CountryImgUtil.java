package rokudol.com.youqu.utils;

import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

import rokudol.com.youqu.R;

/**
 * Created by rokudo on 2017/4/27.
 * 为货币添加国旗的工具类
 */

public class CountryImgUtil {
//	private int AED = R.mipmap.aed;
//	private int ARS = R.mipmap.ars;
//	private int ATS = R.mipmap.ats;
//	private int AUD = R.mipmap.aud;
//	private int BDT = R.mipmap.bdt;
//	private int BEF = R.mipmap.bef;
//	private int BGN = R.mipmap.bgn;
//	private int BHD = R.mipmap.bhd;
//	private int BMD = R.mipmap.bmd;
//	private int BND = R.mipmap.bnd;
//	private int BOB = R.mipmap.bob;
//	private int BRL = R.mipmap.brl;
//	private int BUK = R.mipmap.buk;
//	private int BWP = R.mipmap.bwp;
//	private int CAD = R.mipmap.cad;
//	private int CHF = R.mipmap.chf;
//	private int CLP = R.mipmap.clp;
//	private int CNY = R.mipmap.cny;
//	private int COP = R.mipmap.cop;
//	private int CUP = R.mipmap.cup;
//	private int CZK = R.mipmap.czk;
//	private int DEM = R.mipmap.dem;
//	private int DKK = R.mipmap.dkk;
//	private int EGP = R.mipmap.egp;
//	private int ESP = R.mipmap.esp;
//	private int EUR = R.mipmap.eur;
//	private int FIM = R.mipmap.fim;
//	private int FRF = R.mipmap.frf;
//	private int GBP = R.mipmap.gbp;
//	private int GHC = R.mipmap.ghc;
//	private int GRD = R.mipmap.grd;
//	private int GTQ = R.mipmap.gtq;
//	private int HKD = R.mipmap.hkd;
//	private int HRK = R.mipmap.hrk;
//	private int HUF = R.mipmap.huf;
//	private int IDR = R.mipmap.idr;
//	private int IEP = R.mipmap.iep;
//	private int ILS = R.mipmap.ils;
//	private int INR = R.mipmap.inr;
//	private int ISK = R.mipmap.isk;
//	private int ITL = R.mipmap.itl;
//	private int JMD = R.mipmap.jmd;
//	private int JOD = R.mipmap.jod;
//	private int JPY = R.mipmap.jpy;
//	private int KES = R.mipmap.kes;
//	private int KPW = R.mipmap.kpw;
//	private int KRW = R.mipmap.krw;
//	private int KWD = R.mipmap.kwd;
//	private int KZT = R.mipmap.kzt;
//	private int LAK = R.mipmap.lak;
//	private int LBP = R.mipmap.lbp;
//	private int LKR = R.mipmap.lkr;
//	private int LSL = R.mipmap.lsl;
//	private int LTL = R.mipmap.ltl;
//	private int LVL = R.mipmap.lvl;
//	private int LYD = R.mipmap.lyd;
//	private int MAD = R.mipmap.mad;
//	private int MMK = R.mipmap.mmk;
//	private int MNT = R.mipmap.mnt;
//	private int MOP = R.mipmap.mop;
//	private int MRO = R.mipmap.mro;
//	private int MUR = R.mipmap.mur;
//	private int MWK = R.mipmap.mwk;
//	private int MXN = R.mipmap.mxn;
//	private int MYR = R.mipmap.myr;
//	private int NGN = R.mipmap.ngn;
//	private int NIO = R.mipmap.nio;
//	private int NLG = R.mipmap.nlg;
//	private int NOK = R.mipmap.nok;
//	private int NPR = R.mipmap.npr;
//	private int NZD = R.mipmap.nzd;
//	private int OMR = R.mipmap.omr;
//	private int PAB = R.mipmap.pab;
//	private int PEN = R.mipmap.pen;
//	private int PGK = R.mipmap.pgk;
//	private int PHP = R.mipmap.php;
//	private int PKR = R.mipmap.pkr;
//	private int PLN = R.mipmap.pln;
//	private int PTE = R.mipmap.pte;
//	private int PYG = R.mipmap.pyg;
//	private int QAR = R.mipmap.qar;
//	private int RON = R.mipmap.ron;
//	private int RUB = R.mipmap.rub;
//	private int RWF = R.mipmap.rwf;
//	private int SAR = R.mipmap.sar;
//	private int SBD = R.mipmap.sbd;
//	private int SCR = R.mipmap.scr;
//	private int SEK = R.mipmap.sek;
//	private int SGD = R.mipmap.sgd;
//	private int SOS = R.mipmap.sos;
//	private int SYP = R.mipmap.syp;
//	private int THB = R.mipmap.thb;
//	private int TND = R.mipmap.tnd;
//	private int TRY = R.mipmap.try_;
//	private int TWD = R.mipmap.twd;
//	private int TZS = R.mipmap.tzs;
//	private int USD = R.mipmap.usd;
//	private int UYU = R.mipmap.uyu;
//	private int VEB = R.mipmap.veb;
//	private int VND = R.mipmap.vnd;
//	private int ZAR = R.mipmap.zar;
//	private int ZWD = R.mipmap.zwd;

	private static Map flagMap = new HashMap();
	private static Map currencyMap = new HashMap();

	/*
	* 根据传入的货币名称设置图片
	* */
	public static void setCurrencImg(ImageView imageView, String currencyName) {
		imageView.setBackgroundResource(getFlagMap(getCurrencyMap(currencyName)));
	}

	/*
	* 根据传入的货币代码设置图片
	* */
	public static void setCountryImg(ImageView imageView, String currencyCode) {
		imageView.setBackgroundResource(getFlagMap(currencyCode));
//      通过映射方式设置图片
//		// 获取对象对应类中的所有属性域
//		Field[] fields = this.getClass().getDeclaredFields();
//		for (int i = 0, len = fields.length; i < len; i++) {
//			// 对于每个属性，获取属性名
//			String varName = fields[i].getName();
//			if (varName.equals(Counrty)) {
//				// 获取在对象中属性fields[i]对应的对象中的变量
//				Object o = null;
//				try {
//					o = fields[i].get(this);
//					int imgId = Integer.parseInt(o.toString());
//					imageView.setBackgroundResource(imgId);
//					break;
//				} catch (IllegalAccessException e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}

	public static String getCurrencyMap(String key) {
		setCurrencyMap();
		return (String) currencyMap.get(key);
	}

	public static int getFlagMap(String key) {
		setFlagMap();
		return (int) flagMap.get(key);
	}

	private static void setCurrencyMap() {
		currencyMap = new HashMap();
		currencyMap.put("阿联酋迪拉姆", "AED");
		currencyMap.put("阿根廷比索", "ARS");
		currencyMap.put("奥地利先令", "ATS");
		currencyMap.put("澳大利亚元", "AUD");
		currencyMap.put("孟加拉塔卡", "BDT");
		currencyMap.put("比利时法郎", "BEF");
		currencyMap.put("保加利亚列弗", "BGN");
		currencyMap.put("巴林第纳尔", "BHD");
		currencyMap.put("百慕大元", "BMD");
		currencyMap.put("文莱元", "BND");
		currencyMap.put("玻利维亚诺", "BOB");
		currencyMap.put("巴西雷亚尔", "BRL");
		currencyMap.put("缅甸缅元", "BUK");
		currencyMap.put("博茨瓦纳普拉", "BWP");
		currencyMap.put("加拿大元", "CAD");
		currencyMap.put("瑞士法郎", "CHF");
		currencyMap.put("智利比索", "CLP");
		currencyMap.put("人民币", "CNY");
		currencyMap.put("哥伦比亚比索", "COP");
		currencyMap.put("古巴比索", "CUP");
		currencyMap.put("捷克克朗", "CZK");
		currencyMap.put("德国马克", "DEM");
		currencyMap.put("丹麦克朗", "DKK");
		currencyMap.put("埃及镑", "EGP");
		currencyMap.put("西班牙比塞塔", "ESP");
		currencyMap.put("欧元", "EUR");
		currencyMap.put("芬兰马克", "FIM");
		currencyMap.put("法国法郎", "FRF");
		currencyMap.put("英镑", "GBP");
		currencyMap.put("加纳塞地", "GHC");
		currencyMap.put("希腊德拉克马", "GRD");
		currencyMap.put("危地马拉格查尔", "GTQ");
		currencyMap.put("港币", "HKD");
		currencyMap.put("克罗地亚库纳", "HRK");
		currencyMap.put("匈牙利福林", "HUF");
		currencyMap.put("印尼盾", "IDR");
		currencyMap.put("爱尔兰镑", "IEP");
		currencyMap.put("以色列谢克尔", "ILS");
		currencyMap.put("印度卢比", "INR");
		currencyMap.put("冰岛克朗", "ISK");
		currencyMap.put("意大利里拉", "ITL");
		currencyMap.put("牙买加元", "JMD");
		currencyMap.put("约旦第纳尔", "JOD");
		currencyMap.put("日元", "JPY");
		currencyMap.put("肯尼亚先令", "KES");
		currencyMap.put("朝鲜圆", "KPW");
		currencyMap.put("韩元", "KRW");
		currencyMap.put("科威特第纳尔", "KWD");
		currencyMap.put("哈萨克坚戈", "KZT");
		currencyMap.put("老挝基普", "LAK");
		currencyMap.put("黎巴嫩镑", "LBP");
		currencyMap.put("斯里兰卡卢比", "LKR");
		currencyMap.put("莱索托洛提", "LSL");
		currencyMap.put("立陶宛立特", "LTL");
		currencyMap.put("拉脱维亚拉图", "LVL");
		currencyMap.put("利比亚第纳尔", "LYD");
		currencyMap.put("M摩洛哥迪拉姆AD", "MAD");
		currencyMap.put("缅甸元", "MMK");
		currencyMap.put("蒙古图格里克", "MNT");
		currencyMap.put("澳门元", "MOP");
		currencyMap.put("毛里塔尼亚乌吉亚", "MRO");
		currencyMap.put("毛里求斯卢比", "MUR");
		currencyMap.put("马拉维克瓦查", "MWK");
		currencyMap.put("墨西哥比索", "MXN");
		currencyMap.put("林吉特", "MYR");
		currencyMap.put("阿尔及利亚第纳尔", "NGN");
		currencyMap.put("尼加拉瓜科多巴", "NIO");
		currencyMap.put("荷兰盾", "NLG");
		currencyMap.put("挪威克朗", "NOK");
		currencyMap.put("尼泊尔卢比", "NPR");
		currencyMap.put("新西兰元", "NZD");
		currencyMap.put("阿曼里亚尔", "OMR");
		currencyMap.put("巴拿马巴尔博亚", "PAB");
		currencyMap.put("秘鲁新索尔", "PEN");
		currencyMap.put("巴布亚新几内亚基那", "PGK");
		currencyMap.put("菲律宾比索", "PHP");
		currencyMap.put("巴基斯坦卢比", "PKR");
		currencyMap.put("波兰兹罗提", "PLN");
		currencyMap.put("葡萄牙埃斯库多", "PTE");
		currencyMap.put("巴拉圭瓜拉尼", "PYG");
		currencyMap.put("卡塔尔里亚尔", "QAR");
		currencyMap.put("罗马尼亚列伊", "RON");
		currencyMap.put("卢布", "RUB");
		currencyMap.put("卢旺达法郎", "RWF");
		currencyMap.put("沙特里亚尔", "SAR");
		currencyMap.put("所罗门群岛元", "SBD");
		currencyMap.put("塞舌尔法郎", "SCR");
		currencyMap.put("瑞典克朗", "SEK");
		currencyMap.put("新加坡元", "SGD");
		currencyMap.put("索马里先令", "SOS");
		currencyMap.put("叙利亚镑", "SYP");
		currencyMap.put("泰国铢", "THB");
		currencyMap.put("突尼斯第纳尔", "TND");
		currencyMap.put("土耳其里拉", "TRY");
		currencyMap.put("新台币", "TWD");
		currencyMap.put("坦桑尼亚先令", "TZS");
		currencyMap.put("美元", "USD");
		currencyMap.put("乌拉圭比索", "UYU");
		currencyMap.put("委内瑞拉博利瓦", "VEB");
		currencyMap.put("越南盾", "VND");
		currencyMap.put("南非兰特", "ZAR");
		currencyMap.put("津巴布韦元", "ZWD");
	}

	private static void setFlagMap() {
		flagMap = new HashMap();
		flagMap.put("AED", R.mipmap.aed);
		flagMap.put("ARS", R.mipmap.ars);
		flagMap.put("ATS", R.mipmap.ats);
		flagMap.put("AUD", R.mipmap.aud);
		flagMap.put("BDT", R.mipmap.bdt);
		flagMap.put("BEF", R.mipmap.bef);
		flagMap.put("BGN", R.mipmap.bgn);
		flagMap.put("BHD", R.mipmap.bhd);
		flagMap.put("BMD", R.mipmap.bmd);
		flagMap.put("BND", R.mipmap.bnd);
		flagMap.put("BOB", R.mipmap.bob);
		flagMap.put("BRL", R.mipmap.brl);
		flagMap.put("BUK", R.mipmap.buk);
		flagMap.put("BWP", R.mipmap.bwp);
		flagMap.put("CAD", R.mipmap.cad);
		flagMap.put("CHF", R.mipmap.chf);
		flagMap.put("CLP", R.mipmap.clp);
		flagMap.put("CNY", R.mipmap.cny);
		flagMap.put("COP", R.mipmap.cop);
		flagMap.put("CUP", R.mipmap.cup);
		flagMap.put("CZK", R.mipmap.czk);
		flagMap.put("DEM", R.mipmap.dem);
		flagMap.put("DKK", R.mipmap.dkk);
		flagMap.put("EGP", R.mipmap.egp);
		flagMap.put("ESP", R.mipmap.esp);
		flagMap.put("EUR", R.mipmap.eur);
		flagMap.put("FIM", R.mipmap.fim);
		flagMap.put("FRF", R.mipmap.frf);
		flagMap.put("GBP", R.mipmap.gbp);
		flagMap.put("GHC", R.mipmap.ghc);
		flagMap.put("GRD", R.mipmap.grd);
		flagMap.put("GTQ", R.mipmap.gtq);
		flagMap.put("HKD", R.mipmap.hkd);
		flagMap.put("HRK", R.mipmap.hrk);
		flagMap.put("HUF", R.mipmap.huf);
		flagMap.put("IDR", R.mipmap.idr);
		flagMap.put("IEP", R.mipmap.iep);
		flagMap.put("ILS", R.mipmap.ils);
		flagMap.put("INR", R.mipmap.inr);
		flagMap.put("ISK", R.mipmap.isk);
		flagMap.put("ITL", R.mipmap.itl);
		flagMap.put("JMD", R.mipmap.jmd);
		flagMap.put("JOD", R.mipmap.jod);
		flagMap.put("JPY", R.mipmap.jpy);
		flagMap.put("KES", R.mipmap.kes);
		flagMap.put("KPW", R.mipmap.kpw);
		flagMap.put("KRW", R.mipmap.krw);
		flagMap.put("KWD", R.mipmap.kwd);
		flagMap.put("KZT", R.mipmap.kzt);
		flagMap.put("LAK", R.mipmap.lak);
		flagMap.put("LBP", R.mipmap.lbp);
		flagMap.put("LKR", R.mipmap.lkr);
		flagMap.put("LSL", R.mipmap.lsl);
		flagMap.put("LTL", R.mipmap.ltl);
		flagMap.put("LVL", R.mipmap.lvl);
		flagMap.put("LYD", R.mipmap.lyd);
		flagMap.put("MAD", R.mipmap.mad);
		flagMap.put("MMK", R.mipmap.mmk);
		flagMap.put("MNT", R.mipmap.mnt);
		flagMap.put("MOP", R.mipmap.mop);
		flagMap.put("MRO", R.mipmap.mro);
		flagMap.put("MUR", R.mipmap.mur);
		flagMap.put("MWK", R.mipmap.mwk);
		flagMap.put("MXN", R.mipmap.mxn);
		flagMap.put("MYR", R.mipmap.myr);
		flagMap.put("NGN", R.mipmap.ngn);
		flagMap.put("NIO", R.mipmap.nio);
		flagMap.put("NLG", R.mipmap.nlg);
		flagMap.put("NOK", R.mipmap.nok);
		flagMap.put("NPR", R.mipmap.npr);
		flagMap.put("NZD", R.mipmap.nzd);
		flagMap.put("OMR", R.mipmap.omr);
		flagMap.put("PAB", R.mipmap.pab);
		flagMap.put("PEN", R.mipmap.pen);
		flagMap.put("PGK", R.mipmap.pgk);
		flagMap.put("PHP", R.mipmap.php);
		flagMap.put("PKR", R.mipmap.pkr);
		flagMap.put("PLN", R.mipmap.pln);
		flagMap.put("PTE", R.mipmap.pte);
		flagMap.put("PYG", R.mipmap.pyg);
		flagMap.put("QAR", R.mipmap.qar);
		flagMap.put("RON", R.mipmap.ron);
		flagMap.put("RUB", R.mipmap.rub);
		flagMap.put("RWF", R.mipmap.rwf);
		flagMap.put("SAR", R.mipmap.sar);
		flagMap.put("SBD", R.mipmap.sbd);
		flagMap.put("SCR", R.mipmap.scr);
		flagMap.put("SEK", R.mipmap.sek);
		flagMap.put("SGD", R.mipmap.sgd);
		flagMap.put("SOS", R.mipmap.sos);
		flagMap.put("SYP", R.mipmap.syp);
		flagMap.put("THB", R.mipmap.thb);
		flagMap.put("TND", R.mipmap.tnd);
		flagMap.put("TRY", R.mipmap.try_);
		flagMap.put("TWD", R.mipmap.twd);
		flagMap.put("TZS", R.mipmap.tzs);
		flagMap.put("USD", R.mipmap.usd);
		flagMap.put("UYU", R.mipmap.uyu);
		flagMap.put("VEB", R.mipmap.veb);
		flagMap.put("VND", R.mipmap.vnd);
		flagMap.put("ZAR", R.mipmap.zar);
		flagMap.put("ZWD", R.mipmap.zwd);
	}

}

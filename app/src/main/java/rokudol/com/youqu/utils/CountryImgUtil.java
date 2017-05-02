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

	private static Map map;

	public static void getCountryImg(ImageView imageView, String Counrty) {
		setMap();
		imageView.setBackgroundResource(getMap(Counrty));
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

	private static int getMap(String key) {
		return (int) map.get(key);
	}

	private static void setMap() {
		map = new HashMap();
		map.put("AED", R.mipmap.aed);
		map.put("ARS", R.mipmap.ars);
		map.put("ATS", R.mipmap.ats);
		map.put("AUD", R.mipmap.aud);
		map.put("BDT", R.mipmap.bdt);
		map.put("BEF", R.mipmap.bef);
		map.put("BGN", R.mipmap.bgn);
		map.put("BHD", R.mipmap.bhd);
		map.put("BMD", R.mipmap.bmd);
		map.put("BND", R.mipmap.bnd);
		map.put("BOB", R.mipmap.bob);
		map.put("BRL", R.mipmap.brl);
		map.put("BUK", R.mipmap.buk);
		map.put("BWP", R.mipmap.bwp);
		map.put("CAD", R.mipmap.cad);
		map.put("CHF", R.mipmap.chf);
		map.put("CLP", R.mipmap.clp);
		map.put("CNY", R.mipmap.cny);
		map.put("COP", R.mipmap.cop);
		map.put("CUP", R.mipmap.cup);
		map.put("CZK", R.mipmap.czk);
		map.put("DEM", R.mipmap.dem);
		map.put("DKK", R.mipmap.dkk);
		map.put("EGP", R.mipmap.egp);
		map.put("ESP", R.mipmap.esp);
		map.put("EUR", R.mipmap.eur);
		map.put("FIM", R.mipmap.fim);
		map.put("FRF", R.mipmap.frf);
		map.put("GBP", R.mipmap.gbp);
		map.put("GHC", R.mipmap.ghc);
		map.put("GRD", R.mipmap.grd);
		map.put("GTQ", R.mipmap.gtq);
		map.put("HKD", R.mipmap.hkd);
		map.put("HRK", R.mipmap.hrk);
		map.put("HUF", R.mipmap.huf);
		map.put("IDR", R.mipmap.idr);
		map.put("IEP", R.mipmap.iep);
		map.put("ILS", R.mipmap.ils);
		map.put("INR", R.mipmap.inr);
		map.put("ISK", R.mipmap.isk);
		map.put("ITL", R.mipmap.itl);
		map.put("JMD", R.mipmap.jmd);
		map.put("JOD", R.mipmap.jod);
		map.put("JPY", R.mipmap.jpy);
		map.put("KES", R.mipmap.kes);
		map.put("KPW", R.mipmap.kpw);
		map.put("KRW", R.mipmap.krw);
		map.put("KWD", R.mipmap.kwd);
		map.put("KZT", R.mipmap.kzt);
		map.put("LAK", R.mipmap.lak);
		map.put("LBP", R.mipmap.lbp);
		map.put("LKR", R.mipmap.lkr);
		map.put("LSL", R.mipmap.lsl);
		map.put("LTL", R.mipmap.ltl);
		map.put("LVL", R.mipmap.lvl);
		map.put("LYD", R.mipmap.lyd);
		map.put("MAD", R.mipmap.mad);
		map.put("MMK", R.mipmap.mmk);
		map.put("MNT", R.mipmap.mnt);
		map.put("MOP", R.mipmap.mop);
		map.put("MRO", R.mipmap.mro);
		map.put("MUR", R.mipmap.mur);
		map.put("MWK", R.mipmap.mwk);
		map.put("MXN", R.mipmap.mxn);
		map.put("MYR", R.mipmap.myr);
		map.put("NGN", R.mipmap.ngn);
		map.put("NIO", R.mipmap.nio);
		map.put("NLG", R.mipmap.nlg);
		map.put("NOK", R.mipmap.nok);
		map.put("NPR", R.mipmap.npr);
		map.put("NZD", R.mipmap.nzd);
		map.put("OMR", R.mipmap.omr);
		map.put("PAB", R.mipmap.pab);
		map.put("PEN", R.mipmap.pen);
		map.put("PGK", R.mipmap.pgk);
		map.put("PHP", R.mipmap.php);
		map.put("PKR", R.mipmap.pkr);
		map.put("PLN", R.mipmap.pln);
		map.put("PTE", R.mipmap.pte);
		map.put("PYG", R.mipmap.pyg);
		map.put("QAR", R.mipmap.qar);
		map.put("RON", R.mipmap.ron);
		map.put("RUB", R.mipmap.rub);
		map.put("RWF", R.mipmap.rwf);
		map.put("SAR", R.mipmap.sar);
		map.put("SBD", R.mipmap.sbd);
		map.put("SCR", R.mipmap.scr);
		map.put("SEK", R.mipmap.sek);
		map.put("SGD", R.mipmap.sgd);
		map.put("SOS", R.mipmap.sos);
		map.put("SYP", R.mipmap.syp);
		map.put("THB", R.mipmap.thb);
		map.put("TND", R.mipmap.tnd);
		map.put("TRY", R.mipmap.try_);
		map.put("TWD", R.mipmap.twd);
		map.put("TZS", R.mipmap.tzs);
		map.put("USD", R.mipmap.usd);
		map.put("UYU", R.mipmap.uyu);
		map.put("VEB", R.mipmap.veb);
		map.put("VND", R.mipmap.vnd);
		map.put("ZAR", R.mipmap.zar);
		map.put("ZWD", R.mipmap.zwd);
	}

}

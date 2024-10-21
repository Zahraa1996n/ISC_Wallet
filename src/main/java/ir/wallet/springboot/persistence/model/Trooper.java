package ir.wallet.springboot.persistence.model;

public enum Trooper {
	EXEMPTION, //معافیت
	EDUCATIONAL_EXEMPTION, //معافیت تحصیلی
	DESERTER_SOLDIER, //سرباز فراری
	DISCHARGE_CERTIFICATE //کارت پایان خدمت
;

	public boolean isEmpty() {
		return false;
	}

	public String trim() {
		return null;
	}
}

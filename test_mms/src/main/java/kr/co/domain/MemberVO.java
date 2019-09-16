package kr.co.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class MemberVO implements Serializable{
	private static final long serialVersionUID = 1L;

	//health_persinfo table
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String joindate;
	private String locker;
	private String shirts;
	private String birthday;
	
	//health_healinfo table
	private int pk_num;
//	private String id;    health_persinfo foreign key
	private int weight;
	private int height;
	private String pt;
	private String updatedate;
	
	
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}

	
	//all attr constructor
	public MemberVO(String id, String pw, String name, String phone, String joindate, String locker, String shirts, String birthday,
			int pk_num, int weight, int height, String pt, String updatedate) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.joindate = joindate;
		this.locker = locker;
		this.shirts = shirts;
		this.pk_num = pk_num;
		this.weight = weight;
		this.height = height;
		this.pt = pt;
		this.updatedate = updatedate;
	}

	
	//health_persinfo attr constructor
	public MemberVO(String id, String pw, String name, String phone, String joindate, String locker, String shirts, String birthday) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.joindate = joindate;
		this.locker = locker;
		this.shirts = shirts;
		this.birthday = birthday;
	}

	
	//health_healinfo attr constructor
	public MemberVO(int pk_num, String id, int weight, int height, String pt, String updatedate) {
		super();
		this.id = id;
		this.pk_num = pk_num;
		this.weight = weight;
		this.height = height;
		this.pt = pt;
		this.updatedate = updatedate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getJoindate() {
		return joindate;
	}


	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}


	public String getLocker() {
		return locker;
	}


	public void setLocker(String locker) {
		this.locker = locker;
	}


	public String getShirts() {
		return shirts;
	}


	public void setShirts(String shirts) {
		this.shirts = shirts;
	}


	public int getPk_num() {
		return pk_num;
	}
	
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	public void setPk_num(int pk_num) {
		this.pk_num = pk_num;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public String getPt() {
		return pt;
	}


	public void setPt(String pt) {
		this.pt = pt;
	}


	public String getUpdatedate() {
		return updatedate;
	}


	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", joindate=" + joindate
				+ ", locker=" + locker + ", shirts=" + shirts + ", birthday=" + birthday + ", pk_num=" + pk_num
				+ ", weight=" + weight + ", height=" + height + ", pt=" + pt + ", updatedate=" + updatedate + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

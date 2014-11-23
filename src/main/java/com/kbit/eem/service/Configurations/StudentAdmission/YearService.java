package com.kbit.eem.service.Configurations.StudentAdmission;

import java.util.ArrayList;
import java.util.List;

import com.kbit.eem.models.service.Configurations.StudentAdmission.YearSO;
import com.kbit.eem.service.Configurations.Repository;

public class YearService extends Repository<YearSO>{
	public static List<YearSO> Get_Items() {//throws DBException, Exception {
		List<YearSO> list = new ArrayList<YearSO>();
		YearSO so = new YearSO();
		so.setId(1);
		so.setName("1st Class");
		list.add(so);
		
		so = new YearSO();
		so.setId(2);
		so.setName("2nd Class");
		list.add(so);
		
		so = new YearSO();
		so.setId(3);
		so.setName("3rd Class");
		list.add(so);
		
		return list;
	}
}

package com.kbit.eem.service.Configurations.StudentAdmission;

import java.util.ArrayList;
import java.util.List;

import com.kbit.eem.models.service.Configurations.StudentAdmission.LanguageSO;
import com.kbit.eem.service.Configurations.Repository;
import com.kbit.eem.utils.DBException;

public class LanguageService extends Repository<LanguageSO> {
	public static List<LanguageSO> Get_Items() throws DBException, Exception {
		List<LanguageSO> list = new ArrayList<LanguageSO>();
		LanguageSO so = new LanguageSO();
		so.setId(1);
		so.setName("English");
		list.add(so);
		
		so = new LanguageSO();
		so.setId(2);
		so.setName("Hindi");
		list.add(so);
		
		so = new LanguageSO();
		so.setId(3);
		so.setName("Other");
		list.add(so);
		
		return list;
	}
}

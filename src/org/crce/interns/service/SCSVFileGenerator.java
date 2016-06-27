package org.crce.interns.service;

import java.util.List;

import org.crce.interns.beans.UserCompanyBean;

public interface SCSVFileGenerator extends FileGeneratorService {
	
	final public String type="SCSV";
	
	@Override
	public String download();
	
	@Override
	public String[] getParameters(Object bean);
	
	@Override
	public void setType(String type);
		
	
	public void generateSCSV( Object bean,List<List<String>> result
			,List<UserCompanyBean> list);

}

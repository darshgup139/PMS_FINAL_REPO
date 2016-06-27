package org.crce.interns.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.crce.interns.beans.ApplicantCSVBean;
import org.crce.interns.beans.SCSVReader;
import org.crce.interns.beans.UserCompanyBean;
import org.crce.interns.dao.EligibilityDao;
import org.crce.interns.dao.ProfileDAO;
import org.crce.interns.model.PersonalProfile;
import org.crce.interns.model.ProfessionalProfile;
import org.crce.interns.model.Qualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("scsvService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SCSVFileGenerator implements org.crce.interns.service.SCSVFileGenerator {


	@Autowired
	private ProfileDAO profileDAO;
	
	@Autowired
	private EligibilityDao edao;
	
	@Autowired
	private SCSVReader bp;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	
	public String download() {
		// TODO Auto-generated method stub
		//return null;
		return "C:\\Users\\Dsouza\\workspace\\test4\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\PMS_new_frcrceinterns\\WEB-INF\\applicant.scsv";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	
	public String[] getParameters(Object bean) {
		// TODO Auto-generated method stub
		//return null;
		String[] param;
		StringBuilder result= new StringBuilder("NO;NAME");
		
		if(bean.getClass().getName().equals("org.crce.interns.beans.ApplicantCSVBean")){
			
			ApplicantCSVBean a = (ApplicantCSVBean) bean;
			
			
			
			if(a.isBranch()){
				result.append(";BRANCH");
			}
					
			
			if(a.isEmailId()){
				result.append(";EMAIL");
			}
			
			if(a.isMobileNo()){
				result.append(";CONTACT");
			}
					
			if(a.isSsc_per()){
				result.append(";SSC");
			}
					
					
			if(a.isHscOrDip()){
				result.append(";HSC");
			}	
					
			if(a.isDeg()){
				result.append(";CGPA");
			}
			
			
			if(a.isCorrespondenceAddress()){
				result.append(";CORRESPONDENCE ADDRESS");
			}
			
		}
		
		param = new String(result).split(";");
		
		return param;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	
	public void setType(String type) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	
	public void generateSCSV(Object bean, List<List<String>> result, List<UserCompanyBean> list) {
		// TODO Auto-generated method stub
		ApplicantCSVBean a = (ApplicantCSVBean) bean;
		
		String[] param = getParameters(bean);
		//System.out.println(Arrays.asList(param).toString());
		
		result.add(Arrays.asList(param));
		
		for(UserCompanyBean i : list){
			
			List<String> t = new ArrayList<String>();
					//System.out.println("INSIDE FOR");
			
			ProfessionalProfile p = new ProfessionalProfile();
			p.setUserName(i.getUsername());
			p = profileDAO.getProfile(p);
			//			System.out.println("p "+p.getUserName());
			
			PersonalProfile q = new PersonalProfile();
			q.setUserName(i.getUsername());
			q = profileDAO.getProfile(q);
		//				System.out.println("q "+q.getUserName());
			
			Qualification qp = edao.getQualification(i.getUsername());
					//	System.out.println("qp "+qp.getUsername());
			
			t.add(String.valueOf(list.indexOf(i)+1));
			a.setName(q.getName());
			t.add(a.getName());
		
			System.out.println("name "+a.getName());
			System.out.println("t "+t.toString());
			
			if(a.isBranch()){
				
				a.setBranch(p.getBranch());				
				t.add(a.getBranch());
				
			}
					
			
			if(a.isEmailId()){
				a.setEmailId(q.getEmailId());
				t.add(a.getEmailId());
			}
			
			if(a.isMobileNo()){
				a.setMobileNo(q.getMobileNo());
				t.add(a.getMobileNo());
			}
					
			if(a.isSsc_per()){
				a.setSsc(qp.getSsc_per());
				t.add(a.getSsc());
			
			}
					
					
			if(a.isHscOrDip()){
				a.setHscOrDip(qp.getHsc_or_dip_per());
				t.add(a.getHscOrDip());
			}	
					
			if(a.isDeg()){
				a.setCgpa(qp.getDeg_per());
				t.add(a.getCgpa());
			}
			
			
			if(a.isCorrespondenceAddress()){
				a.setCorrespondenceAddress(q.getCorrespondenceAddress());
				t.add(a.getCorrespondenceAddress());
			}
		
			result.add(t);
			
			//t.clear();
			
		}
		
		System.out.println("EXTRACTED RESULT="+result.toString());
		
		try{
			
			FileWriter writer = new FileWriter(bp.getFile());
			
			int rlen = result.size();
			for(int i=0; i< rlen; i++){
				
				List<String> line = result.get(i);
				int llen = line.size();
				
				for(int j=0; j< llen; j++){
					
					if(j!=llen-1){
						writer.append(line.get(j));
						writer.append(';');
					}
					else{
						writer.append(line.get(j));
						writer.append('\n');
					}
					
				}
				writer.flush();
			    
			}
			writer.close();
			
		}
		catch( IOException ioe){
			System.out.println("Exception="+ioe);
			return;
		}


	}

}

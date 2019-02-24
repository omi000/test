package com.internousdev.websample.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.websample.dao.MCategoryDAO;
import com.internousdev.websample.dto.MCategoryDTO;
import com.internousdev.websample.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	private List<MCategoryDTO> mCategoryDtoList=new ArrayList<MCategoryDTO>();
	private String categoryId;
	private Map<String,Object> session;
	public String execute(){
//もしsessionにloginIdとtempUserId両方のkeyが存在しなければ
		if(!(session.containsKey("loginId"))&&!(session.containsKey("tempUserId"))){
//CommonUtilityをインスタンス化して
			CommonUtility commonUtility =new CommonUtility();
//sessionにtempUserIdというキーでcommonUtilityのgetRamdomCValueメソッドの値を格納する
			session.put("tempUserId", commonUtility.getRamdomValue());
		}
//もしsessionにloginIdというキーが存在しなければ
		if(!session.containsKey("loginId")){
//sessionにloginIdというキーで0を格納する
			session.put("loginId",0);
		}
//もしsessionにmCategoryListというキーが存在しなければ
		if(!session.containsKey("mCategoryList")){
//MCategoryDAOをインスタンス化して
			MCategoryDAO mCategoryDao=new MCategoryDAO();
//mCategoryDtoListにmCategoryDaoのgetMCategoryListメソッドの値を代入する
			mCategoryDtoList=mCategoryDao.getMCategoryList();
//sessionにmCategoryDtoListというキーでmCategoryListを格納する
			session.put("mCategoryDtoList",mCategoryDtoList);
		}
		return SUCCESS;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId=categoryId;
	}

	public List<MCategoryDTO> getCategoryDtoList(){
		return mCategoryDtoList;
	}

	public void setCateegoryDtoList(List<MCategoryDTO> mCategoryDtoList){
		this.mCategoryDtoList=mCategoryDtoList;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}

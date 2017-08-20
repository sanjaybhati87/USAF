package com.sapient.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ssi248
 *
 */
public class QueryBuilder {
	public String employee ="Select * from employee";
	
	
	public Map<String,String> getEmployeetDetails(String Department) throws SQLException{
		Map<String,String> map=new HashMap<String,String>();
		ResultSet rs=null;
		if(Department.equalsIgnoreCase("Computer")){
			rs=DBUtil.performSelectQuery(employee);
			while (rs.next()) {
				map.put("EmployeeId", rs.getString("EmpId"));
				map.put("countryCode", rs.getString("countryCode"));
			}
		}
	return map;
}	
	
}

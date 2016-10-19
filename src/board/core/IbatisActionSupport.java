package board.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.opensymphony.xwork2.ActionSupport;

public abstract class IbatisActionSupport extends ActionSupport implements ServletRequestAware, IbatisAware, SessionAware {

	private static final long serialVersionUID = -3498919062072598310L;
	
	protected String path;
	public String getPath() { return path; }

	protected SqlMapClient sqlMap;
	protected HttpServletRequest request = null;
	@SuppressWarnings("rawtypes")
	protected Map sMap;

	@Override
	public abstract String execute() throws Exception;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		this.path = request.getContextPath();
	}

	@Override
	public void setIbatis(SqlMapClient sqlMap) { this.sqlMap = sqlMap; }

	@SuppressWarnings("rawtypes")
	@Override
	public void setSession(Map session) { this.sMap = session; }

	public void inject(Object org, Object dst) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method[] methods = dst.getClass().getMethods();
		
		Map<String, Method> getter = new HashMap<String, Method>();
		Map<String, Method> setter = new HashMap<String, Method>();
		
		for (Method m : methods) {
			if (m.getName().length()>3) {
				String head = m.getName().substring(0, 3);
				String name = m.getName().substring(3);
				if (head.equals("set")) setter.put(name, m);
				if (head.equals("get")) getter.put(name, m);
			}
		}
		
		for (String curMethodName : setter.keySet()) {
			Object data = getter.get(curMethodName).invoke(org);
			setter.get(curMethodName).invoke(dst,data);
		}
	}
}

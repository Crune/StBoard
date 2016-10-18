package board.core;

import java.io.IOException;
import java.io.Reader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public	class IbatisInterceptor
			implements Interceptor
{
	private static final long serialVersionUID = 1364416206550815527L;
	Log log = LogFactory.getLog(IbatisInterceptor.class);

	private Reader re;
	private SqlMapClient sqlMap;
	
	@Override
	public void destroy() { }

	@Override
	public void init() {
		log.info("DB init() start!");
		try {
			re = Resources.getResourceAsReader("sqlMapConfig.xml");
			log.info("DB Resources.getResourceAsReader Complete");
			sqlMap = SqlMapClientBuilder.buildSqlMapClient(re);
			log.info("DB SqlMapClientBuilder.buildSqlMapClien Complete");
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("DB init() end!");
	}

	@Override
	public String intercept(ActionInvocation inv) throws Exception {
		log.info("DB intercept.start!");
		
		Object obj = inv.getAction();		
		if (obj instanceof IbatisAware) {
			IbatisAware action = (IbatisAware) obj;
			action.setIbatis(sqlMap);
		}
		
		String result = inv.invoke();		
		
		log.info("DB intercept.end\tresult : "+result);
		return result;
	}

}

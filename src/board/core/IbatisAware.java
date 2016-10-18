package board.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ibatis.sqlmap.client.SqlMapClient;

public interface IbatisAware {
	public void setIbatis(SqlMapClient sqlMap);
	Log log = LogFactory.getLog(IbatisAware.class);
}

package ruxing.demo.core.interceptor.mybatis;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * Created by ruxing on 30/01/2018.
 */
@Intercepts({@Signature(type = ParameterHandler.class, method = "getParameterObject", args = {})})
public class MyInterceptor implements Interceptor {

    public Object intercept(Invocation invocation) throws Throwable {
        Object result = invocation.proceed();
        return result;
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {

    }

}

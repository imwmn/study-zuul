package com.wmn.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.protocol.RequestContent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wmn
 * @Date: 2020/4/26 16:08
 */
@Component
public class TokenFilter extends ZuulFilter {
    /**
     * 过滤器类型pre，表示在请求之前进行执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序，当一个请求在同一个阶段的时候存在多个过滤器的时候，多个过滤器执行的顺序
     * @return
     */

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 表示过滤器是否开启
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 业务逻辑代码
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //拦截所有的服务接口，判断服务接口上是否有传递userToken
        //1.获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //2.获取request
        HttpServletRequest request = currentContext.getRequest();
        //3.获取token
        String token = request.getParameter("userToken");
        if(StringUtils.isEmpty(token)){
            //不会继续执行，不会去调用服务接口，网关服务直接相应给客户端
          currentContext.setSendZuulResponse(false);
          currentContext.setResponseBody("userToken is null");
          currentContext.setResponseStatusCode(401);
          return null;

        }


        return null;
    }
}

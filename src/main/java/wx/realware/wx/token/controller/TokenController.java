package wx.realware.wx.token.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wx.realware.grp.pt.pb.respority.service.impl.CommonServiceImpl;
import wx.realware.wx.token.job.AutoAccessTokenJob;
import wx.realware.wx.token.util.CheckUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class TokenController {
    @Autowired
    AutoAccessTokenJob job;
    @ResponseBody
    @RequestMapping(value = "/checkToken.do")
    public String messChecke(HttpServletRequest request, HttpServletResponse response) {
        //token、timestamp、nonce
        String timestamp=request.getParameter("timestamp");
        String nonce=request.getParameter("nonce");
        String signature=request.getParameter("signature");
        String echostr=request.getParameter("echostr");
        if(CheckUtil.checkSignature(signature,timestamp,nonce)){
            return echostr;
        }
        return "";
    }

    @RequestMapping(value = "/shedule.do")
    public void shedule(HttpServletRequest request, HttpServletResponse response) {
        job.pringTest();
    }
}

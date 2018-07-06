package com.wxmp.wxcms.ctrl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wxmp.backstage.img.domain.ImgResource;
import com.wxmp.backstage.img.service.ImgResourceService;
import com.wxmp.backstage.sys.domain.SysUser;
import com.wxmp.backstage.sys.service.ISysUserService;
import com.wxmp.core.domain.ajax.BaseAjaxResult;
import com.wxmp.core.domain.ajax.CmsAjaxResult;
import com.wxmp.core.page.Pagination;
import com.wxmp.core.spring.SpringFreemarkerContextPathUtil;
import com.wxmp.core.util.PropertiesConfigUtil;
import com.wxmp.core.util.SessionUtilsWeb;
import com.wxmp.core.util.UploadUtil;
import com.wxmp.wxapi.process.MediaType;
import com.wxmp.wxapi.process.MpAccount;
import com.wxmp.wxapi.process.WxApiClient;
import com.wxmp.wxapi.process.WxMemoryCacheClient;
import com.wxmp.wxapi.vo.Material;
import com.wxmp.wxapi.vo.MaterialArticle;
import com.wxmp.wxapi.vo.MaterialItem;
import com.wxmp.wxcms.domain.Account;
import com.wxmp.wxcms.domain.MediaFiles;
import com.wxmp.wxcms.domain.MsgNews;
import com.wxmp.wxcms.domain.MsgText;
import com.wxmp.wxcms.mapper.AccountMapper;
import com.wxmp.wxcms.mapper.MsgNewsMapper;
import com.wxmp.wxcms.service.MsgNewsService;
import net.sf.json.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 
 */
@Controller
@RequestMapping("/wxcms")
public class WxCmsCtrl {

	@Autowired
	private AccountMapper accountDao;

	@Autowired
	private MsgNewsMapper msgNewsDao;
	
	@Autowired
	private ISysUserService sysUserService;
	
	@Autowired
	private ImgResourceService imgResourceService;
	
	@Autowired
	private MsgNewsService msgNewsService;

	private String TOKEN_URL_FORMAT = "%s://%s%s/wxapi/%s/message.html";

	/**
	 * 用户引导页
	 * @param request
	 * @param userId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/index_p")
	public ModelAndView indexPage(HttpServletRequest request ,@RequestParam(required=false) String userId, HttpSession session){
		ModelAndView mv = new ModelAndView("wxcms/first_page");
		SysUser sysUser = sysUserService.getSysUserById(userId);
		mv.addObject("account", sysUser.getAccount());
		mv.addObject("userId", sysUser.getId());
		return mv;
	}

	/**
	 * 老的页面入口 TODO 待删除
	 * @param request
	 * @param save
	 * @param userId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/urltokenOld")
	public ModelAndView urltokenOld(HttpServletRequest request ,String save,
								 @RequestParam(required=false) String userId,
								 HttpSession session){

		ModelAndView mv = new ModelAndView("wxcms/urltokenOld");
		List<Account> accounts = accountDao.listForPage(null);
		if(!CollectionUtils.isEmpty(accounts)){
			mv.addObject("account",accounts.get(0));
		}else{
			mv.addObject("account",new Account());
		}
		List<String> msgCountList = new ArrayList<String>();
		for(int i=1;i<8;i++){
			msgCountList.add(String.valueOf(i));
		}
		mv.addObject("cur_nav", "urltoken");
		if(save != null){
			mv.addObject("successflag",true);
		}else{
			mv.addObject("successflag",false);
		}
		mv.addObject("msgCountList", msgCountList);

		SysUser sysUser =  SessionUtilsWeb.getUser(request);
		session.setAttribute("sysUser", sysUser);
		return mv;
	}

	/**
	 * 跳转主页面入口
	 * @param request
	 * @param save
	 * @param userId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/urltoken")
	public ModelAndView urltoken(HttpServletRequest request ,String save,
			@RequestParam(required=false) String userId,
			HttpSession session){
		
		ModelAndView mv = new ModelAndView("wxcms/urltoken");
		List<Account> accounts = accountDao.listForPage(null);
		if(!CollectionUtils.isEmpty(accounts)){
			mv.addObject("account",accounts.get(0));
		}else{
			mv.addObject("account",new Account());
		}
		SysUser sysUser =  SessionUtilsWeb.getUser(request);
		session.setAttribute("sysUser", sysUser);
		return mv;
	}

	//TODO 待删除 更新tokenurl信息
	@RequestMapping(value = "/getUrlOld")
	public ModelAndView getUrlOld(HttpServletRequest request ,@ModelAttribute Account account){
		String path = SpringFreemarkerContextPathUtil.getBasePath(request);
		String url = request.getScheme() + "://" + request.getServerName() + path + "/wxapi/" + account.getAccount()+"/message.html";

		if(account.getId() == null){
			//新增
			account.setUrl(url);
			account.setToken(UUID.randomUUID().toString().replace("-", ""));
			account.setCreatetime(new Date());
			accountDao.add(account);
		}else{//更新
			Account tmpAccount = accountDao.getById(account.getId().toString());
			tmpAccount.setUrl(url);
			tmpAccount.setAccount(account.getAccount());
			tmpAccount.setAppid(account.getAppid());
			tmpAccount.setAppsecret(account.getAppsecret());
			tmpAccount.setMsgcount(account.getMsgcount());
			accountDao.update(tmpAccount);
		}
		WxMemoryCacheClient.addMpAccount(account);
		return new ModelAndView("redirect:/wxcms/urltoken?save=true");
	}

	/**
	 * 生成在微信填写的服务器地址， 然后刷新当前的urltoken页面
	 * @param request
	 * @param account
	 * @return
	 */
	@RequestMapping(value = "/getUrl", method = RequestMethod.POST)
	@ResponseBody
	public BaseAjaxResult getUrl(HttpServletRequest request , @ModelAttribute Account account){
		BaseAjaxResult result = null;
		try {
			SysUser user = SessionUtilsWeb.getUser(request);
			String path = SpringFreemarkerContextPathUtil.getBasePath(request);
			String url = String.format(TOKEN_URL_FORMAT, request.getScheme(), request.getServerName(), path, account.getAccount());
			if(account.getId() == null){
				//新增
				account.setUrl(url);
				account.setToken(UUID.randomUUID().toString().replace("-", ""));
				account.setCreatetime(new Date());
				result = new CmsAjaxResult(user, 0, "add success");
				accountDao.add(account);
			}else{
				//更新
				Account tmpAccount = accountDao.getById(account.getId().toString());
				tmpAccount.setUrl(url);
				tmpAccount.setAccount(account.getAccount());
				tmpAccount.setAppid(account.getAppid());
				tmpAccount.setAppsecret(account.getAppsecret());
				tmpAccount.setMsgcount(account.getMsgcount());
				accountDao.update(tmpAccount);
				result = new CmsAjaxResult(user, 0, "update success");
			}
			WxMemoryCacheClient.addMpAccount(account);
		} catch (Exception e){
			e.printStackTrace();
			result = new CmsAjaxResult(null, -1, "exception occured !");
		}
		return result;
	}
	
	@RequestMapping(value = "/ckeditorImage")
	public void ckeditorImage(HttpServletRequest request,HttpServletResponse response,@RequestParam(value="imgFile",required=false)MultipartFile file){
		String contextPath = SpringFreemarkerContextPathUtil.getBasePath(request);
		String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath;
		String realPath = request.getSession().getServletContext().getRealPath("/");
		
		//读取配置文上传件的路径
		if(PropertiesConfigUtil.getProperty("upload.properties","upload.path") != null){
			realPath = PropertiesConfigUtil.getProperty("upload.properties","upload.path").toString();
		}
		
		JSONObject obj = new JSONObject();
		if(file != null && file.getSize() > 0){
			String tmpPath = UploadUtil.doUpload(realPath,file);//上传文件，上传文件到 /res/upload/ 下
			obj.put("error", 0);
			obj.put("url", url + tmpPath);
		}
		
		try {
			response.getWriter().write(obj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//上传永久素材，这里以图文消息为例子
	@RequestMapping(value = "/toUploadMaterial")
	public  ModelAndView toUploadMaterial(String[] newIds){
		ModelAndView mv = new ModelAndView("wxcms/materialUpload");
		mv.addObject("cur_nav", "material");
		return mv;
	}
	
	//到生成二维码页面
	@RequestMapping(value = "/qrcode")
	public ModelAndView qrcode(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("wxcms/qrcode");
		mv.addObject("cur_nav", "qrcode");
		return mv;
	}
	
	//发送消息页面
	@RequestMapping(value = "/sendMsg")
	public ModelAndView sendMsg(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("wxcms/sendmsg");
		mv.addObject("cur_nav", "sendmsg");
		
		return mv;
	}
	
	//通过interceptor处理OAuth认证
	@RequestMapping(value = "/oauthInterceptor")
	public ModelAndView oauthInterceptor(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("wxcms/oauthInterceptor");
		mv.addObject("cur_nav", "oauthInterceptor");
		
		return mv;
	}
	
	//jssdk
	@RequestMapping(value = "/jssdk")
	public ModelAndView jssdk(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("wxcms/jssdk");
		mv.addObject("cur_nav", "jssdk");
		
		return mv;
	}
	
	//weui 微信网页开发样式库
	@RequestMapping(value = "/weui")
	public ModelAndView weui(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("wxcms/weui");
		mv.addObject("cur_nav", "weui");
		return mv;
	}
	
	/**
	 * 多图文素材页面
	 * zhangming @20160524
	 */
	@RequestMapping(value = "/toMultiGraphic")
	public ModelAndView toMultiGraphic(MsgText entity,
			@RequestParam(required=false,defaultValue="1") Integer page,
            @RequestParam(required=false,defaultValue="3") Integer pageSize){
		ModelAndView mv = new ModelAndView("wxcms/multiGraphic");
		
		PageHelper.startPage(page, pageSize);
		List<MediaFiles> mediaList = this.msgNewsService.getMediaFileList();
		PageInfo mediaPage=new PageInfo(mediaList);
		
		List<MsgNews> newsList = this.msgNewsService.getMsgNewsList();
		
		mv.addObject("mediaList",mediaList);
		//分页对象
		mv.addObject("page",mediaPage);
		mv.addObject("newsList",newsList);
		mv.addObject("cur_nav", "news");
		return mv;
	}	
	
	//获取永久素材
	@RequestMapping(value = "/getMaterials")
	public  ModelAndView syncMaterials(Pagination<MaterialArticle> pagination){
		MpAccount mpAccount = WxMemoryCacheClient.getSingleMpAccount();//获取缓存中的唯一账号
		
		ModelAndView mv = new ModelAndView("wxcms/materialList");
		Integer offset = pagination.getStart();
		Integer count = pagination.getPageSize();
		Material material = WxApiClient.syncBatchMaterial(MediaType.News, offset, count,mpAccount);
		if(material != null){
			List<MaterialArticle> materialList = new ArrayList<MaterialArticle>();
			List<MaterialItem> itemList = material.getItems();
			if(itemList != null){
				for(MaterialItem item : itemList){
					MaterialArticle m = new MaterialArticle();
					if(item.getNewsItems() != null && item.getNewsItems().size() > 0){
						MaterialArticle ma = item.getNewsItems().get(0);//用第一个图文的简介、标题、作者、url
						m.setAuthor(ma.getAuthor());
						m.setTitle(ma.getTitle());
						m.setUrl(ma.getUrl());
					}
					materialList.add(m);
				}
			}
			pagination.setTotalItemsCount(material.getTotalCount());
			pagination.setItems(materialList);
		}
		mv.addObject("page",pagination);
		mv.addObject("cur_nav", "material");
		return mv;
	}
	
	/**
	 * 添加单图文
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/toSingleNews")
	public ModelAndView toMerge(MsgText entity){
		ModelAndView mv = new ModelAndView("wxcms/singleNews");
        
		return mv;
	}
	
	/**
	 * 添加多图文
	 * @param entity
	 * @return
	 */
	@RequestMapping(value = "/toMoreNews")
	public ModelAndView addMore(MsgText entity){
		ModelAndView mv = new ModelAndView("wxcms/moreNews");

		return mv;
	}
	
    /*
     * 
     * 测试图片上传
     */
	@RequestMapping(value = "/test")
	public ModelAndView testImg(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("wxcms/test");
        
		return mv;
	}
	
	@RequestMapping(value="/saveFile")
	@ResponseBody
	public void saveFile(MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws Exception{
		 String fileName = file.getOriginalFilename();  
		 String ext = FilenameUtils.getExtension(fileName);
		 System.out.println(System.currentTimeMillis());
		 fileName = System.currentTimeMillis()+new Random().nextInt(10000)+"."+ext;
		 
		 String filePath = request.getSession().getServletContext().getRealPath("/")+"upload\\"+fileName;  
		 File saveFile = new File(filePath);
		 
		 if(!saveFile.exists()){
			 saveFile.mkdirs();
		 }
		 file.transferTo(saveFile);
		 
		 
		 MpAccount mpAccount = WxMemoryCacheClient.getSingleMpAccount();//获取缓存中的唯一账号
		 //添加永久图片
		 String materialType = MediaType.Image.toString();
	    
		 //返回mediaId
		 JSONObject imgResultObj = WxApiClient.addMaterial(filePath,materialType,mpAccount);
		 ImgResource img = new ImgResource();
		
		 //上传图片的id
		 String imgMediaId = "";
		 String imgUrl = "";
		 
		 JSONObject obj = new JSONObject();
		 if(imgResultObj != null && imgResultObj.containsKey("media_id")){
				imgMediaId = imgResultObj.getString("media_id");
				imgUrl = imgResultObj.getString("url");
				img.setName(fileName);
				img.setSize((int)file.getSize());
				img.setTrueName(fileName);
				img.setType(ext);
				img.setUrl("/upload/" + fileName);
				img.setHttpUrl(imgUrl);//http地址
				obj.put("url", fileName);
				obj.put("id", "111");
				obj.put("imgMediaId", imgMediaId);
		   }else{
				obj.put("url", fileName);
				obj.put("id", "111");
				obj.put("imgMediaId", null);
	       }

		   response.getWriter().print(obj);
	}

}
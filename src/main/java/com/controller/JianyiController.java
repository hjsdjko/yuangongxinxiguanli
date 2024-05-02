package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.JianyiEntity;

import com.service.JianyiService;
import com.entity.view.JianyiView;
import com.service.YonghuService;
import com.entity.YonghuEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 建议
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jianyi")
public class JianyiController {
    private static final Logger logger = LoggerFactory.getLogger(JianyiController.class);

    @Autowired
    private JianyiService jianyiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
     
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = jianyiService.queryPage(params);

        //字典表数据转换
        List<JianyiView> list =(List<JianyiView>)page.getList();
        for(JianyiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JianyiEntity jianyi = jianyiService.selectById(id);
        if(jianyi !=null){
            //entity转view
            JianyiView view = new JianyiView();
            BeanUtils.copyProperties( jianyi , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jianyi.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JianyiEntity jianyi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jianyi:{}",this.getClass().getName(),jianyi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            jianyi.setInsertTime(new Date());
            jianyi.setCreateTime(new Date());
            jianyi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            jianyiService.insert(jianyi);
            return R.ok();
        }else {
            return R.error(511,"您没有权限新增建议");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JianyiEntity jianyi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jianyi:{}",this.getClass().getName(),jianyi.toString());
//        //根据字段查询是否有相同数据
//        Wrapper<JianyiEntity> queryWrapper = new EntityWrapper<JianyiEntity>()
//            .notIn("id",jianyi.getId())
//            .andNew()
//            .eq("yonghu_id", jianyi.getYonghuId())
//            .eq("jianyi_name", jianyi.getJianyiName())
//            .eq("jianyi_types", jianyi.getJianyiTypes())
//            ;
//        logger.info("sql语句:"+queryWrapper.getSqlSegment());
//        JianyiEntity jianyiEntity = jianyiService.selectOne(queryWrapper);
//        if(jianyiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jianyi.set
            //  }
            jianyiService.updateById(jianyi);//根据id更新
            return R.ok();
//        }else {
//            return R.error(511,"表中有相同数据");
//        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jianyiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}


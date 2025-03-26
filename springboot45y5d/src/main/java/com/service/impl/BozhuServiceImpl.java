package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.BozhuDao;
import com.entity.BozhuEntity;
import com.service.BozhuService;
import com.entity.vo.BozhuVO;
import com.entity.view.BozhuView;

@Service("bozhuService")
public class BozhuServiceImpl extends ServiceImpl<BozhuDao, BozhuEntity> implements BozhuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BozhuEntity> page = this.selectPage(
                new Query<BozhuEntity>(params).getPage(),
                new EntityWrapper<BozhuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BozhuEntity> wrapper) {
		  Page<BozhuView> page =new Query<BozhuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BozhuVO> selectListVO(Wrapper<BozhuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BozhuVO selectVO(Wrapper<BozhuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BozhuView> selectListView(Wrapper<BozhuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BozhuView selectView(Wrapper<BozhuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

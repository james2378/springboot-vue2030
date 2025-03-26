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


import com.dao.DiscussbozhuwenzhangDao;
import com.entity.DiscussbozhuwenzhangEntity;
import com.service.DiscussbozhuwenzhangService;
import com.entity.vo.DiscussbozhuwenzhangVO;
import com.entity.view.DiscussbozhuwenzhangView;

@Service("discussbozhuwenzhangService")
public class DiscussbozhuwenzhangServiceImpl extends ServiceImpl<DiscussbozhuwenzhangDao, DiscussbozhuwenzhangEntity> implements DiscussbozhuwenzhangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussbozhuwenzhangEntity> page = this.selectPage(
                new Query<DiscussbozhuwenzhangEntity>(params).getPage(),
                new EntityWrapper<DiscussbozhuwenzhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussbozhuwenzhangEntity> wrapper) {
		  Page<DiscussbozhuwenzhangView> page =new Query<DiscussbozhuwenzhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussbozhuwenzhangVO> selectListVO(Wrapper<DiscussbozhuwenzhangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussbozhuwenzhangVO selectVO(Wrapper<DiscussbozhuwenzhangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussbozhuwenzhangView> selectListView(Wrapper<DiscussbozhuwenzhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussbozhuwenzhangView selectView(Wrapper<DiscussbozhuwenzhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

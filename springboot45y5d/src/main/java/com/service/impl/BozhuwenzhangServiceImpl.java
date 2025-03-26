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


import com.dao.BozhuwenzhangDao;
import com.entity.BozhuwenzhangEntity;
import com.service.BozhuwenzhangService;
import com.entity.vo.BozhuwenzhangVO;
import com.entity.view.BozhuwenzhangView;

@Service("bozhuwenzhangService")
public class BozhuwenzhangServiceImpl extends ServiceImpl<BozhuwenzhangDao, BozhuwenzhangEntity> implements BozhuwenzhangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BozhuwenzhangEntity> page = this.selectPage(
                new Query<BozhuwenzhangEntity>(params).getPage(),
                new EntityWrapper<BozhuwenzhangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BozhuwenzhangEntity> wrapper) {
		  Page<BozhuwenzhangView> page =new Query<BozhuwenzhangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BozhuwenzhangVO> selectListVO(Wrapper<BozhuwenzhangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BozhuwenzhangVO selectVO(Wrapper<BozhuwenzhangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BozhuwenzhangView> selectListView(Wrapper<BozhuwenzhangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BozhuwenzhangView selectView(Wrapper<BozhuwenzhangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

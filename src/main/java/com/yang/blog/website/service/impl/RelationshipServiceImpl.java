package com.yang.blog.website.service.impl;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.yang.blog.website.dao.RelationshipVoMapper;
import com.yang.blog.website.model.Vo.RelationshipVoExample;
import com.yang.blog.website.model.Vo.RelationshipVoKey;
import com.yang.blog.website.service.IRelationshipService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by BlueT on 2017/3/18.
 */
@Service
public class RelationshipServiceImpl implements IRelationshipService {
    private static final Logger LOGGER = Logger.getLogger(RelationshipServiceImpl.class);

    @Resource
    private RelationshipVoMapper relationshipVoMapper;

    @Override
    public void deleteById(Integer cid, Integer mid) {
        RelationshipVoExample relationshipVoExample = new RelationshipVoExample();
        RelationshipVoExample.Criteria criteria = relationshipVoExample.createCriteria();
        if (cid != null) {
            criteria.andCidEqualTo(cid);
        }
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        relationshipVoMapper.deleteByExample(relationshipVoExample);
    }

    @Override
    public List<RelationshipVoKey> getRelationshipById(Integer cid, Integer mid) {
        RelationshipVoExample relationshipVoExample = new RelationshipVoExample();
        RelationshipVoExample.Criteria criteria = relationshipVoExample.createCriteria();
        if (cid != null) {
            criteria.andCidEqualTo(cid);
        }
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        return relationshipVoMapper.selectByExample(relationshipVoExample);
    }

    @Override
    public void insertVo(RelationshipVoKey relationshipVoKey) {
        relationshipVoMapper.insert(relationshipVoKey);
    }

    @Override
    public Long countById(Integer cid, Integer mid) {
        LOGGER.debug("Enter countById method:cid={},mid={}");
        RelationshipVoExample relationshipVoExample = new RelationshipVoExample();
        RelationshipVoExample.Criteria criteria = relationshipVoExample.createCriteria();
        if (cid != null) {
            criteria.andCidEqualTo(cid);
        }
        if (mid != null) {
            criteria.andMidEqualTo(mid);
        }
        long num = relationshipVoMapper.countByExample(relationshipVoExample);
        LOGGER.debug("Exit countById method return num={}");
        return num;
    }
}

package com.findmoreplus.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.findmoreplus.admin.domain.bean.Organizer;
import com.findmoreplus.admin.mapper.OrganizatorMapper;
import com.findmoreplus.admin.service.OrganizerService;

import java.util.List;

/**
 * @author WEIR
 * @description
 * @date 20/10/2021 - 19:30
 */
public class OrganizerServiceImpl extends ServiceImpl<OrganizatorMapper, Organizer> implements OrganizerService {

//    private final SqlSession openSession = SqlUtil.getOpeningSession();
//    private final this.baseMapper this.baseMapper= openSession.getMapper(this.baseMapper.class);

    @Override
    public Organizer selectInfoByPhoneAndPassword(String phone, String password) {
        return this.baseMapper.selectInfoByPhoneAndPassword(phone, password);
    }

    @Override
    public void orgRegister(Organizer org) {
        org.setId(this.baseMapper.countAllOrg());
        this.baseMapper.addOrg(org);
//        openSession.commit();
    }

    @Override
    public String selectHeadPortrait(Integer id) {
        return this.baseMapper.getHeadPortrait(id);
    }

    @Override
    public void addInfo(Integer id, String info) {
        this.baseMapper.addInfo(id, info);
//        openSession.commit();
    }

    @Override
    public String selectInfo(Integer id) {
        return this.baseMapper.selectInfo(id);
    }

    @Override
    public List<Organizer> getOrgs(int start, int end) {
        return this.baseMapper.getOrgs(start, end);
    }

    @Override
    public boolean checkOrgName(Integer count) {
        return false;
    }

    @Override
    public List<Organizer> queryOrgsByName(String name) {
        return this.baseMapper.queryOrgsByName(name);
    }
}

package com.findmoreplus.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.findmoreplus.admin.mapper.ActivityMapper;
import com.findmoreplus.admin.domain.bean.ActivityUser;
import com.findmoreplus.admin.domain.bean.Participater;
import com.findmoreplus.admin.domain.bean.Pictures;
import com.findmoreplus.admin.service.ActivityService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author WEIR
 * @description
 * @date 14/10/2021 - 16:04
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper,ActivityUser> implements ActivityService {

//    private final SqlSession openSession = SqlUtil.getOpeningSession();
//    private final this.baseMapper this.baseMapper = openSession.getMapper(this.baseMapper.class);

//    @Autowired
//    private 
    @Override
    public void addActivity(ActivityUser activityUser) {
        try {
            activityUser.setId(this.baseMapper.countAllAct());
            this.baseMapper.addActivity(activityUser);
//            openSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("添加活动失败!");
        }
    }

    @Override
    public void deleteActivityById(Integer id) {
        this.baseMapper.deleteActivity(id);
    }

    @Override
    public void updateActivityById(Integer id, ActivityUser activityUser) {
        try {
            this.baseMapper.addActivityInfo(id, activityUser.getInfo());
//            openSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("更新活动信息失败!");
        }
    }

    @Override
    public ActivityUser selectActivity(Integer id) {
        return this.baseMapper.selectInfoById(id);
    }

    @Override
    public boolean checkActivityName(String name) {
        return this.baseMapper.checkActivityExist(name);
    }

    @Override
    public void addPicture(Integer id, String pic) {
        try {
            this.baseMapper.addActivityPicture(id, pic);
//            openSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("注册失败!");
        }
    }

    @Override
    public List<Pictures> getPicture(Integer id) {
        return this.baseMapper.selectPicturesById(id);
    }

    @Override
    public List<Participater> selectStudentInActivity(Integer id) {
        return this.baseMapper.selectStudentsByArtId(id);
    }

    @Override
    public List<ActivityUser> getActivity(int start, int end) {
        return this.baseMapper.getActivity(start, end);
    }


    @Override
    public void addActivityInfo(Integer id, String info) {
        try {
            this.baseMapper.addActivityInfo(id, info);
//            openSession.commit();
        } catch (Exception e) {
            throw new RuntimeException("添加活动失败!");
        }
    }

    @Override
    public List<ActivityUser> selectActivitiesByOrganizer(Integer organizer) {
        return this.baseMapper.selectActivitiesByOrganizer(organizer);
    }

    @Override
    public List<ActivityUser> selectInfoIncludePars(Integer id) {
        return this.baseMapper.selectInfoIncludePars(id);
    }

    @Override
    public List<ActivityUser> searchActivityByName(String searchText) {
        return null;
    }

}

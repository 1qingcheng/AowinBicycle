package service;

import dao.VenderMapper;
import model.Vender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class VenderService implements VenderInter{
    @Resource
    private VenderMapper venderMapper;

    public VenderMapper getVenderMapper() {
        return venderMapper;
    }

    public void setVenderMapper(VenderMapper venderMapper) {
        this.venderMapper = venderMapper;
    }

    //得到所有的供应商
    @Override
    public List<Vender> getAllVender() {
        return venderMapper.getAllVender();
    }
    //新增供应商
    @Override
    public int addVender(Vender vender) {
        return venderMapper.addVender(vender);
    }

    //根据id查询
    @Override
    public Vender queryVenderById(int vender_id) {
        return venderMapper.queryVenderById(vender_id);
    }

    //更新供应商
    @Override
    public int updateVender(Vender vender) {
        return venderMapper.updateVender(vender);
    }

    //注销供应商
    public int logout(String vender_id){
        return venderMapper.logout(vender_id);
    }

}

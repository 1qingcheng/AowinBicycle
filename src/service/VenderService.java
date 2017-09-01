package service;

import dao.VenderMapper;
import model.Vender;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class VenderService implements VenderInter{
    private VenderMapper venderMapper;

    public VenderMapper getVenderMapper() {
        return venderMapper;
    }

    public void setVenderMapper(VenderMapper venderMapper) {
        this.venderMapper = venderMapper;
    }

    /**
     * 查询供应商
     * @return
     */
    @Override
    public List<Vender> query() {
        return venderMapper.query();
    }
}

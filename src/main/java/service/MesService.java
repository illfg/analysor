package service;

import entity.Mes;
import mapper.MesMapper;

import java.util.List;

public class MesService extends DaoProvider {
    MesMapper mapper = getMapper(MesMapper.class);

    public List<Mes> queryallMes(){
        List<Mes> mesList = mapper.selectAllMes();
        return mesList;
    }

    public void insertMes(Mes mes){
        mapper.insert(mes);
        commit();
    }

}

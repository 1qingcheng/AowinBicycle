package dao;

import model.Vender;

import java.util.List;

public interface VenderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vender
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer venderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vender
     *
     * @mbggenerated
     */
    int insert(Vender record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vender
     *
     * @mbggenerated
     */
    int insertSelective(Vender record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vender
     *
     * @mbggenerated
     */
    Vender selectByPrimaryKey(Integer venderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vender
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Vender record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vender
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Vender record);

    List<Vender> query();
}
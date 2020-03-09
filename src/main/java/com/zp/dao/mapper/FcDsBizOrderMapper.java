package com.zp.dao.mapper;

import com.zp.dao.entity.FcDsBizOrder;
import com.zp.dao.entity.FcDsBizOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FcDsBizOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    long countByExample(FcDsBizOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    int deleteByExample(FcDsBizOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    int insert(FcDsBizOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    int insertSelective(FcDsBizOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    List<FcDsBizOrder> selectByExampleWithBLOBsWithRowbounds(FcDsBizOrderExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    List<FcDsBizOrder> selectByExampleWithBLOBs(FcDsBizOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    List<FcDsBizOrder> selectByExampleWithRowbounds(FcDsBizOrderExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    List<FcDsBizOrder> selectByExample(FcDsBizOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    FcDsBizOrder selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    int updateByExampleSelective(@Param("record") FcDsBizOrder record, @Param("example") FcDsBizOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") FcDsBizOrder record, @Param("example") FcDsBizOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    int updateByExample(@Param("record") FcDsBizOrder record, @Param("example") FcDsBizOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    int updateByPrimaryKeySelective(FcDsBizOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(FcDsBizOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order
     *
     * @mbg.generated Fri Mar 06 12:07:21 CST 2020
     */
    int updateByPrimaryKey(FcDsBizOrder record);

    List<String> selectDz();
}
package com.zp.dao.mapper;

import com.zp.dao.entity.FcDsBizOrderDetail;
import com.zp.dao.entity.FcDsBizOrderDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FcDsBizOrderDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    long countByExample(FcDsBizOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    int deleteByExample(FcDsBizOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    int insert(FcDsBizOrderDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    int insertSelective(FcDsBizOrderDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    List<FcDsBizOrderDetail> selectByExampleWithBLOBsWithRowbounds(FcDsBizOrderDetailExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    List<FcDsBizOrderDetail> selectByExampleWithBLOBs(FcDsBizOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    List<FcDsBizOrderDetail> selectByExampleWithRowbounds(FcDsBizOrderDetailExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    List<FcDsBizOrderDetail> selectByExample(FcDsBizOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    FcDsBizOrderDetail selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    int updateByExampleSelective(@Param("record") FcDsBizOrderDetail record, @Param("example") FcDsBizOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") FcDsBizOrderDetail record, @Param("example") FcDsBizOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    int updateByExample(@Param("record") FcDsBizOrderDetail record, @Param("example") FcDsBizOrderDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    int updateByPrimaryKeySelective(FcDsBizOrderDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(FcDsBizOrderDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table fc_ds_biz_order_detail
     *
     * @mbg.generated Sat Mar 07 18:27:09 CST 2020
     */
    int updateByPrimaryKey(FcDsBizOrderDetail record);

    List<String> selectDz();
}